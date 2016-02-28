import java.util.*;
import java.io.*;

public class Configuration {
    private static Configuration _instance = null;

    private Properties props = null;

    private Configuration() {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                    new File("src/main/resources/config.properties"));
            props.load(fis);
        }
        catch (Exception e) {
            System.out.println("no such file: src/main/resources/config.properties");
        }
    }

    public synchronized static Configuration getInstance() {
        if (_instance == null)
            _instance = new Configuration();
        return _instance;
    }


    public synchronized String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
        else {
            System.out.println("property file don't contains key : " + key);
        }
        return value;
    }
}