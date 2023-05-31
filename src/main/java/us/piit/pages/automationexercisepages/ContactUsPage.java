package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import us.piit.base.CommonAPI;
import us.piit.utility.ExcelReader;

import java.io.File;


public class ContactUsPage extends CommonAPI {

    Logger log = LogManager.getLogger(ContactUsPage.class.getName());
    public ContactUsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    String currentDir = System.getProperty("user.dir");
    String path1 = currentDir + File.separator + "data" + File.separator+"automationExsercise.xlsx";

    ExcelReader excelReader = new ExcelReader(path1);

    String nameDB = excelReader.getStringDataFromCell("automaticExercise",1 ,0);
    String emailDB = excelReader.getStringDataFromCell("automaticExercise",1 ,1);
    String subjectDB = excelReader.getStringDataFromCell("automaticExercise",1 ,2);
    String messageDB = excelReader.getStringDataFromCell("automaticExercise", 1,3);


    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement $contactUsHeader;
    @FindBy(css = "input[data-qa='name']")
    public WebElement $contactUsReviewNameField;
    @FindBy(css = "input[data-qa='email']")
    public WebElement $contactUsReviewEmailField;
    @FindBy(css = "input[data-qa='subject']")
    public WebElement $contactUsReviewSubjectField;
    @FindBy(css = "textarea[data-qa='message']")
    public WebElement $contactUsReviewField;
    @FindBy(css = ".btn.btn-primary.pull-left.submit_form")
    public WebElement $submitContactUsReviewButton;

    public String getContactUsHeaderText() {
        String text = getElementText($contactUsHeader);
        log.info("Ya did it! 'Contact Us' text acquisition success!!");
        return text;
    }


    public void enterReviewContactUsPage(WebDriver driver) {
        typeText($contactUsReviewNameField,"Joe");
        typeText($contactUsReviewEmailField,"joe@gmail.com");
        typeText($contactUsReviewSubjectField,"Cool");
        typeText($contactUsReviewField,"I'm impressed with the dress!");
        clickWithActions(driver,$submitContactUsReviewButton );
        log.info("Ya did it! Review submittion success");
    }
}
