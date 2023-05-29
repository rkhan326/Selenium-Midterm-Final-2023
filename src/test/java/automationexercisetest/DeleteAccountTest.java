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
    public void deleteAccount5() {
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

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

        //enter login email address, password and click login button
        loginpage.enterSignupEmailInLoginEmailField();
        loginpage.enterValidLoginPasswordInLoginPasswordField();
        loginpage.clickOnLoginButton();

        //validate logged in icon
        loginpage.validatePresenceOfloggedInIcon();

        //delete account
        loginpage.clickOnDeleteAccountButton();

        //click on pop us blocker


        //validate deletion
        String expectedAccountDeletedHeader = "ACCOUNT DELETED!";
        String actualAccountDeletedHeader = homePage.getAccountDeletedHeaderText();
        Assert.assertEquals(expectedAccountDeletedHeader, actualAccountDeletedHeader);


        //click on continue button
        loginpage.clickOnDeleteAccountContinueButton();

    }
}


