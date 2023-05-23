package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;

public class DeleteAccountTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());
    @Test
    public void deleteAccount() {
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //click on signup/ login button
        homePage.clickClickOnSignupLoginButton();

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader,actualLoginToYourAccountHeader);

        //enter login email address, password and click login button
        loginpage.enterValidLoginEmailInLoginEmailField();
        loginpage.enterValidLoginPasswordInLoginPasswordField();
        loginpage.clickClickOnLoginButton();

        //validate logged in icon
        loginpage.validatePresenceOfloggedInIcon();

    //delete account
    loginpage.clickClickOnDeleteAccountButton();
        waitFor(2);

    //click on continue button
        loginpage.clickClickOnDeleteAccountContinueButton();

//validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader,actualCategoryHeader);

    }
}

