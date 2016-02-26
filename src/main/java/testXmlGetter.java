import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by natali on 25.02.16.
 */
public class testXmlGetter {
    public static final Logger LOG= Logger.getLogger(testXmlGetter.class);
    @Test(dataProvider = "test1")
    public void testGetter(String get_xml, String date) throws IOException {
        int res;
        XMLGetter getter = new XMLGetter();
        res = getter.getDocument(get_xml, date);
        LOG.info("res:"+res);



    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() throws Exception {

        Object[][] testObjArray = ExcelUtils.getTableArray("src/main/resources/providerData.xlsx", "Sheet1",2,2);

        return (testObjArray);
    }

}
