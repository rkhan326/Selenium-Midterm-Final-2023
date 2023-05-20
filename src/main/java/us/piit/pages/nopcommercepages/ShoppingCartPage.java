package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ShoppingCartPage extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());
    public ShoppingCartPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    //Locator
    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement bookTextocator;

    @FindBy( xpath = "//a[text()='Apple MacBook Pro 13-inch']")
    WebElement bookLinkLocator;
    @FindBy(css = "#add-to-cart-button-4")
    WebElement addToCartLocator;

    //******reusable methods*****

    public void clickOnBookText(){
        clickOn(bookTextocator);
        log.info("click on book text Success");
    }
    public void clickOnBookLink(){
        clickOn(bookLinkLocator);
        log.info("click on Fahrenheit 451 by Ray Bradbury link success");
    }
    public void clickOnAddToCart(){
        clickOn(addToCartLocator);
        log.info("click on add to cart success");
    }
}
