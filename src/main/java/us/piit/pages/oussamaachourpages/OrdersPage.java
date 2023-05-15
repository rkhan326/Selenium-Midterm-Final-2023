package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    Logger log = LogManager.getLogger(OrdersPage.class.getName());

    public OrdersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "")
//    WebElement ;
}
