package oussamaachourtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.CartPage;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.SingleProductPage;

public class ApplyCouponTest extends CommonAPI {
    Logger log = LogManager.getLogger(ApplyCouponTest.class.getName());

    @Test(enabled = true)
    public void updateCartCount(){
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        //scroll to and add the camera to cart from homepage
        homePage.scrollToCameraC430WAddToCartButton(getDriver());
        homePage.clickOnAddToCartForCameraC430WButton();

        //assert that the cart count equals one.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsOne());

        //assert that we see the goto cart button which is only visible after item has been added to cart
        Assert.assertTrue(homePage.checkPresenceOfCameraC430WViewCartButton());

        //Click on add to cart button
        homePage.clickOnCameraC430WViewCartButton();

        //assert that we land on the cart page.
        Assert.assertTrue(cartPage.checkPresenceOfCartPageHeader());
        ;
        //enter the desired quantity and hit update
        cartPage.enterCouponCode("Razia20sitewide", getDriver());
        cartPage.clickOnApplyCouponButton();

        //assert that the cart count equals two.
        String expectedValidTextAlert = "Coupon code applied successfully.";
        String actualValidTextAlert = cartPage.getCouponAppliedSuccessfullyText();
        Assert.assertEquals(actualValidTextAlert,expectedValidTextAlert);
        log.info("Coupon code applied successfully.");

    }
}
