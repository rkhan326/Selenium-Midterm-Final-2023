package us.piit.pages.lumapages;

import org.openqa.selenium.interactions.Actions;
import us.piit.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitnessEquipmentMagentoPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(FitnessEquipmentMagentoPage.class.getName());
    public FitnessEquipmentMagentoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects
    @FindBy(xpath = "//img[@alt='Zing Jump Rope']")
    WebElement ZingJumpRope;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[9]")
    WebElement addTocart1;
    @FindBy(xpath = "//img[@alt='Dual Handle Cardio Ball']")
    WebElement DualHandleCardioBall;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[10]")
    WebElement addTocart2;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartButton;
    @FindBy(xpath = "//span[text()='View and Edit Cart']")
    WebElement viewAndEditCartButton;
    @FindBy(xpath = "//form[@data-product-sku='24-WG088']")
    WebElement spriteFoamRollerAddToCart;
    @FindBy(xpath = "//div[@id='authenticationPopup']/following-sibling::div/following-sibling::div//ol//li/following-sibling::li/following-sibling::li/following-sibling::li")
    WebElement spriteFoamRoller;




    //reusable methods
    public void hoverOverItem1(WebDriver driver){
        waitForElementToBeVisible(driver, 10, ZingJumpRope);
        hoverOver(driver,ZingJumpRope);
        LOG.info("hover over Zing Jump Rope success");
    }
    public void hoverOverItem2(WebDriver driver){
        waitForElementToBeVisible(driver, 10, DualHandleCardioBall);
        hoverOver(driver,DualHandleCardioBall);
        LOG.info("hover over DualHandleCardioBall success");
    }
    public void clickOnAddToCart1(){
        clickOn(addTocart1);
        LOG.info("click on add to cart button success");
    }
    public void clickOnAddToCart2(){
        clickOn(addTocart2);
        LOG.info("click on add to cart button success");
    }
    public void clickOnCartButton(){
        clickOn(cartButton);
        LOG.info("click on cart button success");
    }
    public void clickOnViewAndEditCart(WebDriver driver){
        clickWithActions(driver, viewAndEditCartButton);
        LOG.info("click on view and edit cart button success");
    }
    public void clickOnSpriteFoamRoller(){
        clickOn(spriteFoamRoller);
    }
    public void addSpriteFoamRollerToCart(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(spriteFoamRoller).build().perform();
        clickOn(spriteFoamRollerAddToCart);

    }
}
