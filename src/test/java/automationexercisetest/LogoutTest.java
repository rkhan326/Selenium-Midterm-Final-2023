package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;

public class LogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void smoothLogout4() {
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //validate home page
        String expectedCategoryHeader = "CATEGORY";
        String actualCategoryHeader = homePage.getCategoryHeaderText();
        Assert.assertEquals(expectedCategoryHeader, actualCategoryHeader);
        log.info(homePage.wellDoneBoy.concat(expectedCategoryHeader).concat(homePage.headerValidationSuccess));

        homePage.clickOnSignupLoginButton();//click on signup/ login button

        //validate login page
        String expectedLoginToYourAccountHeader = "Login to your account";
        String actualLoginToYourAccountHeader = loginpage.getLoginToYourAccountHeaderText();
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneBoy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));

        //enter login email address, password and click login button
        loginpage.enterValidLoginEmailInLoginEmailField();
        loginpage.enterValidLoginPasswordInLoginPasswordField();
        loginpage.clickOnLoginButton();

        loginpage.clickOnLogoutButton(); //logout

        //validate logout
        Assert.assertEquals(expectedLoginToYourAccountHeader, actualLoginToYourAccountHeader);
        log.info(homePage.wellDoneBoy.concat(expectedLoginToYourAccountHeader.concat(homePage.headerValidationSuccess)));
    }
}
