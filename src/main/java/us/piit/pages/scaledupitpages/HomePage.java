package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".custom-logo")
    WebElement mainHeader;



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


    public String getHeaderText(){
        String text = getElementText(mainHeader);
        log.info("user logged in success");
        return text;
    }
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

}




