package oussamaachourtest; //8 tests

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.oussamaachourpages.HomePage;
import uspiit.pages.oussamaachourpages.LoginRegisterPage;
import uspiit.pages.oussamaachourpages.LostPasswordPage;
import uspiit.pages.oussamaachourpages.MyAccountPage;

import uspiit.utility.ConnectDB;
import uspiit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Properties prop = Utility.loadProperties();

    ConnectDB connectDB = new ConnectDB();

    String validUsername = connectDB.getTableColumnData("select * from login","username").get(0);
    String validPassword = connectDB.getTableColumnData("select * from login","password").get(0);
    String validUrl = connectDB.getTableColumnData("select * from login","url").get(0);
    String validLoginUsername = Utility.decode(prop.getProperty("oussamaachour.login-username"));
    String validLoginPassword = Utility.decode(prop.getProperty("oussamaachour.login-password"));

    @Test(enabled = true)//groups = {"sanity"},priority = 1,alwaysRun = false
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
        loginRegisterPage.enterLoginUsername(validUsername);
        loginRegisterPage.enterLoginPassword(validPassword);
        loginRegisterPage.clickOnLoginBtn();


        //make sure user lands on login page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
    }

    @Test(groups = {"sanity"},priority = 0,enabled = true)
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
        loginRegisterPage.enterLoginPassword("InvalidLoginPassword");
        loginRegisterPage.clickOnLoginBtn();

        //validate error message
        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginInvalidPasswordMessage());

        String expectedLoginInvalidPasswordMessageText = "Error: The password you entered for the email address rkhan326@gmail.com is incorrect. Lost your password?";
        String actualLoginInvalidPasswordMessageText = loginRegisterPage.getLoginInvalidPasswordMessageText();
        Assert.assertEquals(expectedLoginInvalidPasswordMessageText, actualLoginInvalidPasswordMessageText);
    }


    @Test(groups = {"sanity"},priority = 1,enabled = true)
    public void invalidUsername(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();
        loginRegisterPage.enterLoginUsername("InvalidLoginUsername");
        loginRegisterPage.enterLoginPassword(validLoginPassword);
        loginRegisterPage.clickOnLoginBtn();

        //validate error message
        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginInvalidUsernameMessage());

        String expectedLoginInvalidUsernameMessageText = "Error: The username InvalidLoginUsername is not registered on this site. If you are unsure of your username, try your email address instead.";
        String actualLoginInvalidUsernameMessageText = loginRegisterPage.getLoginInvalidUsernameMessageText();
        Assert.assertEquals(expectedLoginInvalidUsernameMessageText, actualLoginInvalidUsernameMessageText);
    }
    @Test(groups = {"sanity"},priority = 2,enabled = true)
    public void unrecognizedEmail(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();
        loginRegisterPage.enterLoginUsername("InvalidEmail@gmail.com");
        loginRegisterPage.enterLoginPassword(validLoginPassword);
        loginRegisterPage.clickOnLoginBtn();

        //validate error message
        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginUnrecognizedEmailMessage());

        String expectedLoginUnrecognizedEmailMessageText = "Unknown email address. Check again or try your username.";
        String actualLoginUnrecognizedEmailMessageText = loginRegisterPage.getLoginUnrecognizedEmailMessageText();
        Assert.assertEquals(expectedLoginUnrecognizedEmailMessageText, actualLoginUnrecognizedEmailMessageText);
    }



    @Test (groups = {"smoke"},priority = 3,enabled = true)
    public void resetPasswordRequest(){
        LostPasswordPage lostPasswordPage = new LostPasswordPage(getDriver());
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account btn on homepage
        homePage.clickOnMyAccountLink();

        //click on lost your password link
        loginRegisterPage.clickOnLostYourPasswordLink();

        //make sure user lands on lost password page successfully
        Assert.assertTrue(lostPasswordPage.checkPresenceOfLostPasswordHeader());

        String expectedLostPasswordHeaderText = "Lost password";
        String actualLostPasswordHeaderText = lostPasswordPage.getLostPasswordHeaderText();
        Assert.assertEquals(expectedLostPasswordHeaderText, actualLostPasswordHeaderText);

        //enter username or email and enter password reset button.
        lostPasswordPage.enterLostPasswordUsernameOrEmail(validLoginUsername);
        lostPasswordPage.clickOnResetPasswordBtn();

        //Validate
        Assert.assertTrue(lostPasswordPage.checkPresenceOfPasswordResetEmailSentMessage());

        String expectedPasswordResetEmailSentMessageText = "Password reset email has been sent.";
        String actualPasswordResetEmailSentMessageText = lostPasswordPage.getPasswordResetEmailSentMessageText();
        Assert.assertEquals(expectedPasswordResetEmailSentMessageText, actualPasswordResetEmailSentMessageText);
    }

    @Test(groups = {"sanity"},priority = 4,enabled = true)
    public void validateStrongPassword(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter fake strong password
        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.fakeStrongPassword());

        //Assert that fake strong password returns the strong validation
        String expectedPasswordStrengthMessage = "Strong";
        String actualPasswordStrengthMessage = loginRegisterPage.getStrongPasswordStrengthText();
        System.out.println(actualPasswordStrengthMessage);
        Assert.assertEquals(expectedPasswordStrengthMessage,actualPasswordStrengthMessage);

    }
    @Test(groups = {"smoke"},priority = 4,enabled = true)
    public void validateWeakPassword(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter fake strong password
        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.fakeWeakPassword());

        //Assert that weak strong password returns the strong validation
        String expectedPasswordStrengthMessage = "Weak - Please enter a stronger password.";
        String actualPasswordStrengthMessage = loginRegisterPage.getWeakPasswordStrengthText();
        Assert.assertEquals(expectedPasswordStrengthMessage,actualPasswordStrengthMessage);
    }
    @Test(groups = {"sanity", "smoke", "regression"},priority = 5,enabled = true)
    public void validateMediumPassword(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter fake strong password
        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.fakeMediumPassword());

        //Assert that weak strong password returns the strong validation
        String expectedPasswordStrengthMessage = "Medium";
        String actualPasswordStrengthMessage = loginRegisterPage.getMediumPasswordStrengthText();
        Assert.assertEquals(expectedPasswordStrengthMessage,actualPasswordStrengthMessage);


    }

}
