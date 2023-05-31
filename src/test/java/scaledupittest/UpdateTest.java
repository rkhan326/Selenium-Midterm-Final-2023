package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.UpdatePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class UpdateTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchTest.class.getName());


   @Test(enabled = true,priority = 0)
    public void updateAccountWithItemNumber() {

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


        // check 1 item is added to the cart
        String expectedCartCount = "1";
        String actualCartCount = update.getCartCountHeaderText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        update.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");


        // update.entreItemNumberBtn
        update.hoverOverOnQuantityField(getDriver());
        waitFor(3);

        // entre 2 in item quantity
        update.entreItemNumberBtn("2");
        waitFor(5);

        // click on update cart button
        update.clickOnUpdateCartButton();
        waitFor(3);

        // check user has added 2 items to the cart
        String expectedCartCountUpdateItem = "2";
        String actualCartCountUpdateItem = update.getCartCountUpadteHeaderItemText();
        Assert.assertEquals(expectedCartCountUpdateItem, actualCartCountUpdateItem);
        log.info("2 item added to cart success");
    }
    @Test(enabled = true,priority = 1)
    public void updateAccountPrice() {

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


        // check 1 item is added to the cart
        String expectedCartCount = "1";
        String actualCartCount = update.getCartCountHeaderText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        update.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");


        // update.entreItemNumberBtn("4");
        update.hoverOverOnQuantityField(getDriver());
        waitFor(3);

        // entre 2 in item quantity
        update.entreItemNumberBtn("5");
        waitFor(5);

        // click on update cart button
        update.clickOnUpdateCartButton();
        waitFor(3);

        // check user has added 2 items to the cart
        String expectedCartCountPriceUpdate = "5";
       String actualCartCountPriceUpdate = update.getCartCountUpadtePriceHeaderText();
        Assert.assertEquals(expectedCartCountPriceUpdate, actualCartCountPriceUpdate);
        log.info("5 item added to cart success");

        // check price is changed to 795 $
       Assert.assertTrue(update.checkPriceUpdate());
        String expectedPriceUpdate = "$795.00";
        String actualPriceUpdate = update.getPriceUpdateText();
        Assert.assertEquals(expectedPriceUpdate, actualPriceUpdate);
        log.info("price updated to 765$ success");
        takeScreenshot("Scalledupit Update Test");
    }



    }




