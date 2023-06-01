package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.AddressMenuPage;
import uspiit.pages.nopcommercepages.LoginPage;
import uspiit.utility.ExcelReader;

import java.io.File;

public class AddressMenuTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartTest.class.getName());
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"nopcommercedata.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String validEmail= excelReader.getStringDataFromCell("data",10,1);
    String validPassword= excelReader.getStringDataFromCell("data",8,1);

    //    String firstName= "Danish";
    String firstName =excelReader.getStringDataFromCell("data",5,1);
    //    String lastName= "Mahmud";
    String lastName =excelReader.getStringDataFromCell("data",6,1);
    String email= validEmail;

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
        loginPage.enterUsername(validEmail);
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
        loginPage.enterUsername(validEmail);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);;
        // from here Account Address
        addressMenuPage.clickOnAddressLink();
        scrollToCoordinates(0,100);
        addressMenuPage.clickOnChangePasswordLink();
        addressMenuPage.typeOldPassword(validPassword);
        addressMenuPage.typeNewPassword("final1234");
        addressMenuPage.typeConfirmNewPassword("final1234");
        scrollToCoordinates(0,100);
        addressMenuPage.clickOnChangePasswordButton();

        // Password Change validation
        String expectedText = "Password was changed";
        String actualText = addressMenuPage.changePasswordValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Password Change validation Success");


    }

}
