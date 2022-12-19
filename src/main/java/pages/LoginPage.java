package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement newUserButton = $("#newUser"),
            userNameInput = $("#userName"),
            passwordInput = $("#password"),
            loginButton = $("#login"),
            logOutMessage = $("h2");
}
