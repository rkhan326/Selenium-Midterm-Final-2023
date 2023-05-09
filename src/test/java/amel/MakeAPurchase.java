package amel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;


public class MakeAPurchase extends SetUp {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void addToCart() throws InterruptedException {

  // user land to the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user logged in success");


        // hover over & click on women collection
        hoverOver("//*[contains(text(),'Women Collection')]");
        log.info("hover over women collection success");
        clickOn("//*[contains(text(),'Women Collection')]");
        log.info("click on Women Collection success");
        waitFor(3);

        // check user has landed to the women collection page
        boolean WomenCollectionHeaderIsDisplayed = isVisible(("//h1[@class='woocommerce-products-header__title page-title']"));
        Assert.assertTrue(WomenCollectionHeaderIsDisplayed);
        log.info("Women collection header is displayed");
        String expectedheaderText = "Women Collection";
        String actualheaderText = getElementText("h1[class='woocommerce-products-header__title page-title']");
        Assert.assertEquals(expectedheaderText, actualheaderText);
        log.info("validating Women Collection header success ");

        // click on converse item
        clickOn(".woocommerce-loop-product__title");
        log.info("click on converse success");
        waitFor(3);

        // add to cart
        clickOn("//ul[@class='products columns-4']/li[1]/a[2]");
        log.info("converse added to cart success");
        waitFor(3);

        //check converse is added to the cart
        boolean cartcount = isVisible(("//span[@class='cart-value cart-customlocation' and text()=1]"));
        Assert.assertTrue(cartcount);
        log.info("1 item on the cart is displayed");


      // click on cart
        clickOn("//span[@class='cart-value cart-customlocation' and text()=1]");
        log.info("click on cart success");
        waitFor(3);

    }
}








