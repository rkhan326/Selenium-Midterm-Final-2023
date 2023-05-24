package us.piit.pages.lumapages;

import us.piit.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPurchasePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(SuccessPurchasePage.class.getName());

    public SuccessPurchasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    WebElement confirmation;

    public String getconfirmationMessage(){

        return getElementText(confirmation);
    }
}
