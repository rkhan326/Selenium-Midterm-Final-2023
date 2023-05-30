package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.AddressMenuPage;
import us.piit.pages.nopcommercepages.LoginPage;

public class AddressMenuTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartTest.class.getName());
    String validUsername= "hello7@gmail.com";
    String validPassword= "hello1234";

    String firstName= "Danish";
    String lastName= "Mahmud";
    String email= validUsername;

    @Test(priority = 1)

    public void addAddress(){
        LoginPage loginPage= new LoginPage(getDriver());
        AddressMenuPage addressMenuPage= new AddressMenuPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);
        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");
        //enter  username,Password and click
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);
        // from here Account Address

        addressMenuPage.clickOnAddressLink();
        addressMenuPage.clickOnAddNewButton();
        addressMenuPage.clickOnFirstNameField();
        addressMenuPage.typeOnFirstNameField(firstName);
        addressMenuPage.clickOnLastNameField();
        addressMenuPage.typeOnLastNameField(lastName);
        addressMenuPage.clickOnEmailNameField();
        addressMenuPage.typeEmail(email);
        scrollToCoordinates(0,150);
        addressMenuPage.clickOnCountryOption();
        addressMenuPage.clickOnUnitedState();
        waitFor(1);
        addressMenuPage.clickOnCityFieldField();
        addressMenuPage.typeOnCityNameField("Jackson Heights");

        scrollToCoordinates(0,150);
        addressMenuPage.clickOnAddressField();
        addressMenuPage.typeOnAddressNameField("3429 73rd");
        addressMenuPage.clickOnZipCodeField();
        addressMenuPage.typeOnZipCodeField("11372");
        addressMenuPage.clickOnPhoneNumberField();
        addressMenuPage.typeOnPhoneNumberField("123-456-1789");
        scrollToCoordinates(0,150);
        addressMenuPage.clickOnSaveButton();

        // Address add validation
        String expectedText = "Delete";
        String actualText = addressMenuPage.addAddressValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Address validation Success");

    }

    //Change Password
    @Test(priority = 2)
    public void passwordChange(){
        LoginPage loginPage = new LoginPage(getDriver());
        AddressMenuPage addressMenuPage= new AddressMenuPage(getDriver());
        ///check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);
        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");
        //enter  username,Password and click
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);;
        // from here Account Address
        addressMenuPage.clickOnAddressLink();
        scrollToCoordinates(0,100);
        addressMenuPage.clickOnChangePasswordLink();
        addressMenuPage.typeOldPassword(validPassword);
        addressMenuPage.typeNewPassword("hello12345");
        addressMenuPage.typeConfirmNewPassword("hello12345");
        scrollToCoordinates(0,100);
        addressMenuPage.clickOnChangePasswordButton();

        // Password Change validation
        String expectedText = "Password was changed";
        String actualText = addressMenuPage.changePasswordValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Password Change validation Success");


    }

}
