import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.thoughtworks.xstream.XStream;

import javax.ws.rs.core.MultivaluedMap;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by natali on 25.02.16.
 */
public class XMLGetter {
    //String pattern ="/(\\n*\\.*)(<?xml version=\"1.0\" encoding=\"UTF-8\"?>)*(\\n*\\.*)/";
    String pattern ="/^(.*)/";
    Pattern p;
    Matcher m;
    public XMLGetter()
    {
        p = Pattern.compile(pattern);
    }
    public Integer getDocument(String get_xml, String date){
        Client client = Client.create();
        WebResource resource;
        resource = client.resource("https://www.bnm.md/en/official_exchange_rates");
        MultivaluedMap queryParams = new MultivaluedMapImpl();
        queryParams.add("get_xml", get_xml);
        queryParams.add("date", date);
        String response = resource.queryParams(queryParams).get(String.class);
        if(!response.contains("<?xml"))
            return 1;
        if(response.contains("Request in bad format"))
            return 2;
        StringReader sr = new StringReader(response);
        XStream xstream = new XStream();
        xstream.alias("ValCurs", ValCurs.class);
        xstream.alias("Valute", Valute.class);
        xstream.aliasField("Date", ValCurs.class, "Date");
        xstream.aliasField("name", ValCurs.class, "name");

        xstream.aliasField("ID", Valute.class, "ID");
        xstream.aliasField("NumCode", Valute.class, "NumCode");
        xstream.aliasField("CharCode", Valute.class, "CharCode");
        xstream.aliasField("Nominal", Valute.class, "Nominal");

        xstream.aliasField("Name", Valute.class, "Name");
        xstream.aliasField("Value", Valute.class, "Value");
        xstream.addImplicitCollection(ValCurs.class, "valute");

        ValCurs curs = (ValCurs)xstream.fromXML(sr);
        if(!curs.getDate().equals(date))
            return 3;

    return 0;

    }
}
