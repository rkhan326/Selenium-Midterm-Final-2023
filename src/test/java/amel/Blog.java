package amel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class Blog extends SetUp {
    Logger log = LogManager.getLogger(Blog.class.getName());


    @Test
    public void addComment(){

        // user is landed on the website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //  click on Blog
        clickOn("//li[@id='menu-item-292']/a[1]");
        log.info("click on blog success");
        waitFor(3);

        //scroll to read more  button
        scrollToCoordinates(0,3000);
        waitFor(3);
        boolean readMoreButtonVisibile = isVisible("//a[@href='https://automation.scaledupit.com/2017/12/03/fun-in-shop/ ']\t");
        Assert.assertTrue(readMoreButtonVisibile);
        log.info("scroll to read more success");
        waitFor(3);

        // click on read more button
        clickOn("//a[@href='https://automation.scaledupit.com/2017/12/03/fun-in-shop/ ']\t\t");
        log.info("click on read more success");
        waitFor(3);

        // scroll to leave comment
        scrollToCoordinates(0,2500);
        waitFor(3);
        boolean leaveCommentVisibile = isVisible(".comment-reply-title");
        Assert.assertTrue(leaveCommentVisibile);
        log.info("scroll to leave comment success");
        waitFor(3);

        // enter  comment
        typeText("#comment","I like this page too much ");
        log.info("enter comment success");
        waitFor(3);

        // enter Name
        typeText("input[name='author']","Amel  ");
        log.info("enter Name success");
        waitFor(3);

        // enter email
        typeText("//input[contains(@name,'email')]","boucettaamel8@gmail.com ");
        log.info("enter email success");
        waitFor(3);

        // enter url website
        typeText("#url","https://automation.scaledupit.com//");
        log.info("enter Url website success");
        waitFor(3);

        //check box on Save my name, email, and website in this browser for the next time I comment.
        clickOn("//p[@class='comment-form-cookies-consent']/input");
        log.info("check box on Save my name, email, and website in this browser for the next time I comment success ");
        waitFor(3);
        boolean SaveButton = isChecked("//p[@class='comment-form-cookies-consent']/input");;
        Assert.assertTrue(SaveButton);
        log.info(" Save my name, email, and website in this browser for the next time I comment , check box   success");

        // click on submit button
        clickOn("input[id='submit']");
        log.info("click on submit button success");
        waitFor(3);

        // check user has add comment
        String expectedText = "Your comment is awaiting moderation.";
        String actualText = getElementText(".comment-awaiting-moderation");
        Assert.assertEquals(expectedText, actualText);
        log.info("comment added success");


    }


}



