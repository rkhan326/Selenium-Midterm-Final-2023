package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.HomePage;
import us.piit.pages.nopcommercepages.LoginPage;
import us.piit.pages.nopcommercepages.RegisterPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegisterTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    String firstName= "Danish";
    String lastName= "Mahmud";
    String email= "mahmud786@gmail.com";
    String companyName= "PNT";
    String password= "mahmud123";
    String confirmPassword= "mahmud123";

    String emptyFirstName = "";


    @Test
    public void registerNewCustomer() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        //click on register
        registerPage.clickOnRegisterMenu();
        waitFor(1);

        // click radio button
        registerPage.clickOnRadioButton();
        waitFor( 1);

        //enter FirstName
        registerPage.typeFirstName(firstName);
        waitFor(1);

        //enter LastName
        registerPage.typeLastName(lastName);
        waitFor(1);

        //enter Email
        registerPage.typeEmail(email);
        waitFor(1);

        //enter Company
        registerPage.typeCompanyName(companyName);
        waitFor(1);

        //enter password
        registerPage.typePassword(password);
        waitFor(1);

        //enter confirm password
        registerPage.typeConfirmPassword(confirmPassword);
        waitFor(1);

        //click on register-button button
        registerPage.clickOnRegisterButton();

        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
    @Test
    public void registerWithoutFillMandatoryField() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        //click on register
        registerPage.clickOnRegisterMenu();
        waitFor(1);

        // click radio button
        registerPage.clickOnRadioButton();
        waitFor( 1);

        //enter FirstName
        registerPage.typeFirstName(emptyFirstName);
        waitFor(1);

        //enter LastName
        registerPage.typeLastName(lastName);
        waitFor(1);

        //enter Email
        registerPage.typeEmail(email);
        waitFor(1);

        //enter Company
        registerPage.typeCompanyName(companyName);
        waitFor(1);

        //enter password
        registerPage.typePassword(password);
        waitFor(1);

        //enter confirm password
        registerPage.typeConfirmPassword(confirmPassword);
        waitFor(1);

        //click on register-button button
        registerPage.clickOnRegisterButton();

        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
}
