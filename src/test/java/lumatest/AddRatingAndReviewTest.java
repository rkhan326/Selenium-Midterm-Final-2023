package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.lumapages.*;

public class AddRatingAndReviewTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(AddRatingAndReviewTest.class.getName());
    //ReadFromExcel read = new ReadFromExcel("D:\\BootCamp Selenium\\web-automation-framework-team4\\data\\titles.xlsx", "Magento");

    @Test
    public void AddThefirstratingAndReview() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        ShopNewYogaPage shopNewYogaPage = new ShopNewYogaPage(getDriver());
        ElisaEverCoolTeePage elisaEverCoolTeePage = new ElisaEverCoolTeePage(getDriver());

        homePage.clickOnSigninButton1();
        //String expectedTitle = read.getCellValueForGivenHeaderAndKey("key", "login page title");
        String actualTitle = getCurrentTitle();
        String expectedTitle="Customer Login";
        Assert.assertEquals(expectedTitle, actualTitle);
        //String email = ConnectDB.getTableColumnData("select * from cred", "email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy2@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred", "password").get(0);
        signinPageMagento.typePassword("password$1234");
        signinPageMagento.clickOnSigninButton2();
        //String expectedTitle1 = read.getCellValueForGivenHeaderAndKey("key", "home page title");
        String actualTitle1 = getCurrentTitle();
        String expectedTitle1="Home Page";
        Assert.assertEquals(expectedTitle1, actualTitle1);
        LOG.info("Signin success");
        homePage.clickOnShopNewYoga();

        String title2= getCurrentTitle();
        Assert.assertEquals(title2, "New Luma Yoga Collection");
        LOG.info("shop New Yoga  title page validation success");

        shopNewYogaPage.clickOnElisaEverCoolTee();
        String title3= getCurrentTitle();
        Assert.assertEquals(title3, "Elisa EverCool™ Tee");
        LOG.info("Elisa ever cool Tee  title page validation success");
        Thread.sleep(3000);
        elisaEverCoolTeePage.clickOnReviews();
        elisaEverCoolTeePage.hoverOverRatingButton(getDriver());

        elisaEverCoolTeePage.typeSummary("Nice product");
        Thread.sleep(3000);
        elisaEverCoolTeePage.typeReview("Perfect");
        elisaEverCoolTeePage.clickOnSubmitReview();
    }

        @Test
            public void AddratingAndReview() throws InterruptedException {
                HomePageMagento homePage = new HomePageMagento(getDriver());
                SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
                ShopNewYogaPage shopNewYogaPage = new ShopNewYogaPage(getDriver());
                LaylaTeePage laylaTeePage = new LaylaTeePage(getDriver());

                homePage.clickOnSigninButton1();
                //String expectedTitle = read.getCellValueForGivenHeaderAndKey("key", "login page title");
                String actualTitle = getCurrentTitle();
                String expectedTitle2 = "Customer Login";
                String expectedTitle="Customer Login";

                Assert.assertEquals(expectedTitle, actualTitle);
                //String email = ConnectDB.getTableColumnData("select * from cred", "email").get(0);
                signinPageMagento.typeEmailAddress("gsbappy2@gmail.com");
                //String password = ConnectDB.getTableColumnData("select * from cred", "password").get(0);
                signinPageMagento.typePassword("password$1234");
                signinPageMagento.clickOnSigninButton2();
                //String expectedTitle1 = read.getCellValueForGivenHeaderAndKey("key", "home page title");
                String actualTitle1 = getCurrentTitle();
                String expectedTitle1="Home Page";
                Assert.assertEquals(expectedTitle1, actualTitle1);
                LOG.info("Signin success");
                homePage.clickOnShopNewYoga();

                String title2 = getCurrentTitle();
                Assert.assertEquals(title2, "New Luma Yoga Collection");
                LOG.info("shop New Yoga  title page validation success");
                shopNewYogaPage.hoverOverLaylaTee(getDriver());
                shopNewYogaPage.clickOnReviews();

                String title3 = getCurrentTitle();
                Assert.assertEquals(title3, "Layla Tee");
                LOG.info("Layla Tee  title page validation success");
                Thread.sleep(3000);
                laylaTeePage.hoverOverRatingButton(getDriver());
                ;
                laylaTeePage.typeSummary("Light, comfy");
                laylaTeePage.typeReview("This shirt is pretty good!");
                laylaTeePage.clickOnSubmitReview();

            }
        }




