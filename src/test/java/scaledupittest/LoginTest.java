package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.scaledupitpages.HomePage;
import uspiit.pages.scaledupitpages.LoginPage;
import uspiit.utility.Utility;


import java.util.Properties;

public class LoginTest  extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Properties prop = Utility.loadProperties();

    String validUsername = Utility.decode(prop.getProperty("scalledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scalledupit.password"));





    @Test(groups = {"sanity","smoke"},enabled = true,priority = 0)
    public void validCred() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register/login
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter username , password and click login
        loginPage.enterUsername(validUsername);
        waitFor(3);
        loginPage.enterPassword(validPassword);
        waitFor(3);
        loginPage.clickOnLoginBtn();
        waitFor(3);


        // check user is logged in
        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "Hello boucettaamel811 (not boucettaamel811? Log out)";
        String actualLoginPageHeader = loginPage.getMainLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        waitFor(3);
    }

   @Test(groups={"smoke"},enabled = true,priority = 2)
    public void missingUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnSignInButton();
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


        // check error message
        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
        String expectedError = "Error: Username is required.";
        String actualError = loginPage.getErrorMessageText();
        Assert.assertEquals(expectedError, actualError);
        log.info("error message validate  success");

    }
   @Test(groups={"sanity"},enabled = true,priority = 3)
    public void missingPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnSignInButton();
        loginPage.enterUsername(validUsername);
        loginPage.clickOnLoginBtn();


        // check error message
        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
        String expectedError2 = "Error: The password field is empty.";
        String actualError2 = loginPage.getErrorMessageText();
        Assert.assertEquals(expectedError2, actualError2);
        log.info("error message validate  success");

    }
     @ Test(groups={"regression","sanity"},enabled = true,priority = 1)
     public void invalidCred() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.clickOnSignInButton();
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


        // check user is logged in
        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
        String expectedError3 = "Error: The username invalidUsername is not registered on this site. If you are unsure of your username, try your email address instead.";
        String actualError3 = loginPage.getErrorMessageText();
        Assert.assertEquals(expectedError3, actualError3);
        log.info("error message validate  success");

    }
    @Test(groups={"regression","smoke"},enabled = true,priority = 4)
    public void existingEmailDifferentPass() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register/login
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter username , password and click login
        loginPage.enterUsername(validUsername);
        waitFor(3);
        loginPage.enterPassword("Amelboucetta81196");
        waitFor(3);
        loginPage.clickOnLoginBtn();
        waitFor(3);



        // check user is logged in
        Assert.assertTrue(loginPage.checkPresenceOfErrorMessageText());
        String expectedError4 = "Error: The password you entered for the email address boucettaamel811@gmail.com is incorrect. Lost your password?";
        String actualError4 = loginPage.getErrorMessageText();
        Assert.assertEquals(expectedError4, actualError4);
        log.info("error message validate  success");
    }
     @Test(groups={"regression"},enabled = true,priority = 5)
    public void ForgetPass() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on register/login
        homePage.clickOnSignInButton();
        waitFor(3);

        // enter username , password and click login
        loginPage.enterUsername(validUsername);
        waitFor(3);

        loginPage.clickOnForgetPasswordBtn();
        waitFor(3);

        // check user is logged in
        Assert.assertTrue(loginPage.checkPresenceOfLostPasswordHeader());
        String expectedError4 = "Lost password";
        String actualError4 = loginPage.getForgetPasswordHeadertext();
        Assert.assertEquals(expectedError4, actualError4);
        log.info("error message validate  success");
        takeScreenshot("My Final Login Test");
    }


    //    @Test(dataProvider = "data")
//    public void dataProvideTest(String firstName,String lastName,String age){
//        System.out.println(firstName+"-------"+lastName+"------"+age);
//    }
//    @DataProvider
//    public Object[][]data() {
//        ExcelReader read = new ExcelReader("C:\\Users\\Amel Boucetta Gacem\\eclipse-workspace\\Selenium-Midterm-Final-2023\\data\\ScalledupitExcelData.xlsx");
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
    }
// @Test(dataProviderClass=Data.class,dataProvider="data",enabled=true)
//public void dataProviderTest1(String firstName,String lastName,String age){
//     System.out.println(firstName+"-------"+lastName+"------"+age);
//    }
//    //@Test(dataProviderClass=Data.class,dataProvider="data",enabled=true)
//    public void dataProviderTest2(String firstName,String lastName,String age){
//        System.out.println(firstName+"-------"+lastName+"------"+age);
//    }
//   // @Test(dataProviderClass=Data.class,dataProvider="data",enabled=true)
//    public void dataProviderTest3(String firstName,String lastName,String age){
//        System.out.println(firstName+"-------"+lastName+"------"+age);
//    }
