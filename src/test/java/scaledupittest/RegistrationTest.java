package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.RegistrationPage;
import us.piit.utility.ExcelReader;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegistrationTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegistrationTest.class.getName());
    Properties prop = Utility.loadProperties();
    ExcelReader excelReader = new ExcelReader(Utility.currentDir + "/data/ScalledupitExcelData.xlsx");

    String validUsername= excelReader.getStringDataFromCell("Sheet1",1,1);


    String validPassword= excelReader.getStringDataFromCell("Sheet1",1,2);



    @Test(enabled = true, priority = 0)
    public void registerNewUser() {

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button

        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);

        registrationPage.enterPassword(registrationPage.enterNewFakeRegistrationPassword());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }

    @Test(enabled = true, priority = 1)
    public void registerWithValidEmail() {

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is getting an error message
        Assert.assertTrue(registrationPage.checkPresenceOfValidUsernameErrorMessage());
        String expectedErrorMessage1 = "Error: Please enter an account password.";
        String actualErrorMessage1 = registrationPage.getValidUsernameErrorMessage();
        Assert.assertEquals(expectedErrorMessage1, actualErrorMessage1);
        waitFor(3);


    }

    @Test(enabled = true, priority = 2)
    public void registerWithValidEmailAndWeekPassword() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);

        registrationPage.enterPassword(registrationPage.entreNewFakeWeakPassword());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }

    @Test(enabled = true, priority = 3)
    public void registerWithValidEmailAndShortPassword() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button
        registrationPage.enterEmail(registrationPage.enterNewFakeRegistrationEmail());
        waitFor(3);

        registrationPage.enterPassword(registrationPage.entreNewFakeShortPassword());
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }
    @Test(enabled = true, priority = 4)
    public void registerNewUserUsingExcelReader() {

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter email adress , password, and click on register button

        registrationPage.enterEmail(validUsername);
        waitFor(3);

        registrationPage.enterPassword(validPassword);
        waitFor(3);


        registrationPage.clickOnRegisterBtn();
        waitFor(3);


        // check user is sign up successfully
        Assert.assertTrue(registrationPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = registrationPage.getLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);
        takeScreenshot("Scalledupit Registration test");

    }
}
