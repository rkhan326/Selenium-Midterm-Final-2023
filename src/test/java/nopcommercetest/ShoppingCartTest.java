package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.ShoppingCartPage;

public class ShoppingCartTest extends CommonAPI {

    Logger log = LogManager.getLogger(ShoppingCartTest.class.getName());
    @Test
    public void checkShoppingCart(){
        ShoppingCartPage shoppingCartPage= new ShoppingCartPage(getDriver());


        //click on books
        shoppingCartPage.clickOnBookText();
        waitFor(1);
        //click on Fahrenheit 451 by Ray Bradbury link
        shoppingCartPage.clickOnBookLink();
        waitFor(1);

        // click on add to cart
        shoppingCartPage.clickOnAddToCart();
        waitFor(1);

        //ensure we are successfully add to cart search page
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Apple MacBook Pro 13-inch";
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
