package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.ContactUsPage;
import uspiit.utility.ExcelReader;

import java.io.File;

public class ContactUsTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"nopcommercedata.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String fullName= excelReader.getStringDataFromCell("data",11,1);
    String email= excelReader.getStringDataFromCell("data",10,1);
    String message= excelReader.getStringDataFromCell("data",12,1);

    @Test(priority = 1)
    public void filledMandatoryRequirement(){
        ContactUsPage contactUsPage= new ContactUsPage(getDriver());

        scrollToElement(0,300);
        contactUsPage.clickOnContactUsButton();
        scrollToElement(0, 250);
        contactUsPage.typeFullName(fullName);
        contactUsPage.typeEmail(email);
        contactUsPage.typeInTextFieldBox(message);
        contactUsPage.clickOnSubmitButton();

        String expectedText = "Your enquiry has been successfully sent to the store owner.";
        String actualText = contactUsPage.contactUsValidation();
        Assert.assertEquals(expectedText,actualText);

    }
    @Test(priority = 2)
    public void filledWithoutMandatoryRequirement(){
        ContactUsPage contactUsPage= new ContactUsPage(getDriver());

        scrollToElement(0,300);
        contactUsPage.clickOnContactUsButton();
        scrollToElement(0, 250);
        contactUsPage.typeFullName(fullName);
        // email missing here
        contactUsPage.typeInTextFieldBox(message);
        contactUsPage.clickOnSubmitButton();

        String expectedText = "Enter email";
        String actualText = contactUsPage.contactUsValidationErrorMessage();
        Assert.assertEquals(expectedText,actualText);

    }
}
