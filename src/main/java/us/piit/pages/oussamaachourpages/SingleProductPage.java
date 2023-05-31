package us.piit.pages.oussamaachourpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SingleProductPage extends CommonAPI {
    Logger log = LogManager.getLogger(SingleProductPage.class.getName());

    public SingleProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();

    @FindBy( css = "h1[class = 'entry-title']")
    WebElement camerasCameraC430W;
    @FindBy( xpath = "//h1[text()='Camera C430W 4k with  Waterproof cover']")
    WebElement camerasCameraC430WPageHeader;

    @FindBy( css = "a[href='#tab-reviews']")
    WebElement camerasCameraC430WPageReviewLink;



    @FindBy( css = "select[id='rating']")
    WebElement reviewSelectStars;

    @FindBy(css = ".star-1")
    WebElement stars1;

    @FindBy( css = ".star-2")
    WebElement stars2;

    @FindBy( css = ".star-3")
    WebElement stars3;

    @FindBy( css = ".star-4")
    WebElement stars4;

    @FindBy( css = ".star-5")
    WebElement stars5;

    @FindBy( css = "#comment")
    WebElement reviewTextField;

    @FindBy( css = "#author")
    WebElement reviewerNameField;

    @FindBy( css = "#email")
    WebElement reviewerEmailField;

    @FindBy( css = "#wp-comment-cookies-consent")
    WebElement saveInfoCheckBox;

    @FindBy( css = "#submit")
    WebElement addReviewBtn;

    @FindBy( xpath = "//em[text() = 'Your comment is awaiting approval']")
    WebElement reviewWaitingApprovalMessage;

    @FindBy(css = "#respond h3")
    WebElement addAReviewHeader;

    @FindBy(css = ".wp-die-message p")
    WebElement duplicateReviewErrorMessage;

    @FindBy(css = ".wp-die-message p")
    WebElement invalidEmailErrorMessage;

    @FindBy(css = "a[href ='javascript:history.back()']")
    WebElement errorBackButton;

    @FindBy(css = "a[href = '?add-to-cart=2706']" )
    WebElement tabletAir3AddToCart;

    @FindBy(css = "a[class = 'added_to_cart wc-forward']" )
    WebElement tabletAir3GoToCartButton;

    @FindBy(css = "a[href = '?add-to-cart=5552']" )
    WebElement macChargerAddToCart;

    @FindBy(css = "a[class = 'added_to_cart wc-forward']" )
    WebElement macChargerGoToCartButton;

    @FindBy(css = "a[href = '?add-to-cart=2707']" )
    WebElement gearVirtualRealityAddToCart;

    @FindBy(css = "a[class = 'added_to_cart wc-forward']" )
    WebElement gearVirtualRealityGoToCartButton;





    public boolean checkPresenceOfCameraC430WHeader(){
        boolean CameraC430WHeaderIsDisplayed = isVisible(camerasCameraC430WPageHeader);
        log.info("login invalid password error message validation success.");
        return CameraC430WHeaderIsDisplayed;
    }

    public void clickOnCameraC430WPageReviewLink(WebDriver driver){
        scrollToElementwJS(camerasCameraC430WPageReviewLink, driver);
        waitFor(3);
        log.info("scroll to camera C430W review link success");
        clickOn(camerasCameraC430WPageReviewLink);
        log.info("click on camera C430W review link success");
    }

    public void selectStarsForItemReview(String starValue,WebDriver driver) {
        scrollToElementwJS(reviewSelectStars,driver);
        waitFor(5);
        selectOptionFromDropdown(reviewSelectStars,starValue);
        log.info("Successfully selected stars for review");
    }

    public void clickOn1StarForReview(){
        clickOn(stars1);
        log.info("Successfully selected  1 star for review");
    }

    public void clickOn2StarsForReview(){
        clickOn(stars2);
        log.info("Successfully selected  2 stars for review");
    }

    public void clickOn3StarsForReview(){
        clickOn(stars3);
        log.info("Successfully selected  2 stars for review");
    }
    public void clickOn4StarsForReview(){
        clickOn(stars4);
        log.info("Successfully selected  2 stars for review");
    }
    public void clickOn5StarsForReview(){
        clickOn(stars5);
        log.info("Successfully selected  2 stars for review");
    }
    public void enterReviewText(String reviewText){
        typeText(reviewTextField, reviewText);
        log.info("Successfully entered review text");
    }
    public void enterReviewerName(String reviewerName){
        typeText(reviewerNameField, reviewerName);
        log.info("Successfully entered reviewer name");
    }
    public void enterReviewerEmail(String reviewerEmail){
        typeText(reviewerEmailField, reviewerEmail);
        log.info("Successfully entered reviewer email");
    }
    public void clickOnSaveInfoCheckBox(){
        clickOn(saveInfoCheckBox);
        log.info("Successfully clicked on save info checkbox");
    }
    public void clickOnAddReviewBtn(){
        clickOn(addReviewBtn);
        log.info("Successfully clicked on add review button");
    }

    public boolean checkPresenceOfReviewAwaitingApprovalMessage(WebDriver driver){
        scrollToElementwJS(reviewWaitingApprovalMessage, driver);
        waitFor(5);
        boolean reviewAwaitingApprovalMessageIsDisplayed = isVisible(reviewWaitingApprovalMessage);
        return reviewAwaitingApprovalMessageIsDisplayed;
    }

    public boolean checkPresenceOfAddAReviewHeader(WebDriver driver){
        scrollToElementwJS(addAReviewHeader, driver);
        waitFor(5);
        boolean addAReviewHeaderIsDisplayed = isVisible(addAReviewHeader);
        return addAReviewHeaderIsDisplayed;
    }

    public boolean checkPresenceOfDuplicateReviewErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(duplicateReviewErrorMessage);
      //  log.info("duplicate review error message validation success.");
        return errorMessageIsDisplayed;
    }

    public boolean checkPresenceOfInvalidEmailErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(invalidEmailErrorMessage);
       // log.info("invalid email error message validation success.");
        return errorMessageIsDisplayed;
    }

    public void clickOnErrorBackButton(){
        clickOn(errorBackButton);
        log.info("successfully clicked on error back button");
    }

    public void clickOnAddToCartForTabletAir3(){
        clickOn(tabletAir3AddToCart);
        log.info("Click on click On Add To Cart For Tablet Air 3 link success");
    }

    public void clickOnAddToCartForMacCharger(){
        clickOn(macChargerAddToCart);
        log.info("Click on click On Add To Cart For Mac Charger success");
    }

    public void clickOnAddToCartForGearVirtualReality(){
        clickOn(gearVirtualRealityAddToCart);
        log.info("Click on click On Add To Cart For Mac Charger success");
    }

    public boolean checkPresenceOfTabledAir3GoToCartButton(){
        boolean goToCartButtonIsDisplayed = isVisible(tabletAir3GoToCartButton);
        log.info("tablet air 360 go to cart button is successfully displayed.");
        return goToCartButtonIsDisplayed;
    }

    public boolean checkPresenceOfMacChargerGoToCartButton(){
        boolean goToCartButtonIsDisplayed = isVisible(macChargerGoToCartButton);
        log.info("mac charger go to cart button is successfully displayed.");
        return goToCartButtonIsDisplayed;
    }


    public boolean checkPresenceOfGearVirtualRealityToCartButton(){
        boolean goToCartButtonIsDisplayed = isVisible(gearVirtualRealityGoToCartButton);
        log.info("tablet air 360 go to cart button is successfully displayed.");
        return goToCartButtonIsDisplayed;
    }

    public void scrollToMacChargerAddToCartButton(WebDriver driver){
        scrollToElementwJS(macChargerAddToCart ,driver );
        waitFor(1);
        log.info("scroll to add to cart button is successfully displayed.");
    }
    public boolean checkPresenceOfMacChargerAddToCartButton(){
        boolean goToCartButtonIsDisplayed = isVisible(macChargerAddToCart);
        log.info("add to cart button is successfully displayed.");
        return goToCartButtonIsDisplayed;
    }


    public String enterFakeReviewText(){return faker.harryPotter().quote();}
    public String enterFakeReviewerName(){return faker.harryPotter().character();}
    public String enterFakeReviewerEmail(){return faker.internet().emailAddress();}
    public String enterFakeReviewText1(){return faker.chuckNorris().fact();}




}
