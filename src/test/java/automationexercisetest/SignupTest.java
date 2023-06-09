package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.HomePage;
import uspiit.pages.automationexercisepages.LoginPage;
import uspiit.pages.automationexercisepages.SignupPage;

public class SignupTest extends CommonAPI {
    Logger log = LogManager.getLogger(SignupTest.class.getName());

    @Test
    public void signup4() {
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SignupPage signupPage = new SignupPage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);

        //click on signup/ login button
        homePage.clickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneBoy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));

        //enter login email address, password and click login button
        loginpage.enterNameInSignupNameField();
        loginpage.enterEmailInSignupEmailField();
        loginpage.clickOnSignupButton();

        //fill out all the necessary fields
        signupPage.enterPasswordInSignupField();
        signupPage.enterFNameInSignupField();
        signupPage.enterLNameInSignupField();
        signupPage.enterAddressInSignupField();
        signupPage.enterStateInSignupField();
        signupPage.enterCityInSignupField();
        signupPage.enterZipcodeInSignupField();
        signupPage.enterMobileInSignupField();

        signupPage.clickOnSignupButton(); //click create account

        //validate signup
        String expectedAccountCreatedHeader = "ACCOUNT CREATED!";
        String actualAccountCreatedHeader = homePage.getAccountCreatedHeaderText();
        Assert.assertEquals(expectedAccountCreatedHeader, actualAccountCreatedHeader);
        log.info(homePage.wellDoneBoy.concat(expectedAccountCreatedHeader.concat(homePage.headerValidationSuccess)));

        signupPage.clickOnSingupContinueButton();//click on continue button
    }
}
