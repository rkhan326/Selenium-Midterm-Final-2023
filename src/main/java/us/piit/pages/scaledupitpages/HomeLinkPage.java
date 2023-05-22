package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomeLinkPage extends CommonAPI {

    Logger log = LogManager.getLogger(HomeLinkPage.class.getName());

    public HomeLinkPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement blogPageHeader;



    @FindBy(css = ".woocommerce-products-header__title.page-title")
    WebElement menCollectionPageHeader;


    @FindBy(css= ".xe3v8dz")
    WebElement faceBookPageHeader;

    @FindBy(css = "._ab6-")
    WebElement instagramPageHeader;

    @FindBy(xpath = "//h1[text()='My account']")
    WebElement loginPageHeader;


    public boolean checkPresenceOfBlogPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(blogPageHeader);
        log.info("Men Collection page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getBlogPageHeadertext() {
        String blogPageHeaderText = getElementText(blogPageHeader);
        log.info("blog page header text is " + blogPageHeaderText);
        return blogPageHeaderText;

    }

    public boolean checkPresenceOfMenCollectionPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(menCollectionPageHeader);
        log.info("blog page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getMenCollectionPageHeadertext() {
        String blogPageHeaderText = getElementText(menCollectionPageHeader);
        log.info("Men Collection page header text is " + blogPageHeaderText);
        return blogPageHeaderText;

    }
    public boolean checkPresenceOfLoginPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }
    public String getMainLoginPageHeadertext() {
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }

    public String getFaceBookPageHeadertext() {
        String blogPageHeaderText = getElementText(faceBookPageHeader);
        log.info("FaceBook page header text is " + blogPageHeaderText);
        return blogPageHeaderText;

    }
    public boolean checkPresenceOfInstagramPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(instagramPageHeader);
        log.info("instagram page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getInstagramPageHeadertext() {
        String blogPageHeaderText = getElementText(instagramPageHeader);
        log.info("instagram page header text is " + blogPageHeaderText);
        return blogPageHeaderText;

    }
}
