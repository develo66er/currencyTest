import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by natali on 25.02.16.
 */
public class testXmlGetter {
    public static final Logger LOG= Logger.getLogger(testXmlGetter.class);
    @Test(dataProvider = "test1")
    public void testGetter(String get_xml, String date, String expectStr) throws IOException {
        Integer res,expectInt;
        Double temp = Double.parseDouble(expectStr);
        expectInt = temp.intValue();
        XMLGetter getter = new XMLGetter();
        res = getter.getDocument(get_xml, date);
        Assert.assertEquals(res,expectInt);
        LOG.info("received value: "+res+" expected value: "+expectInt);

    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("src/main/resources/providerData.xlsx", "Sheet1",30,3);
        return (testObjArray);
    }

}
