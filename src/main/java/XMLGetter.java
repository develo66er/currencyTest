import com.thoughtworks.xstream.XStream;

import java.io.*;
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

    public String streamConverter(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(in));
        while((str = br.readLine())!=null){
            sb.append(str);
        }
        return sb.toString();
    }
    public Integer getDocument(String get_xml, String date){
        String res="";
        try {
            query = String.format("get_xml=%s&date=%s",URLEncoder.encode(get_xml,charset),URLEncoder.encode(date,charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = new URL(url+"?"+query).openConnection();
            InputStream response = connection.getInputStream();
            res = streamConverter(response);
        } catch (IOException e) {
            //e.printStackTrace();
            return 4;
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
