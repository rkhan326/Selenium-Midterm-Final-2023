package uspiit.pages.lumapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import uspiit.base.CommonAPI;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class WatchesPage extends CommonAPI {

    Logger LOG = LogManager.getLogManager().getLogger(WatchesPage.class.getName());

    public WatchesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ELEMENTS
    @FindBy(xpath = "//div[@id='authenticationPopup']/following-sibling::div/following-sibling::div//ol//li/following-sibling::li")
    WebElement clamberWatch;

    @FindBy(xpath = "//form[@data-product-sku='24-WG03']")
    WebElement clamberWatchAddToCart;

    @FindBy(xpath = "//ol[@class='products list items product-items']//li//following-sibling::li//a[@class='action towishlist']")
    WebElement clamberWatchToWishList;

    @FindBy(xpath = "//select[@id='sorter']")
    WebElement sortItems;

    @FindBy(xpath = "//ol[@class='products list items product-items']//li//div//div//div[@class='price-box price-final_price']//span//span//span")
    WebElement firstItemOnList;

    @FindBy(xpath = "")
    WebElement lastItemOnList;

    //METHOD
    public void addClamberWatchToCart(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(clamberWatch).build().perform();
        clickOn(clamberWatchAddToCart);
    }
    public void addClamberWatchToWishList(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(clamberWatch).build().perform();
        LOG.info("hover over item successful");
        clickOn(clamberWatchToWishList);
        LOG.info("click 'add to wishlist' successful");
    }

    public void sortByPrice(){
        Select select = new Select(sortItems);
        select.selectByVisibleText("\n" +
                "Price ");
    }

    public WebElement firstItemOnList(WebDriver driver){
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        return list.get(0);

    }

    public WebElement lastItemOnList(WebDriver driver){
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        return list.get(list.size()-1);
    }

    public String getTextFromFirstItem(WebDriver driver){
        return firstItemOnList.getText().substring(1,firstItemOnList.getText().length());
    }
    public String getTextFromLastItem(WebDriver driver){
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        WebElement lastItem = driver.findElement(By.xpath("//ol[@class='products list items product-items']//li["+(list.size()-1)+"]//div//div//div[@class='price-box price-final_price']//span//span//span"));
        LOG.info(lastItemOnList(driver).getText());

        return lastItem.getText().substring(1,lastItem.getText().length());
    }




}
