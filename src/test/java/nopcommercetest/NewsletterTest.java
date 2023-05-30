package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.NewsletterPage;

public class NewsletterTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());
    RegisterTest registerTest = new RegisterTest();
    String email = registerTest.email;

    @Test(enabled = true, priority = 1)
    public void NewsletterTestWithValidEmail() {
        NewsletterPage newsletterPage= new NewsletterPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        newsletterPage.enterValidEmail(email);
        newsletterPage.clickOnSubscribe();

        String expectedText = "Thank you for signing up! A verification email has been sent. " +
                "We appreciate your interest.";
        String actualText = newsletterPage.subscribeSuccessfully();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test(enabled = true, priority = 2)
    public void NewsletterTestWithInvalidEmail() {
        NewsletterPage newsletterPage= new NewsletterPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        newsletterPage.enterValidEmail("");
        newsletterPage.clickOnSubscribe();

        String expectedText = "Enter valid email";
        String actualText = newsletterPage.subscribeErrorMessage();
        Assert.assertEquals(expectedText, actualText);
    }
}
