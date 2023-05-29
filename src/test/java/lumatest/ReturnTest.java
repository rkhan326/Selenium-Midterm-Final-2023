package lumatest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.lumapages.*;

import static java.sql.DriverManager.getDriver;


public class ReturnTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(ReturnTest.class.getName());

    //ReadFromExcel read = new ReadFromExcel("D:\\BootCamp Selenium\\web-automation-framework-team4\\data\\titles.xlsx", "Magento");
@Test
public void returnTest(){
    HomePageMagento homePage = new HomePageMagento(getDriver());
    OrderAndReturnPage orderAndRuternPage = new OrderAndReturnPage(getDriver());
    Order000017128Page order000017128Page = new Order000017128Page(getDriver());

    homePage.clickOnOrderAndRuters();

    String title= getCurrentTitle();
        Assert.assertEquals(title, "Orders and Returns");
        LOG.info("Orders and Returns  title page validation success");
        orderAndRuternPage.typeOrderID("000017128");
        orderAndRuternPage.typeBillingLastname("golam");
        orderAndRuternPage.typeEmail("gsbappy1@gmail.com");
        orderAndRuternPage.clickOnContinueButton();

        String title1= getCurrentTitle();
        Assert.assertEquals(title1, "Orders and Returns");
        LOG.info("Order # 000017128  title page validation success");

}





}
