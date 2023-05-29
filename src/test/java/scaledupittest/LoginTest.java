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
//import us.piit.utility.ExcelReader;
//import us.piit.utility.Utility;
//import java.util.ArrayList;
//import java.util.List;
//
//// 6ddc485e497e88e90f4d32231cbeba0a13403098
//
//import java.util.Properties;
//
//public class LoginTest  extends CommonAPI {
//    Logger log = LogManager.getLogger(LoginTest.class.getName());
//
//    Properties prop = Utility.loadProperties();
//
//    String validUsername = Utility.decode(prop.getProperty("scalledupit.username"));
//    String validPassword = Utility.decode(prop.getProperty("scalledupit.password"));
//
//
//    @Test(enabled = true,priority = 0)
//    public void validCred() {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
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
//   // @Test(enabled = true,priority = 2)
//    public void missingusername() {
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
//
//        homePage.clickOnSignInButton();
//        loginPage.enterPassword(validPassword);
//        loginPage.clickOnLoginBtn();
//
//
//        // check error message
//        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
//        String expectedError = "Error: Username is required.";
//        String actualError = loginPage.getErrorMessageText();
//        Assert.assertEquals(expectedError, actualError);
//        log.info("error message validate  success");
//
//    }
//    //@Test(enabled = true,priority = 3)
//    public void missingpassword() {
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
//
//        homePage.clickOnSignInButton();
//        loginPage.enterUsername(validUsername);
//        loginPage.clickOnLoginBtn();
//
//
//        // check error message
//        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
//        String expectedError2 = "Error: The password field is empty.";
//        String actualError2 = loginPage.getErrorMessageText();
//        Assert.assertEquals(expectedError2, actualError2);
//        log.info("error message validate  success");
//
//    }
//   // @Test(enabled = true,priority = 1)
//    public void invalidCred() {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
//
//        homePage.clickOnSignInButton();
//        loginPage.enterUsername("invalidUsername");
//        loginPage.enterPassword(validPassword);
//        loginPage.clickOnLoginBtn();
//
//
//        // check user is logged in
//        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
//        String expectedError3 = "Error: The username invalidUsername is not registered on this site. If you are unsure of your username, try your email address instead.";
//        String actualError3 = loginPage.getErrorMessageText();
//        Assert.assertEquals(expectedError3, actualError3);
//        log.info("error message validate  success");
//
//    }
//   // @Test(enabled = true,priority = 4)
//    public void existingEmailDifferentPass() {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
//
//        // click on register/login
//        homePage.clickOnSignInButton();
//        waitFor(3);
//
//        // enter username , password and click login
//        loginPage.enterUsername(validUsername);
//        waitFor(3);
//        loginPage.enterPassword("Amelboucetta81196");
//        waitFor(3);
//        loginPage.clickOnLoginBtn();
//        waitFor(3);
//
//
//
////        // check user is logged in
//        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
//        String expectedError4 = "Error: The password you entered for the email address boucettaamel811@gmail.com is incorrect. Lost your password?";
//        String actualError4 = loginPage.getErrorMessageText();
//        Assert.assertEquals(expectedError4, actualError4);
//        log.info("error message validate  success");
//    }
//    @Test(enabled = true,priority = 5)
//    public void ForgettPass() {
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        String expectedTitle = "Automation – Automate eCommerce";
//        String actualTitle = getCurrentTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
//
//        // click on register/login
//        homePage.clickOnSignInButton();
//        waitFor(3);
//
//        // enter username , password and click login
//        loginPage.enterUsername(validUsername);
//        waitFor(3);
//
//        loginPage.clickOnForgetPasswordBtn();
//        waitFor(3);
//
//        // check user is logged in
//        Assert.assertTrue(loginPage.checkPresenceOfLostPasswordHeader());
//        String expectedError4 = "Lost password";
//        String actualError4 = loginPage.getForgetPasswordHeadertext();
//        Assert.assertEquals(expectedError4, actualError4);
//        log.info("error message validate  success");
//    }
//    @Test(dataProvider = "data")
//    public void dataProvideTest(String firstName,String lastName,String age){
//        System.out.println(firstName+"-------"+lastName+"------"+age);
//    }
//    @DataProvider
//    public Object[][]data() {
//        ExcelReader read = new ExcelReader("C:\\Users\\Amel Boucetta Gacem\\eclipse-workspace\\Selenium-Midterm-Final-2023\\data\\data.xlsx");
//        List<String> columnData = new ArrayList<>();
//        columnData = read.getEntireColumnData("Data", 1, 0);
//        Object[][] data = new Object[3][3];
//        for (int i = 0; i < 3; i++) {
//            if (i != 0) {
//                columnData = read.getEntireColumnData("Data", 1, i);
//            }
//            for (int j = 0; j < columnData.size(); j++) {
//                data[j][i] = columnData.get(j);
//
//
//            }
//
//        }
//        return data;
//    }
//    }
