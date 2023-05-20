package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LostPasswordPage extends CommonAPI {
    Logger log = LogManager.getLogger(LostPasswordPage.class.getName()) ;
    public LostPasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='entry-title' and text() = 'Lost password']")
    WebElement lostPasswordHeader;

    @FindBy(css = "#user_login")
    WebElement lostPasswordUsernameOrEmailField;

    @FindBy(xpath = "//button[text()='Reset password']")
    WebElement resetPasswordBtn;

    @FindBy(xpath = "//div[@class = 'woocommerce-message']")
    WebElement passwordResetEmailSentMessage;


    public boolean checkPresenceOfLostPasswordHeader(){
        boolean lostPasswordPageHeaderIsDisplayed = isVisible(lostPasswordHeader);
        log.info("Lost password page header is displayed");
        return lostPasswordPageHeaderIsDisplayed;
    }

    public String getLostPasswordHeaderText(){
        String lostPasswordActualHeaderText = getElementText(lostPasswordHeader);
        log.info("user login page validation text match success");
        return lostPasswordActualHeaderText;
    }
    public void enterLostPasswordUsernameOrEmail(String usernameOrEmail){
        typeText(lostPasswordUsernameOrEmailField,usernameOrEmail);
        log.info("enter lost password username or email success");
    }
     public void clickOnResetPasswordBtn(){
        clickOn(resetPasswordBtn);
         log.info("click on reset button success");
     }
    public boolean checkPresenceOfPasswordResetEmailSentMessage(){
        boolean passwordResetEmailSentMessageIsDisplayed = isVisible(passwordResetEmailSentMessage);
        log.info("password reset email sent message is displayed");
        return passwordResetEmailSentMessageIsDisplayed;
    }

    public String getPasswordResetEmailSentMessageText(){
        String lostPasswordActualHeaderText = getElementText(passwordResetEmailSentMessage);
        log.info("Password Reset Email Sent Message text match success");
        return lostPasswordActualHeaderText;
    }



}
