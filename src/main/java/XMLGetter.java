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
    public boolean checkString(InputStream in, String toContain, int numLn) throws IOException {

        br = new BufferedReader(new InputStreamReader(in));
        for(int i = 0; i < numLn; i++) str = br.readLine();
        if(!str.contains(toContain))return false;
        return true;
    }
    public Integer getDocument(String get_xml, String date) throws IOException {

        query = String.format("get_xml=%s&date=%s",URLEncoder.encode(get_xml,charset),URLEncoder.encode(date,charset));
        URLConnection connection = new URL(url+"?"+query).openConnection();
        InputStream response = connection.getInputStream();
        InputStreamReader sr = new InputStreamReader(response);

        if(!checkString(response, "<?xml", 1))
            return 1;
        if(checkString(response, "Request in bad format", 2))
            return 2;
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        ValCurs curs = (ValCurs)xstream.fromXML(sr);
        if(!curs.getDate().equals(date))
            return 3;


    return 0;

    }
}
