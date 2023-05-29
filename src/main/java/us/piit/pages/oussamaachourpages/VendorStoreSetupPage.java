package us.piit.pages.oussamaachourpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class VendorStoreSetupPage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorStoreSetupPage.class.getName()) ;
    public VendorStoreSetupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();

    @FindBy(css = "input[id='address[street_1]']")
    WebElement storeSetupStreet1Field;

    @FindBy(css = "input[id='address[street_2]']")
    WebElement storeSetupStreet2Field;

    @FindBy(css = "input[id='address[city]']")
    WebElement storeSetupCityField;

    @FindBy(css = "input[id='address[zip]']")
    WebElement storeSetupZipCodeField;

    @FindBy(xpath = "//select[@id= 'address[country]']")
    WebElement storeSetupCountryDropDown;

    @FindBy(xpath = "//select[@id='calc_shipping_state']")
    WebElement storeSetupStateDropdown;

    @FindBy(xpath = "//td[@class='checkbox']/label[1]")
    WebElement storeSetupEmailShowInStoreCheckBox;

    @FindBy(css = "input[value='Continue']")
    WebElement storeSetupContinueButton;

    @FindBy(xpath = "//a[text()='Skip this step']")
    WebElement storeSetupSkipThisStepButton;

    @FindBy(xpath = "//li[@id='select2-addresscountry-result-in1w-US']")
    WebElement storeSetupCountryDropdownUSOption;

    public void enterStoreSetupStreet1Info(String streetName1){
        typeText(storeSetupStreet1Field,streetName1);
        log.info("enter store setup street1 success");
    }
    public void enterStoreSetupStreet2Info(String streetName2){
        typeText(storeSetupStreet2Field,streetName2);
        log.info("enter store setup street2 success");
    }
    public void enterStoreSetupCityInfo(String city){
        typeText(storeSetupCityField,city);
        log.info("enter store setup city success");
    }

    public void enterStoreSetupZipCodeInfo(String zipCode){
        typeText(storeSetupZipCodeField,zipCode);
        log.info("enter store setup zip code success");
    }

//    public void enterStoreSetupStateInfo(String state){
//        typeText(storeSetupStateField,state);
//        log.info("enter store setup state success");
//    }


    public void clickOnStoreSetupContinueBtn(){
       clickOn(storeSetupContinueButton);
        log.info("click on store setup continue button success");
    }

    public void clickOnStoreSkipThisStepBtn(){
        clickOn(storeSetupSkipThisStepButton);
        log.info("click on store setup skip this button success");
    }

    public void clickOnEmailShowInStoreCheckBox(){
        clickOn(storeSetupEmailShowInStoreCheckBox);
        log.info("click on store setup setup email show in store success");
    }
    public void clickOnStoreSetupCountryDropdown(){
        clickOn(storeSetupCountryDropDown);
        log.info("click on store setup country dropdown success");
    }

    public String getCountryDropdownUSText(){
        String countryDropdownText = getElementText(storeSetupCountryDropdownUSOption);
        return countryDropdownText;
    }


    public void selectStoreSetupCountryFromDropdown(String CountryCode,WebDriver driver) {
        scrollToElementwJS(storeSetupCountryDropDown,driver);
        waitFor(5);
        selectOptionFromDropdown(storeSetupCountryDropDown,CountryCode);
        log.info("Successfully selected Country/Region");
    }


    public void selectStoreSetupStateFromDropdown(String StateCode,WebDriver driver) {
        scrollToElementwJS(storeSetupStateDropdown,driver);
        waitFor(5);
        selectOptionFromDropdown(storeSetupStateDropdown,StateCode);
        log.info("Successfully selected Country/Region");
    }

//    public void selectOptionFromMenuDropdownWithSelectOptions(String option){
//        List<WebElement> elements = getDropDownOptions(storeSetupCountryDropDown);
//            for (WebElement element:elements) {
//            if (element.getText().equalsIgnoreCase(option)){
//                element.click();
//         }=


//    <li class="select2-results__option" id="select2-addresscountry-result-in1w-US" role="option" data-selected="false" tabindex="-1" aria-selected="false">United States (US)</li>

    public String storeSetupFakeStreet1() {return faker.address().streetAddress();}
    public String storeSetupFakeStreet2() {return faker.address().buildingNumber();}
    public String storeSetupFakeCity() {return faker.address().city();}
    public String storeSetupFakeZip() {return faker.address().zipCode();}
    public String storeSetupFakeState() {return faker.address().state();}


}

