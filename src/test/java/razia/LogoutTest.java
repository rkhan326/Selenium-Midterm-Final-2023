package razia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.Test;
import us.piit.SetUp;

public class LogoutTest extends SetUp {

    Logger log = LogManager.getLogger("LogoutTest.class.getName()");
    @Test
    public void logoutButton1(){

        //Assume that we are supposed to land on the My Account page when we log in.

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //Assert user lands on the login/register page
        String loginRegisterPageExpectedHeaderText = "Login";
        String loginRegisterPageActualHeaderText = getElementText("//div[@class = 'u-column1 col-1']/h2");
        System.out.println(loginRegisterPageActualHeaderText);
        Assert.assertEquals(loginRegisterPageExpectedHeaderText, loginRegisterPageActualHeaderText);
        log.info("user login/register page validation text match success");

        //enter  username
        typeText("#username", "rkhan326@gmail.com");
        log.info("enter username success");
        waitFor(2);

        //enter  password
        typeText("#password", "HelloWorld123!");
        log.info("enter password success");
        waitFor(2);

        //click on login button
        clickOn("//button[text() = 'Log in']");
        log.info("click on login button Success");
        waitFor(2);

        //Assert user lands on My Account page successfully
        boolean myAccountPageHeadedisDisplayed = isVisible("//h1[@class='entry-title']");
        Assert.assertTrue(myAccountPageHeadedisDisplayed);
        log.info("My Account page header is displayed");
        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = getElementText("//h1[@class='entry-title']");
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
        log.info("user My Account validation text match success");

        //click on logout button1 (on the menu)
        clickOn("//li[@class= 'woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']/a[1]");
        log.info("logout button1 on the menu click success");
        waitFor(2);

        //Assert user lands on Login/register Page
        String loginRegisterPageExpectedHeaderTextAfterLogout = "Login";
        String loginRegisterPageActualHeaderTextAfterLogout = getElementText("//div[@class = 'u-column1 col-1']/h2");
        Assert.assertEquals(loginRegisterPageExpectedHeaderTextAfterLogout, loginRegisterPageActualHeaderTextAfterLogout);
        log.info("user login/register page validation text match success");



    }
    ////div[@class='woocommerce-MyAccount-content']/p[1]/a[1]     ->logout Button2
}
