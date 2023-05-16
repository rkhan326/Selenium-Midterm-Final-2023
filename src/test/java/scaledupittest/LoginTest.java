package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest  extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Properties prop = Utility.loadProperties();

    String validUsername = Utility.decode(prop.getProperty("scalledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scalledupit.password"));


    @Test
    public void validCred() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register/login
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter username , password and click login
        loginPage.enterUsername(validUsername);
        waitFor(3);
        loginPage.enterPassword(validPassword);
        waitFor(3);
        loginPage.clickOnLoginBtn();
        waitFor(3);



        // check user is logged in
        String expectedLoginPageHeader = "Hello boucettaamel811 (not boucettaamel811? Log out)";
        String actualLoginPageHeader = loginPage.getMainLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader,actualLoginPageHeader);
        log.info("user  logged in success");
        waitFor(3);

    }
    @Test
    public void missingusername() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnSignInButton();
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


        // check error message
        String expectedError = "Error: Username is required.";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        log.info("error message validate  success");

    }
    @Test
    public void missingpassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnSignInButton();
        loginPage.enterUsername(validUsername);
        loginPage.clickOnLoginBtn();


        // check error message
        String expectedError2 = "Error: The password field is empty.";
        String actualError2 = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError2, actualError2);
        log.info("error message validate  success");

    }
    @Test
    public void invalidCred() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnSignInButton();
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


        // check user is logged in
        String expectedError3 = "Error: The username invalidUsername is not registered on this site. If you are unsure of your username, try your email address instead.";
        String actualError3 = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError3, actualError3);
        log.info("error message validate  success");

    }

}
