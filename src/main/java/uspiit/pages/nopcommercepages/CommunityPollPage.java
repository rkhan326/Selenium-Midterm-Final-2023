package uspiit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class CommunityPollPage extends CommonAPI {
    Logger log = LogManager.getLogger(CommunityPollPage.class.getName());
    public CommunityPollPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //************************Locator*******************************
    @FindBy(xpath = "//input[@id='pollanswers-1']")
    WebElement excellentRadioButtonLocator;
    @FindBy(xpath = "//button[@id='vote-poll-1']")
    WebElement voteButtonLocator;
    @FindBy(xpath = "//div[@id='block-poll-vote-error-1']")
    WebElement voteErrorMessageLocator;

    @FindBy(xpath = "//input[@id='pollanswers-4']")
    WebElement veryGoodRadioButtonLocator;
    @FindBy(xpath = "//strong[normalize-space()='Community poll']")
    WebElement voteValidation;



    // ********************Reusable Methods*************************
    public void clickOnExcellentRadioButton(){
        clickOn(excellentRadioButtonLocator);
        log.info("click on Excellent radio button Success");
    }
    public void clickOnVoteButton(){
        clickOn(voteButtonLocator);
        waitFor(1);
        log.info("click on Vote button Success");
    }
    public String voteSuccessfullyConfirmed() {
        String text = getElementText(voteErrorMessageLocator);
        log.info("Vote successfully confirmed.");
        return text;
    }

    public void clickOnEVeryGoodRadioButton(){
        clickOn(veryGoodRadioButtonLocator);
        log.info("click on Excellent radio button Success");
    }
    public String voteValidationText() {
        String text = getElementText(voteValidation);
        log.info("vote Validation successfully.");
        return text;
    }




}
