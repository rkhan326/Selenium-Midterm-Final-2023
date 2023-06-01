package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.scaledupitpages.HomePage;
import uspiit.pages.scaledupitpages.LoginPage;
import uspiit.utility.Utility;

import java.util.Properties;

public class LogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    Properties prop = Utility.loadProperties();

    String validUsername = Utility.decode(prop.getProperty("scalledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scalledupit.password"));


    @Test(enabled = true,priority = 0)
    public void logout() {

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

        //hover hover & click on logout link
        homePage.ClickOnLogoutLink();
        waitFor(3);

        //check user is landed to the login page
        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
        log.info("login page header is displayed");
        String expectedLoginPageHeaderText = "My account";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
        captureScreenshot();
    }

}



