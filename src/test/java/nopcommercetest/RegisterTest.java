package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class RegisterTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    @Test
    public void registerNewCustomer() {


        //click on register
        clickOn("//a[@class='ico-register']");
        log.info("Click on register success");
        waitFor(1);

        // click radio button
        clickOn("#gender-male");
        log.info("radio button click success");
        waitFor( 1);

        //enter FirstName
        typeText("#FirstName", "Danish");
        log.info("typing FirstName success");
        waitFor(1);

        //enter LastName
        typeText("#LastName", "Mahmud");
        log.info("typing LastName success");
        waitFor(1);

        //enter Email
        typeText("#Email", "mahmud.mahmud786@gmail.com");
        log.info("typing email success");
        waitFor(1);

        //enter Company
        typeText("#Company", "PNT");
        log.info("typing Company success");
        waitFor(1);

        //enter password
        typeText("#Password", "mahmud123");
        log.info("typing password success");
        waitFor(1);

        //enter confirm password
        typeText("#ConfirmPassword", "mahmud123");
        log.info("typing ConfirmPassword success");
        waitFor(1);

        //click on register-button button
        clickOn("#register-button");
        log.info("registered successfully");


        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
    @Test
    public void registerWithoutFillMandatoryField() {


        //click on register
        clickOn("//a[@class='ico-register']");
        log.info("Click on register success");
        waitFor(1);

        // click radio button
        clickOn("#gender-male");
        log.info("radio button click success");
        waitFor( 1);

        //enter FirstName
        typeText("#FirstName", "");
        log.info("typing FirstName success");
        waitFor(1);

        //enter LastName
        typeText("#LastName", "Mahmud");
        log.info("typing LastName success");
        waitFor(1);

        //enter Email
        typeText("#Email", "mahmud.mahmud786@gmail.com");
        log.info("typing email success");
        waitFor(1);

        //enter Company
        typeText("#Company", "PNT");
        log.info("typing Company success");
        waitFor(1);

        //enter password
        typeText("#Password", "mahmud123");
        log.info("typing password success");
        waitFor(1);

        //enter confirm password
        typeText("#ConfirmPassword", "mahmud123");
        log.info("typing ConfirmPassword success");
        waitFor(1);

        //click on register-button button
        clickOn("#register-button");
        log.info("registered successfully");


        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
}
