package us.piit.pages.automationexercisepages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ProductsPage extends CommonAPI {

    Logger log = LogManager.getLogger(ProductsPage.class.getName());


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String searchProduct = "neon green";
    @FindBy(css = ".form-control.input-lg")
    WebElement $searchField;
    @FindBy(css = "#name")
    WebElement $reviewNameField;
    @FindBy(css = "#email")
    WebElement $reviewEmailField;
    @FindBy(css = "#review")
    WebElement $reviewField;
    @FindBy(css = ".btn.btn-default.btn-lg")
    WebElement $searchButton;
    @FindBy(css = ".title.text-center")
    WebElement $searchedProductsHeader;
    @FindBy(css = "a[href='#Men']")
    WebElement $menButton;
    @FindBy(css = "a[href='/category_products/3']")
    WebElement $tshirtButton;
    @FindBy(xpath = "//span[text()='(4)']")
    WebElement $babyHugButton;
    @FindBy(css = ".title.text-center")
    WebElement $tshirtsProductsHeader;
    @FindBy(css = ".title.text-center")
    WebElement $babyhugProductsHeader;
    @FindBy(xpath = "//h2[text()='Rose Pink Embroidered Maxi Dress']")
    WebElement $maxiDressHeader;
    @FindBy(css = "img[src='/get_product_picture/4']")
    WebElement $stylishDressImage;
    @FindBy(css = "img[src='/get_product_picture/42']")
    WebElement $laceTopDressImage;
    @FindBy(css = "a[href='/product_details/38']")
    WebElement $viewProductMaxiDressButton;
    @FindBy(css = ".btn.btn-default.cart")
    WebElement $maxiDressAddToCartButton;
    @FindBy(css = ".modal-title.w-100")
    WebElement $maxiDressAddedButton;
    @FindBy(css = ".cart_quantity_delete")
    public WebElement $maxiDressDeleteFromCartButton;
    @FindBy(css = ".btn.btn-default.pull-right")
    public WebElement $submitReviewButton;

    public void enterSearchProductInSearchField() {
        typeText($searchField, searchProduct);
    }
    public void enterReviewMaxiDress(WebDriver driver) {
        typeText($reviewNameField,"Top G");
        typeText($reviewEmailField,"topg@gmail.com");
        typeText($reviewField,"This Maxi dress is great. Love it!");
        clickWithActions(driver,$submitReviewButton );
        log.info("Well done my G! Review submittion success");
    }
    public void clickOnSearchButton() {
        clickOn($searchButton);
        log.info(" Click click on 'Search button' success!!");
    }

    public void clickOnMenButton(WebDriver driver) {
        clickWithActions(driver, $menButton);
        log.info("Well done my guy! Click click on 'Men button' success!!");
    }

    public void clickOnTshirtButton(WebDriver driver) {
        clickWithActions(driver, $tshirtButton);
        log.info("Well done my guy! Click click on'Tshirt button' success!!");
    }
    public void clickOnBabyhugButton(WebDriver driver) {
        clickWithActions(driver, $babyHugButton);
        log.info("Well done my guy! Click click on 'Babyhug button' success!!");
    }
    public void clickOnViewProductMaxiDressButton(WebDriver driver) {
        clickWithActions(driver,$viewProductMaxiDressButton);
        log.info("Well done ma guy! Click click on 'View product Maxi dress' success!!");
    }
    public void clickOnMaxiDressAddToCartButton(WebDriver driver) {
        clickWithActions(driver,$maxiDressAddToCartButton);
        log.info("Well done ma guy! Click click on 'Maxi Dress Add to cart button' success!!");
    }

    public void clickOnMaxiDressDeleteFromCartButton(WebDriver driver) {
        clickWithActions(driver,$maxiDressDeleteFromCartButton);
        log.info("Well done ma guy! Click click on 'Maxi Dress Add to cart button' success!!");
    }
    public String getBabyhugProductsHeaderText() {
        String text = getElementText($babyhugProductsHeader);
        log.info("Well done my boy! 'Babyhug Product header' text acquisition success!!");
        return text;
    }
    public String getTshirtsProductsHeaderText() {
        String text = getElementText($tshirtsProductsHeader);
        log.info("Well done my boy! 'Tshirt Product header' text acquisition success!!");
        return text;
    }
    public void scrollToViewStylishDressImage(WebDriver driver) {
        scrollToView(driver, $stylishDressImage);
        log.info("Well done my boy! 'Babyhug button' scroll to view success!!");
    }

    public void scrollToViewMaxiDressImage(WebDriver driver) {
        scrollToView(driver, $laceTopDressImage);
        log.info("Well done my boy! 'Maxi Dress Image' scroll to view success!!");
    }
    public String getSearchProductsHeaderText() {
        String text = getElementText($searchedProductsHeader);
        log.info("Well done my boy! 'Searched product header' text acquisition success!!");
        return text;
    }
    public String getMaxiDressHeaderText() {
        String text = getElementText($maxiDressHeader);
        log.info("Well done my boy! 'Maxi dress header' text acquisition success!!");
        return text;
    }
    public String getMaxiDressAddedText() {
        String text = getElementText($maxiDressAddedButton);
        log.info("Well done my boy! 'Maxi dress Added' text acquisition success!!");
        return text;
    }

}



