package steps;

import pages.RegisterPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class RegisterPageTestSteps {
    public RegisterPage registerPage = new RegisterPage();
    public RegisterPageTestSteps fillFirstName(String firstName){
        registerPage.firstNameInput.sendKeys(firstName);
        return this;
    }
    public RegisterPageTestSteps fillLastName(String lastName){
        registerPage.lastNameInput.sendKeys(lastName);
        return this;
    }
    public RegisterPageTestSteps fillUserName(String userName){
        registerPage.userNameInput.sendKeys(userName);
        return this;
    }
    public RegisterPageTestSteps fillPassword(String password){
        registerPage.passwordInput.sendKeys(password);
        return this;
    }
    public RegisterPageTestSteps clickOnRegisterButton(){
        registerPage.registerButton.scrollTo().click();
        return this;
    }
    public RegisterPageTestSteps validateRegistration(String text){
        registerPage.message.shouldBe(visible).shouldHave(exactText(text));
        return this;
    }

}
