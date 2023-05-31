package nopcommercetest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.RegisterPage;
import us.piit.utility.ConnectDB;
import us.piit.utility.ExcelReader;

import java.io.File;

public class RegisterTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());
    Faker faker= new Faker();

    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"nopcommercedata.xlsx";
    ExcelReader excelReader = new ExcelReader(path);

      String firstName= ConnectDB.getTableColumnData("select * from Nop_Commerce","first_name").get(0);
//    String firstName =excelReader.getStringDataFromCell("data",5,1);
      String lastName=  ConnectDB.getTableColumnData("select * from Nop_Commerce","last_name").get(0);
//    String lastName =excelReader.getStringDataFromCell("data",6,1);
//    String email= excelReader.getStringDataFromCell("data",10,1);
    String email= faker.internet().emailAddress();

//    String companyName= "PNT";
    String companyName =excelReader.getStringDataFromCell("data",7,1);
//    String password= "admin123";
    String password =excelReader.getStringDataFromCell("data",8,1);
//    String confirmPassword= "admin123";
    String confirmPassword =excelReader.getStringDataFromCell("data",9,1);


    String emptyFirstName = "";


    @Test(priority = 2)
    public void registerNewCustomer() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        //click on register
        registerPage.clickOnRegisterMenu();
        waitFor(1);

        // click radio button
        registerPage.clickOnRadioButton();
        //enter FirstName
        registerPage.typeFirstName(firstName);
        //enter LastName
        registerPage.typeLastName(lastName);
        //enter BirthDay
        registerPage.selectDateOfBirthDay();
        //enter BirthMonth
        registerPage.selectDateOfBirthMonth();
        //enter BirthYear
        registerPage.selectDateOfBirthYear();
        //enter Email
        registerPage.typeEmail(email);
        System.out.println(email);
//        String fakeRegistrationEmail = registerPage.getEmailOfNopCommerce();
//        registerPage.typeEmail(fakeRegistrationEmail);
        //enter Company
        registerPage.typeCompanyName(companyName);
        //enter password
        registerPage.typePassword(password);
        //enter confirm password
        registerPage.typeConfirmPassword(confirmPassword);

        //click on register-button button
        registerPage.clickOnRegisterButton();

        //ensure we are successfully registered
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered nopCommerce website");
    }
//    @Test(priority = 1)
//    public void registerWithoutFillMandatoryField() {
//        RegisterPage registerPage = new RegisterPage(getDriver());
//        //click on register
//        registerPage.clickOnRegisterMenu();
//        waitFor(1);
//        // click radio button
//        registerPage.clickOnRadioButton();
//        //enter FirstName
//        registerPage.typeFirstName(emptyFirstName);
//        //enter LastName
//        registerPage.typeLastName(lastName);
//        //enter BirthDay
//        registerPage.selectDateOfBirthDay();
//        //enter BirthMonth
//        registerPage.selectDateOfBirthMonth();
//        //enter BirthYear
//        registerPage.selectDateOfBirthYear();
//        //enter Email
//        registerPage.typeEmail(email);
//        //enter Company
//        registerPage.typeCompanyName(companyName);
//        //enter password
//        registerPage.typePassword(password);
//        //enter confirm password
//        registerPage.typeConfirmPassword(confirmPassword);
//        //click on register-button button
//        registerPage.clickOnRegisterButton();
//
//        //ensure we are successfully registered
//        String actualTitle = getCurrentTitle();
//        String expectedTitle = "nopCommerce demo store. Register";
//        Assert.assertEquals(actualTitle, expectedTitle);
//        log.info("Successfully entered nopCommerce website");
//    }

}
