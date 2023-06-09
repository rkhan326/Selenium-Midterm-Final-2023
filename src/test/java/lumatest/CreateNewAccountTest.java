package lumatest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.lumapages.CreatenewAccountPageMagento;
import uspiit.pages.lumapages.HomePageMagento;

public class CreateNewAccountTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(CreateNewAccountTest.class.getName());
    Faker fakeData = new Faker();
    String emailAddress=fakeData.internet().emailAddress();
    String name = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();


    @Test
    public void RegisterWithAnExistingCredentials() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        homePage.clickOnCreateanAccountButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Create New Customer Account");
        LOG.info("create an account title page validation success");
        CreatenewAccountPageMagento createnewAccountPageMagento = new CreatenewAccountPageMagento(getDriver());
        //String FirstName  = ConnectDB.getTableColumnData("select * from cred","FirstName").get(0);
        createnewAccountPageMagento.typeFirstName("name");
        //String LastName  = ConnectDB.getTableColumnData("select * from cred","lastName").get(0);
        createnewAccountPageMagento.typeLastName("lastName");
        //String email  = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        createnewAccountPageMagento.typeEmailAddress("gsbappy2@gmail.com");
        //String password  = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        createnewAccountPageMagento.typePassword("password$1234");
        createnewAccountPageMagento.typeConfirmPassword("password$1234");
        createnewAccountPageMagento.clickOnCreateanAccountButton();
        String error = createnewAccountPageMagento.getErrorMessage1();
        Assert.assertEquals(error, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
        LOG.info("Failing Creation of an account success");
    }

    @Test
    public void InvalidCredentials() {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        homePage.clickOnCreateanAccountButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Create New Customer Account");
        LOG.info("create an account title page validation success");
        CreatenewAccountPageMagento createnewAccountPageMagento = new CreatenewAccountPageMagento(getDriver());
        //String FirstName = ConnectDB.getTableColumnData("select * from cred", "FirstName").get(0);
        createnewAccountPageMagento.typeFirstName(name);
        //String LastName  = ConnectDB.getTableColumnData("select * from cred","lastName").get(0);
        createnewAccountPageMagento.typeLastName(lastName);
        //String invalidEmailAdress  = ConnectDB.getTableColumnData("select * from cred","invalidEmailAdress").get(0);
        createnewAccountPageMagento.typeEmailAddress("gsbappy2@gmail.");
       // String password  = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        createnewAccountPageMagento.typePassword("password$1234");
        createnewAccountPageMagento.typeConfirmPassword("password$1234");
        createnewAccountPageMagento.clickOnCreateanAccountButton();
        String error = createnewAccountPageMagento.getErrorMessage();
        Assert.assertEquals(error, "Please enter a valid email address (Ex: johndoe@domain.com).");
        LOG.info("Failing Creation of an account success");
    }
    @Test
    public void RegisterNewAcount() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        homePage.clickOnCreateanAccountButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Create New Customer Account");
        LOG.info("create an account title page validation success");
        CreatenewAccountPageMagento createnewAccountPageMagento = new CreatenewAccountPageMagento(getDriver());
        createnewAccountPageMagento.typeFirstName(name);
        createnewAccountPageMagento.typeLastName(lastName);
        createnewAccountPageMagento.typeEmailAddress(emailAddress);
        createnewAccountPageMagento.typePassword("password&1234");
        createnewAccountPageMagento.typeConfirmPassword("password&1234");
        createnewAccountPageMagento.clickOnCreateanAccountButton();
        String confirmation = createnewAccountPageMagento.getConfirmation();
        Assert.assertEquals(confirmation, "Thank you for registering with Main Website Store.");
        LOG.info(" Creation of a new account success");
    }
}
