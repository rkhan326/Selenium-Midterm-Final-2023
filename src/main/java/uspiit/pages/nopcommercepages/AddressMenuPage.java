package uspiit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class AddressMenuPage extends CommonAPI {
    Logger log = LogManager.getLogger(AddressMenuPage.class.getName());
    public AddressMenuPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //************************Locator*******************************
    // click on Address link
    @FindBy(xpath = "//a[normalize-space()='Addresses']")
    WebElement addressLink;

    // click on Add New Button
    @FindBy(xpath = "//button[normalize-space()='Add new']")
    WebElement addNewButton;

    //First Name field
    @FindBy(xpath = "//input[@id='Address_FirstName']")
    WebElement firstNameField;

    //Last name field lastNameField
    @FindBy(xpath = "//input[@id='Address_LastName']")
    WebElement lastNameField;

    // Email field
    @FindBy(xpath = "//input[@id='Address_Email']")
    WebElement emailField;

    //Country
    @FindBy(xpath = "//select[@id='Address_CountryId']")
    WebElement countryField;

    // Select US
    @FindBy(css= "option[value='1']")
    WebElement selectCountry;

    //City cityField
    @FindBy(xpath = "//input[@id='Address_City']")
    WebElement cityField;

    //Address
    @FindBy(css = "#Address_Address1")
    WebElement address1Field;

    //Zip code
    @FindBy(xpath = "//input[@id='Address_ZipPostalCode']")
    WebElement zipCodeField;

    //Phone number
    @FindBy(xpath = "//input[@id='Address_PhoneNumber']")
    WebElement phoneNumberField;

    //Save button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    //Add address validation "Delete button/link shown
    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement addAddressValidation;

    //*********************Change Password locators**************************
    //click on Change Password
    @FindBy(css = "a[href='/customer/changepassword']")
    WebElement changePasswordLink;

    //Old Password Field
    @FindBy(xpath = "//input[@id='OldPassword']")
    WebElement OldPassword;

    // new password field
    @FindBy(xpath = "//input[@id='NewPassword']")
    WebElement newPasswordField;

    //confirm new password field
    @FindBy(xpath = "//input[@id='ConfirmNewPassword']")
    WebElement confirmNewPasswordField;

    //Change password button
    @FindBy(xpath = "//button[normalize-space()='Change password']")
    WebElement changePasswordButton;

    //Password Change Validation changePasswordValidation
    @FindBy(xpath = "//p[@class='content']")
    WebElement changePasswordValidation;


    //--------------------------------------------------------------------------
    // ************************( Reusable Methods )*****************************
    // ---------------------------------------------------------------------------


    // click on Address link
    public void clickOnAddressLink() {
        clickOn(addressLink);
        log.info("Click On Address Link successfully");
    }

    // click on Add New Button
    public void clickOnAddNewButton() {
        clickOn(addNewButton);
        log.info("Click On Add New Button successfully");
    }

    //First Name field
    public void clickOnFirstNameField() {
        clickOn(firstNameField);
        log.info("Click On First Name Field successfully");
    }
    //Type on First Name field
    public void typeOnFirstNameField(String firstName) {
        typeText(firstNameField, firstName);
        log.info("Type first name successfully");
    }
    //Last name field

    public void clickOnLastNameField() {
        clickOn(lastNameField);
        log.info("Click On Last Name Field successfully");
    }
    //Type on Last Name field
    public void typeOnLastNameField(String lastName) {
        typeText(lastNameField, lastName);
        log.info("Type Last name successfully");
    }
    // Email Field
    public void clickOnEmailNameField() {
        clickOn(emailField);
        log.info("Click On email Field successfully");
    }
    //Type Email
    public void typeEmail(String email) {
        typeText(emailField, email);
        log.info(" Type email successfully");
    }
    // Select Country
    public void clickOnCountryOption() {
        clickOn(countryField);
        log.info("Click On email Field successfully");
    }

    //Select Bangladesh
    public void clickOnUnitedState() {
        clickOn(selectCountry);
        log.info("US selected successfully");
    }



    //    public void typeCountryName() {
//        selectOptionFromDropDown(countryField, "United");
//        log.info("Selected Country successfully");
//    }
    //City
    public void clickOnCityFieldField() {
        clickOn(cityField);
        log.info("Click On City Field successfully");
    }
    // type city name
    public void typeOnCityNameField(String cityName) {
        typeText(cityField, cityName);
        log.info("Type Last name successfully");
    }
    // Address 1 Field
    public void clickOnAddressField() {
        clickOn(address1Field);
        log.info("Click On Address 1 Field successfully");
    }
    // Type Address
    public void typeOnAddressNameField(String addressField) {
        typeText(address1Field, addressField);
        log.info("Type Address successfully");
    }

    //Zip Code Field
    public void clickOnZipCodeField() {
        clickOn(zipCodeField);
        log.info("Click ZipCode Field successfully");
    }
    //type Zip code
    public void typeOnZipCodeField(String zipCodeNumber) {
        typeText(zipCodeField, zipCodeNumber);
        log.info("Type zip Code Number successfully");
    }
    //Phone number Field
    public void clickOnPhoneNumberField() {
        clickOn(phoneNumberField);
        log.info("Click on Phone Number Field successfully");
    }
    //Type phone number
    public void typeOnPhoneNumberField(String phoneNumber) {
        typeText(phoneNumberField, phoneNumber);
        log.info("Type Phone Number successfully");
    }
    //Click on Save button saveButton
    public void clickOnSaveButton() {
        clickOn(saveButton);
        log.info("Click on save Button successfully");
    }

    //Add address validation "Delete button/link shown
    public String addAddressValidationText() {
        String text = getElementText(addAddressValidation);
        log.info("  Add Address Validation succeeded");
        return text;

    }
    //*********************Change Password methods**************************
    //click on Change Password
    public void clickOnChangePasswordLink() {
        clickOn(changePasswordLink);
        log.info("Click Password Link successfully");
    }
    //Old Password Field OldPassword
    public void typeOldPassword(String oldPassword) {
        typeText(OldPassword, oldPassword);
        log.info("Type Old Password successfully");
    }
    // new password field
    public void typeNewPassword(String newPassword) {
        typeText(newPasswordField, newPassword);
        log.info("Type New Password successfully");
    }
    //confirm new password field
    public void typeConfirmNewPassword(String confirmNewPassword) {
        typeText(confirmNewPasswordField, confirmNewPassword);
        log.info("Type Confirm New Password successfully");
    }
    //Change password button
    public void clickOnChangePasswordButton() {
        clickOn(changePasswordButton);
        log.info("Click on Change Password Button successfully");
    }
    //Password Change Validation
    public String changePasswordValidationText() {
        String text = getElementText(changePasswordValidation);
        log.info("Change Password Validation succeeded");
        return text;

    }
}
