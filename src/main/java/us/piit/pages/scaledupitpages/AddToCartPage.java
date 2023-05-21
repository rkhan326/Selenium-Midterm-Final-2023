package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AddToCartPage extends CommonAPI {

    Logger log = LogManager.getLogger(AddToCartPage.class.getName());

    public AddToCartPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h2[text()='Bag Collection']")
    WebElement bagCollectionButon;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;



    @FindBy(xpath="//h2[text()='Patient Ninja']")
    WebElement PatientNinjaButton;

    public void clickOnBagCollection() {
        clickOn(bagCollectionButon);
        log.info("click on bag collection success");

    }
    public void clickOnAddToCartButton() {
        clickOn(addToCartButton);
        log.info("click on add cart  success");

    }
    public boolean checkcartCount() {
        boolean cartCountIsDisplayed = isVisible(cartCount);
        log.info("cart count is  " + cartCountIsDisplayed);
        return cartCountIsDisplayed;
    }
    public String getCartCountText() {
        String cartCountText = getElementText(cartCount);
        log.info("cart count text is " + cartCountText);
        return cartCountText;

    }
    public void clickOnCart() {
        clickOn(cartCount);
        log.info("click on  cart and 1 item added  success");

    }
    public void clickOnPatientNinjaButton() {
        clickOn(PatientNinjaButton);
        log.info("click on patient Ninja button  success");

    }

}


