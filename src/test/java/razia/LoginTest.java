package razia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LoginTest extends SetUp {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validCredential() {

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //enter  username
        typeText("#username", "rkhan326@gmail.com");
        log.info("enter username success");
        waitFor(2);
        typeText("#password", "HelloWorld123!");
        log.info("enter password success");
        waitFor(2);

        clickOn("//button[text() = 'Log in']");
        log.info("click on login button Success");
        waitFor(2);

        //make sure user lands on login page successfully
        boolean myAccountPageHeadedisDisplayed = isVisible("//h1[@class='entry-title']");
        Assert.assertTrue(myAccountPageHeadedisDisplayed);
        log.info("My Account page header is displayed");
        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = getElementText("//h1[@class='entry-title']");
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
        log.info("user login page validation text match success");
    }

    @Test
    public void invalidPassword() {

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        clickOn("//a[@title = 'My Account']");
        log.info("Click on My Account success");
        waitFor(2);

        //enter  username
        typeText("#username", "rkhan326@gmail.com");
        log.info("enter username success");
        waitFor(2);

        typeText("#password", "HelloWorld122");
        log.info("enter password success");
        waitFor(2);

        clickOn("//button[text() = 'Log in']");
        log.info("click on login button Success");
        waitFor(2);

        //validate error message
        boolean errorMessageIsDisplayed = isVisible("//li[text()=\" The password you entered for the email address \"]");
        Assert.assertTrue(errorMessageIsDisplayed);
        log.info("error message validation success.");
    }

    public void resetPassword(){

    }

    public void validateStrongPassword(){


    }
    public void InvalidPassword(){


    }


}
