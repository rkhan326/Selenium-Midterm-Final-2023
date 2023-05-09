package amel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LoginTest  extends SetUp {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validCred() {

        // user landed successfully to the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on Register/Login
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");

        // enter username
        typeText("//input[@id='username']", "boucettaamel811@gmail.com");
        log.info("enter username success");

        // enter a password
        typeText("//input[@id='password']", "amel");
        log.info("enter password success");

        //check box on rememmber me
        clickOn("#rememberme");
        waitFor(3);
        boolean isRememberMe = isChecked("#rememberme");;
        Assert.assertTrue(isRememberMe);
        log.info(" remember me check box  success");

        // click on login
        clickOn("// button[@name='login']");
        log.info("click on login button success");
        waitFor(3);

        // check user is logged in
        String expectedText = "My account";
        String actualText = getElementText("//h1[text()='My account']");
        Assert.assertEquals(expectedText, actualText);
        log.info("user logged in success");

    }

    @Test
    public void missingpassword() {
        // user landed to the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on Rgister/Login
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");

        // enter username
        typeText("//input[@id='username']", "boucettaamel811@gmail.com"); // accept xpath and ccs
        log.info("enter username success");

        // missing password
        typeText("//input[@id='password']", "");
        log.info(" password not entered success");

        //check box on rememmber me
        clickOn("#rememberme");
        waitFor(3);
        boolean isRememberMe = isChecked("#rememberme");;
        Assert.assertTrue(isRememberMe);
        log.info("remember me check box  success");

        // click on login
        clickOn("// button[@name='login']");
        log.info("click on login button success");
        waitFor(3);

        // validate error message
        String expectedError = "Error: The password field is empty.";
        String actualError = getElementText("//div[@class='woocommerce-notices-wrapper']/ul[1]/li[1]");
        log.info("validate error message");

    }
}




