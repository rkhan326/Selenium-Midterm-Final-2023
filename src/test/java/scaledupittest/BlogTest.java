package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.BlogPage;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.utility.ConnectDB;
import us.piit.utility.DataProviderClass;
import us.piit.utility.Utility;

import java.util.Properties;

public class BlogTest extends CommonAPI {
    Logger log = LogManager.getLogger(BlogTest.class.getName());

    Properties prop = Utility.loadProperties();

    String MyComment = ConnectDB.getTableColumnData("select * from Amel", "Mycomment").get(0);
    String Name = ConnectDB.getTableColumnData("select * from Amel", "Myname").get(0);
    String Email= ConnectDB.getTableColumnData("select * from Amel", "EMAIL").get(0);
    String Url = ConnectDB.getTableColumnData("select * from Amel", "Url").get(0);

//    @Test(enabled = true, priority = 0)
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
        Assert.assertTrue(blogPage.checkPresenceOfBlogPageHeader());
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = blogPage.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader, actualBlogPageHeader);
        log.info("user landed to the blog page success");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0, 3000);
        waitFor(3);

        // check if read more button is  visible
        Assert.assertTrue(blogPage.checkReadMoreButtonIsVisible());
        waitFor(3);

        // click on read more button
        blogPage.clickOnReadMoreButton();
        waitFor(3);

        // check user is landed to the fun in shop page
        String expectedtitle = "Fun in Shop – Automation";
        String actualtitle = getCurrentTitle();
        Assert.assertEquals(expectedtitle, actualtitle);
        log.info("user landed to the fun in shop page success");
        waitFor(3);

        // scroll to add comment
        scrollToElement(0, 2500);
        waitFor(3);
        // check if read leave comment button is visible
        Assert.assertTrue(blogPage.checkLeaveCommentButtonIsVisible());
        waitFor(3);


        // enter comment , name,email,url
        blogPage.enterComment(MyComment);
        waitFor(3);

        blogPage.enterName(Name);
        waitFor(3);

        blogPage.enterEmail(blogPage.enterNewFakeEmail());
        waitFor(3);

        blogPage.enterUrl(Url);
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
        Assert.assertTrue(blogPage.checkPresenceOfCommentHeader());
        String expectedCommentHeaderText = "Your comment is awaiting moderation.";
        String actualCommentHeaderText = blogPage.getCommentHeadertext();
        Assert.assertEquals(expectedCommentHeaderText, actualCommentHeaderText);
        log.info("comment added success");


    }

//    @Test(enabled = true, priority = 0)
    public void AddCommentWithAnyInformations() {
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
        Assert.assertTrue(blogPage.checkPresenceOfBlogPageHeader());
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = blogPage.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader, actualBlogPageHeader);
        log.info("user landed to the blog page success");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0, 3000);
        waitFor(3);

        // check if read more button is  visible
        Assert.assertTrue(blogPage.checkReadMoreButtonIsVisible());
        waitFor(3);

        // click on read more button
        blogPage.clickOnReadMoreButton();
        waitFor(3);

        // check user is landed to the fun in shop page
        String expectedtitle = "Fun in Shop – Automation";
        String actualtitle = getCurrentTitle();
        Assert.assertEquals(expectedtitle, actualtitle);
        log.info("user landed to the fun in shop page success");
        waitFor(3);

        // scroll to add comment
        scrollToElement(0, 2500);
        waitFor(3);
        // check if read leave comment button is visible
        Assert.assertTrue(blogPage.checkLeaveCommentButtonIsVisible());
        waitFor(3);


        // enter comment , name,email,url
        blogPage.enterComment(MyComment);
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
        Assert.assertTrue(blogPage.checkPresenceOfCommentErrorMessage());
        String expectedCommentErrorMessage = "Error: Please fill the required fields.";
        String actualCommentErrorMessage = blogPage.getCommentErrorMessageText();
        Assert.assertEquals(expectedCommentErrorMessage, actualCommentErrorMessage);
        log.info("comment Error message validate  success");


    }

//    @Test(enabled = true, priority = 0)
    public void AddCommentWithInvEmail() {
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
        Assert.assertTrue(blogPage.checkPresenceOfBlogPageHeader());
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = blogPage.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader, actualBlogPageHeader);
        log.info("user landed to the blog page success");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0, 3000);
        waitFor(3);

        // check if read more button is  visible
        Assert.assertTrue(blogPage.checkReadMoreButtonIsVisible());
        waitFor(3);

        // click on read more button
        blogPage.clickOnReadMoreButton();
        waitFor(3);

        // check user is landed to the fun in shop page
        String expectedtitle = "Fun in Shop – Automation";
        String actualtitle = getCurrentTitle();
        Assert.assertEquals(expectedtitle, actualtitle);
        log.info("user landed to the fun in shop page success");
        waitFor(3);

        // scroll to add comment
        scrollToElement(0, 2500);
        waitFor(3);
        // check if read leave comment button is visible
        Assert.assertTrue(blogPage.checkLeaveCommentButtonIsVisible());
        waitFor(3);


        // enter comment , name,email,url
        blogPage.enterComment(MyComment);
        waitFor(3);

        blogPage.enterName(Name);
        waitFor(3);

        blogPage.enterEmail("invalid email");
        waitFor(3);

        blogPage.enterUrl(Url);
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
        String expectedError = "Fun in Shop – Automation";
        String actualError= getCurrentTitle();
        Assert.assertEquals(expectedError, actualError);


    }
//    @Test(enabled = true, priority = 0)
    public void duplicateComment() {
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
        Assert.assertTrue(blogPage.checkPresenceOfBlogPageHeader());
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = blogPage.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader, actualBlogPageHeader);
        log.info("user landed to the blog page success");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0, 3000);
        waitFor(3);

        // check if read more button is  visible
        Assert.assertTrue(blogPage.checkReadMoreButtonIsVisible());
        waitFor(3);

        // click on read more button
        blogPage.clickOnReadMoreButton();
        waitFor(3);

        // check user is landed to the fun in shop page
        String expectedtitle = "Fun in Shop – Automation";
        String actualtitle = getCurrentTitle();
        Assert.assertEquals(expectedtitle, actualtitle);
        log.info("user landed to the fun in shop page success");
        waitFor(3);

        // scroll to add comment
        scrollToElement(0, 2500);
        waitFor(3);
        // check if read leave comment button is visible
        Assert.assertTrue(blogPage.checkLeaveCommentButtonIsVisible());
        waitFor(3);


        // enter comment , name,email,url
        blogPage.enterComment(MyComment);
        waitFor(3);

        blogPage.enterName(Name);
        waitFor(3);

        blogPage.enterEmail(Email);
        waitFor(3);

        blogPage.enterUrl(Url);
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
        Assert.assertTrue(blogPage.checkPresenceOfDupliacteCommentErrorMessage());
        String expectedDuplicateCommentErrorMessage = "Duplicate comment detected; it looks as though you’ve already said that!";
        String actualDuplicateCommentErrorMessage  = blogPage.getDuplicateCommentErrorMessageText();
        Assert.assertEquals(expectedDuplicateCommentErrorMessage , actualDuplicateCommentErrorMessage );
        log.info("Duplicate Comment Error Message validate succes");


    }
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "excelDPScalledupitBlogTest", enabled = true)

    public void AddCommentUsingDataProvider(String Comment,String MyName,String MyEmail,String MyUrl ) {
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
        Assert.assertTrue(blogPage.checkPresenceOfBlogPageHeader());
        String expectedBlogPageHeader = "Blog";
        String actualBlogPageHeader = blogPage.getBlogPageHeadertext();
        Assert.assertEquals(expectedBlogPageHeader, actualBlogPageHeader);
        log.info("user landed to the blog page success");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0, 3000);
        waitFor(3);

        // check if read more button is  visible
        Assert.assertTrue(blogPage.checkReadMoreButtonIsVisible());
        waitFor(3);

        // click on read more button
        blogPage.clickOnReadMoreButton();
        waitFor(3);

        // check user is landed to the fun in shop page
        String expectedtitle = "Fun in Shop – Automation";
        String actualtitle = getCurrentTitle();
        Assert.assertEquals(expectedtitle, actualtitle);
        log.info("user landed to the fun in shop page success");
        waitFor(3);

        // scroll to add comment
        scrollToElement(0, 2500);
        waitFor(3);
        // check if read leave comment button is visible
        Assert.assertTrue(blogPage.checkLeaveCommentButtonIsVisible());
        waitFor(3);


        // enter comment , name,email,url
        blogPage.enterComment(Comment);
        waitFor(3);

        blogPage.enterName(MyName);
        waitFor(3);

        blogPage.enterEmail(blogPage.enterNewFakeEmail());
         waitFor(3);

        blogPage.enterUrl(MyUrl);
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
        Assert.assertTrue(blogPage.checkPresenceOfCommentHeader());
        String expectedCommentHeaderText = "Your comment is awaiting moderation.";
        String actualCommentHeaderText = blogPage.getCommentHeadertext();
        Assert.assertEquals(expectedCommentHeaderText, actualCommentHeaderText);
        log.info("comment added success");


    }
}


