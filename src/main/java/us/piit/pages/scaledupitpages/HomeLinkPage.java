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

    @FindBy(xpath = "//button[@class='_acan _acap _acas _aj1-']")
    WebElement instagramPageHeader;

    @FindBy(xpath = "//h1[text()='My account']")
    WebElement loginPageHeader;

    @FindBy(xpath = "")
    WebElement logInBtn;

    @FindBy(xpath = "//div[text()='Continue as boucetta.amel']")
    WebElement continuAsAmel;

    @FindBy(xpath="//div[text()='Home']")
    WebElement homeBtn;

    @FindBy(xpath="//a[text()='boucetta.amel']")
    WebElement instagramHomePageHeader;

    public boolean checkPresenceOfBlogPageHeader() {
        boolean blogPageHeaderIsDisplayed = isVisible(blogPageHeader);
        log.info("Men Collection page header presence " + blogPageHeaderIsDisplayed);
        return blogPageHeaderIsDisplayed;
    }

    public String getBlogPageHeadertext() {
        String blogPageHeaderText = getElementText(blogPageHeader);
        log.info("blog page header text is " + blogPageHeaderText);
        return blogPageHeaderText;

    }

    public boolean checkPresenceOfMenCollectionPageHeader() {
        boolean MenCollectionPageHeaderIsDisplayed = isVisible(menCollectionPageHeader);
        log.info("blog page header presence " + MenCollectionPageHeaderIsDisplayed);
        return MenCollectionPageHeaderIsDisplayed;
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

    public boolean checkPresenceOfInstagramPageHeader() {
        boolean InstagramnPageHeaderIsDisplayed = isVisible(instagramPageHeader);
        log.info("instagram page header presence " + InstagramnPageHeaderIsDisplayed );
        return InstagramnPageHeaderIsDisplayed ;
    }

    public String getInstagramPageHeaderText() {
        String instagramPageHeaderText = getElementText(instagramPageHeader);
        log.info("instagram page header text is " + instagramPageHeaderText);
        return instagramPageHeaderText;

    }
    public void clickOnLogIn() {
        clickOn(logInBtn);
        log.info("click on Log In success");
    }
    public boolean checkContiueAsAmelIsVisible (){
        boolean isContiueAsAmelVisible = isVisible(continuAsAmel);
        log.info("Continue As Amel button is visible");
        return isContiueAsAmelVisible;
    }
    public void clickOnContinueAsAmelBoucettaBtn() {
        clickOn(continuAsAmel);
        log.info("click on Log In success");
    }
    public void clickOnHomeBtn() {
        clickOn(homeBtn);
        log.info("click on Home success");
    }
    public boolean checkPresenceOfInstagramHomePageHeader() {
        boolean InstagramHomePageHeaderIsDisplayed = isVisible(instagramHomePageHeader);
        log.info("Instagram Home page header presence " + InstagramHomePageHeaderIsDisplayed);
        return InstagramHomePageHeaderIsDisplayed;
    }

    public String getInstagramHomePageHeadertext() {
        String InstagramHomePageHeadertext = getElementText(instagramHomePageHeader);
        log.info("Instagram Home page header text is " + InstagramHomePageHeadertext);
        return InstagramHomePageHeadertext;

    }
}
