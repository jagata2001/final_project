package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    public SelenideElement firstNameInput = $("#firstname"),
            lastNameInput = $("#lastname"),
            userNameInput = $("#userName"),
            passwordInput = $("#password"),
            registerButton = $("#register"),
            message = $("#name");
}
