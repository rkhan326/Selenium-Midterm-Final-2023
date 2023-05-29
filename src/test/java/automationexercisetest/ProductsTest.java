package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.ProductsPage;

public class ProductsTest extends CommonAPI {
    Logger log = LogManager.getLogger(ProductsTest.class.getName());

//    @Test
    public void productsSearchField6(){

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnMenButton(getDriver());
        waitFor(1);

        //enter search product in search field
        productsPage.enterSearchProductInSearchField();
        productsPage.clickOnSearchButton();

        //validate searched products header
        String expectedSearchedProductsHeader = "SEARCHED PRODUCTS";
        String actualSearchProductsHeader = productsPage.getSearchProductsHeaderText();
        Assert.assertEquals(expectedSearchedProductsHeader,actualSearchProductsHeader);
        log.info("Well done my G!! Search products header validation success");
    }

//  @Test
      public void productsCategorySideButtons7(){

    HomePage homePage = new HomePage(getDriver());
    ProductsPage productsPage = new ProductsPage(getDriver());

    homePage.clickOnProductsButton(); //navigate to products page

    //click men on side filter then click tshirts
    productsPage.clickOnMenButton(getDriver());
    waitFor(1);
    productsPage.clickOnMenButton(getDriver());
    waitFor(1);
    productsPage.clickOnTshirtButton(getDriver());
    waitFor(1);


    //validate page header
    String expectedTshirtsProductsHeader = "MEN - TSHIRTS PRODUCTS";
    String actualTshirtsProductsHeader = productsPage.getTshirtsProductsHeaderText();
    Assert.assertEquals(actualTshirtsProductsHeader,expectedTshirtsProductsHeader);
    log.info("Well done my G!! Tshirts prodcuts header validation success");
    }

//    @Test
    public void productsBrandSideButtons8() {

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewStylishDressImage(getDriver());
        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedBabyhugProductsHeader = "BRAND - BABYHUG PRODUCTS";
        String actualBabyhugProductsHeader = productsPage.getBabyhugProductsHeaderText();
        Assert.assertEquals(actualBabyhugProductsHeader,expectedBabyhugProductsHeader);
        log.info("Well done my G!! Babyhug title validation success");
    }

//    @Test
    public void viewProductButton9(){

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());

        productsPage.clickOnViewProductMaxiDressButton(getDriver());

        //validate page header
        String expectedMaxiDressHeader = "Rose Pink Embroidered Maxi Dress";
        String actualMaxiDressHeader = productsPage.getMaxiDressHeaderText();
        Assert.assertEquals(actualMaxiDressHeader,expectedMaxiDressHeader);
        log.info("Well done my G!! Maxi Dress title validation success");
    }
    @Test
    public void writeReivewMaxiDress10() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnProductsButton(); //navigate to products page

        productsPage.clickOnBabyhugButton(getDriver());
        waitFor(1);
        productsPage.scrollToViewMaxiDressImage(getDriver());
        productsPage.clickOnViewProductMaxiDressButton(getDriver());
        waitFor(1);
        productsPage.enterReviewMaxiDress(getDriver());

    }

}
//byte - short - char - int - long - float - double