package oussamaachourtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.*;

public class UpdateCartTest extends CommonAPI {

    @Test(enabled = true)
    public void updateCartCount(){
        HomePage homePage = new HomePage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());
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
        cartPage.enterProductQuantity(getDriver());
        cartPage.clickOnUpdateCartButton();

        //assert that the cart count equals two.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsTwo());

    }

}
