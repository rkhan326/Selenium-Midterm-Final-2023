package amel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class RegisterTest extends SetUp {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void RegisterNewAccount() {

        // user landed successfully to the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on Register/Login
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");

        // enter email address
        typeText("#reg_email", "amel96@gmail.com");
        log.info("enter email address success");
        waitFor(3);

        // enter password
        typeText("#reg_password", "020373nm");
        log.info(" enter password  success");
        waitFor(3);

        // click on Register
        clickOn("//button[contains(text(),'Register')]");
        log.info("click on Register button success");
        waitFor(3);

        // check user is logged in
        String expectedText = "Hello amel96 (not amel96? Log out)";
        String actualText = getElementText("//div[@class='woocommerce-MyAccount-content']/p[1]");
        Assert.assertEquals(expectedText, actualText);
        log.info("user logged in success");

    }

    @Test
    public void registerExistingAccount() {

        //user land to the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        // click on Register/Login
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");

        // enter email address
        typeText("#reg_email", "boucettaamel811@gmail.com");
        log.info("enter email address success");
        waitFor(3);


        // click on Register
        clickOn("//button[contains(text(),'Register')]");
        log.info("click on Register button success");
        waitFor(3);


        // validate error message
        String expectedError = "Error: An account is already registered with your email address. Please log in.";
        String actualError = getElementText("//ul[@class='woocommerce-error']/li[1]");
        log.info("validate error message");
    }
}
