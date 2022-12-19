package dataProvider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name="loginDataProviderFunction")
    public Object[][] authData() {
        return new Object[][]{{"testAutomation","Automation@1234"}};
    }
}

