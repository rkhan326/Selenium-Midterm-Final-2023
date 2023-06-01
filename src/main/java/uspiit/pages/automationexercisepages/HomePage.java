package uspiit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class HomePage extends CommonAPI {

    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public String wellDoneG = "Well done my G! ";
    public String wellDoneBoy = "Well done my boy! ";
    public String wellDoneGuy = "Well done my guy! ";
    public String headerValidationSuccess = " Header validation success!!";
    public String errorMessageSuccess = " Error message success!!";

    //Buttons
    @FindBy(css = "a[href='/']")
    WebElement $homeButton;
    @FindBy(css = ".right.control-carousel.hidden-xs")
    WebElement $nextRightButton;
    @FindBy(css = ".left.control-carousel.hidden-xs")
    WebElement $nextLeftButton;
    @FindBy(css = ".right.recommended-item-control")
    WebElement $nextRightRecommendedItemsButton;
    @FindBy(css = ".left.recommended-item-control")
    WebElement $nextLeftRecommededItemsButton;
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
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement $subscriptionHeader;
    //click on button methods
    public void clickOnProductsButton() {
        clickOn($productsButton);
        log.info("Well Done my guy! Click click on 'Products button' success!!");
    }
    public void clickOnCartButton() {
        clickOn($cartButton);
        log.info(wellDoneGuy + "Click click on 'Cart button' success!!");
    }
    public void clickOnSignupLoginButton() {
        clickOn($signupLoginButton);
        log.info(wellDoneGuy + "Click click on 'Signup/ login button' success!!");
    }
    public void clickOnTestCasesButton() {
        clickOn($testCasesButton);
        log.info(wellDoneGuy + "Click click on 'Test cases button' success!!");
    }
    public void clickOnAPITestingButton() {
        clickOn($aPITestingButton);
        log.info(wellDoneGuy + "Click click on 'API testing button' success!!");
    }
    public void clickOnVideoTutorialsButton() {
        clickOn($videoTutorialsButton);
        log.info(wellDoneGuy + "Click click on 'Video tutorials button' success!!");
    }
    public void clickOnContactUsButton() {
        clickOn($contactUsButton);
        log.info(wellDoneGuy + "Click click on 'Contact us button' success!!");
    }

    public void clickOnNextRightButton() {
        clickOn($nextRightButton);
        log.info(wellDoneGuy + "Click click on 'next right button' success!!");
    }
    public void clickOnNextLeftRecommendedItemsButton() {
        clickOn($nextLeftRecommededItemsButton);
        log.info(wellDoneGuy + "Click click on 'next left button' success!!");
    }
    public void clickOnNextRightRecommendedItemsButton() {
        clickOn($nextRightRecommendedItemsButton);
        log.info(wellDoneGuy + "Click click on 'next right button' success!!");
    }
    public void clickOnNextLeftButton() {
        clickOn($nextLeftButton);
        log.info(wellDoneGuy + "Click click on 'next left button' success!!");
    }
    //get header text methods
    public String getCategoryHeaderText() {
        String text = getElementText($loginPageCategoryHeader);
        log.info(wellDoneBoy + "'Category header' text acquisition success!!");
        return text;
    }
    public String getAccountCreatedHeaderText() {
        String text = getElementText($accountCreatedHeader);
        log.info(wellDoneBoy + "'Account created header' text acquisition success!!");
        return text;
    }
    public String getAccountDeletedHeaderText() {
        String text = getElementText($accountDeletedHeader);
        log.info(wellDoneBoy + "'Account deleted header' text acquistion success!!");
        return text;
    }
    public void scrollToViewRecommendedItems(WebDriver driver) {
        scrollToView(driver, $subscriptionHeader);
        log.info("Well done my boy! 'Maxi Dress Image' scroll to view success!!");
    }
}
