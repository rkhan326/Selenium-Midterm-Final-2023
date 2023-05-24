package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomeLinkPage;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class HomeLinksTest extends CommonAPI {
    Logger log = LogManager.getLogger(CouponsTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test(enabled = false)
    public void BlogPage() {

       HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


      //  homePage.clickOnShopButton();


        homePage.clickOnBlogButton();


        // check user is landed to blog page
        Assert.assertTrue(links.checkPresenceOfBlogPageHeader());
        String expectedblogPageHeader = "Blog";
        String actualblogPageHeader = links.getBlogPageHeadertext();
        Assert.assertEquals(expectedblogPageHeader,actualblogPageHeader);
        waitFor(3);

    }
    @Test(enabled = false)
    public void MenCollectionPage() {

        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        homePage.hoverOverOnCategoriesButton(getDriver());
        homePage.clickOnMenCollection();


        // check user is landed to blog page
        Assert.assertTrue(links.checkPresenceOfMenCollectionPageHeader());
        String expectedMenCollectionPageHeader = "Men Collection";
        String actualMenCollectionHeader = links.getMenCollectionPageHeadertext();
        Assert.assertEquals(expectedMenCollectionPageHeader,actualMenCollectionHeader);
        waitFor(3);

    }
    @Test(enabled = false)
    public void myAccountPage() {

        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);





        homePage.clickOnMyAccountButton();


        // check user is landed to blog page
//        String expectedTitle4 = "https://www.instagram.com/rawromel/";
//        String actualTitle4 = getCurrentTitle();
//        Assert.assertEquals(expectedTitle4, actualTitle4);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
        Assert.assertTrue(links.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = links.getMainLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is registred success");
        waitFor(3);

    }
    @Test
    public void instagramPage() {

        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


        homePage.clickOnInstagramButton();
waitFor(3);

        // check user is landed to blog page
//        String expectedTitle4 = "https://www.instagram.com/rawromel/";
//        String actualTitle4 = getCurrentTitle();
//        Assert.assertEquals(expectedTitle4, actualTitle4);
//        log.info("user landed successfully to the website ");
//        waitFor(3);
        String expectedinstagramTitle = "Automation – Automate eCommerce";
        String actualinstagramTitle = getCurrentTitle();
        Assert.assertEquals(expectedinstagramTitle, actualinstagramTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


    }

    }
