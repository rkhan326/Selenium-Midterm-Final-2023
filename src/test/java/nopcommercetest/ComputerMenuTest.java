package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.ComputerMenuPage;

public class ComputerMenuTest extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    @Test(enabled = true, priority = 1)
    public void checkDesktopMenu() {

        ComputerMenuPage computerMenuPage = new ComputerMenuPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover Over Computer menu
        computerMenuPage.hoverOverComputerMenu(getDriver());
        //click on Desktop
        computerMenuPage.hoverOverDesktopMenuAndClick(getDriver());
        //check we are desktop page
        String expectedDesktopsPageHeader = "Desktops";
        String actualDesktopsPageHeader = computerMenuPage.checkDesktopsPageIsOpen();
        Assert.assertEquals(expectedDesktopsPageHeader, actualDesktopsPageHeader);
        waitFor(1);
        //click on product
        computerMenuPage.clickOnProduct();
        // select Ram and select 2gb
        computerMenuPage.selectRamMenu();
        computerMenuPage.selectRam2gbMenu();
        //select HDD radio button
        computerMenuPage.clickOnRadioButton();
        //click on add to cart
        computerMenuPage.clickOnAddToCartButton();
        // see successfully added product in add to cart message

        String expectedText = "The product has been added to your shopping cart";
        String actualText = computerMenuPage.getOrderAddToCartAlertText();
        Assert.assertEquals(expectedText, actualText);
    }

     @Test(enabled = true, priority = 2)
    public void checkDesktopMenuNotFillMandatoryRequirement() {
        ComputerMenuPage computerMenuPage = new ComputerMenuPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover Over Computer menu
        computerMenuPage.hoverOverComputerMenu(getDriver());
        //click on Desktop
        computerMenuPage.hoverOverDesktopMenuAndClick(getDriver());
        //check we are desktop page
        String expectedDesktopsPageHeader = "Desktops";
        String actualDesktopsPageHeader = computerMenuPage.checkDesktopsPageIsOpen();
        Assert.assertEquals(expectedDesktopsPageHeader, actualDesktopsPageHeader);
        waitFor(1);
        //click on product
        computerMenuPage.clickOnProduct();
        //  Not select Ram and select 2gb

        //computerMenuPage.selectRam2gbMenu();
        //select HDD radio button
        computerMenuPage.clickOnRadioButton();
        //click on add to cart
        computerMenuPage.clickOnAddToCartButton();
        // see successfully added product in add to cart message

//       Assert.assertTrue(computerMenuPage.checkErrorMessage());
        String expectedText = "Please select RAM";
        String actualText = computerMenuPage.showErrorMessage();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test(enabled = true, priority = 3)
    public void checkNotebookMenu() {

        ComputerMenuPage computerMenuPage = new ComputerMenuPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover Over Computer menu
        computerMenuPage.hoverOverComputerMenu(getDriver());
        //click on Notebook
        computerMenuPage.hoverOverNotebookMenuAndClick(getDriver());
        //check we are Notebook page
        String expectedDesktopsPageHeader = "Notebooks";
        String actualDesktopsPageHeader = computerMenuPage.checkNotebooksPageIsOpen();
        Assert.assertEquals(expectedDesktopsPageHeader, actualDesktopsPageHeader);
        waitFor(1);
        //click on product
        computerMenuPage.clickOnNotebook();
        //click on add to cart
        computerMenuPage.clickOnAddCartButton();
        //click on we add product add to cart success
        String expectedText = "The product has been added to your shopping cart";
        String actualText = computerMenuPage.getOrderAddToCartText();
        Assert.assertEquals(expectedText, actualText);
    }
}