package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    public SelenideElement usernameValueLabel = $("#userName-value"),
            bookStoreButton = $("#gotoStore"),
            logOutButton = $("#submit");
}
