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
//        Assert.assertTrue(homePage.checkKidsCollectionButtonIsVisible());
//        waitFor(3);

        homePage.clickOnaddKidsToCartButton();
        waitFor(3);

        // click on add cart
//        update.clickOnAddToCartButton();
//        waitFor(3);
   // check 1 item is added to the cart
        String expectedCartCount = "1";
        String actualCartCount= update.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        update.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");


       // update.entreItemNumberBtn("4");
        update.hoverOverOnQuantitField(getDriver());
        waitFor(3);
        update.clickOnChangeItemButton();
      //  update.entreItemNumberBtn("5");
        waitFor(3);
//// click on apply coupons
//        update.clickOnApplyCoupons();
//        waitFor(3);
//// user get error message
//        String expectedErrorMessage = "Coupon \"12456\" does not exist!";
//        String actualErrorMessage = coupons.getErrorMessage();
//        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
//        log.info("error message  text validate ");
//        waitFor(3);

    }

}

















        //click on kids collection
//      homePage.clickOnKidsCollectionJS();
//      waitFor(3);
//
//        //Make sure we land on the kids Collectoion page successfully
//        Assert.assertTrue(update.checkPresenceOfKidsCollectionPageHeader());
//
//        String expectedKidsCollectionHeaderText = "Kids Collection";
//        String actualKidsCollectionHeaderText = update.getKidsCollectionPageHeadertext();
//        Assert.assertEquals(expectedKidsCollectionHeaderText, actualKidsCollectionHeaderText);
//
//
//    }}
