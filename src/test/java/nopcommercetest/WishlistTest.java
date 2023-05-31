package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.ComputerMenuPage;
import us.piit.pages.nopcommercepages.WishlistPage;

public class WishlistTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartTest.class.getName());

    @Test(priority = 1)
    public void checkWishList(){
        ComputerMenuPage computerMenuPage = new ComputerMenuPage(getDriver());
        WishlistPage wishlistPage= new WishlistPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover Over Computer menu
        wishlistPage.hoverOverComputerMenu(getDriver());
        //click on Desktop
        wishlistPage.hoverOverDesktopMenuAndClick(getDriver());
        //check we are desktop page
        String expectedDesktopsPageHeader = "Desktops";
        String actualDesktopsPageHeader = computerMenuPage.checkDesktopsPageIsOpen();
        Assert.assertEquals(expectedDesktopsPageHeader, actualDesktopsPageHeader);
        waitFor(1);
        //click on product
        wishlistPage.clickOnProduct();
        // select Ram and select 2gb
        wishlistPage.selectRamMenu();
        wishlistPage.selectRam2gbMenu();
        //select HDD radio button
        wishlistPage.clickOnRadioButton();
        //click clickOn Wishlist Button
        wishlistPage.clickOnWishlistButton();
        // click WishList Menu
        wishlistPage.clickWishListMenu();

        String expectedText = "Product(s)";
        String actualText = wishlistPage.checkWishListPage();
        Assert.assertEquals(expectedText,actualText);
        takeScreenshot("wishlistTest");

    }
}
