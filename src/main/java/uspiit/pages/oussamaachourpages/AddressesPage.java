package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
    Logger log = LogManager.getLogger(AddressesPage.class.getName());

    public AddressesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "")
//    WebElement ;
}
