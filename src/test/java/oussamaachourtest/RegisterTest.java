package oussamaachourtest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class RegisterTest extends CommonAPI {
   Logger log = LogManager.getLogger(oussamaachourtest.RegisterTest.class.getName());

    @Test
    public void registerNewCustomer() {
        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //enter username
        typeText("//input[@id ='reg_email' ]", "marziahaque02@gmail.com");
        log.info("typing email success");
        waitFor(2);

        //enter password
        typeText("//input[@id ='reg_password' ]", "HelloWorld123!");
        log.info("typing password success");
        waitFor(2);

        //click on radio button
        clickOn("//input[@value = 'customer']");
        waitFor(2);
        boolean isCustomerRadioButton = isChecked("//input[@value = 'customer']");
        Assert.assertTrue(isCustomerRadioButton);
        boolean isVendorRadioButton = isChecked("//input[@value = 'seller']");;
        Assert.assertFalse(isVendorRadioButton);
        log.info("click on customer radio button success");

        //scroll to register button
        scrollToCoordinates(0,300);
        waitFor(3);
        boolean registerButtonVisibile = isVisible("//button[text()='Register']");
        Assert.assertTrue(registerButtonVisibile);
        log.info("scroll to target element success.");

        //click on register button
        clickOn("//button[text()='Register']");
        waitFor(3);
        log.info("click on target element success.");

        //Make sure we land on the "My Account" page successfully
        boolean myAccountPageHeadedisDisplayed = isVisible("//h1[@class = 'entry-title']");
        Assert.assertTrue(myAccountPageHeadedisDisplayed);
        log.info("My Account page header is displayed");

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = getElementText("//h1[@class = 'entry-title']");
        Assert.assertEquals(myAccountActualHeaderText,myAccountExpectedHeaderText);
        log.info("customer login page validation text match success");

    }

    @Test
    public void registerExistingCustomer() {

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //enter username
        typeText("//input[@id ='reg_email' ]", "erfanhaque88@gmail.com");
        log.info("enter email success");
        waitFor(2);

        //enter password
        typeText("//input[@id ='reg_password' ]", "HelloWorld123!");
        log.info("enter password success");
        waitFor(2);

        //click on radio button
        clickOn("//input[@value = 'customer']");
        waitFor(2);
        boolean isCustomerRadioButton = isChecked("//input[@value = 'customer']");
        Assert.assertTrue(isCustomerRadioButton);
        boolean isVendorRadioButton = isChecked("//input[@value = 'seller']");;
        Assert.assertFalse(isVendorRadioButton);
        log.info("click on customer radio button success");

        //scroll to register button
        scrollToCoordinates(0,300);
        waitFor(3);
        boolean registerButtonVisibile = isVisible("//button[text()='Register']");
        Assert.assertTrue(registerButtonVisibile);
        log.info("scroll to target element success.");

        //click on register button
        clickOn("//button[text()='Register']");
        waitFor(3);
        log.info("click on target element success.");

        //validate error message
        boolean errorMessageIsDisplayed = isVisible("//li[text()=' An account is already registered with your email address. ']");
        Assert.assertTrue(errorMessageIsDisplayed);
        log.info("error message validation success.");
    }

    @Test
    public void registerNewVendor() {

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //enter username
        typeText("//input[@id ='reg_email' ]", "razia1@gmail.com");
        log.info("enter email success");
        waitFor(2);

        //enter password
        typeText("//input[@id ='reg_password' ]", "HelloWorld123!");
        log.info("enter password success");
        waitFor(2);

        //scroll down
        scrollToCoordinates(0,300);
        waitFor(3);

        //click on radio button
        clickOn("//input[@value = 'seller']");
        waitFor(2);
        boolean isCustomerRadioButton = isChecked("//input[@value = 'customer']");
        Assert.assertFalse(isCustomerRadioButton);
        boolean isVendorRadioButton = isChecked("//input[@value = 'seller']");;
        Assert.assertTrue(isVendorRadioButton);
        log.info("click on vendor radio button success");

        //new fields appear after hitting vendor radio button
        //enter first name
        typeText("//input[@id ='first-name' ]", "Razia");
        log.info("enter first name success");
        waitFor(2);

        //enter last name
        typeText("//input[@id ='last-name' ]", "Khan");
        log.info("enter last name success");
        waitFor(2);


        //enter shop name
        typeText("//input[@id ='company-name' ]", "Razia and Co.");
        log.info("enter shop name success");
        waitFor(2);

        //enter shop url
        typeText("//input[@id ='seller-url' ]", "https://raziakhan.com");
        log.info("enter shop url success");
        waitFor(2);

        //enter phone number
        typeText("//input[@id ='shop-phone' ]", "718-888-8888");
        log.info("enter phone number success");
        waitFor(2);

        //scroll to register button
        scrollToCoordinates(0,50);
        waitFor(3);
        boolean registerButtonVisibile = isVisible("//button[text()='Register']");
        Assert.assertTrue(registerButtonVisibile);
        log.info("scroll to target element success.");

        //click on register button
        clickOn("//button[text()='Register']");
        waitFor(3);
        log.info("click on target element success.");

       //Make sure we land on the vendor login page successfully
        boolean myAccountPageHeadedisDisplayed = isVisible("//h1[@id='wc-logo']");
        Assert.assertTrue(myAccountPageHeadedisDisplayed);
        log.info("My Account page header is displayed");
        String myAccountExpectedHeaderText = "Welcome to Worldwide Electronics Store";
        String myAccountActualHeaderText = getElementText("//h1[@id='wc-logo']");
        Assert.assertEquals(myAccountActualHeaderText,myAccountExpectedHeaderText);
        log.info("vendor login page validation text match success");

        //check if vendor gets added to StoreList

    }
}
