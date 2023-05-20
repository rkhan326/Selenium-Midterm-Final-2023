package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.LoginPage;
import us.piit.pages.scaledupitpages.RegistrationPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegistrationTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegistrationTest.class.getName());
    Properties prop = Utility.loadProperties();




   // @Test(enabled = true,priority = 0)
    public void registerWithValidUsernameAndValidPassword() {

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail("admin.piit@gmail.com");
        waitFor(3);



        registrationPage.enterPassword("amelboucetta96");
        waitFor(3);

        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfValidUsPassRegisterPageHeader());

        String expectedLoginPageHeader = "Hello admin.piit (not admin.piit? Log out)";
        String actualLoginPageHeader = registrationPage.getValidUsPassRegisterPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader,actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }
  //  @Test(enabled = true,priority = 1)
    public void registerWithValidUsername() {

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail("nana85@gmail.com");
        waitFor(3);

        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfValidUsernameErrorMessage());
        String expectedErrorMessage1 = "Error: Please enter an account password.";
        String actualErrorMessage1 = registrationPage.getValidUsernameErrorMessage();
        Assert.assertEquals(expectedErrorMessage1,actualErrorMessage1);
        waitFor(3);


    }
    @Test(enabled = true,priority = 2)
    public void registerWithValidUsernameAndWeekPassword() {

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail("nana216@gmail.com");
        waitFor(3);

        registrationPage.enterPassword("mami");
        waitFor(3);

        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfWeekPassRegisterPageHeader());
        String expectedLoginPageHeader2 = "Hello nana216 (not nana216? Log out)";
        String actualLoginPageHeader2 = registrationPage.getValidWeekPassRegisterPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader2,actualLoginPageHeader2);
        waitFor(3);

    }

}
