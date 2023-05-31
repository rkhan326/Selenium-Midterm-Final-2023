package us.piit.pages.scaledupitpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CheckoutPage extends CommonAPI {
    Logger log = LogManager.getLogger(CheckoutPage.class.getName());
 Faker faker=new Faker();
    public CheckoutPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product_title.entry-title")
    WebElement KidsCollectionHeader;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;

    @FindBy(xpath=" //a[contains(text(),'\tProceed to checkout')]")
    WebElement proceedToCheckoutBtn;

    @FindBy(xpath="//h1[text()='Checkout']")
    WebElement checkoutPageHeader;

    @FindBy(css="#billing_first_name")
    WebElement firstNameField;
    @FindBy(css="#billing_last_name")
    WebElement lastNameField;
    @FindBy(css="#billing_company")
    WebElement companyField;
    @FindBy(css="#billing_email")
    WebElement emailField;
    @FindBy(css="#billing_address_1")
    WebElement streetAddressField;
    @FindBy(css="#billing_city")
    WebElement cityField;
    @FindBy(css="#billing_postcode")
    WebElement zipCodeField;
    @FindBy(css="#billing_phone")
    WebElement phoneNumberField;

    @FindBy(xpath="//select[@name='billing_country']")
    WebElement selectCountryDropDown;

    @FindBy(xpath="//select[@id='billing_state']")
    WebElement selectStateDropdown;

    @FindBy(css="#place_order")
    WebElement placeOrderBtn;

    @FindBy(xpath="//ul[@class='woocommerce-error']/li[1]")
    WebElement checkoutErrorMessage;

    @FindBy(xpath="//ul[@class='woocommerce-error']/li[1]")
    WebElement checkoutWithoutAddressErrorMessage;



    public boolean checkPresenceOfKidsCollectionPageHeader() {
        boolean kidsCollectionPageHeaderIsDisplayed = isVisible(KidsCollectionHeader);
        log.info("kids colletion page header presence " + kidsCollectionPageHeaderIsDisplayed);
        return kidsCollectionPageHeaderIsDisplayed;
    }

    public String getKidsCollectionPageHeadertext() {
        String kidsColletionPageHeaderText = getElementText(KidsCollectionHeader);
        log.info("kids Collection header text is " + kidsColletionPageHeaderText);
        return kidsColletionPageHeaderText;

    }

    public void clickOnAddToCartButton() {
        clickOn(addToCartButton);
        log.info("click on add cart  success");

    }

    public boolean checkcartCountHeader() {
        boolean cartCountHeaderIsDisplayed = isVisible(cartCount);
        log.info("cart count is  " + cartCountHeaderIsDisplayed);
        return cartCountHeaderIsDisplayed;
    }

    public String getCartCountHeaderText() {
        String cartCountText = getElementText(cartCount);
        log.info("cart count text is " + cartCountText);
        return cartCountText;

    }

    public void clickOnCart() {
        clickOn(cartCount);
        log.info("click on  cart and 1 item added  success");

    }
    public void clickOnProceedToCheckoutBtn() {
        clickOn(proceedToCheckoutBtn);
        log.info("click on  cart and 1 item added  success");

    }
    public boolean checkCheckoutPageHeader() {
        boolean checkoutPageHeaderIsDisplayed = isVisible(checkoutPageHeader);
        log.info("checkout page header is  " + checkoutPageHeaderIsDisplayed);
        return checkoutPageHeaderIsDisplayed;
    }

    public String getCheckoutPageHeaderText() {
        String checkoutPageText = getElementText(checkoutPageHeader);
        log.info("checkout page header text is " + checkoutPageText);
        return checkoutPageText;
    }
    public void enterFirstName(String firstName) {
        typeText(firstNameField, firstName);

        log.info("enter First Name success");
    }
    public void enterLastName(String lastName) {
        typeText(lastNameField, lastName);

        log.info("enter last name success");
    }
    public void enterEmail(String email) {
        typeText(emailField, email);

        log.info("enter email success");
    }
    public void enterCompany(String company) {
        typeText(companyField, company);

        log.info("enter company name success");
    }
    public void enterStreetAddress(String StreetAddress) {
        typeText(streetAddressField, StreetAddress);

        log.info("enter Street  Address success");
    }
    public void enterCity(String city) {
        typeText(cityField, city);

        log.info("enter city success");
    }
    public void enterZipCode(String zipCode) {
        typeText(zipCodeField, zipCode);

        log.info("enter zip code success");
    }
    public void enterPhoneNumber(String phoneNumber) {
        typeText(phoneNumberField, phoneNumber);

        log.info("enter phone number success");
    }
    public void selectCountryFromDropdown(String Country,WebDriver driver) {
        selectOptionFromDropdown(selectCountryDropDown,Country);
        log.info("Successfully selected Country");
    }


    public void selectStateFromDropdown(String State,WebDriver driver) {
        selectOptionFromDropdown(selectStateDropdown,State);
        log.info("Successfully selected state");
    }

    public void clickOnPlaceOrder() {
        clickOn(placeOrderBtn);
        log.info("click on  place order success");

    }
    public boolean checkPresenceCheckoutErrorMessage() {
        boolean checkoutErrorMessageIsDisplayed = isVisible(checkoutErrorMessage);
        log.info("checkout Error Message is  " + checkoutErrorMessageIsDisplayed);
        return checkoutErrorMessageIsDisplayed;
    }

    public String getCheckoutErrorMessageText() {
        String checkoutErrorMessageText = getElementText(checkoutErrorMessage);
        log.info("checkout Error Message text is " + checkoutErrorMessageText);
        return checkoutErrorMessageText;
    }
    public String enterNewFakeCheckoutFirstName(){return  faker.name().firstName();}
    public String enterNewFakeCheckoutLastName(){ return faker.name().lastName();}
    public String enterNewFakeCheckoutEmail(){ return faker.internet().emailAddress(); }
    public String enterNewFakeStreet() {return faker.address().streetAddress();}

    public String enterNewFakeCity() {return faker.address().city();}
    public String enterNewFakeZip() {return faker.address().zipCode();}
    public String enterNewFakeState() {return faker.address().state();}
    public String enterPhoneNumber(){return faker.phoneNumber().cellPhone();}

    public boolean checkPresenceCheckoutWithoutAddressErrorMessage() {
        boolean checkoutWithoutAddressErrorMessageIsDisplayed = isVisible(checkoutWithoutAddressErrorMessage);
        log.info("checkout Without Address Error Message is  " + checkoutWithoutAddressErrorMessageIsDisplayed);
        return checkoutWithoutAddressErrorMessageIsDisplayed;
    }

    public String getCheckoutWithoutAddressErrorMessageText() {
        String checkoutWithoutAddressErrorMessageText = getElementText(checkoutWithoutAddressErrorMessage);
        log.info("checkout Without Address Error Message text is " + checkoutWithoutAddressErrorMessageText);
        return checkoutWithoutAddressErrorMessageText;
    }

    public boolean checkPresenceCheckoutWithoutNameErrorMessage() {
        boolean checkoutWithoutNameErrorMessageIsDisplayed = isVisible(checkoutWithoutAddressErrorMessage);
        log.info("checkout Without Name Error Message is  " + checkoutWithoutNameErrorMessageIsDisplayed);
        return checkoutWithoutNameErrorMessageIsDisplayed;
    }

    public String getCheckoutWithoutNameErrorMessageText() {
        String checkoutWithoutNameErrorMessageText = getElementText(checkoutWithoutAddressErrorMessage);
        log.info("checkout Without Name Error Message text is " + checkoutWithoutNameErrorMessageText);
        return checkoutWithoutNameErrorMessageText;
    }
}

