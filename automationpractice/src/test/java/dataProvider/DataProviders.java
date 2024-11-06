package dataProvider;



import helper.ExcelReader;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "valid-user-credentials")
    public static Object[][] gerValidUserCredentials() {
        return new ExcelReader("Booksheet5", "Sheet1").getData();
    }



}