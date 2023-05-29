package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.lumapages.HomePageMagento;
import us.piit.pages.lumapages.SigninPageMagento;

import java.time.Duration;

public class SignInTest extends CommonAPI {


    Logger LOG = LogManager.getLogger(SignInTest.class.getName());
    WebDriver driver;
    @Test
    public void validTitle() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String expectedTitle = "Home Page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("Title success");
        driver.quit();
        System.out.println("close success");

    }
    @Test
    public void invalidTitle() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");
        String expectedTitle = "Hom Page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Title success");
        driver.quit();
        System.out.println("close success");

    }

    @Test
    public void validCredentials() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("Sign in title page validation success");
        //String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy1@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword("password&1234");
        signinPageMagento.clickOnSigninButton2();
        Thread.sleep(3000);
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Home Page");
        LOG.info("Signin success");
    }
    @Test
    public void invalidEmailAdress() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login ");
        LOG.info("login title page validation success");
        //String invalidEmailAdress = ConnectDB.getTableColumnData("select * from cred","invalidEmailAdress").get(0);
        signinPageMagento.typeInvalidEmailAddress("gsbappy1@gmail");
        signinPageMagento.typePassword("password&1234");
        signinPageMagento.clickOnSigninButton2();
        String error = signinPageMagento.getErrorMessage();
        Assert.assertEquals(error, "Please enter a valid email address (Ex: johndoe@domain.com).");
        LOG.info("error message validation success");
    }
    @Test
    public void invalidPassword() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("login title page validation success");
        //String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy1@gmail.com");
        //String invalidPassword = ConnectDB.getTableColumnData("select * from cred","invalidPassword").get(0);
        signinPageMagento.typeInvalidPassword("Borno2009@");
        signinPageMagento.clickOnSigninButton2();
        String error = signinPageMagento.getErrorMessage1();
        LOG.info("error message validation success");
    }

}
