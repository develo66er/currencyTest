import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class XMLGetter {
    static Configuration config;
    private String query;
    private String str;
    BufferedReader br;
    public XMLGetter(){
        config = Configuration.getInstance();
        str="";
    }

    public String streamConverter(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(in));
        while((str = br.readLine())!=null){
            sb.append(str);
        }
        return sb.toString();
    }
    public Integer getDocument(String get_xml, String date){
        URL obj = null;
        String res="";
        try {
            obj = new URL(config.getProperty("endpointURL")+"?get_xml="+get_xml+"&date="+date);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            res = streamConverter(con.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!res.contains("<?xml"))
            return 2;//redirect to main page of service
        if(res.contains("Request in bad format"))
            return 1;//request in bad format

        StringReader sr = new StringReader(res);
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        ValCurs curs = (ValCurs)xstream.fromXML(sr);
        if(!curs.getDate().equals(date))
            return 3;
    return 0;

    }
}
