package us.piit.pages.lumapages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class BasePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckOutPageMagento.class.getName());

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //ELEMENTS ON HEADER
    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement cartItemCounter;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartIcon;

    //element of clickable LOGO
    @FindBy (xpath = "//a[@class='logo']//img")
    WebElement luma;

    @FindBy(xpath = "//div[@class='panel header']//a//following-sibling::ul//li[3]//a")
    WebElement createAnAccount;

    //ELEMENTS ON THE MAIN MENU

    @FindBy (xpath = "//a[@id='ui-id-3']")
    WebElement whatsNew;

    @FindBy (xpath = "//a[@id='ui-id-4']")
    WebElement women;

    @FindBy (xpath = "//a[@id='ui-id-5']")
    WebElement men;

    @FindBy (xpath = "//a[@id='ui-id-6']")
    WebElement gear;

    @FindBy (xpath = "//a[@id='ui-id-7']")
    WebElement training;

    @FindBy (xpath = "//a[@id='ui-id-8']")
    WebElement sale;

    //DROP DOWN ELEMENTS FOR WOMEN
    @FindBy (xpath = "//a[@id='ui-id-9']")
    WebElement womenTops;

    @FindBy (xpath = "//a[@id='ui-id-10']")
    WebElement womenBottoms;

    //DROP ELEMENTS FOR WOMEN/TOPS
    @FindBy (xpath = "//a[@id='ui-id-11']")
    WebElement womenJackets;

    @FindBy (xpath = "//a[@id='ui-id-12']")
    WebElement womenHoodiesAndSweatshirts;

    @FindBy (xpath = "//a[@id='ui-id-13']")
    WebElement womanTees;

    @FindBy (xpath = "//a[@id='ui-id-14']")
    WebElement womenBrasAndTanks;


    //DROP DOWN ELEMENTS FOR WOMEN/BOTTOMS
    @FindBy (xpath = "//a[@id='ui-id-15']")
    WebElement womenPants;

    @FindBy (xpath = "//a[@id='ui-id-16']")
    WebElement womenShorts;

    //DROP DOWN ELEMENTS FOR MEN

    @FindBy (xpath = "//a[@id='ui-id-17']")
    WebElement menTops;

    @FindBy (xpath = "//a[@id='ui-id-18']")
    WebElement menBottoms;


    //DROP ELEMENTS FOR MEN/TOPS
    @FindBy (xpath = "//a[@id='ui-id-19']")
    WebElement menJackets;

    @FindBy (xpath = "//a[@id='ui-id-20']")
    WebElement menHoodiesAndSweatshirts;

    @FindBy (xpath = "//a[@id='ui-id-21']")
    WebElement menTees;

    @FindBy (xpath = "//a[@id='ui-id-22']")
    WebElement menTanks;


    //DROP DOWN ELEMENTS FOR MEN/BOTTOMS
    @FindBy (xpath = "//a[@id='ui-id-23']")
    WebElement menPants;

    @FindBy (xpath = "//a[@id='ui-id-24']")
    WebElement menShorts;

    //Elements for gear dropdown
    @FindBy (xpath = "//a[@id='ui-id-25']")
    WebElement bags;

    @FindBy (xpath = "//a[@id='ui-id-26']")
    WebElement fitnessEquipment;

    @FindBy (xpath = "//a[@id='ui-id-27']")
    WebElement watches;

    //TRAINING DROPDOWN
    @FindBy (xpath = "//a[@id='ui-id-28']")
    WebElement videoDownload;

    //CART ICON
    @FindBy(xpath = "//span[contains(text(), 'View and Edit Cart')]")
    WebElement viewEditCart;

    @FindBy (xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement checkoutButton;

    //Sign-In
    //@FindBy(xpath = "")

    @FindBy(xpath = "//button[@data-action='customer-menu-toggle']")
    WebElement customerMenuToggle;

    @FindBy(xpath = "//li[@class='link wishlist']")
    WebElement myWishList;




    //USEFUL METHODS
    public int getTotalItemsInCart(WebDriver driver) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        LOG.info(getElementText(cartItemCounter)+" item/items in the cart.");

        return Integer.parseInt(getElementText(cartItemCounter));
    }
    public void clickOnCreateAnAccount(){ clickOn(createAnAccount); }

    public void clickOnLuma(){
        clickOn(luma);
    }

    public void clickOnCartIcon(){
        clickOn(cartIcon);
    }

    public void clickOnWhatsNew(){
        clickOn(whatsNew);
    }

    public void clickOnWomen(){
        clickOn(women);
    }
    public void clickOnMen(){
        clickOn(men);
    }
    public void clickOnGear(){
        clickOn(gear);
    }
    public void clickOnTraining(){
        clickOn(training);
    }

    public void clickOnSale(){
        clickOn(sale);
    }

    //methods for women tests
    public void clickOnWomenTops(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        clickOn(womenTops);
    }
    public void clickOnWomenBottoms(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();

        clickOn(womenBottoms);

    }
    public void clickOnWomenJackets(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(womenTops).build().perform();
        clickOn(womenJackets);
    }
    public void clickOnWomenHoodiesAndSweaters(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(womenTops).build().perform();

        clickOn(womenHoodiesAndSweatshirts);

    }

    public void clickOnWomenTees(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(womenTops).build().perform();
        clickOn(womanTees);
    }
    public void clickOnWomenBrasAndTanks(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(womenTops).build().perform();
        clickOn(womenBrasAndTanks);
    }

    //Methods for men links links
    public void clickOnMenTops(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        clickOn(menTops);
    }
    public void clickOnMenBottoms(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        clickOn(menBottoms);

    }
    public void clickOnMenJackets(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        actions.moveToElement(menTops).build().perform();

        clickOn(menJackets);
    }
    public void clickOnMenHoodiesAndSweaters(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        actions.moveToElement(menTops).build().perform();
        clickOn(menHoodiesAndSweatshirts);

    }

    public void clickOnMenTees(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        actions.moveToElement(menTops).build().perform();
        clickOn(menTees);
    }
    public void clickOnMenTanks(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        actions.moveToElement(menTops).build().perform();
        clickOn(menTanks);
    }
    public void clickOnMenPants(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        actions.moveToElement(menBottoms).build().perform();
        clickOn(menPants);
    }
    public void clickOnMenShorts(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
        actions.moveToElement(menBottoms).build().perform();
        clickOn(menShorts);
    }

    public void clickOnBags(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();
        clickOn(bags);
    }
    public void clickOnFitnessEquipment(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();
        clickOn(fitnessEquipment);
    }
    public void clickOnWatches(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();

        clickOn(watches);
    }
    public void clickOnVideoDownload(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(training).build().perform();

        clickOn(videoDownload);
    }

    public void clickOnCheckout(){ clickOn(checkoutButton);}

    public void clickOnCustomerMenu(){
        clickOn(customerMenuToggle);
    }

    public void clickOnMyWishList(){
        clickOn(myWishList);
    }

    public void clickOnViewEditCart(){
        clickOn(viewEditCart);
    }


}
