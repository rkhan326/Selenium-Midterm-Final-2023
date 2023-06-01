package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.SearchPage;

public class SearchTest extends CommonAPI {

    Logger log= LogManager.getLogger(SearchTest.class.getName());
    String typeMacbook= "macbook";

    @Test
    public void searchBoxIsWork () {

        SearchPage searchPage = new SearchPage(getDriver());

        //type "macbook" on search box
        searchPage.typeInSearchBox(typeMacbook);
        waitFor(1);

        // click search button
        searchPage.clickOnSearchBtn();
        waitFor(1);

        //ensure we are successfully search page
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce search page");




    }

}
