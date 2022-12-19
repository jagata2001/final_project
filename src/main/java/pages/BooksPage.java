package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BooksPage {
    public SelenideElement firstBook = $(byXpath("//span[@class='mr-2']//a")),
            isbnLabel = $(byXpath("//div[@id='ISBN-wrapper']//label[@id='userName-value']")),
            bookTitle = $(byXpath("//div[@id='title-wrapper']//label[@id='userName-value']")),
            searchBoxInput = $("#searchBox"),
            searchButton = $("#basic-addon2");
}
