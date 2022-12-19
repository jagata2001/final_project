package steps;

import pages.ProfilePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class ProfilePageTestSteps {
    public ProfilePage profilePage = new ProfilePage();
    public ProfilePageTestSteps validateUsername(String username){
        profilePage.usernameValueLabel.shouldBe(visible).shouldHave(exactText(username));
        return this;
    }
    public ProfilePageTestSteps clickOnBookStoreButton(){
        profilePage.bookStoreButton.scrollTo().click();
        return this;
    }
    public ProfilePageTestSteps clickOnLogOutButton(){
        profilePage.logOutButton.scrollTo().click();
        return this;
    }
}
