package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    Properties prop = Utility.loadProperties();
//    String validUsername = Utility.decode(prop.getProperty("nopcommerce.username"));
    RegisterTest registerTest= new RegisterTest();
    String validUsername= registerTest.email;
    String validPassword = Utility.decode(prop.getProperty("nopcommerce.password"));
//    String validPassword ="mahmud123";

    @Test(priority = 1)
    public void validCredential() {
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

//        String expectedText="Log out";
//        String actualText = loginPage.loginValidationText();
//        Assert.assertEquals(expectedText,actualText);

    }

    @Test(priority = 2)
    public void invalidPassword() {
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


        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(expectedText,actualText);
        log.info("login page not success");
    }
}
