package uspiit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class ElectronicMenuPage extends CommonAPI {
    Logger log = LogManager.getLogger(ElectronicMenuPage.class.getName());
    public ElectronicMenuPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    //***********************Locator********************************
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[2]/a")
    WebElement electronicMenuLocator;
    @FindBy(xpath = "//div[@class='header-menu']/ul/li[2]/ul/li/a")
    WebElement cameraAndPhotoLocator;
    @FindBy(css = "div[class='picture'] img[title='Show details for Nikon D5500 DSLR']")
    WebElement selectProductLocator;

    @FindBy(xpath = "//h1[text()='Nikon D5500 DSLR']")
    WebElement validationTextLocator;



    //Cell Phone Locator.......
    @FindBy(xpath = "//div[@class='header-menu']/ul/li[2]/ul/li[2]/a")
    WebElement cellPhoneLocator;
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'HTC One M8 Android L 5.0 Lollipop')]")
    WebElement selectPhoneLocator;
    @FindBy(xpath = "//h1[normalize-space()='HTC One M8 Android L 5.0 Lollipop']")
    WebElement validationPhonePageLocator;







    // ********************Reusable Methods*************************


    public void hoverOverElectronicMenu(WebDriver driver){
        hoverOver(driver,electronicMenuLocator);
        log.info("hoverOver Electronic menu Success");
        waitFor(1);
    }
    public void hoverOverCameraAndPhotoMenuAndClick(WebDriver driver){
        hoverOverAndClick(driver,cameraAndPhotoLocator);
        log.info("hoverOver camera And Photo menu and click Success");
        waitFor(1);
    }
    public void selectProduct(){
        clickOn(selectProductLocator);
        log.info("click on Product Success");
        waitFor(1);
    }

    public String checkCameraAndPhotoPageIsOpen(){
        String text = getElementText(validationTextLocator);
        log.info("user Camera And Photo page open success");
        return text;
    }

    //cell Phone methods
    public void hoverOverCellPhoneMenuAndClick(WebDriver driver){
        hoverOverAndClick(driver,cellPhoneLocator);
        log.info("hoverOver cell phone menu and click Success");
        waitFor(1);
    }
    public void selectPhone(){
        clickOn(selectPhoneLocator);
        log.info("click on Product Success");
        waitFor(1);
    }

    public String checkPhonePageIsOpen(){
        String text = getElementText(validationPhonePageLocator);
        log.info("user Cell Phone page open success");
        return text;
    }



}
