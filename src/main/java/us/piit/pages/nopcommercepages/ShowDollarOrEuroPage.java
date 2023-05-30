package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ShowDollarOrEuroPage extends CommonAPI {
    Logger log = LogManager.getLogger(ShowDollarOrEuroPage.class.getName());
    public ShowDollarOrEuroPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //************************Locator*******************************
    @FindBy(css = "#customerCurrency")
    WebElement currencyMenuLocator;
    @FindBy(xpath = "//option[contains(text(),'US Dollar')]")
    WebElement dollarMenuLocator;
    @FindBy(xpath = "//option[contains(text(),'Euro')]")
    WebElement euroMenuLocator;

    @FindBy(xpath = "//span[contains(text(),'$1,200.00')]")
    WebElement DollarSelectSuccessLocator;
    @FindBy(xpath = "//span[contains(text(),'€1032.00')]")
    WebElement euroSelectSuccessLocator;




    // ********************Reusable Methods*************************
    public void hoverOverCurrencyMenuAndClick(WebDriver driver){
        hoverOverAndClick(driver,currencyMenuLocator);
        log.info("hoverOver currency menu and click Success");
    }
    public void clickOnDollar(){
        clickOn(dollarMenuLocator);
        log.info("click on  US Dollar Success");
    }
    public String DollarSelectedSuccessfullyConfirmed() {
        String text = getElementText(DollarSelectSuccessLocator);
        log.info("Dollar selected successfully confirmed.");
        return text;
    }
    public void clickOnEuro(){
        clickOn(euroMenuLocator);
        log.info("click on euro Success");
    }
    public String EuroSelectedSuccessfullyConfirmed() {
        String text = getElementText(euroSelectSuccessLocator);
        log.info("Euro selected successfully confirmed.");
        return text;
    }









}
