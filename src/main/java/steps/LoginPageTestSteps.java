package steps;

import com.codeborne.selenide.conditions.Text;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;

public class LoginPageTestSteps {
    public LoginPage loginPage = new LoginPage();
    public LoginPageTestSteps clickOnNewUser(){
        loginPage.newUserButton.scrollTo().click();
        return this;
    }
    public LoginPageTestSteps fillUserName(String userName){
        loginPage.userNameInput.sendKeys(userName);
        return this;
    }
    public LoginPageTestSteps fillPassword(String password){
        loginPage.passwordInput.sendKeys(password);
        return this;
    }
    public LoginPageTestSteps clickOnLoginButton(){
        loginPage.loginButton.scrollTo().click();
        return this;
    }
    public LoginPageTestSteps validateThatUserLoggedOut(String input){
        loginPage.logOutMessage.shouldHave(exactText(input));
        return this;
    }
}
