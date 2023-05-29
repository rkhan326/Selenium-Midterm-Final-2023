package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.lumapages.*;

public class CheckOutShoppingCartTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(CheckOutShoppingCartTest.class.getName());


    @Test
    public void ShoppingandAddToWishList() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("Sign in title page validation success");

        //String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy1@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword("password&1234");
        signinPageMagento.clickOnSigninButton2();
        LOG.info("Signin success");
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Home Page");
        LOG.info("Sign in title page validation success");
        homePage.ClickOnSaleButton();

        String title2= getCurrentTitle();
        Assert.assertEquals(title2, "Sale");
        LOG.info("Sale title page validation success");
        SaleMagentoPage saleMagentoPage = new SaleMagentoPage(getDriver());
        saleMagentoPage.clickOnShopWomensDealButton();
        String title3 = getCurrentTitle();
        Assert.assertEquals(title3, "Women Sale");
        LOG.info("Women's Deal title page validation success");
        //add a product"Wayfarer Messenger Bag" to the cart
        WomensDealPageMagento womensDealPageMagento = new WomensDealPageMagento(getDriver());
        womensDealPageMagento.hoverOverJosieYogaJacket(getDriver());
        womensDealPageMagento.clickOnSizeM();
        womensDealPageMagento.ClickOnColorBlackButton();
        womensDealPageMagento.ClickAddToCartButton();
        womensDealPageMagento.ClickOnCartButton();
        womensDealPageMagento.ClickOnViewAndEditCart(getDriver());

        String title4= getCurrentTitle();
        Assert.assertEquals(title4, "Shopping Cart");
        LOG.info("Shopping Cart title page validation success");
        ShoppingCartPageMagento shoppingCartPageMagento = new ShoppingCartPageMagento(getDriver());
        shoppingCartPageMagento.ClickOnMoveToWishListButton();
        shoppingCartPageMagento.ClickOnLUMAButton();
        String title5 = getCurrentTitle();
        Assert.assertEquals(title5, "Home Page");
        LOG.info("login title page validation success");
    }


    @Test
    public void UpdateShoppingCartAndCheckout() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        SuccessPurchasePage successPurchasePage =new SuccessPurchasePage(getDriver());
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("Sign in title page validation success");

        //String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy1@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword("password&1234");
        signinPageMagento.clickOnSigninButton2();
        LOG.info("Signin success");
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Home Page");
        LOG.info("Sign in title page validation success");

        homePage.hoverOverFloatingMenu(getDriver());
        homePage.clickOnFitnessEquipment();

        String title2= getCurrentTitle();
        Assert.assertEquals(title2, "Fitness Equipment - Gear");
        LOG.info("Fitness equipment title page validation success");
        FitnessEquipmentMagentoPage fitnessEquipmentMagentoPage = new FitnessEquipmentMagentoPage(getDriver());
        fitnessEquipmentMagentoPage.hoverOverItem1(getDriver());
        fitnessEquipmentMagentoPage.clickOnAddToCart1();

        fitnessEquipmentMagentoPage.hoverOverItem2(getDriver());
        Thread.sleep(3000);
        fitnessEquipmentMagentoPage.clickOnAddToCart2();

        fitnessEquipmentMagentoPage.clickOnCartButton();
        Thread.sleep(3000);
        fitnessEquipmentMagentoPage.clickOnViewAndEditCart(getDriver());

        String title3= getCurrentTitle();
        Assert.assertEquals(title3, "Shopping Cart");
        LOG.info("Shopping Cart title page validation success");
        ShoppingCartPageMagento shoppingCartPageMagento = new ShoppingCartPageMagento(getDriver());
        shoppingCartPageMagento.typeOnQuantityField();
        LOG.info("update quantity success");
        shoppingCartPageMagento.ClickOnRemoveButton();
        LOG.info("update quantity success");
        shoppingCartPageMagento.ClickOnUpdateShoppingCart();


        shoppingCartPageMagento.ClickOnProceedToCheckOutButton();
        CheckOutPageMagento checkOutPageMagento = new CheckOutPageMagento(getDriver());
        String title4= getCurrentTitle();
        Assert.assertEquals(title4, "Checkout");
        LOG.info("checkout title page validation success");



    }






}
