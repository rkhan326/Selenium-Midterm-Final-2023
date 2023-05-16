package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class BlogPage extends CommonAPI {

    Logger log = LogManager.getLogger(BlogPage.class.getName());

    public BlogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement blogPageHeader;

    @FindBy(xpath = "//a[@href='https://automation.scaledupit.com/2017/12/03/fun-in-shop/ ']")
    WebElement readMoreButton;

    @FindBy(css = "#comment")
    WebElement commentField;

    @FindBy(css = "input[name='author']")
    WebElement nameField;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#url")
    WebElement urlField;

    @FindBy(xpath = "//p[@class='comment-form-cookies-consent']/input")
    WebElement checkBoxButton;

    @FindBy(css= "input[id='submit']")
    WebElement submitBtn;

    @FindBy(css = ".comment-awaiting-moderation")
    WebElement commentHeader;


    public boolean checkPresenceOfBlogPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(blogPageHeader);
        log.info("blog page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getBlogPageHeadertext() {
        String blogPageHeaderText = getElementText(blogPageHeader);
        log.info("blog page header text is " + blogPageHeaderText);
        return blogPageHeaderText;

    }
    public void clickOnReadMoreButton() {
        clickOn(readMoreButton);
        log.info("click on read more  button success");

    }
    public void enterComment(String comment) {
        typeText(commentField, comment);

        log.info("enter comment success");
    }
    public void entername(String name) {
        typeText(nameField, name);

        log.info("enter name success");
    }
    public void enteremail(String email) {
        typeText(emailField, email);

        log.info("enter email success");
    }
    public void enterUrl(String url) {
        typeText(urlField, url);

        log.info("enter url success");
    }
    public void clickOnSaveButton() {
        clickOn(checkBoxButton);
        log.info("click on check save box  success");

    }
    public boolean isSaveButtonChecked(){
        boolean isSaveButtonChecked = isChecked(checkBoxButton);
        return isSaveButtonChecked;

    }
    public void clickOnSubmitButton() {
        clickOn(submitBtn);
        log.info("click on submit button success");

    }
    public String getcommentHeadertext() {
        String commentHeaderText = getElementText(commentHeader);
        log.info("comment text header text is " + commentHeaderText);
        return commentHeaderText;

    }


}

