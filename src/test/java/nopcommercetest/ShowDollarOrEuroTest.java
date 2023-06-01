package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.ShowDollarOrEuroPage;

public class ShowDollarOrEuroTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    @Test(enabled = true, priority = 1)
    public void selectDollar() {

        ShowDollarOrEuroPage showDollarOrEuroPage = new ShowDollarOrEuroPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        showDollarOrEuroPage.hoverOverCurrencyMenuAndClick(getDriver());
        showDollarOrEuroPage.clickOnDollar();

        String expectedText = "$1,200.00";
        String actualText = showDollarOrEuroPage.DollarSelectedSuccessfullyConfirmed();
        Assert.assertEquals(expectedText, actualText);


    }
    @Test(enabled = true, priority = 2)
    public void selectEuro() {
        ShowDollarOrEuroPage showDollarOrEuroPage = new ShowDollarOrEuroPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        showDollarOrEuroPage.hoverOverCurrencyMenuAndClick(getDriver());
        showDollarOrEuroPage.clickOnEuro();



        String expectedText = "€1032.00";
        String actualText = showDollarOrEuroPage.EuroSelectedSuccessfullyConfirmed();
        Assert.assertEquals(expectedText, actualText);
    }
}
