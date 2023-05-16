package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.HomePage;
import us.piit.pages.nopcommercepages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("nopcommerce.username"));
    String validPassword = Utility.decode(prop.getProperty("nopcommerce.password"));


    @Test
    public void validCredential() {
        HomePage homePage=new HomePage(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());

        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        waitFor(1);
        loginPage.clickOnLoginBtn();


        String expectedText = "Welcome to our store";
        String actualText = loginPage.getLoginPageSuccessText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void invalidPassword() {

        HomePage homePage=new HomePage(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());

        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword("invalid password");
        waitFor(1);
        loginPage.clickOnLoginBtn();


        String expectedText = "Login was unsuccessful. Please correct the errors and try again";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(expectedText,actualText);
        log.info("login page not success");
    }
}
