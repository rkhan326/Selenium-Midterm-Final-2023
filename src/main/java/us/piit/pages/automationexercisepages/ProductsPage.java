package us.piit.pages.automationexercisepages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ProductsPage extends CommonAPI {

    Logger log = LogManager.getLogger(ProductsPage.class.getName());
    public ProductsPage(WebDriver driver){PageFactory.initElements(driver, this);}

    String searchProduct = "neon green";

    @FindBy(css = ".form-control.input-lg") WebElement searchField;
    @FindBy(css = ".btn.btn-default.btn-lg") WebElement searchButton;
    @FindBy(css = "a[href='/product_details/4']") WebElement viewProductStylishDressButton;
    @FindBy(css = ".title.text-center") WebElement searchedProductsHeader;
    @FindBy(css = ".badge.pull-right") WebElement menButton;
    @FindBy(css = "a[href='/category_products/3']") WebElement tshirtButton;
    @FindBy(css = "a[href='/brand_products/Polo']") WebElement poloButton;
    @FindBy(css=".title.text-center") WebElement tshirtsProductsHeader;


    public void enterSearchProductInSearchField() {typeText(searchField, searchProduct);}

    public void clickClickOnSearchButton() {
        clickOn(searchButton);
        log.info("Well Done ma Gee! 'Search button' click click success!!");
    }
    public void clickClickOnMenButton() {
        clickOn(menButton);
        log.info("Well Done ma Gee! 'Men button' click click success!!");
    }

    public void clickClickOnTshirtButton() {
        clickOn(tshirtButton);
        log.info("Well Done ma Gee! 'Tshirt button' click click success!!");
    }
    public void clickClickOnPoloButton() {
        clickOn(poloButton);
        log.info("Well Done ma Gee! 'Polo button' click click success!!");
    }
    public void clickClickOnViewProductStylishDressButton() {
        clickOn(viewProductStylishDressButton);
        log.info("Well Done ma Gee! 'View product stylish dress' click click success!!");
    }
    public String getSearchProductsHeaderText() {
        String text = getElementText(searchedProductsHeader);
        log.info("Well Done ma Gee! 'Searched product header' text validation success!!");
        return text;
    }
    public String getTshirtsProductsHeaderText() {
        String text = getElementText(tshirtsProductsHeader);
        log.info("Well Done ma Gee! 'Tshirts Product header' text validation success!!");
        return text;
    }
}
