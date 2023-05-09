package danish;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class ShoppingCartTest extends SetUp {

    Logger log = LogManager.getLogger(ShoppingCartTest.class.getName());
    @Test
    public void checkShoppingCart(){

        //click on books
        clickOn("(//a[normalize-space()='Books'])[1]");
        log.info("click on books success");
        waitFor(1);
        //click on Fahrenheit 451 by Ray Bradbury link
        clickOn("//h2[@class='product-title']//a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]");
        log.info("click on Fahrenheit 451 by Ray Bradbury link success");
        waitFor(1);

        // click on add to cart
        clickOn("//button[@id='add-to-cart-button-37']");
        log.info("click on add to cart success");
        waitFor(3);

        //ensure we are successfully add to cart search page
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Fahrenheit 451 by Ray Bradbury";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce add to cart page");


       /* //click on shopping cart
        clickOn("//span[@class='cart-label']");
        log.info("click on shopping cart success");
        waitFor(1);

        //click on remove
        clickOn("//button[@class='remove-btn']");
        log.info("click on remove success");
        waitFor(1);*/


    }
}
