package oussamaachourtest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.LoginRegisterPage;
import us.piit.pages.oussamaachourpages.MyAccountPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Properties prop = Utility.loadProperties();

    String validLoginUsername = Utility.decode(prop.getProperty("oussamaachour.login-username"));
    String validLoginPassword = Utility.decode(prop.getProperty("oussamaachour.login-password"));

    @Test(enabled = false)
    public void validCredential() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account btn on homepage
        homePage.clickOnMyAccountLink();

        // enter username, password and click on login btn on login page
        loginRegisterPage.enterLoginUsername(validLoginUsername);
        loginRegisterPage.enterLoginPassword(validLoginPassword);
        loginRegisterPage.clickOnLoginBtn();


        //make sure user lands on login page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
    }

    @Test(enabled = false)
    public void invalidPassword() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();
        loginRegisterPage.enterLoginUsername(validLoginUsername);
        loginRegisterPage.enterLoginPassword("InvalidPassword");
        loginRegisterPage.clickOnLoginBtn();

        //validate error message
        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginErrorMessage());
    }







    public void resetPassword(){

    }

    public void validateStrongPassword(){


    }
    public void InvalidPassword(){


    }


}
