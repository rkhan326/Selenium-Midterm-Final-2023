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

        //Assert user lands on the login/register page
        String loginRegisterPageExpectedHeaderText = "My Account";
        String loginRegisterPageActualHeaderText = getElementText("//div[@class = 'u-column1 col-1']/h2/text()");
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

        //make sure user lands on Homepage page successfully
        boolean superDealsHeadedisDisplayed = isVisible("//a[@title = 'Super Deals']");
        Assert.assertTrue(superDealsHeadedisDisplayed);
        log.info("My Account page header is displayed");
        String homepageExpectedHeaderText = "My Account";
        String homepageActualHeaderText = getElementText("//a[@title = 'Super Deals']");
        Assert.assertEquals(homepageExpectedHeaderText, homepageActualHeaderText);
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

        //Assert user lands on the login/register page
        String loginRegisterPageExpectedHeaderText = "My Account";
        String loginRegisterPageActualHeaderText = getElementText("//div[@class = 'u-column1 col-1']/h2/text()");
        Assert.assertEquals(loginRegisterPageExpectedHeaderText, loginRegisterPageActualHeaderText);
        log.info("user login/register page validation text match success");

        //enter  username
        typeText("#username", "rkhan326@gmail.com");
        log.info("enter username success");
        waitFor(2);

        //enter  password
        typeText("#password", "HelloWorld122");
        log.info("enter password success");
        waitFor(2);

        //click on login button
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
