package steps;

import pages.BooksPage;

import static com.codeborne.selenide.Condition.exactText;

public class BooksPageTestSteps {
    public BooksPage booksPage = new BooksPage();
    public BooksPageTestSteps clickOnFirstBookTitle(){
        booksPage.firstBook.scrollTo().click();
        return this;
    }
    public String getIsbnValue(){
        return booksPage.isbnLabel.getText();
    }
    public String getBookTitle(){
        return booksPage.bookTitle.getText();
    }
    public String getFirstBookTitle(){
        return booksPage.firstBook.getText();
    }
    public BooksPageTestSteps fillSearchBoxInput(String input){
        booksPage.searchBoxInput.sendKeys(input);
        return this;
    }
    public BooksPageTestSteps clickOnSearchButton(){
        booksPage.searchButton.scrollTo().click();
        return this;
    }
    public BooksPageTestSteps validateThatSearchWorksProperly(String firstBookTitle){
        booksPage.firstBook.shouldHave(exactText(firstBookTitle));
        return this;
    }
}
