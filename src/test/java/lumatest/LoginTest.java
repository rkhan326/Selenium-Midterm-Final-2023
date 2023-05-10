package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

    public class LoginTest extends CommonAPI {
        Logger log = LogManager.getLogger(LoginTest.class.getName());


        @Test (priority = 1)


        public void invalidCr() {
            String expectedTitle = "Home Page";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);


            clickOn("//li[@class='authorization-link']/a[1]");
            waitFor(2);
            typeText("//input[@id='email']", "bappy898@gmail.com");
            waitFor(2);
            typeText("#pass", "12345asf");
            waitFor(2);
            clickOn("//span[text()='Sign In']");
            waitFor(2);
            //input[@id='email']



        }

        @Test (priority = 2)
        public void missingUsername() {
            String expectedTitle = "Home Page";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);


            clickOn("//li[@class='authorization-link']/a[1]");
            waitFor(2);
            typeText("//input[@id='email']", "");
            waitFor(2);
            typeText("#pass", "12345asf");
            waitFor(2);
            clickOn("//span[text()='Sign In']");
            waitFor(2);
            //input[@id='email']


        }
        @Test (priority = 3)
        public void shopYoga(){
            clickOn(".action.more.button");
            waitFor(2);
            String  expectedShopYogaTitle = "Shop New Yoga";
            waitFor(2);
            String actualshopYogaTitle =getElementText(".action.more.button");
            waitFor(2);
            Assert.assertEquals(actualshopYogaTitle,expectedShopYogaTitle);




        }
        @Test (priority = 4)
        public void clickOnSale(){
            clickOn("a[id='ui-id-8'] span");
            waitFor(2);
            String  expectedSalePTitle = "Sale";
            waitFor(2);
            String actualSaleTitle =getElementText(".base");
            waitFor(2);
            Assert.assertEquals(expectedSalePTitle,actualSaleTitle);




        }
        @Test(priority = 5)
        public void clickWhatsNew(){
            clickOn("#ui-id-3");
            waitFor(2);
            String  expectedWhatsNewPTitle = "What's New";
            waitFor(2);
            String actualWhatsNewTitle =getElementText(".base");
            waitFor(2);
            Assert.assertEquals(expectedWhatsNewPTitle,actualWhatsNewTitle);



        }


    }


