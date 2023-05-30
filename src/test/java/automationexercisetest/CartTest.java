package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.CartPage;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;
import us.piit.pages.automationexercisepages.ProductsPage;

public class CartTest extends CommonAPI {

    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void addToCartFromMaxiDressPageButton11() {

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());
        productsPage.clickOnViewProductMaxiDressButton(getDriver());
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText, expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));
    }

//    @Test
    public void deleteMaxiDressFromCart12(){

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());
        productsPage.clickOnViewProductMaxiDressButton(getDriver());
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText,expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));

        //click on view cart
        cartPage.clickOnMaxiDressViewCartButton(getDriver());

        //delete Maxi Dress from cart
        productsPage.clickOnMaxiDressDeleteFromCartButton(getDriver());
        waitFor(1);

        //validate deletion
        String expectedCartIsEmptyText = "Cart is empty!";
        String actualCartIsEmptyText = cartPage.getCartIsEmptyText();
        Assert.assertEquals(actualCartIsEmptyText,expectedCartIsEmptyText);
        log.info(homePage.wellDoneBoy.concat(expectedCartIsEmptyText).concat(homePage.headerValidationSuccess));
    }

//    @Test
    public void proceedToCheckoutMaxiDress13() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());
        productsPage.clickOnViewProductMaxiDressButton(getDriver());
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText,expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));

        //click on view cart
        cartPage.clickOnMaxiDressViewCartButton(getDriver());

        //click on proceed to checkout
        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());
        waitFor(1);

        //click on continue on cart
        cartPage.clickOnContinueOnCartMaxiDressButton(getDriver());

        //validate proceed to checkout button
        Assert.assertTrue(cartPage.proceedToCheckoutIsVisible());
    }

//    @Test
    public void loginButtonProceedToCheckoutMaxiDress14() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());
        productsPage.clickOnViewProductMaxiDressButton(getDriver());
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText,expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));

        //click on view cart
        cartPage.clickOnMaxiDressViewCartButton(getDriver());

        //click on proceed to checkout
        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());
        waitFor(1);

        //click on register/ Login on cart
        cartPage.clickOnRegisterLoginCheckoutMaxiDressButton(getDriver());
    }

//    @Test
    public void LoginFromProceedToCheckoutMaxiDress15() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());
        productsPage.clickOnViewProductMaxiDressButton(getDriver());
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText,expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));

        //click on view cart
        cartPage.clickOnMaxiDressViewCartButton(getDriver());

        //click on proceed to checkout
        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());
        waitFor(1);

        //click on register/ Login on cart
        cartPage.clickOnRegisterLoginCheckoutMaxiDressButton(getDriver());

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();
    }

//    @Test
    public void checkoutMaxiDress16() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnSignupLoginButton(); //navigate to signin page

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        homePage.clickOnCartButton(); //navigate to cart page

        //click on proceed to checkout
        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());
        waitFor(1);

        //validate checkout page
        String expectedAddressDetailsText = "Address Details";
        String actualAddressDetailsText = cartPage.getAddressDetailsText();
        Assert.assertEquals(actualAddressDetailsText,expectedAddressDetailsText);
        log.info(homePage.wellDoneBoy.concat(expectedAddressDetailsText).concat(homePage.headerValidationSuccess));
    }

    @Test
    public void placeOrderMaxiDress17() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnSignupLoginButton(); //navigate to signin page

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        homePage.clickOnCartButton(); //navigate to cart page

        //click on proceed to checkout
        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());
        waitFor(1);

        //validate checkout page
        String expectedAddressDetailsText = "Address Details";
        String actualAddressDetailsText = cartPage.getAddressDetailsText();
        Assert.assertEquals(actualAddressDetailsText,expectedAddressDetailsText);
        log.info(homePage.wellDoneBoy.concat(expectedAddressDetailsText).concat(homePage.headerValidationSuccess));
    }


}

