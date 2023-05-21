package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
//    @FindBy(css = ".custom-logo")
//    WebElement mainHeader;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//a[text()='Login/Register']")
    WebElement SignInButton;

    @FindBy(css = "#wp-block-search__input-1")
    WebElement searchField;

    @FindBy(css = ".search-icon")
    WebElement searchButton;

    @FindBy(xpath = "//li[@id='menu-item-308']/a[1]")
    WebElement shopButton;
    @FindBy(xpath = "//a[@href='https://automation.scaledupit.com/blog/']")
    WebElement blogButton;

    @FindBy(css= ".fa.fa-angle-down.angle-down")
    WebElement categoriesButton;

    @FindBy(xpath = "//li[@id='menu-item-295']/a[1]")
    WebElement foodAndBeveragebutton;

    @FindBy(xpath="//a[text()='Clothing']")
    WebElement clothingButton;

    @FindBy(xpath="//li[@id='menu-item-309']/a[1]")
    WebElement hoddiesButton;




    public void clickOnSignInButton() {
        clickOn(SignInButton);
        log.info("click on Register/Login button success");
    }

    public void ClickOnLogoutLink(){
        clickOn(logoutLink);
        log.info("click on logout link success");
    }
    public void typeItemToSearch(String item) {
        typeText(searchField, item);
        log.info("item name type success");
    }
    public void clickOnSearchButton(){
        clickOn(searchButton);
        log.info("click on  search button  success");
    }

    public void clickOnShopButton() {
        clickOn(shopButton);
        log.info("click on shop button  success");
    }
    public void clickOnBlogButton() {
        clickOn(blogButton);
        log.info("click on blog button  success");
    }

    public void hoverOverOnCategoriesButton(  WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(categoriesButton).build().perform();
        log.info("hover over on categories success");
    }
    public void clickOnFoodAndBeverageButton(){
        clickOn(foodAndBeveragebutton);
        log.info("click on food and beverage  success");
    }
    public void hoverOverOnClothingButton(  WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(clothingButton).build().perform();
        log.info("hover over on clothing button success");
    }
    public void clickOnHoddiesButton() {
        clickOn(hoddiesButton);
        log.info("click on hoddies button success");
    }

}




