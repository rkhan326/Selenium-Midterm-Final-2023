package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.ContactUsPage;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.VideoTutorialsPage;
import us.piit.utility.DataProviderClass;
import us.piit.utility.ExcelReader;

import java.io.File;
import java.io.IOException;

public class ContactUsPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());
    public static String currentDir = System.getProperty("user.dir");

    @Test
    public void contactUsPageButton28() {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        homePage.clickOnContactUsButton(); //navigate to products page

        //validate page header
        String expectedContactUsHeader = "GET IN TOUCH";
        String actualContactUsHeader= contactUsPage.getContactUsHeaderText();
        Assert.assertEquals(actualContactUsHeader, expectedContactUsHeader);
        log.info(homePage.wellDoneBoy.concat(expectedContactUsHeader).concat(homePage.headerValidationSuccess));
    }
    @Test
    public void contactUsSubmitReview29() {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        homePage.clickOnContactUsButton(); //navigate to products page

        //validate page header
        String expectedYoutubeHeader = "GET IN TOUCH";
        String actualYoutubeHeader= contactUsPage.getContactUsHeaderText();
        Assert.assertEquals(actualYoutubeHeader, expectedYoutubeHeader);
        log.info(homePage.wellDoneBoy.concat(expectedYoutubeHeader).concat(homePage.headerValidationSuccess));

        contactUsPage.enterReviewContactUsPage(getDriver()); //submit Review
    }

//    @DataProvider(name = "automaticExercise")
//    public Object[][] provideAutomaticExerciseReviewData() throws IOException {
//        String path1 = currentDir + File.separator + "automaticExercise" + File.separator + "automaticExercise.xlsx";
//        ExcelReader excelReader = new ExcelReader(path1);
//        Object[][] obj1 = excelReader.getExcelData(path1,"automaticExercise");
//        return obj1;
//    }
//    @Test (dataProvider = "automaticExercise")
//    public void contactUsSubmitReview30(String nameDB, String emailDB, String subjectDB, String messageDB) {
//        HomePage homePage = new HomePage(getDriver());
//        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
//
//        homePage.clickOnContactUsButton(); //navigate to products page
//
//        //validate page header
//        String expectedYoutubeHeader = "GET IN TOUCH";
//        String actualYoutubeHeader= contactUsPage.getContactUsHeaderText();
//        Assert.assertEquals(actualYoutubeHeader, expectedYoutubeHeader);
//        log.info(homePage.wellDoneBoy.concat(expectedYoutubeHeader).concat(homePage.headerValidationSuccess));
//
//        typeText(contactUsPage.$contactUsReviewNameField,nameDB);
//        typeText(contactUsPage.$contactUsReviewEmailField,emailDB);
//        typeText(contactUsPage.$contactUsReviewSubjectField,subjectDB);
//        typeText(contactUsPage.$contactUsReviewField,messageDB);
//        clickWithActions(getDriver(),contactUsPage.$submitContactUsReviewButton );
//        log.info("Ya did it! Review submittion success");
//    }
}
