package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.LoginPage;
import us.piit.pages.scaledupitpages.UpdatePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class UpdateTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test
    public void updateAccount() {

        UpdatePage update = new UpdatePage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


        //scroll to kids collection button

        scrollToCoordinates(0, 1500);
        waitFor(3);
        Assert.assertTrue(homePage.checkAddKidsCollectionToCartIsVisible());
        waitFor(3);

        homePage.clickOnaddKidsToCartButton();
        waitFor(3);


//   // check 1 item is added to the cart
        String expectedCartCount = "1";
        String actualCartCount= update.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        update.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");


//        update.entreItemNumberBtn("4");
        update.hoverOverOnQuantitField(getDriver());
        waitFor(3);

        update.entreItemNumberBtn("2");
        waitFor(5);

        update.clickOnUpdateCartButton();
        waitFor(3);

        String expectedCartCountUpdate = "2";
        String actualCartCountUpdate= update.getCartCountUpadteText();
        Assert.assertEquals(expectedCartCountUpdate,actualCartCountUpdate);
       // update.clickOnCart();
        waitFor(3);
        log.info("2 item added to cart success");
    }


}




