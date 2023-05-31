package oussamaachourtest; //3 tests

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.OrdersPage;
import us.piit.pages.oussamaachourpages.TrackYourOrderPage;

public class TrackOrderTest extends CommonAPI {
    Logger log = LogManager.getLogger(oussamaachourtest.TrackOrderTest.class.getName());

    String orderId = "5674";
    String billingEmail = "rkhan326@gmail.com";
    @Test (enabled = true)
    public void validOrderId(){
        TrackYourOrderPage trackYourOrderPage = new TrackYourOrderPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        OrdersPage ordersPage = new OrdersPage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on track your order link.
        homePage.clickOnTrackYourOrderLink();

        //check if we land on the track orders page
        Assert.assertTrue(trackYourOrderPage.checkPresenceOfTrackYourOrderHeader());

        //enter the orderId, billing email and click on track button.
        trackYourOrderPage.enterOrderID(orderId);
        trackYourOrderPage.enterBillingEmail(billingEmail);
        trackYourOrderPage.clickOnTrackBtn();

        //assert we land on orders page
        Assert.assertTrue(ordersPage.checkPresenceOfOrdersDetailsHeader());

    }
    @Test(enabled=true)
    public void invalidOrderId(){
        TrackYourOrderPage trackYourOrderPage = new TrackYourOrderPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        OrdersPage ordersPage = new OrdersPage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on track your order link.
        homePage.clickOnTrackYourOrderLink();

        //check if we land on the track orders page
        Assert.assertTrue(trackYourOrderPage.checkPresenceOfTrackYourOrderHeader());

        //enter the orderId, billing email and click on track button.
        trackYourOrderPage.enterOrderID("invalidOrderId");
        trackYourOrderPage.enterBillingEmail(billingEmail);
        trackYourOrderPage.clickOnTrackBtn();

        //Validate error message
        Assert.assertTrue(trackYourOrderPage.checkPresenceOfTrackOrderNotFoundMessage());

        String expectedTrackOrderOrderNotFoundMessageText = "Sorry, the order could not be found. Please contact us if you are having difficulty finding your order details.";
        String actualTrackOrderOrderNotFoundMessageText = trackYourOrderPage.getTrackOrderNotFoundErrorMessageText();
        Assert.assertEquals(expectedTrackOrderOrderNotFoundMessageText, actualTrackOrderOrderNotFoundMessageText);


    }

    @Test(enabled=true)
    public void invalidEmail(){
        TrackYourOrderPage trackYourOrderPage = new TrackYourOrderPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        OrdersPage ordersPage = new OrdersPage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on track your order link.
        homePage.clickOnTrackYourOrderLink();

        //check if we land on the track orders page
        Assert.assertTrue(trackYourOrderPage.checkPresenceOfTrackYourOrderHeader());

        //enter the orderId, billing email and click on track button.
        trackYourOrderPage.enterOrderID(orderId);
        trackYourOrderPage.enterBillingEmail("incorrectEmail");
        trackYourOrderPage.clickOnTrackBtn();

        //Validate error message
        Assert.assertTrue(trackYourOrderPage.checkPresenceOfTrackInvalidEmailMessage());

        String expectedTrackOrderInvalidEmailMessageText = "Please enter a valid email address";
        String actualTrackOrderInvalidEmailMessageText = trackYourOrderPage.getTrackOrderNotFoundErrorMessageText();
        Assert.assertEquals(expectedTrackOrderInvalidEmailMessageText, actualTrackOrderInvalidEmailMessageText);


    }



}
