package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.LoginPage;
import us.piit.pages.automationexercisepages.ProductsPage;

public class ProductsTest extends CommonAPI {
    Logger log = LogManager.getLogger(ProductsTest.class.getName());
//    @Test
//    public void productsSearchField(){
//        LoginPage loginpage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        ProductsPage productsPage = new ProductsPage(getDriver());
//
//        //navigate to products page
//        homePage.clickClickOnProductsButton();
//
//        //click on pop up blocker
//
//        //enter search product in search field
//        productsPage.enterSearchProductInSearchField();
//        productsPage.clickClickOnSearchButton();
//
//        //validate searched products header
//        String expectedSearchedProductsHeader = "SEARCHED PRODUCTS";
//        String actualSearchProductsHeader = productsPage.getSearchProductsHeaderText();
//        Assert.assertEquals(expectedSearchedProductsHeader,actualSearchProductsHeader);
//
//    }

@Test
public void productsCategory(){
    LoginPage loginpage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    ProductsPage productsPage = new ProductsPage(getDriver());

    //navigate to products page
    homePage.clickClickOnProductsButton();

    //click on pop up blocker

    //click men on side filter then click tshirts
    productsPage.clickClickOnMenButton();
    productsPage.clickClickOnTshirtButton();

    //validate Men tshirts products
    String expectedTshirtProductsHeader = "MEN - TSHIRTS PRODUCTS!";
    String actualTshirtProductsHeader = productsPage.getTshirtsProductsHeaderText();
    Assert.assertEquals(expectedTshirtProductsHeader,actualTshirtProductsHeader);

}
//    @Test
//    public void productsBrand(){
//        LoginPage loginpage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        ProductsPage productsPage = new ProductsPage(getDriver());
//
//        //navigate to products page
//        homePage.clickClickOnProductsButton();
//
//        //click on pop up blocker
//
//    }
//    @Test
//    public void viewProductButton(){
//        LoginPage loginpage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        ProductsPage productsPage = new ProductsPage(getDriver());
//
//        //navigate to products page
//        homePage.clickClickOnProductsButton();
//
//        //click on pop up blocker
//
//    }
//    @Test
//    public void AddToCartButton(){
//        LoginPage loginpage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//        ProductsPage productsPage = new ProductsPage(getDriver());
//
//        //navigate to products page
//        homePage.clickClickOnProductsButton();
//
//        //click on pop up blocker
//
//    }
}
