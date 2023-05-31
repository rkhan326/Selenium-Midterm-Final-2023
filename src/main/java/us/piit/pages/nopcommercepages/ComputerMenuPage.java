package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ComputerMenuPage extends CommonAPI {
    Logger log = LogManager.getLogger(ComputerMenuPage.class.getName());
    public ComputerMenuPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //************************Locator*******************************
    @FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[1]/a[1]")
    WebElement computerMenuLocator;
    @FindBy(xpath = "//a[contains(text(),'Desktops ')]")
    WebElement desktopMenuLocator;
    @FindBy(xpath = "//h1[text()='Desktops']")
    WebElement desktopPageLocator;
    @FindBy(xpath = "//img[@alt='Picture of Build your own computer']")
    WebElement productLocator;

    @FindBy(xpath = "//select[@name='product_attribute_2']")
    WebElement selectRAMLocator;
    @FindBy(xpath = "//select[@name='product_attribute_2']/option[@value='3']")
    WebElement select2gbLocator;
    @FindBy(xpath = "//input[@name='product_attribute_3' and @value= '6']")
    WebElement RadioButtonLocator;
    @FindBy(xpath = "//button[@class='button-1 add-to-cart-button']")
    WebElement addToCartLocator;

    @FindBy(xpath = "//p[@class='content']")
    WebElement addToCartMessageLocator;
    @FindBy(xpath = "//div[@class='bar-notification error']/p[@class='content']")
    WebElement showErrorTextLocator;


    //.........Notebook locator
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']")
    WebElement notebookMenuLocator;
    @FindBy(xpath = "//h1[text()='Notebooks']")
    WebElement notebookPageLocator;
    @FindBy(xpath = "//div[@class='product-item']//img[@title='Show details for Apple MacBook Pro 13-inch']")
    WebElement notebookProductLocator;
    @FindBy(xpath = "//button[@id='add-to-cart-button-4']")
    WebElement addCartLocator;

    @FindBy(xpath = "//p[@class='content']")
    WebElement addToCartConfirmLocator;











    // ********************Reusable Methods*************************


    public void hoverOverComputerMenu(WebDriver driver){
        hoverOver(driver,computerMenuLocator);
        log.info("hoverOver Computer menu Success");
        waitFor(1);
    }
    public void hoverOverDesktopMenuAndClick(WebDriver driver){
        hoverOverAndClick(driver,desktopMenuLocator);
        log.info("hoverOver Desktop menu and click Success");
    }

    public String checkDesktopsPageIsOpen(){
        String text = getElementText(desktopPageLocator);
        log.info("user desktop page open success");
        return text;
    }
    public void clickOnProduct(){
        clickOn(productLocator);
        log.info("click on Product Success");
    }
    public void selectRamMenu(){
        clickOn(selectRAMLocator);
        log.info("click on RAM menu Success");
    }
    public void selectRam2gbMenu(){
        clickOn(select2gbLocator);
        log.info("click on 2gb  Success");
    }
    public void clickOnRadioButton(){
        clickOn(RadioButtonLocator);
        log.info("click on HDD radio button Success");
    }
    public void clickOnAddToCartButton(){
        clickOn(addToCartLocator);
        log.info("click on addToCart button Success");
    }
    public String getOrderAddToCartAlertText() {
        String text = getElementText(addToCartMessageLocator);
        log.info("The order is successfully confirmed.");
        return text;
    }
//    public boolean checkErrorMessage(){
//       boolean errorMassageIsDisplayed=isVisible(showErrorTextLocator);
//       log.info("error message is"+errorMassageIsDisplayed);
//       return errorMassageIsDisplayed;
//    }
    public String showErrorMessage() {
        String text = getElementText(showErrorTextLocator);
        log.info("show error message success.");
        return text;
    }

    //.........notebook methods........
    public void hoverOverNotebookMenuAndClick(WebDriver driver){
        hoverOverAndClick(driver,notebookMenuLocator);
        log.info("hoverOver Notebook menu and click Success");
    }

    public String checkNotebooksPageIsOpen(){
        String text = getElementText(notebookPageLocator);
        log.info("user notebook page open success");
        return text;
    }
    public void clickOnNotebook(){
        clickOn(notebookProductLocator);
        log.info("click on notebook Success");
    }
    public void clickOnAddCartButton(){
        clickOn(addCartLocator);
        log.info("click on addToCart button Success");
    }
    public String getOrderAddToCartText() {
        String text = getElementText(addToCartConfirmLocator);
        log.info("The order is successfully confirmed.");
        return text;
    }



}
