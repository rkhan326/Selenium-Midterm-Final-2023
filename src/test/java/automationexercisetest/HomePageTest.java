package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.HomePage;



public class HomePageTest extends CommonAPI {
    Logger log = LogManager.getLogger(HomePageTest.class.getName());

    @Test
    public void nextRightHomePageButton19() {
        HomePage homePage = new HomePage(getDriver());

        //click on next right button
        homePage.clickOnNextRightButton();
        waitFor(1);
        homePage.clickOnNextRightButton();
        waitFor(1);
        homePage.clickOnNextRightButton();
        waitFor(1);
        homePage.clickOnNextRightButton();
        log.info("Well done my guy! Items Next Right button success!");
    }
    @Test
    public void nextLeftHomePageButton20() {
        HomePage homePage = new HomePage(getDriver());

        //click on next left button
        homePage.clickOnNextLeftButton();
        waitFor(1);
        homePage.clickOnNextLeftButton();
        waitFor(1);
        homePage.clickOnNextLeftButton();
        waitFor(1);
        homePage.clickOnNextLeftButton();
        log.info("Well done my guy! Items Next Left button success!");

    }
    @Test
    public void nextLeftRecommendedItemsHomePageButton21() {
        HomePage homePage = new HomePage(getDriver());

        //scroll down to view recommended Items
        homePage.scrollToViewRecommendedItems(getDriver());

        //click on next left button
        homePage.clickOnNextLeftRecommendedItemsButton();
        waitFor(1);
        homePage.clickOnNextLeftRecommendedItemsButton();
        waitFor(1);
        homePage.clickOnNextLeftRecommendedItemsButton();
        waitFor(1);
        homePage.clickOnNextLeftRecommendedItemsButton();
        log.info("Well done my guy! Recommended Items Next Left button success!");

    }

    @Test
    public void nextRightRecommendedItemsHomePageButton22() {
        HomePage homePage = new HomePage(getDriver());

        //scroll down to view recommended Items
        homePage.scrollToViewRecommendedItems(getDriver());

        //click on next right button
        homePage.clickOnNextRightRecommendedItemsButton();
        waitFor(1);
        homePage.clickOnNextRightRecommendedItemsButton();
        waitFor(1);
        homePage.clickOnNextRightRecommendedItemsButton();
        waitFor(1);
        homePage.clickOnNextRightRecommendedItemsButton();
        log.info("Well done my guy! Recommended Items Next Right button success!");

    }

}
