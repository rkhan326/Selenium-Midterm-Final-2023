package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.GiftCardPage;

public class GiftCardTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartTest.class.getName());

    String firstName= "Danish";
    String lastName= "Mahmud";
    String email= "hello7@gmail.com";
    String senderEmail= "hello7@gmail.com";
    String message= "I have change these all email and password";


    //$25 Gift Card
    @Test(priority = 5)
    public void $25GiftCard(){
        GiftCardPage giftCardPage= new GiftCardPage(getDriver());
        giftCardPage.clickOnGiftCardLink25$();
        scrollToCoordinates(0,200);
        giftCardPage.clickOnVirtualGiftCard25$();
        scrollToCoordinates(0,150);
        giftCardPage.typeRecipientNameField25$(firstName);
        giftCardPage.typeRecipientEmailField25$(email);
        giftCardPage.typeYourNameField25$(lastName);
        giftCardPage.typeYourOrSenderEmailField25$(senderEmail);
        giftCardPage.typeMessageField25$(message);
        giftCardPage.clickOnAddToCartButton25$();

        // validation for $25 gift card
        String expectedResult = "shopping cart";
        String actualText = giftCardPage.validationFor$25GiftCardText();
        Assert.assertEquals(expectedResult,actualText);
        log.info("$25 gift card validation Success");

    }
    @Test(priority = 6)
    public void $50PhysicalGiftCard(){
        GiftCardPage giftCardPage= new GiftCardPage(getDriver());
        giftCardPage.clickOnGiftCardLink25$();
        scrollToCoordinates(0,150);
        giftCardPage.clickOn$50PhysicalGiftCard();
        scrollToCoordinates(0,150);
        giftCardPage.type$50RecipientsNameField(firstName);
        giftCardPage.type$50SenderNameField(lastName);
        giftCardPage.type$50MessageField(message);
        giftCardPage.clickOn$50AddToCartButton();

        // Validation
        String expectedResult = "shopping cart";
        String actualText = giftCardPage.validationFor$50ValidationText();
        Assert.assertEquals(expectedResult,actualText);
        log.info("$50 gift card validation Success");

    }
    @Test (priority = 7)
    public void $100PhysicalGiftCard(){
        GiftCardPage giftCardPage= new GiftCardPage(getDriver());

        giftCardPage.clickOnGiftCardLink25$();
        scrollToCoordinates(0,150);
        giftCardPage.clickOn$100PhysicalGiftCard();
        scrollToCoordinates(0,150);
        giftCardPage.type$100RecipientNameField(firstName);
        giftCardPage.type$100SenderNameField(lastName);
        giftCardPage.type$100MessageField(message);
        giftCardPage.clickOn$100AddToCartButton();

        //Validation
        String expectedResult = "shopping cart";
        String actualText = giftCardPage.validationFor$100ValidationText();
        Assert.assertEquals(expectedResult,actualText);
        log.info("$100 gift card validation Success");

    }
}
