package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.CartPage;
import uspiit.pages.automationexercisepages.ContactUsPage;
import uspiit.pages.automationexercisepages.HomePage;


public class DataProviderTest extends CommonAPI {
    Logger log = LogManager.getLogger(CartPage.class.getName());

    @DataProvider(name = "reviewData")
    public Object[][] provideReviewData() {
        return new Object[][] {
                { "John", "johnnyboy@gmail.com", "Green Dress", "The best prodcut ever! "},
                { "Alice", "aliceinwonderland@gmail.com", "Blue Dress", "Not the best quality."},
                { "Bob", "bobbyboy@gmail.com", "Red Dress", "I likeeeee!!" }
        };
    }
    @Test(dataProvider = "reviewData")
    public void reviewUsingDataProvider23(String nameDB, String emailDB, String subjectDB, String messageDB) {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        homePage.clickOnContactUsButton();
        typeText(contactUsPage.$contactUsReviewNameField, nameDB);
        typeText(contactUsPage.$contactUsReviewEmailField,emailDB);
        typeText(contactUsPage.$contactUsReviewSubjectField,subjectDB);
        typeText(contactUsPage.$contactUsReviewField,messageDB);
        clickWithActions(getDriver(), contactUsPage.$submitContactUsReviewButton);
        log.info("Ya did it! Review submittion success");

        System.out.println("Name: " + nameDB + ", Email: " + emailDB + ", Subject: " + subjectDB+ ", Message: " + messageDB);
    }
}

