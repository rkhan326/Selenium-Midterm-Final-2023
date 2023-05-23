package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;

public class LoginTest extends CommonAPI {

    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validLoginCredentials(){

        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);

        //click on signup/ login button
        homePage.clickClickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);

        //enter login email address, password and click login button
        loginpage.enterValidLoginEmailInLoginEmailField();
        loginpage.enterValidLoginPasswordInLoginPasswordField();
        loginpage.clickClickOnLoginButton();

        //validate logged in icon
        loginpage.validatePresenceOfloggedInIcon();

        //logout
        loginpage.clickClickOnLogoutButton();
    }

    @Test
    public void invalidLoginCredentials(){

    LoginPage loginpage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);

        //click on signup/ login button
        homePage.clickClickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);

        //enter login email address, password and click login button
        loginpage.enterInvalidLoginEmailInLoginEmailField();
        loginpage.enterInvalidLoginPasswordInLoginPasswordField();
        loginpage.clickClickOnLoginButton();

        //validate error message
        String expectedLoginErrorMessage = "Your email or password is incorrect!";
        String actualLoginErrorMessage = loginpage.getLoginMessageErrorText();
        Assert.assertEquals(expectedLoginErrorMessage,actualLoginErrorMessage);

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
//        loginpage.clickClickOnLoginButton();
//
//        //originalgangster1@gmail.com
//        //ontheblock
//        //validate logged in message
//        String expectedCategoryHeader1 = "CATEGORY";
//        String actualCategoryHeader1 = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader1,actualCategoryHeader1);
//
//        //logout
//        loginpage.clickClickOnLogoutButton();
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
//        loginpage.clickClickOnLoginButton();
//
//        //originalgangster1@gmail.com
//        //ontheblock
//        //validate logged in message
//        String expectedCategoryHeader1 = "CATEGORY";
//        String actualCategoryHeader1 = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader1,actualCategoryHeader1);
//
//        //logout
//        loginpage.clickClickOnLogoutButton();
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
//        loginpage.clickClickOnLoginButton();
//
//        //originalgangster1@gmail.com
//        //ontheblock
//        //validate logged in message
//        String expectedCategoryHeader1 = "CATEGORY";
//        String actualCategoryHeader1 = homePage.getCategoryHeaderText();
//        Assert.assertEquals(expectedCategoryHeader1,actualCategoryHeader1);
//
//        //logout
//        loginpage.clickClickOnLogoutButton();
//    }
//
}
