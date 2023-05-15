package oussamaachourtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.LoginPage;
import us.piit.pages.oussamaachourpages.MyAccountPage;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());



    @Test
    public void validCredential() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account btn on homepage
        homePage.clickOnMyAccountLink();

        // enter username, password and click on login btn on login page
        loginPage.enterUsername("rkhan326@gmail.com");
        loginPage.enterPassword("HelloWorld123!");
        loginPage.clickOnLoginBtn();


        //make sure user lands on login page successfully

        boolean myAccountPageHeadedisDisplayed = isVisible("//h1[@class='entry-title']");
        Assert.assertTrue(myAccountPageHeadedisDisplayed);
        log.info("My Account page header is displayed");
        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = getElementText("//h1[@class='entry-title']");
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
        log.info("user login page validation text match success");
    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        MyAccountPage.clickOnMyAccountLink();
        loginPage.enterUsername("rkhan326@gmail.com");
        loginPage.enterPassword("HelloWorld123");
        loginPage.clickOnLoginBtn();

        //validate error message
        boolean errorMessageIsDisplayed = isVisible("//li[text()=\" The password you entered for the email address \"]");
        Assert.assertTrue(errorMessageIsDisplayed);
        log.info("error message validation success.");
    }

    public void resetPassword(){

    }

    public void validateStrongPassword(){


    }
    public void InvalidPassword(){


    }


}
