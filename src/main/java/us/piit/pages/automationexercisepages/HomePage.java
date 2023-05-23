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


    //click on button methods
    public void clickClickOnHomeButton(){
        clickOn(homeButton);
        log.info("Well Done ma Gee! home button click click success!!");
    }
    public void clickClickOnProductsButton() {
        clickOn(productsButton);
        log.info("Well Done ma Gee! products button click click success!!");
    }
    public void clickClickOnCartButton() {
        clickOn(cartButton);
        log.info("Well Done ma Gee! cart button click click success!!");
    }
    public void clickClickOnSignupLoginButton() {
        clickOn(signupLoginButton);
        log.info("Well Done ma Gee! signup/ login button click click success!!");
    }
    public void clickClickOnTestCasesButton() {
        clickOn(testCasesButton);
        log.info("Well Done ma Gee! test cases button click click success!!");
    }
    public void clickClickOnAPITestingButton() {
        clickOn(aPITestingButton);
        log.info("Well Done ma Gee! API testing button click click success!!");
    }
    public void clickClickOnVideoTutorialsButton() {
        clickOn(videoTutorialsButton);
        log.info("Well Done ma Gee! video tutorials button click click success!!");
    }
    public void clickClickOnContactUsButton() {
        clickOn(contactUsButton);
        log.info("Well Done ma Gee! contact us button click click success!!");
    }

    //get header text methods
    public String getCategoryHeaderText(){
        String text = getElementText(loginPageCategoryHeader);
        log.info("Well Done ma Gee! Category header text validation success!!");
        return text;
    }

}
