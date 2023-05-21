package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.CouponsPage;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class CouponsTest extends CommonAPI {
    Logger log = LogManager.getLogger(CouponsTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test
    public void addCoupons() {

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

        // click on pizza
        coupons.clickOnPizzaButton();
        waitFor(3);

// click on add cart
        coupons.clickOnAddToCartButton();
        waitFor(3);
// check 1 item is added to the cart
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
        String expectedErrorMessage = "Coupon \"12456\" does not exist!";
        String actualErrorMessage = coupons.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        log.info("error message  text validate ");
        waitFor(3);

    }

}


