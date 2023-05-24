package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.BlogPage;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class BlogTest extends CommonAPI {
    Logger log = LogManager.getLogger(BlogTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test
    public void AddComment() {
        HomePage homePage = new HomePage(getDriver());
        BlogPage blogPage = new BlogPage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on blog button
        homePage.clickOnBlogButton();
        waitFor(3);

        // check user is land to the blog page
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = blogPage.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader,actualBlogPageHeader);
        log.info("user landed to the blog page success");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0,3000);
        waitFor(3);

        // click on read more button
        blogPage.clickOnReadMoreButton();
        waitFor(3);

        // check user is landed to the fun in shop page
        String expectedtitle = "Fun in Shop – Automation";
        String actualtitle = getCurrentTitle();
        Assert.assertEquals(expectedtitle,actualtitle);
        log.info("user landed to the fun in shop page success");
        waitFor(3);

        // scroll to add comment
        scrollToElement(0,2500);
        waitFor(3);

        // enter comment , name,email,url
        blogPage.enterComment("i like this page very well , I need more details  ");
        waitFor(3);

        blogPage.entername("boucetta amoula gacem");
        waitFor(3);

        blogPage.enteremail("mamiboumoulagacouma4@gmail.com");
        waitFor(3);

        blogPage.enterUrl("https://automation.scaledupit.com/");
        waitFor(3);

        //check box on Save my name, email, and website in this browser for the next time I comment.
        blogPage.clickOnSaveButton();
        waitFor(3);


        // chech save check box
        Assert.assertTrue(blogPage.isSaveButtonChecked());
        log.info(" Save my name, email, and website in this browser for the next time I comment , check box   success");

        // click on submit button
        blogPage.clickOnSubmitButton();
        log.info("click on submit button success");
        waitFor(3);

        // check user has added comment
        String expectedText = "Your comment is awaiting moderation.";
        String actualText = blogPage.getcommentHeadertext();
        Assert.assertEquals(expectedText, actualText);
        log.info("comment added success");


    }


}


