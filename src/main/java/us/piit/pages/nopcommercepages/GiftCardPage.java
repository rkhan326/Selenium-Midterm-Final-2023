package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class GiftCardPage extends CommonAPI {
    Logger log = LogManager.getLogger(GiftCardPage.class.getName()) ;
    public GiftCardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // ************************Gift Cards**************************
    //Click on Gift Card Link
    @FindBy(xpath = " //ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCardLink25$;

    // $25 Virtual Gift Card
    @FindBy(xpath = " //a[normalize-space()='$25 Virtual Gift Card']")
    WebElement VirtualGiftCard25$;

    //Type Recipient Name Field
    @FindBy(css = "#giftcard_43_RecipientName")
    WebElement recipientNameField25$;

    // type Recipient Email Field
    @FindBy(css = "#giftcard_43_RecipientEmail")
    WebElement recipientEmailField25$;

    //Your/sender Name Field    yourNameField25$
    @FindBy(css = "#giftcard_43_SenderName")
    WebElement yourNameField25$;

    //Your/sender Email Field
    @FindBy(css = "#giftcard_43_SenderEmail")
    WebElement yourOrSenderEmailField25$;

    //Message Field
    @FindBy(css = "#giftcard_43_Message")
    WebElement messageField25$;

    //Add to cart button

    @FindBy(css = "#add-to-cart-button-43")
    WebElement addToCartButton25$;

    // Validation for $25 Gift Card
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement validationFor$25GiftCard;

    // ************************$50 Physical Gift Card**************************
    //$50 Physical Gift Card
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'$50 Physical Gift Card')]")
    WebElement $50PhysicalGiftCard;

    //50$ Recipient's Name:
    @FindBy(css = "#giftcard_44_RecipientName")
    WebElement $50RecipientsName;

    //50$ Sender Name
    @FindBy(css = "#giftcard_44_SenderName")
    WebElement $50SenderName;

    // 50$ Message field
    @FindBy(css = "#giftcard_44_Message")
    WebElement $50MessageField;

    // 50$ add to cart button
    @FindBy(css = "#add-to-cart-button-44")
    WebElement $50AddToCartButton;

    // $50 Physical Gift Card Validation
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement $50Validation;

    // ************************$100 Physical Gift Card******************
    //click on $100 Physical Gift Card
    @FindBy(xpath = "//a[normalize-space()='$100 Physical Gift Card']")
    WebElement $100PhysicalGiftCard;

    // 100  Recipient Name Field
    @FindBy(css = "#giftcard_45_RecipientName")
    WebElement $100RecipientNameField;

    //$100 Sender Name Field
    @FindBy(css = "#giftcard_45_SenderName")
    WebElement $100SenderNameField;

    // 100$ Message field
    @FindBy(css = "#giftcard_45_Message")
    WebElement $100MessageField;

    // 100$ Add to cart Button
    @FindBy(css = "#add-to-cart-button-45")
    WebElement $100AddToCartButton;

    // $100 Physical Gift Card Validation

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement $100Validation;


    //************************* Gift Card $25***************************
    //Click on Gift Card Link
    public void clickOnGiftCardLink25$() {
        clickOn(giftCardLink25$);
        log.info("Click on gift CardLink 25$ successfully.");
    }
    // $25 Virtual Gift Card
    public void clickOnVirtualGiftCard25$() {
        clickOn(VirtualGiftCard25$);
        log.info("Click on gift CardLink 25$ successfully.");
    }
    //Type Recipient Name Field
    public void typeRecipientNameField25$(String recipientName) {
        typeText(recipientNameField25$, recipientName);
        log.info(" Type Recipient Name successfully");
    }
    // type Recipient Email Field recipientEmailField25$
    public void typeRecipientEmailField25$(String recipientEmail) {
        typeText(recipientEmailField25$, recipientEmail);
        log.info(" Type Recipient email successfully");
    }
    //Your/sender Name Field    yourNameField25$
    public void typeYourNameField25$(String senderName) {
        typeText(yourNameField25$, senderName);
        log.info(" Type sender Name successfully");
    }
    //Your/sender Email Field yourOrSenderEmailField25$;
    public void typeYourOrSenderEmailField25$(String yourOrSenderEmail) {
        typeText(yourOrSenderEmailField25$, yourOrSenderEmail);
        log.info(" Type sender email successfully");
    }
    //Message Field messageField25$
    public void typeMessageField25$(String typeMessage) {
        typeText(messageField25$, typeMessage);
        log.info(" Type message successfully");
    }
    //Add to cart button ;
    public void clickOnAddToCartButton25$() {
        clickOn(addToCartButton25$);
        log.info("Click on add To Cart Button for 25$ successfully.");
    }
    // Validation for $25 Gift Card  ;

    public String validationFor$25GiftCardText() {
        String text = getElementText(validationFor$25GiftCard);
        log.info("Validation For $25 Gift Card succeeded");
        return text;
    }
    //**************$50 Physical Gift CardMethods************
    //$50 Physical Gift Card $50PhysicalGiftCard
    public void clickOn$50PhysicalGiftCard() {
        clickOn($50PhysicalGiftCard);
        log.info("Click on $50 Physical Gift Card successfully.");
    }

    //50$ Recipient's Name:

    public void type$50RecipientsNameField(String typeRecipientsName) {
        typeText($50RecipientsName, typeRecipientsName);
        log.info(" Type Recipients Name successfully");
    }

    //50$ Sender Name

    public void type$50SenderNameField(String typeSenderName) {
        typeText($50SenderName, typeSenderName);
        log.info(" Type Sender Name successfully");
    }
    // 50$ Message field
    public void type$50MessageField(String typeMessage) {
        typeText($50MessageField, typeMessage);
        log.info(" Type Message successfully");
    }
    // 50$ add to cart button
    public void clickOn$50AddToCartButton() {
        clickOn($50AddToCartButton);
        log.info("Click on $50 Add To Cart Button successfully.");
    }

    // $50 Physical Gift Card Validation
    public String validationFor$50ValidationText() {
        String text = getElementText($50Validation);
        log.info("Validation For $50 Gift Card succeeded");
        return text;
    }

    // ************************$100 Physical Gift Card******************
    //click on $100 Physical Gift Card
    public void clickOn$100PhysicalGiftCard() {
        clickOn($100PhysicalGiftCard);
        log.info("Click on $100 Physical Gift Card successfully.");
    }

    // 100  Recipient Name Field
    public void type$100RecipientNameField(String typeRecipientName) {
        typeText($100RecipientNameField, typeRecipientName);
        log.info(" Type Recipient Name successfully");
    }
    //$100 Sender Name Field
    public void type$100SenderNameField(String typeSenderName) {
        typeText($100SenderNameField, typeSenderName);
        log.info(" Type Sender Name successfully");
    }
    // 100$ Message field
    public void type$100MessageField(String typeMessage) {
        typeText($100MessageField, typeMessage);
        log.info(" Type message successfully");
    }
    // 100$ Add to cart Button
    public void clickOn$100AddToCartButton() {
        clickOn($100AddToCartButton);
        log.info("Click on add to cart successfully.");
    }

    // $100 Physical Gift Card Validation

    public String validationFor$100ValidationText() {
        String text = getElementText($100Validation);
        log.info("Validation For $100 Gift Card succeeded");
        return text;
    }


}
