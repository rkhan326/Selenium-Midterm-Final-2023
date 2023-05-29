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

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String wellDoneG = "Well done my G! ";
    public String wellDoneboy = "Well done my boy! ";
    public String wellDoneguy = "Well done my guy! ";

    public String headerValidationSuccess = " Header validation success!!";
    public String errorMessageSuccess = " Error message success!!";





    //Buttons
    @FindBy(css = "a[href='/']")
    WebElement $homeButton;
    @FindBy(css = "a[href='/products']")
    WebElement $productsButton;
    @FindBy(css = "a[href='/view_cart']")
    WebElement $cartButton;
    @FindBy(css = "a[href='/login']")
    WebElement $signupLoginButton;
    @FindBy(css = "a[href='/test_cases']")
    WebElement $testCasesButton;
    @FindBy(css = "a[href='/api_list']")
    WebElement $aPITestingButton;
    @FindBy(css = "a[href='https://www.youtube.com/c/AutomationExercise']")
    WebElement $videoTutorialsButton;
    @FindBy(css = "a[href='/contact_us']")
    WebElement $contactUsButton;

    //Headers
    @FindBy(xpath = "//h2[text()='Category']")
    WebElement $loginPageCategoryHeader;
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement $accountDeletedHeader;
    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement $accountCreatedHeader;


    //click on button methods
    public void clickOnHomeButton() {
        clickOn($homeButton);
        log.info("Well Done my guy! Click click on 'Home button' success!!");
    }

    public void clickOnProductsButton() {
        clickOn($productsButton);
        log.info("Well Done my guy! Click click on 'Products button' success!!");
    }

    public void clickOnCartButton() {
        clickOn($cartButton);
        log.info("Well Done my guy! Click click on 'Cart button' success!!");
    }

    public void clickOnSignupLoginButton() {
        clickOn($signupLoginButton);
        log.info("Well Done my guy! Click click on 'Signup/ login button' success!!");
    }

    public void clickOnTestCasesButton() {
        clickOn($testCasesButton);
        log.info("Well Done my guy! Click click on 'Test cases button' success!!");
    }

    public void clickOnAPITestingButton() {
        clickOn($aPITestingButton);
        log.info("Well Done my guy! Click click on 'API testing button' success!!");
    }

    public void clickOnVideoTutorialsButton() {
        clickOn($videoTutorialsButton);
        log.info("Well Done my guy! Click click on 'Video tutorials button' success!!");
    }

    public void clickOnContactUsButton() {
        clickOn($contactUsButton);
        log.info("Well Done my guy! Click click on 'Contact us button' success!!");
    }


    //get header text methods
    public String getCategoryHeaderText() {
        String text = getElementText($loginPageCategoryHeader);
        log.info("Well Done my boy! 'Category header' text acquisition success!!");
        return text;
    }

    public String getAccountCreatedHeaderText() {
        String text = getElementText($accountCreatedHeader);
        log.info("Well Done my boy! 'Account created header' text acquisition success!!");
        return text;
    }

    public String getAccountDeletedHeaderText() {
        String text = getElementText($accountDeletedHeader);
        log.info("Well Done my boy! 'Account deleted header' text acquistion success!!");
        return text;
    }

}
