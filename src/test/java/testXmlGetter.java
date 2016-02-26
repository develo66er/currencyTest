import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by natali on 25.02.16.
 */
public class testXmlGetter {
    @Test(dataProvider = "test1")
    public void testGetter(String get_xml, String date){
        int res;
        XMLGetter getter = new XMLGetter();
        res = getter.getDocument(get_xml,date);
        Assert.assertEquals(1,res);
        //Assert.assertNotEquals(1, res);
        //Assert.assertNotEquals(2, res);
        //Assert.assertNotEquals(3, res);

    }
    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][] {{"0", "22.11.2015"}, {"-1", "22.11.2015"}, {"0", "22.11.2015"}, {"0", "22.11.2015"}, {"0", "22.11.2015"}};
    }
}
