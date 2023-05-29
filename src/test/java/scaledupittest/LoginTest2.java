//package scaledupittest;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import us.piit.base.CommonAPI;
//import us.piit.pages.scaledupitpages.HomePage;
//import us.piit.pages.scaledupitpages.LoginPage;
//import us.piit.pages.scaledupitpages.LoginPage2;
//import us.piit.utility.Utility;
//
//import java.io.IOException;
//import java.util.Properties;
//
//public class LoginTest2 extends CommonAPI {
//
//
//    Properties prop = Utility.loadProperties();
//
//
//    String sheetName="Sheet1";
////    @DataProvider
////    public Object[][] dataTest() throws IOException {
////        return getTestData(sheetName);
////    }
//     @Test(enabled = true,priority = 0)//dataProvider = "dataTest")
//    public void validCred(String validUsername,String validPassword) {
//
//        LoginPage2 loginPage = new LoginPage2(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        waitFor(3);
//
//
//        // click on register/login
//        homePage.clickOnSignInButton();
//        waitFor(3);
//
//        // enter username , password and click login
//        loginPage.enterUsername(validUsername);
//        waitFor(3);
//        loginPage.enterPassword(validPassword);
//        waitFor(3);
//        loginPage.clickOnLoginBtn();
//        waitFor(3);
//
//
//        // check user is logged in
//        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
//        String expectedLoginPageHeader = "Hello boucettaamel811 (not boucettaamel811? Log out)";
//        String actualLoginPageHeader = loginPage.getMainLoginPageHeadertext();
//        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
//        waitFor(3);
//    }
//
//
//public void singIN(String username, String password){
//
//
//
//
//}
//
//}
