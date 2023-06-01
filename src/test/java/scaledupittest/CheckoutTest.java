package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.scaledupitpages.CheckoutPage;
import uspiit.pages.scaledupitpages.HomePage;
import uspiit.utility.Utility;

import java.util.Properties;

public class CheckoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(CheckoutTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test(enabled = true, priority = 0)
    public void checkoutWithoutPayementMethod() {

        CheckoutPage checkout = new CheckoutPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        //scroll to kids collection button

        scrollToCoordinates(0, 1500);
        waitFor(3);
        Assert.assertTrue(homePage.checkAddKidsCollectionToCartIsVisible());
        waitFor(3);

        homePage.clickOnaddKidsToCartButton();
        waitFor(3);

        // check 1 item is added to the cart
        Assert.assertTrue(checkout.checkcartCountHeader());
        String expectedCartCount = "1";
        String actualCartCount = checkout.getCartCountHeaderText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        log.info("1 item added to cart success");

        //click on cart
        checkout.clickOnCart();
        waitFor(3);

        // click on proceed to checkout
        checkout.clickOnProceedToCheckoutBtn();
        waitFor(3);

        // check user is landed to the checkout page
        Assert.assertTrue(checkout.checkCheckoutPageHeader());
        String expectedChekoutPageHeader = "Checkout";
        String actualChekoutPageHeader = checkout.getCheckoutPageHeaderText();
        Assert.assertEquals(expectedChekoutPageHeader, actualChekoutPageHeader);
        log.info("Checkout Page Header success");


        // enter firstname,lastname,company,phonenumber,email,zipcode,street adresss,drop down to country and to state
        checkout.enterFirstName("Amel");
        waitFor(3);

        checkout.enterLastName("Boucetta");
        waitFor(3);

        checkout.enterCompany("PIIT");
        waitFor(3);

        checkout.selectCountryFromDropdown("United States (US)", getDriver());

        checkout.enterStreetAddress("12135 new street ");
        waitFor(3);

        checkout.enterCity("Rio Grande");
        waitFor(3);

        checkout.selectStateFromDropdown("New Jersey", getDriver());

        checkout.enterZipCode("08242");
        waitFor(3);

        checkout.enterPhoneNumber("609-897-654");
        waitFor(3);

        checkout.enterEmail("abcd@gmail.com");
        waitFor(3);

        // click on place order
        checkout.clickOnPlaceOrder();
        waitFor(3);

 // check user has an invalid payment method error message
        Assert.assertTrue(checkout.checkPresenceCheckoutErrorMessage());
        String expectedCheckoutErrorMessage = "Invalid payment method.";
        String actualCheckoutErrorMessage = checkout.getCheckoutErrorMessageText();
        Assert.assertEquals(expectedCheckoutErrorMessage, actualCheckoutErrorMessage);
        log.info("Checkout Error Message validate success");
    }

    @Test(enabled = true, priority = 1)
    public void checkoutWithoutAddress() {

        CheckoutPage checkout = new CheckoutPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        //scroll to kids collection button

        scrollToCoordinates(0, 1500);
        waitFor(3);
        Assert.assertTrue(homePage.checkAddKidsCollectionToCartIsVisible());
        waitFor(3);

        homePage.clickOnaddKidsToCartButton();
        waitFor(3);

        // check 1 item is added to the cart
        Assert.assertTrue(checkout.checkcartCountHeader());
        String expectedCartCount = "1";
        String actualCartCount = checkout.getCartCountHeaderText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        log.info("1 item added to cart success");

        //  click on cart
        checkout.clickOnCart();
        waitFor(3);

        // click on proceed to checkout
        checkout.clickOnProceedToCheckoutBtn();
        waitFor(3);

        // check user landed to the checkout page
        Assert.assertTrue(checkout.checkCheckoutPageHeader());
        String expectedChekoutPageHeader = "Checkout";
        String actualChekoutPageHeader = checkout.getCheckoutPageHeaderText();
        Assert.assertEquals(expectedChekoutPageHeader, actualChekoutPageHeader);
        log.info("Checkout Page Header success");

        // enter firstname,lastname,company,phonenumber,email,zipcode,city
         checkout.enterFirstName(checkout.enterNewFakeCheckoutFirstName());

        checkout.enterLastName(checkout.enterNewFakeCheckoutLastName());
        checkout.enterCompany("PIIT");
        waitFor(3);

        // checkout.selectCountryFromDropdown("United State (Us)", getDriver());


        checkout.enterCity(checkout.enterNewFakeCity());
        waitFor(3);

        // checkout.selectStateFromDropdown("New Jersey", getDriver());

        checkout.enterNewFakeState();
        checkout.enterZipCode(checkout.enterNewFakeZip());
        waitFor(3);

        checkout.enterPhoneNumber(checkout.enterPhoneNumber());
        waitFor(3);

        // click on place order
        checkout.clickOnPlaceOrder();
        waitFor(3);

        // check user has an error message
        Assert.assertTrue(checkout.checkPresenceCheckoutWithoutAddressErrorMessage());
        String expectedCheckoutWithoutAdrressErrorMessage = "Billing Street address is a required field.";
        String actualCheckoutWithoutAdrressErrorMessage = checkout.getCheckoutWithoutAddressErrorMessageText();
        Assert.assertEquals(expectedCheckoutWithoutAdrressErrorMessage, actualCheckoutWithoutAdrressErrorMessage);
        log.info("Checkout without address Error Message validate success");
    }

     @Test(enabled = true, priority = 2)
    public void checkoutWithoutName() {

        CheckoutPage checkout = new CheckoutPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        //scroll to kids collection button

        scrollToCoordinates(0, 1500);
        waitFor(3);
        Assert.assertTrue(homePage.checkAddKidsCollectionToCartIsVisible());
        waitFor(3);

        homePage.clickOnaddKidsToCartButton();
        waitFor(3);

        // check 1 item is added to the cart
        Assert.assertTrue(checkout.checkcartCountHeader());
        String expectedCartCount = "1";
        String actualCartCount = checkout.getCartCountHeaderText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        log.info("1 item added to cart success");

        // click on cart
        checkout.clickOnCart();
        waitFor(3);

        // click on proceed to checkout
        checkout.clickOnProceedToCheckoutBtn();
        waitFor(3);

        // check user islanded to the checkout page
        Assert.assertTrue(checkout.checkCheckoutPageHeader());
        String expectedChekoutPageHeader = "Checkout";
        String actualChekoutPageHeader = checkout.getCheckoutPageHeaderText();
        Assert.assertEquals(expectedChekoutPageHeader, actualChekoutPageHeader);
        log.info("Checkout Page Header success");

        // enter company, adress,city,state,zipcode,email,phone number
        checkout.enterCompany("PIIT");
        waitFor(3);

       checkout.selectCountryFromDropdown("United States (US)", getDriver());


        checkout.enterCity(checkout.enterNewFakeCity());
        waitFor(3);

        checkout.selectStateFromDropdown("New Jersey", getDriver());

        checkout.enterNewFakeState();
        checkout.enterZipCode(checkout.enterNewFakeZip());
        waitFor(3);

        checkout.enterPhoneNumber(checkout.enterPhoneNumber());
        waitFor(3);

        // click on place order
        checkout.clickOnPlaceOrder();
        waitFor(3);

     //check user has an error message
        Assert.assertTrue(checkout.checkPresenceCheckoutWithoutNameErrorMessage());
       String expectedCheckoutWithoutNameErrorMessage = "Billing First name is a required field.";
        String actualCheckoutWithoutNameErrorMessage = checkout.getCheckoutWithoutNameErrorMessageText();
        Assert.assertEquals(expectedCheckoutWithoutNameErrorMessage, actualCheckoutWithoutNameErrorMessage);
        log.info("Checkout without Name Error Message validate success");
        takeScreenshot("Scalledupit Fiinal checkout test ");
    }
}