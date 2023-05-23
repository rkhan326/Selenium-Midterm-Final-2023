package nopcommercetest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.HomePage;
import us.piit.pages.nopcommercepages.LoginPage;
import us.piit.pages.nopcommercepages.RegisterPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegisterTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());
    Faker faker= new Faker();

    String firstName= "Danish";
    String lastName= "Mahmud";
    String email= faker.internet().emailAddress();
    String companyName= "PNT";
    String password= "admin123";
    String confirmPassword= "admin123";

    String emptyFirstName = "";


    @Test(priority = 1)
    public void registerNewCustomer() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        //click on register
        registerPage.clickOnRegisterMenu();
        waitFor(1);

        // click radio button
        registerPage.clickOnRadioButton();
        //enter FirstName
        registerPage.typeFirstName(firstName);
        //enter LastName
        registerPage.typeLastName(lastName);
        //enter BirthDay
        registerPage.selectDateOfBirthDay();
        //enter BirthMonth
        registerPage.selectDateOfBirthMonth();
        //enter BirthYear
        registerPage.selectDateOfBirthYear();
        //enter Email
        registerPage.typeEmail(email);
//        String fakeRegistrationEmail = registerPage.getEmailOfNopCommerce();
//        registerPage.typeEmail(fakeRegistrationEmail);
        //enter Company
        registerPage.typeCompanyName(companyName);
        //enter password
        registerPage.typePassword(password);
        //enter confirm password
        registerPage.typeConfirmPassword(confirmPassword);

        //click on register-button button
        registerPage.clickOnRegisterButton();

        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
    @Test(priority = 2)
    public void registerWithoutFillMandatoryField() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        //click on register
        registerPage.clickOnRegisterMenu();
        waitFor(1);
        // click radio button
        registerPage.clickOnRadioButton();
        //enter FirstName
        registerPage.typeFirstName(emptyFirstName);
        //enter LastName
        registerPage.typeLastName(lastName);
        //enter BirthDay
        registerPage.selectDateOfBirthDay();
        //enter BirthMonth
        registerPage.selectDateOfBirthMonth();
        //enter BirthYear
        registerPage.selectDateOfBirthYear();
        //enter Email
        registerPage.typeEmail(email);
        //enter Company
        registerPage.typeCompanyName(companyName);
        //enter password
        registerPage.typePassword(password);
        //enter confirm password
        registerPage.typeConfirmPassword(confirmPassword);
        //click on register-button button
        registerPage.clickOnRegisterButton();

        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
//    @Test(priority = 3)
//    public void validCredential() {
//        LoginPage loginPage=new LoginPage(getDriver());
//
//        //click on login
//        loginPage.clickOnLoginText();
//        waitFor(1);
//
//        // check login page success
//        Assert.assertTrue(loginPage.checkLoginPageSuccess());
//        log.info("login page success");
//
//        //enter  username,Password and click
//        loginPage.enterUsername(email);
//        loginPage.enterPassword(password);
//        waitFor(1);
//        loginPage.clickOnLoginBtn();
//
//
////        String expectedText = "Welcome to our store";
////        String actualText = loginPage.getLoginPageSuccessText();
////        Assert.assertEquals(expectedText,actualText);
//
//    }

}
