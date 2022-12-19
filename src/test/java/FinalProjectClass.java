import com.codeborne.selenide.Configuration;
import data.LogOutTestData;
import data.LoginTestData;
import data.RegisterTestData;
import dataProvider.LoginDataProvider;
import dataProvider.RegisterDataProvider;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BooksPageTestSteps;
import steps.LoginPageTestSteps;
import steps.ProfilePageTestSteps;
import steps.RegisterPageTestSteps;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FinalProjectClass {
    public LoginPageTestSteps loginPageTestSteps = new LoginPageTestSteps();
    public RegisterPageTestSteps registerPageTestSteps = new RegisterPageTestSteps();

    public ProfilePageTestSteps profilePageTestSteps = new ProfilePageTestSteps();
    public BooksPageTestSteps booksPageTestSteps = new BooksPageTestSteps();

    //data
    public RegisterTestData registerTestData = new RegisterTestData();
    public LoginTestData loginTestData = new LoginTestData();
    public LogOutTestData logOutTestData = new LogOutTestData();

    @BeforeMethod
    public void setUpWebSelenide(){
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test(dataProvider = "registerDataProviderFunction", dataProviderClass = RegisterDataProvider.class, priority=1)
    public void firstTest(String firstName, String lastName, String userName, String password){
        open("/login");
        loginPageTestSteps.clickOnNewUser();
        registerPageTestSteps.fillFirstName(firstName).fillLastName(lastName)
                .fillUserName(userName).fillPassword(password)
                .clickOnRegisterButton().validateRegistration(registerTestData.registerCaptchaErrorMessage);
    }
    @Test(dataProvider = "loginDataProviderFunction", dataProviderClass = LoginDataProvider.class, priority=2)
    public void secondTest(String userName,String password){
        open("/login");
        loginPageTestSteps.fillUserName(userName).fillPassword(password).clickOnLoginButton();
        //profilePageTestSteps.validateUsername(userName);
        profilePageTestSteps.validateUsername(loginTestData.usernameValue);
    }
    @Test(dependsOnMethods="secondTest", priority=3)
    public void thirdTest(){
        open("/profile");
        profilePageTestSteps.clickOnBookStoreButton();
        booksPageTestSteps.clickOnFirstBookTitle();
        String isbnId = booksPageTestSteps.getIsbnValue();
        String bookTitle = booksPageTestSteps.getBookTitle();
        given().
                header("accept","application/json").
                queryParam("ISBN",isbnId).
                when().
                get("https://bookstore.toolsqa.com/BookStore/v1/Book").
                then().
                assertThat().
                statusCode(200).
                body("title",equalTo(bookTitle));
    }
    @Test(dependsOnMethods="secondTest", priority=4)
    public void fourthTest(){
        open("/profile");
        profilePageTestSteps.clickOnBookStoreButton();
        String firstBookTitle = booksPageTestSteps.getFirstBookTitle();
        booksPageTestSteps.fillSearchBoxInput(firstBookTitle).clickOnSearchButton().
                validateThatSearchWorksProperly(firstBookTitle);
    }
    @Test(dependsOnMethods="secondTest", priority=5)
    public void fifthTest(){
        open("/profile");
        profilePageTestSteps.clickOnLogOutButton();
        loginPageTestSteps.validateThatUserLoggedOut(logOutTestData.textAfterLogOut);
    }
}
