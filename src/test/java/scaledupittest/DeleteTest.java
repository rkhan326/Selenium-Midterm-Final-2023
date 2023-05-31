package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.DeletePage;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class DeleteTest extends CommonAPI {
    Logger log = LogManager.getLogger(DeleteTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test(enabled = true,priority = 0)
    public void DeleteItem() {

       DeletePage  delete = new DeletePage(getDriver());
       HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

       // click on cart button
        homePage.clickOnCartButton();
        waitFor(3);

        //check user is landed to the cart page
        Assert.assertTrue(delete.checkPresenceOfCartHeaderText());
        String expectedCartPageHeader = "Cart";
        String actualCartPageHeader= delete.getCartPageHeaderText();
        Assert.assertEquals(expectedCartPageHeader, actualCartPageHeader);

        // click  on return Shop
        delete.clickOnReturnToShopBtn();
        waitFor(3);

     // check if user landed to the shop page
     Assert.assertTrue(delete.checkShopPageHeader());
     String expectedShopPageHeader = "Shop";
     String actualShopPageHeader = delete.getShopPageHeaderText();
     Assert.assertEquals(expectedShopPageHeader, actualShopPageHeader);
     log.info("shop page  header text validate  success");

     //click on Belt button
       delete.clickOnBeltBtn();
        waitFor(3);

     // check if user landed to the belt page
     Assert.assertTrue(delete.checkBeltPageHeader());
     String expectedBeltPageHeader = "Belt";
     String actualBeltPageHeader = delete.getBeltPageHeaderText();
     Assert.assertEquals(expectedBeltPageHeader, actualBeltPageHeader);
     log.info("Belt page header text validate  success");

     // click on add to cart
        delete.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item has added to the cart
        Assert.assertTrue(delete.checkCartCount());
        String expectedCartCount = "1";
        String actualCartCount= delete.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        waitFor(3);
        log.info("1 item added to cart success");

        // click on cart button
        delete.clickOnCart();
        waitFor(3);

        // click on delete with (x)
        delete.clickOnX();
        waitFor(3);

        // check item is deleted fromcart
        delete.checkPresenceOfCartEmptyHeaderText();
        String expectedCartEmpty = "Your cart is currently empty.";
        String actualCartEmpty= delete.getCartEmptyPageHeaderText();
        Assert.assertEquals(expectedCartEmpty,actualCartEmpty);
        waitFor(3);
        log.info("cart Empty Header Success success");

        takeScreenshot("Scalledupit Delete Test");
    }
}

