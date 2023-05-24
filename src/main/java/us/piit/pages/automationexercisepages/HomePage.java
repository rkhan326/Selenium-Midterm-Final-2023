package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {

    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){PageFactory.initElements(driver, this);}

    //Buttons
    @FindBy(css = "a[href='/']")
    WebElement homeButton;
    @FindBy(css = "a[href='/products']")
    WebElement productsButton;
    @FindBy(css = "a[href='/view_cart']")
    WebElement cartButton;
    @FindBy(css = "a[href='/login']")
    WebElement signupLoginButton;
    @FindBy(css = "a[href='/test_cases']")
    WebElement testCasesButton;
    @FindBy(css = "a[href='/api_list']")
    WebElement aPITestingButton;
    @FindBy(css = "a[href='https://www.youtube.com/c/AutomationExercise']")
    WebElement videoTutorialsButton;
    @FindBy(css = "a[href='/contact_us']")
    WebElement contactUsButton;

    //Headers
    @FindBy(xpath = "//h2[text()='Category']")
    WebElement loginPageCategoryHeader;
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement accountDeletedHeader;
    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedHeader;


    //click on button methods
    public void clickClickOnHomeButton(){
        clickOn(homeButton);
        log.info("Well Done ma Gee! 'Home button' click click success!!");
    }
    public void clickClickOnProductsButton() {
        clickOn(productsButton);
        log.info("Well Done ma Gee! 'Products button' click click success!!");
    }
    public void clickClickOnCartButton() {
        clickOn(cartButton);
        log.info("Well Done ma Gee! 'Cart button' click click success!!");
    }
    public void clickClickOnSignupLoginButton() {
        clickOn(signupLoginButton);
        log.info("Well Done ma Gee! 'Signup/ login button' click click success!!");
    }
    public void clickClickOnTestCasesButton() {
        clickOn(testCasesButton);
        log.info("Well Done ma Gee! 'Test cases button' click click success!!");
    }
    public void clickClickOnAPITestingButton() {
        clickOn(aPITestingButton);
        log.info("Well Done ma Gee! 'API testing button' click click success!!");
    }
    public void clickClickOnVideoTutorialsButton() {
        clickOn(videoTutorialsButton);
        log.info("Well Done ma Gee! 'Video tutorials button' click click success!!");
    }
    public void clickClickOnContactUsButton() {
        clickOn(contactUsButton);
        log.info("Well Done ma Gee! 'Contact us button' click click success!!");
    }

    //get header text methods
    public String getCategoryHeaderText(){
        String text = getElementText(loginPageCategoryHeader);
        log.info("Well Done ma Gee! 'Category header' text validation success!!");
        return text;
    }
    public String getAccountCreatedHeaderText(){
        String text = getElementText(accountCreatedHeader);
        log.info("Well Done ma Gee! 'Account created header' text validation success!!");
        return text;
    }
    public String getAccountDeletedHeaderText(){
        String text = getElementText(accountDeletedHeader);
        log.info("Well Done ma Gee! 'Account deleted header' text validation success!!");
        return text;
    }

}
