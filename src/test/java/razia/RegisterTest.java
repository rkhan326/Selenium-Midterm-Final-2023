package razia;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class RegisterTest extends SetUp {
   Logger log = LogManager.getLogger(razia.RegisterTest.class.getName());

    @Test
    public void registerNewCustomer() {
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //enter username
        typeText("//input[@id ='reg_email' ]", "erfanhaque88@gmail.com");
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
        log.info("login page validation text match success");

    }

//    @Test
//    public void registerNewVendor() {
//
//    }
}
