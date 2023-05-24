package us.piit.pages.lumapages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;


public class HomePageMagento extends CommonAPI {
    Logger log = LogManager.getLogger(HomePageMagento.class.getName());
    public HomePageMagento(WebDriver driver) {PageFactory.initElements(driver,this);}

    WebDriver driver;

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;
    @FindBy(xpath = "//button[@class='action search']")
    WebElement searchButton;
    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul/li[2]/a")
    WebElement signinButton1;
    @FindBy(xpath = "(//span[text()='Welcome, samia iddir!'])[1]")
    WebElement headerText;
    @FindBy(xpath = "(//li[@class='authorization-link']//following::li/a)[1]")
    WebElement createAccountButton;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartButton;
    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gearFloatingMenu;
    @FindBy(xpath = "//span[text()='Fitness Equipment']")
    WebElement fitnessEquipment;
    @FindBy (xpath = "//span[text()='Sale']")
    WebElement saleButton;
    @FindBy (xpath = "//a[@class='action compare']")
    WebElement compareProductsButton;
    @FindBy (xpath = "(//button[@class='action switch'])[1]")
    WebElement DropDown;
    @FindBy (xpath = "//li[@class='authorization-link']/a")
    WebElement SignOut;
    @FindBy (xpath = "//span[text()='Women']")
    WebElement womenProducts;
    @FindBy (xpath = "//span[text()='Shop New Yoga']")
    WebElement shopNewYoga;
    @FindBy (xpath = "//a[text()='Orders and Returns']")
    WebElement OrderAndReturnsButton;
    @FindBy (xpath = "//a[text()='Advanced Search']")
    WebElement AdvancedSearchButton;
    @FindBy (xpath = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[8]")
    WebElement TrainingButton;
    @FindBy (xpath = "//a[text()='Video Download']")
    WebElement VideoDownload ;
    @FindBy (xpath = "(//span[@class='action more icon'])[1]")
    WebElement ShopPantsToday;
    @FindBy (xpath = "(//div[@class='customer-menu']/ul/li/a)[1]")
    WebElement MyAccount;
    @FindBy (xpath = "//a[@id='ui-id-27']")
    WebElement Watches;

    public void clickOnAdvancedSearchButton(){
        clickOn(AdvancedSearchButton);
        log.info("click Advanced search success");
    }
    public void clickOnVideoDownload(){
        clickOn(VideoDownload);
        log.info("click Video Download success");
    }
    public void clickOnTraining(){
        clickOn(TrainingButton);
        log.info("click Advanced search success");
    }

    public String getHeaderText(){
        return getElementText(headerText);
    }


    public void typeItemToSearch(String item){
        typeText(searchField, item);
        log.info("item name type success");
    }

    public void clickOnSearchButton(){
        clickOn(searchButton);
        log.info("click search success");
    }
    public void searchItem(String item){
        typeText(searchField, item);
        log.info("item name type and enter success");
    }

    public void clickOnSigninButton1(){
        clickOn(signinButton1);
        log.info("click on signin button success");
    }
    public void clickOnCartButton(){
        clickOn(cartButton);
        log.info("click on cart button success");
    }

    public void clickOnAddToCartButton(WebDriver driver){
        clickOn( cartButton);
        log.info("click cart button success");
    }
    public void clickOnCreateanAccountButton(){
        clickOn(createAccountButton);
        log.info("click create an account button success");
    }
    public void hoverOver(WebElement gearFloatingMenu) {
        Actions actions = new Actions(driver);
        actions.moveToElement(gearFloatingMenu).build().perform();
    }
    public void clickOnFitnessEquipment(){
        clickOn(fitnessEquipment);
        log.info("click fitness Equipment success");
    }

    public void ClickOnSaleButton(){
        clickOn(saleButton);
        log.info("click Sale button success");
    }


    public void ClickOnCompareProductsButton(){
        clickOn(compareProductsButton);
        log.info("click compare Products Button success");
    }

    public void clickOnDropDown(){
        clickOn(DropDown);
        log.info("click DropDown Button success");
    }

    public void clickOnSignOut(){
        clickOn(SignOut);
        log.info("click Sign out Button success");
    }

    public void clickOnWommenProducts(){
        clickOn(womenProducts);
        log.info("click on women products success");
    }

    public void clickOnShopNewYoga(){
        clickOn(shopNewYoga);
        log.info("Click on shop new yoga products success");
    }
    public void clickOnOrderAndRuters(){
        clickOn(OrderAndReturnsButton);
        log.info("Click on shop new yoga products success");
    }
    public void clickOnShopPantsToday(){
        clickOn(ShopPantsToday);
        log.info("Click on shop pants today success");
    }
    public void clickOnMyAccount(){
        clickOn(MyAccount);
        log.info("click On MyAccount Button success");
    }
    public void hoverOverGear(WebDriver driver){
        waitForElementToBeVisible(driver, 10, gearFloatingMenu);
        hoverOver(driver, gearFloatingMenu);
        log.info("Gear hover over menu success");
    }

    public void clickOnWatches(){
        clickOn(Watches);
        log.info("click Watches success");
    }






}

