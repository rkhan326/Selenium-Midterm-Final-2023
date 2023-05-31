package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;
import us.piit.pages.automationexercisepages.ProductsPage;

public class DeleteAccountTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test (groups = {}, priority = 5, enabled = false)
    public void deleteAccount5() {
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);

        homePage.clickOnSignupLoginButton(); //click on signup/ login button

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneBoy.concat(expectedLoginToYourAccountHeader).concat(homePage.headerValidationSuccess));

        //enter login email address, password and click login button
        loginpage.enterSignupEmailInLoginEmailField();
        loginpage.enterValidLoginPasswordInLoginPasswordField();
        loginpage.clickOnLoginButton();

        loginpage.validatePresenceOfloggedInIcon(); //validate logged in icon

        loginpage.clickOnDeleteAccountButton(); //delete account

        productsPage.clickOnBabyhugButton(getDriver()); //click on ad
        waitFor(1);

        //validate deletion
        String expectedAccountDeletedHeader = "ACCOUNT DELETED!";
        String actualAccountDeletedHeader = homePage.getAccountDeletedHeaderText();
        Assert.assertEquals(expectedAccountDeletedHeader, actualAccountDeletedHeader);
        log.info(homePage.wellDoneBoy.concat(expectedAccountDeletedHeader).concat(homePage.headerValidationSuccess));

        loginpage.clickOnDeleteAccountContinueButton();//click on continue button
    }
}


