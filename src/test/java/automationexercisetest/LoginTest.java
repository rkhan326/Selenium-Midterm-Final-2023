package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.HomePage;
import uspiit.pages.automationexercisepages.LoginPage;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validLoginCredentials1() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);
        log.info(homePage.wellDoneBoy.concat(expectedCategoryHeader).concat(homePage.headerValidationSuccess));

        //click on signup/ login button
        homePage.clickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginPage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneBoy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        loginPage.validatePresenceOfloggedInIcon();//validate logged in icon

    }
    @Test
    public void invalidLoginUsername2() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);
        log.info(homePage.wellDoneBoy.concat(expectedCategoryHeader).concat(homePage.headerValidationSuccess));

        homePage.clickOnSignupLoginButton(); //click on signup/ login button

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginPage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneBoy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));

        //enter login email address, password and click login button
        loginPage.enterInvalidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        //validate error message
        String expectedLoginErrorMessage = "Your email or password is incorrect!";
        String actualLoginErrorMessage = loginPage.getLoginMessageErrorText();
        Assert.assertEquals(expectedLoginErrorMessage, actualLoginErrorMessage);
        log.info(homePage.wellDoneBoy.concat(expectedLoginErrorMessage).concat(homePage.errorMessageSuccess));
    }

    @Test
    public void invalidLoginPassword3(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);

        //click on signup/ login button
        homePage.clickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginPage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterInvalidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        //validate error message
        String expectedLoginErrorMessage = "Your email or password is incorrect!";
        String actualLoginErrorMessage = loginPage.getLoginMessageErrorText();
        Assert.assertEquals(expectedLoginErrorMessage, actualLoginErrorMessage);
        log.info(homePage.wellDoneBoy.concat(expectedLoginErrorMessage).concat(homePage.errorMessageSuccess));

    }

}
