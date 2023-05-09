package amel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LogoutTest extends SetUp {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void logout() throws InterruptedException {

      // user is landed to the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on register/Login
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");
        waitFor(3);

        // enter username
        typeText("//input[@id='username']", "boucettaamel811@gmail.com");
        log.info("enter username success");
        waitFor(3);

        // click on password
        typeText("//input[@id='password']", "amel");
        log.info("enter password success");
        waitFor(3);

        // click on login
        clickOn("// button[@name='login']");
        log.info("click on login button success");
        waitFor(3);

        // check user is logged in
        String expectedText = "My account";
        String actualText = getElementText("//h1[text()='My account']");
        Assert.assertEquals(expectedText, actualText);
        log.info("user logged in success");


        // hover hover & click on logout link
        hoverOver("//a[text()='Logout']");
        log.info("hover over on logout link success");
        waitFor(3);
        clickOn("//a[text()='Logout']");
        log.info("click on logout success");
        waitFor(3);


        // check user is landed to the login page
        boolean loginPageHeaderIsDisplayed=isVisible(("//header[@class='entry-header']/h1[1]"));
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("login page is displayed");
        String expectedLoginPageHeaderText="My account";
        String actualLoginPageHeaderText=getElementText("//header[@class='entry-header']/h1[1]");
        Assert.assertEquals(expectedLoginPageHeaderText,actualLoginPageHeaderText);
        log.info("login page header text validation success");
    }
}

