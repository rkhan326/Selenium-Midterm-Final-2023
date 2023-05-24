package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class OrdersPage extends CommonAPI {
    Logger log = LogManager.getLogger(OrdersPage.class.getName());

    public OrdersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//h2[text()='Order details']")
    WebElement orderDetailsHeader;

    @FindBy(xpath = "//li[@class = 'woocommerce-order-overview__order order']/strong")
    WebElement orderNumber ;

    @FindBy(xpath = "//li[@class = 'woocommerce-order-overview__email email']/strong")
    WebElement orderEmail;

    public boolean checkPresenceOfOrdersDetailsHeader(){
        boolean orderDetailsHeaderIsVisible = isVisible(orderDetailsHeader);
        log.info("order details header visibility check success.");
        return orderDetailsHeaderIsVisible;
    }


}
