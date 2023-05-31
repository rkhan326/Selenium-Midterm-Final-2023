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

public class CartPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

//    @Test
    public void addToCartFromMaxiDressPageButton11() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnAdButton(getDriver());//click on Ad
        waitFor(1);

        productsPage.scrollToViewMaxiDressImage(getDriver());//scroll to view Maxi dress

        productsPage.clickOnViewProductMaxiDressButton(getDriver());//click on Maxi dress
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());//add dress to cart
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

        productsPage.clickOnAdButton(getDriver());//click on Ad
        waitFor(1);


        productsPage.scrollToViewMaxiDressImage(getDriver());//scroll to view Maxi dress

        productsPage.clickOnViewProductMaxiDressButton(getDriver());//click on Maxi dress
        waitFor(1);
        productsPage.clickOnMaxiDressAddToCartButton(getDriver());//add dress to cart
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText,expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));

        cartPage.clickOnMaxiDressViewCartButton(getDriver()); //click on view cart

        productsPage.clickOnMaxiDressDeleteFromCartButton(getDriver());//delete Maxi Dress from cart
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

        productsPage.clickOnAdButton(getDriver());//click on Ad
        waitFor(1);

        productsPage.scrollToViewMaxiDressImage(getDriver());//scroll to view Maxi dress

        productsPage.clickOnViewProductMaxiDressButton(getDriver());//click on Maxi dress
        waitFor(1);

        productsPage.clickOnMaxiDressAddToCartButton(getDriver());//add dress to cart
        waitFor(1);

        //validate page header
        String expectedMaxiDressAddedText = "Added!";
        String actualMaxiDressAddedText = productsPage.getMaxiDressAddedText();
        Assert.assertEquals(actualMaxiDressAddedText,expectedMaxiDressAddedText);
        log.info(homePage.wellDoneBoy.concat(expectedMaxiDressAddedText).concat(homePage.headerValidationSuccess));

        cartPage.clickOnMaxiDressViewCartButton(getDriver());//click on view cart

        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());//click on proceed to checkout
        waitFor(1);

        cartPage.clickOnContinueOnCartMaxiDressButton(getDriver());//click on continue on cart

        Assert.assertTrue(cartPage.proceedToCheckoutIsVisible());//validate proceed to checkout button
    }
//    @Test
    public void loginButtonProceedToCheckoutMaxiDress14() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnAdButton(getDriver());//click on Ad
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

        cartPage.clickOnMaxiDressViewCartButton(getDriver());//click on view cart

        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());//click on proceed to checkout
        waitFor(1);

        cartPage.clickOnRegisterLoginCheckoutMaxiDressButton(getDriver());//click on register/ Login on cart
    }
//    @Test
    public void loginFromProceedToCheckoutMaxiDress15() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnAdButton(getDriver());//click on Ad
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

        cartPage.clickOnMaxiDressViewCartButton(getDriver());//click on view cart

        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());//click on proceed to checkout
        waitFor(1);

        cartPage.clickOnRegisterLoginCheckoutMaxiDressButton(getDriver());//click on register/ Login on cart

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
//        waitFor(1);

        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());//click on proceed to checkout
        waitFor(1);

        //validate checkout page
        String expectedAddressDetailsText = "Address Details";
        String actualAddressDetailsText = cartPage.getAddressDetailsText();
        Assert.assertEquals(actualAddressDetailsText,expectedAddressDetailsText);
        log.info(homePage.wellDoneBoy.concat(expectedAddressDetailsText).concat(homePage.headerValidationSuccess));
    }
//    @Test
    public void placeOrderMaxiDress17() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnSignupLoginButton(); //navigate to signin page

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        homePage.clickOnCartButton(); //navigate to cart page

        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());//click on proceed to checkout
        waitFor(1);

        //validate checkout page
        String expectedAddressDetailsText = "Address Details";
        String actualAddressDetailsText = cartPage.getAddressDetailsText();
        Assert.assertEquals(actualAddressDetailsText,expectedAddressDetailsText);
        log.info(homePage.wellDoneBoy.concat(expectedAddressDetailsText).concat(homePage.headerValidationSuccess));

        cartPage.scrollToViewSubscibtionText(getDriver());//scroll to view subscribtion text
        waitFor(1);

        cartPage.clickOnPlaceOrderButton(getDriver());//click on place order
        waitFor(3);

        productsPage.clickOnAdButton(getDriver());//click on Ad
        waitFor(1);

        //validate payment header

    }
//    @Test
    public void makePaymentMaxiDress17() {
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.clickOnSignupLoginButton(); //navigate to signin page

        //enter login email address, password and click login button
        loginPage.enterValidLoginEmailInLoginEmailField();
        loginPage.enterValidLoginPasswordInLoginPasswordField();
        loginPage.clickOnLoginButton();

        homePage.clickOnCartButton(); //navigate to cart page

        cartPage.clickOnProceedToCheckoutMaxiDressButton(getDriver());//click on proceed to checkout
        waitFor(1);

        //validate checkout page
        String expectedAddressDetailsText = "Address Details";
        String actualAddressDetailsText = cartPage.getAddressDetailsText();
        Assert.assertEquals(actualAddressDetailsText,expectedAddressDetailsText);
        log.info(homePage.wellDoneBoy.concat(expectedAddressDetailsText).concat(homePage.headerValidationSuccess));

        cartPage.scrollToViewSubscibtionText(getDriver());//scroll to view subscribtion text
        cartPage.clickOnPlaceOrderButton(getDriver());//click on place order


    }


}

