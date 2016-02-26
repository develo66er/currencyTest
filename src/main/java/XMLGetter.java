import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class XMLGetter {
    private static final String url = "https://www.bnm.md/en/official_exchange_rates";
    private String query;
    private static final String charset = "utf-8";
    private String str;
    BufferedReader br;
    public XMLGetter(){
        str="";
    }
    public int checkString(InputStream in) throws IOException {

        br = new BufferedReader(new InputStreamReader(in));
        str = br.readLine();
        if(!str.contains("<?xml"))
            return 2;
        str = br.readLine();
        if(str.contains("Request in bad format"))return 1;
        return 0;
    }
    public Integer getDocument(String get_xml, String date) throws IOException {
        int res;
        query = String.format("get_xml=%s&date=%s",URLEncoder.encode(get_xml,charset),URLEncoder.encode(date,charset));
        URLConnection connection = new URL(url+"?"+query).openConnection();
        InputStream response = connection.getInputStream();
        InputStreamReader sr = new InputStreamReader(response);
        res = checkString(response);
        if(res==2)
            return 2;
        if(res==1)
            return 1;
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        ValCurs curs = (ValCurs)xstream.fromXML(sr);
        if(!curs.getDate().equals(date))
            return 3;


    return 0;

    }
}
