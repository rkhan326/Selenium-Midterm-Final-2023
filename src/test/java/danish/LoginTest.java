package danish;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LoginTest extends SetUp {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validCredential() {

        //click on login
        clickOn("//a[@class='ico-login']");
        log.info("Click on login success");
        waitFor(1);

        // check login page success
        boolean expectedloginPageSuccess = isVisible("//button[@class='button-1 search-box-button']");
        Assert.assertTrue(expectedloginPageSuccess);
        log.info("login page success");

        //enter  username
        typeText("#Email", "mahmud.mahmud786@gmail.com");
        log.info("enter email success");
        waitFor(1);

        typeText("#Password", "mahmud123");
        log.info("enter password success");
        waitFor(1);

        clickOn("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
        log.info("click on login button Success");
        waitFor(1);

        String expectedText = "Welcome to our store";
        String actualText = getElementText("//h2[text()='Welcome to our store']");
        Assert.assertEquals(expectedText,actualText);
        log.info("login page success");
    }

    @Test
    public void invalidPassword() {

        //click on login
        clickOn("//a[@class='ico-login']");
        log.info("Click on login success");
        waitFor(1);

        // check login page success
        boolean expectedloginPageSuccess = isVisible("//button[@class='button-1 search-box-button']");
        Assert.assertTrue(expectedloginPageSuccess);
        log.info("login page success");

        //enter  username
        typeText("#Email", "mahmud.mahmud786@gmail.com");
        log.info("enter email success");
        waitFor(1);

        typeText("#Password", "mahmud");
        log.info("enter password success");
        waitFor(1);

        clickOn("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
        log.info("click on login button Success");
        waitFor(1);

        String expectedText = "Login was unsuccessful. Please correct the errors and try again";
        String actualText = getElementText("div[class='message-error validation-summary-errors']");
        Assert.assertEquals(expectedText,actualText);
        log.info("login page not success");
    }
}
