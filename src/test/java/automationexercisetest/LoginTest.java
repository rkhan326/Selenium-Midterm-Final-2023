package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;

public class LoginTest extends CommonAPI {

    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validLoginCredentials1() {

        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);
        log.info(homePage.wellDoneboy.concat(expectedCategoryHeader).concat(homePage.headerValidationSuccess));

        //click on signup/ login button
        homePage.clickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneboy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));

        //enter login email address, password and click login button
        loginpage.enterValidLoginEmailInLoginEmailField();
        loginpage.enterValidLoginPasswordInLoginPasswordField();
        loginpage.clickOnLoginButton();

        //validate logged in icon
        loginpage.validatePresenceOfloggedInIcon();


        //logout
        loginpage.clickOnLogoutButton();
    }

    @Test
    public void invalidLoginCredentials2() {

        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);
        log.info(homePage.wellDoneboy.concat(expectedCategoryHeader).concat(homePage.headerValidationSuccess));

        //click on signup/ login button
        homePage.clickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneboy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));

        //enter login email address, password and click login button
        loginpage.enterInvalidLoginEmailInLoginEmailField();
        loginpage.enterInvalidLoginPasswordInLoginPasswordField();
        loginpage.clickOnLoginButton();

        //validate error message
        String expectedLoginErrorMessage = "Your email or password is incorrect!";
        String actualLoginErrorMessage = loginpage.getLoginMessageErrorText();
        Assert.assertEquals(expectedLoginErrorMessage, actualLoginErrorMessage);
        log.info(homePage.wellDoneboy.concat(expectedLoginErrorMessage).concat(homePage.errorMessageSuccess));

    }

//    @Test
//    public void invalidLoginPassword(){
//
//        //validate home page
//        String expectedCategoryHeader = "CATEGORY";
//        String actualCategoryHeader = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);
//
//        //click on signup/ login button
//        homePage.clickOnSignupLoginButton();
//
//        //validate login page
//        String expectedLoginToYourAccountHeader = "Login to your account";
//        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
//        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);
//
//        //enter login email address, password and click login button
//        loginpage.enterLoginEmailInLoginEmailField();
//        loginpage.enterLoginPasswordInLoginPasswordField();
//        loginpage.clickOnLoginButton();
//
//        //originalgangster1@gmail.com
//        //ontheblock
//        //validate logged in message
//        String expectedCategoryHeader1 = "CATEGORY";
//        String actualCategoryHeader1 = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader1,actualCategoryHeader1);
//
//        //logout
//        loginpage.clickOnLogoutButton();
//    }
//    @Test
//    public void missingLoginEmail(){
//
//        //validate home page
//        String expectedCategoryHeader = "CATEGORY";
//        String actualCategoryHeader = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);
//
//        //click on signup/ login button
//        homePage.clickOnSignupLoginButton();
//
//        //validate login page
//        String expectedLoginToYourAccountHeader = "Login to your account";
//        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
//        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);
//
//        //enter login email address, password and click login button
//        loginpage.enterLoginEmailInLoginEmailField();
//        loginpage.enterLoginPasswordInLoginPasswordField();
//        loginpage.clickOnLoginButton();
//
//        //originalgangster1@gmail.com
//        //ontheblock
//        //validate logged in message
//        String expectedCategoryHeader1 = "CATEGORY";
//        String actualCategoryHeader1 = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader1,actualCategoryHeader1);
//
//        //logout
//        loginpage.clickOnLogoutButton();
//    }
//    @Test
//    public void missingLoginPassword(){
//
//        //validate home page
//        String expectedCategoryHeader = "CATEGORY";
//        String actualCategoryHeader = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);
//
//        //click on signup/ login button
//        homePage.clickClickOnSignupLoginButton();
//
//        //validate login page
//        String expectedLoginToYourAccountHeader = "Login to your account";
//        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
//        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);
//
//        //enter login email address, password and click login button
//        loginpage.enterLoginEmailInLoginEmailField();
//        loginpage.enterLoginPasswordInLoginPasswordField();
//        loginpage.clickOnLoginButton();
//
//        //originalgangster1@gmail.com
//        //ontheblock
//        //validate logged in message
//        String expectedCategoryHeader1 = "CATEGORY";
//        String actualCategoryHeader1 = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader1,actualCategoryHeader1);
//
//        //logout
//        loginpage.clickOnLogoutButton();
//    }
//
}
