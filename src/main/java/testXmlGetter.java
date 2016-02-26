import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by natali on 25.02.16.
 */
public class testXmlGetter {
    @Test(dataProvider = "test1")
    public void testGetter(String get_xml, String date) throws IOException {
        int res;
        XMLGetter getter = new XMLGetter();
        res = getter.getDocument(get_xml, date);
        Assert.assertEquals(1, res);


    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{"0", "22.11.2015"}, {"-1", "22.11.2015"}, {"0", "22.11.2015"}, {"0", "22.11.2015"}, {"0", "22.11.2015"}};
    }
//

}
