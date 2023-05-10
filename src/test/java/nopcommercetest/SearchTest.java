package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class SearchTest extends CommonAPI {

    Logger log= LogManager.getLogger(SearchTest.class.getName());

    @Test
    public void searchBoxIsWork () {
        //type "macbook" on search box
        typeText("//input[@id='small-searchterms']","macbook" );
        log.info("type macbook in search box success");
        waitFor(1);

        // click search button

        clickOn("//button[@class='button-1 search-box-button']");
        log.info("search button click success");
        waitFor(1);

        //ensure we are successfully search page
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce search page");




    }

}
