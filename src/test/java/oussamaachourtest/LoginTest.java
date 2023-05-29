//package oussamaachourtest;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import us.piit.base.CommonAPI;
//import us.piit.pages.oussamaachourpages.HomePage;
//import us.piit.pages.oussamaachourpages.LoginRegisterPage;
//import us.piit.pages.oussamaachourpages.LostPasswordPage;
//import us.piit.pages.oussamaachourpages.MyAccountPage;
//import us.piit.utility.Utility;
//
//import java.util.Properties;
//
//public class LoginTest extends CommonAPI {
//    Logger log = LogManager.getLogger(LoginTest.class.getName());
//
//    Properties prop = Utility.loadProperties();
//
//    String validLoginUsername = Utility.decode(prop.getProperty("oussamaachour.login-username"));
//    String validLoginPassword = Utility.decode(prop.getProperty("oussamaachour.login-password"));
//
//    @Test(enabled = false)
//    public void validCredential() {
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
//
//        //Assert we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account btn on homepage
//        homePage.clickOnMyAccountLink();
//
//        // enter username, password and click on login btn on login page
//        loginRegisterPage.enterLoginUsername(validLoginUsername);
//        loginRegisterPage.enterLoginPassword(validLoginPassword);
//        loginRegisterPage.clickOnLoginBtn();
//
//
//        //make sure user lands on login page successfully
//        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());
//
//        String myAccountExpectedHeaderText = "My Account";
//        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
//        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
//    }
//
//    @Test(enabled = false)
//    public void invalidPassword() {
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //ensure we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account
//        homePage.clickOnMyAccountLink();
//        loginRegisterPage.enterLoginUsername(validLoginUsername);
//        loginRegisterPage.enterLoginPassword("InvalidLoginPassword");
//        loginRegisterPage.clickOnLoginBtn();
//
//        //validate error message
//        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginInvalidPasswordMessage());
//
//        String expectedLoginInvalidPasswordMessageText = "Error: The password you entered for the email address rkhan326@gmail.com is incorrect. Lost your password?";
//        String actualLoginInvalidPasswordMessageText = loginRegisterPage.getLoginInvalidPasswordMessageText();
//        Assert.assertEquals(expectedLoginInvalidPasswordMessageText, actualLoginInvalidPasswordMessageText);
//    }
//
//    @Test(enabled = false)
//    public void invalidUsername(){
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //ensure we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account
//        homePage.clickOnMyAccountLink();
//        loginRegisterPage.enterLoginUsername("InvalidLoginUsername");
//        loginRegisterPage.enterLoginPassword(validLoginPassword);
//        loginRegisterPage.clickOnLoginBtn();
//
//        //validate error message
//        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginInvalidUsernameMessage());
//
//        String expectedLoginInvalidUsernameMessageText = "Error: The username InvalidLoginUsername is not registered on this site. If you are unsure of your username, try your email address instead.";
//        String actualLoginInvalidUsernameMessageText = loginRegisterPage.getLoginInvalidUsernameMessageText();
//        Assert.assertEquals(expectedLoginInvalidUsernameMessageText, actualLoginInvalidUsernameMessageText);
//    }
//    @Test(enabled = false)
//    public void unrecognizedEmail(){
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //ensure we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account
//        homePage.clickOnMyAccountLink();
//        loginRegisterPage.enterLoginUsername("InvalidEmail@gmail.com");
//        loginRegisterPage.enterLoginPassword(validLoginPassword);
//        loginRegisterPage.clickOnLoginBtn();
//
//        //validate error message
//        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginUnrecognizedEmailMessage());
//
//        String expectedLoginUnrecognizedEmailMessageText = "Unknown email address. Check again or try your username.";
//        String actualLoginUnrecognizedEmailMessageText = loginRegisterPage.getLoginUnrecognizedEmailMessageText();
//        Assert.assertEquals(expectedLoginUnrecognizedEmailMessageText, actualLoginUnrecognizedEmailMessageText);
//    }
//
//
//
//    @Test (enabled = false)
//    public void resetPasswordRequest(){
//        LostPasswordPage lostPasswordPage = new LostPasswordPage(getDriver());
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //Assert we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account btn on homepage
//        homePage.clickOnMyAccountLink();
//
//        //click on lost your password link
//        loginRegisterPage.clickOnLostYourPasswordLink();
//
//        //make sure user lands on lost password page successfully
//        Assert.assertTrue(lostPasswordPage.checkPresenceOfLostPasswordHeader());
//
//        String expectedLostPasswordHeaderText = "Lost password";
//        String actualLostPasswordHeaderText = lostPasswordPage.getLostPasswordHeaderText();
//        Assert.assertEquals(expectedLostPasswordHeaderText, actualLostPasswordHeaderText);
//
//        //enter username or email and enter password reset button.
//        lostPasswordPage.enterLostPasswordUsernameOrEmail(validLoginUsername);
//        lostPasswordPage.clickOnResetPasswordBtn();
//
//        //Validate
//        Assert.assertTrue(lostPasswordPage.checkPresenceOfPasswordResetEmailSentMessage());
//
//        String expectedPasswordResetEmailSentMessageText = "Password reset email has been sent.";
//        String actualPasswordResetEmailSentMessageText = lostPasswordPage.getPasswordResetEmailSentMessageText();
//        Assert.assertEquals(expectedPasswordResetEmailSentMessageText, actualPasswordResetEmailSentMessageText);
//    }
//
//    @Test(enabled = false, priority = 0)
//    public void validateStrongPassword(){
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //ensure we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account
//        homePage.clickOnMyAccountLink();
//
//        //enter fake strong password
//        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.fakeStrongPassword());
//
//        //Assert that fake strong password returns the strong validation
//        String expectedPasswordStrengthMessage = "Strong";
//        String actualPasswordStrengthMessage = loginRegisterPage.getStrongPasswordStrengthText();
//        System.out.println(actualPasswordStrengthMessage);
//        Assert.assertEquals(expectedPasswordStrengthMessage,actualPasswordStrengthMessage);
//
//
//    }
//    @Test(enabled = false, priority = 1)
//    public void validateWeakPassword(){
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //ensure we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account
//        homePage.clickOnMyAccountLink();
//
//        //enter fake strong password
//        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.fakeWeakPassword());
//
//        //Assert that weak strong password returns the strong validation
//        String expectedPasswordStrengthMessage = "Weak - Please enter a stronger password.";
//        String actualPasswordStrengthMessage = loginRegisterPage.getWeakPasswordStrengthText();
//        Assert.assertEquals(expectedPasswordStrengthMessage,actualPasswordStrengthMessage);
//    }
//    @Test(enabled = false, priority = 2)
//    public void validateMediumPassword(){
//        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        //ensure we are on the correct website
//        String expectedTitle = "Welcome to Worldwide Electronics Store";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on my account
//        homePage.clickOnMyAccountLink();
//
//        //enter fake strong password
//        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.fakeMediumPassword());
//
//        //Assert that weak strong password returns the strong validation
//        String expectedPasswordStrengthMessage = "Medium";
//        String actualPasswordStrengthMessage = loginRegisterPage.getMediumPasswordStrengthText();
//        Assert.assertEquals(expectedPasswordStrengthMessage,actualPasswordStrengthMessage);
//
//
//    }
//
//}
