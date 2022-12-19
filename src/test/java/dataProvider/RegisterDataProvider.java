package dataProvider;

import org.testng.annotations.DataProvider;

public class RegisterDataProvider {
    @DataProvider(name="registerDataProviderFunction")
    public Object[][] registerData() {
        return new Object[][]{
                {"test","test last name","test username","password"},
                {"test1","test last name1","test username1","password1"}
        };
    }
}
