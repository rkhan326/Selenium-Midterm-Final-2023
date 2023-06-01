package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.scaledupitpages.CouponsPage;
import uspiit.pages.scaledupitpages.HomePage;
import uspiit.utility.Utility;

import java.util.Properties;

public class CouponsTest extends CommonAPI {
    Logger log = LogManager.getLogger(CouponsTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test(enabled = true,priority = 0)
    public void addCouponsWithInvalidCoupons() {

        CouponsPage coupons = new CouponsPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // hover over on catefgories
        homePage.hoverOverOnCategoriesButton(getDriver());
        waitFor(3);

        // click on food and beverage
        homePage.clickOnFoodAndBeverageButton();
        waitFor(3);

        // check user if he landed to the food and beverage page
        Assert.assertTrue(coupons.checkFoodAndBeveragePageHeader());
        String expectedFoodAndBeveragePageHeader = "Food & Beverage";
        String actualFoodAndBeveragePageHeader = coupons.getFoodAndBeveragePageHeaderText();
        Assert.assertEquals(expectedFoodAndBeveragePageHeader,actualFoodAndBeveragePageHeader);
        log.info("Food and Beverage Page header text validate  success");

        // click on pizza
        coupons.clickOnPizzaButton();
        waitFor(3);

        // check user if he landed to the Pizza page
        Assert.assertTrue(coupons.checkPizzaPageHeader());
        String expectedFPizzaPageHeader = "Pizza";
        String actualPizzaPageHeader = coupons.getPizzaPageHeaderText();
        Assert.assertEquals(expectedFPizzaPageHeader,actualPizzaPageHeader);
        log.info("Pizza Page header text validate  success");

        // click on add cart
        coupons.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item is added to the cart
        Assert.assertTrue(coupons.checkCartCount());
        String expectedCartCount = "1";
        String actualCartCount= coupons.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        coupons.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");

        // enter coupons
        coupons.enterCoupons("12456");
        waitFor(3);

        // click on apply coupons
        coupons.clickOnApplyCoupons();
        waitFor(3);

        // user get error message
        String expectedCouponsErrorMessage = "Coupon \"12456\" does not exist!";
        String actualCouponsErrorMessage = coupons.getErrorMessageHeaderText();
        Assert.assertEquals(expectedCouponsErrorMessage, actualCouponsErrorMessage);
        log.info("error message  text validate ");
        waitFor(3);

    }
    @Test(enabled = true,priority = 1)
    public void applyCouponWithoutCoupon() {

        CouponsPage coupons = new CouponsPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // hover over on catefgories
        homePage.hoverOverOnCategoriesButton(getDriver());
        waitFor(3);

        // click on food and beverage
        homePage.clickOnFoodAndBeverageButton();
        waitFor(3);

        // check user if he landed to the food and beverage page
        Assert.assertTrue(coupons.checkFoodAndBeveragePageHeader());
        String expectedFoodAndBeveragePageHeader = "Food & Beverage";
        String actualFoodAndBeveragePageHeader = coupons.getFoodAndBeveragePageHeaderText();
        Assert.assertEquals(expectedFoodAndBeveragePageHeader,actualFoodAndBeveragePageHeader);
        log.info("Food and Beverage Page header text validate  success");

        // click on pizza
        coupons.clickOnPizzaButton();
        waitFor(3);

        // check user if he landed to the Pizza page
        Assert.assertTrue(coupons.checkPizzaPageHeader());
        String expectedFPizzaPageHeader = "Pizza";
        String actualPizzaPageHeader = coupons.getPizzaPageHeaderText();
        Assert.assertEquals(expectedFPizzaPageHeader,actualPizzaPageHeader);
        log.info("Pizza Page header text validate  success");

        // click on add cart
        coupons.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item is added to the cart
        Assert.assertTrue(coupons.checkCartCount());
        String expectedCartCount = "1";
        String actualCartCount= coupons.getCartCountText();
        Assert.assertEquals(expectedCartCount,actualCartCount);
        coupons.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");



        // click on apply coupons
        coupons.clickOnApplyCoupons();
        waitFor(3);

        // user get error message
        Assert.assertTrue(coupons.checkNoCouponsErrorMessageHeader());
        String expectedNoCouponsErrorMessage = "Please enter a coupon code.";
        String actualNoCouponsErrorMessage = coupons.getNoCouponsErrorMessageHeaderText();
        Assert.assertEquals(expectedNoCouponsErrorMessage, actualNoCouponsErrorMessage);
        log.info("No coupons error message  text validate ");
        waitFor(3);
        takeScreenshot("scalledupit final coupon test");

    }

}


