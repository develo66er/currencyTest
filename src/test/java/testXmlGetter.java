import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by natali on 25.02.16.
 */
public class testXmlGetter {
    @Test(dataProvider = "test1")
    public void testGetter(String get_xml, String date) {
        int res;
        XMLGetter getter = new XMLGetter();
        res = getter.getDocument(get_xml, date);
        Assert.assertEquals(1, res);
        //Assert.assertNotEquals(1, res);
        //Assert.assertNotEquals(2, res);
        //Assert.assertNotEquals(3, res);

    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{"0", "22.11.2015"}, {"-1", "22.11.2015"}, {"0", "22.11.2015"}, {"0", "22.11.2015"}, {"0", "22.11.2015"}};
    }

    public Map<String, String> readDbConfig() {

        Properties prop = new Properties();
        InputStream input = null;
        Map<String, String> map = new HashMap<String, String>();

        try {
            input = getClass().getClassLoader().getResourceAsStream("testData.properties");

            prop.load(input);
while(!prop.isEmpty())
            map.put("get_xml", prop.getProperty("testData.get_xml"));
            map.put("data", prop.getProperty("testData.data"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return map;

    }
}
