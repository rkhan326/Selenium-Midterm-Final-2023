package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.net.Priority;
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

  //  @Test (enabled = true,priority=0)
    public void BlogPage() {
        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on blog button
        homePage.clickOnBlogButton();

        // check user is landed to blog page
        Assert.assertTrue(links.checkPresenceOfBlogPageHeader());
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = links.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader,actualBlogPageHeader);
        waitFor(3);

    }
 //   @Test (enabled = true,priority=1)
    public void MenCollectionPage() {

        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // hover over categories button
        homePage.hoverOverOnCategoriesButton(getDriver());

        // click on Men collection button
        homePage.clickOnMenCollection();

        // check user is landed to Men Collection page
        Assert.assertTrue(links.checkPresenceOfMenCollectionPageHeader());
        String expectedMenCollectionPageHeader = "Men Collection";
        String actualMenCollectionHeader = links.getMenCollectionPageHeadertext();
        Assert.assertEquals(expectedMenCollectionPageHeader,actualMenCollectionHeader);
        waitFor(3);

    }
  //  @Test (enabled = true,priority=2)
    public void myAccountPage() {

        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


        // click on my  Account button
        homePage.clickOnMyAccountButton();

        // Check user is landed to the login page
        Assert.assertTrue(links.checkPresenceOfLoginPageHeader());
        String expectedLoginPageHeader = "My account";
        String actualLoginPageHeader = links.getMainLoginPageHeadertext();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("user is landed to the login page with success");
        waitFor(3);

    }
    @Test (enabled = true,priority=3)
    public void instagramPage() {

        HomeLinkPage links = new HomeLinkPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // user land to the browser
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


        //user click on instagram
        homePage.clickOnInstagramButton();
        waitFor(3);

        // check user is landed to instagram page
        String expectedinstagramTitle = "Automation – Automate eCommerce";
        String actualinstagramTitle = getCurrentTitle();
        Assert.assertEquals(expectedinstagramTitle, actualinstagramTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on log in
        links.clickOnLogIn();
        waitFor(3);

      // check if continue as amel boucetta is visible
        Assert.assertTrue(links.checkContiueAsAmelIsVisible());
        waitFor(3);

        // click on continue as Amel
        links.clickOnContinueAsAmelBoucettaBtn();

        // click on Home
        links.clickOnHomeBtn();
        waitFor(2);

        // Check user is landed to the instagram home page
        Assert.assertTrue(links.checkPresenceOfInstagramHomePageHeader());
        String expectedInstagramHomePageHeader = "boucetta.amel";
        String actualInstagramHomePageHeader = links.getInstagramHomePageHeadertext();
        Assert.assertEquals(expectedInstagramHomePageHeader, actualInstagramHomePageHeader);
        log.info("user is landed to the login page with success");
        waitFor(3);

    }
    }


