package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.HomePage;
import us.piit.pages.nopcommercepages.LoginPage;
import us.piit.utility.ExcelReader;
import us.piit.utility.Utility;

import java.io.File;
import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"nopcommercedata.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    Properties prop = Utility.loadProperties();
//    String validEmail = Utility.decode(prop.getProperty("nopcommerce.username"));
    String validEmail= excelReader.getStringDataFromCell("data",10,1);
    String validPassword =excelReader.getStringDataFromCell("data",8,1);
//    String validPassword = Utility.decode(prop.getProperty("nopcommerce.password"));
//    String validPassword ="mahmud123";

    @Test(groups = {"sanity"} , priority = 1)
    public void validCredential() {
        LoginPage loginPage=new LoginPage(getDriver());

        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validEmail);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);

        String expectedText="Log out";
        String actualText = loginPage.loginValidationText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test(groups = {"smoke"}, priority = 2)
    public void invalidPassword() {
        LoginPage loginPage=new LoginPage(getDriver());

        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validEmail);
        loginPage.enterPassword("invalid password");
        waitFor(1);
        loginPage.clickOnLoginBtn();


        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(expectedText,actualText);
        log.info("login page not success");
    }

    @Test(groups = {"regression"},priority = 3)
    public void logOutTest(){

        LoginPage loginPage = new LoginPage(getDriver());
        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validEmail);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);

        loginPage.clickOnLogOutButton();

        String expectedText="Log in";
        String actualText = loginPage.logOutValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Log-out validation Success");


    }
    @Test(groups = {"regression","smoke"},priority = 4)
    public void passwordRecovery(){
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnRegisterLink();
        loginPage.clickOnLoginLink();
        scrollToCoordinates(0,100);
        waitFor(1);
        homePage.clickOnForgotPassword();
        waitFor(1);
        homePage.clickOnRecoveryEmailField();
        homePage.typeEmailOnRecoveryEmailField(validEmail);
        homePage.clickOnRecoveryButton();

        String expectedText="Email with instructions has been sent to you.";
        String actualText = homePage.recoveryValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Password recovery validation Success");
    }
    @Test(groups = {"regression","sanity"},priority = 5)
    public void passwordRecoveryWithInvalidEmail(){
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnRegisterLink();
        loginPage.clickOnLoginLink();
        scrollToCoordinates(0,100);
        waitFor(1);
        homePage.clickOnForgotPassword();
        waitFor(1);
        homePage.clickOnRecoveryEmailField();
        homePage.typeEmailOnRecoveryEmailField("wrong email");
        homePage.clickOnRecoveryButton();

        String expectedText="Wrong email";
        String actualText = homePage.recoveryEmailErrorMassage();
        Assert.assertEquals(expectedText,actualText);

    }
}
