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



    @Test
    public void validCred() {

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
        registrationPage.enterEmail("nassmerboutibouc03021973@gmail.com");
        waitFor(3);

        registrationPage.enterPassword("6101993&!amelboucetta");
        waitFor(3);

        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        String expectedLoginPageHeader = "Hello nassmerboutibouc03021973 (not nassmerboutibouc03021973? Log out)";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader,actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }
    @Test
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

//
        // check user is sign up successfully
//        String expectedErrorMessage = "Error: Please enter an account password.";
//        String actualErrorMessage = registrationPage.getErrorMessage();
//        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
//        log.info("user get error message success");
//        waitFor(3);
//
//    }
    }
    @Test(enabled = false)
    public void registerWithValidUsernameAndweekPassword() {

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
        registrationPage.enterEmail("nassmerboutibou@gmail.com");
        waitFor(3);

        registrationPage.enterPassword("");
        waitFor(3);

        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        String expectedLoginPageHeader = "Error: Please enter an account password.";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader,actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }

}


