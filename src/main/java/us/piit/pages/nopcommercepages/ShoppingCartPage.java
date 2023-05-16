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

    @FindBy( xpath = "//h2[@class='product-title']//a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]")
    WebElement bookLinkLocator;
    @FindBy(xpath = "//button[@id='add-to-cart-button-37']")
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
