package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.ContactUsPage;

public class ContactUsTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    String fullName= " Danish Mahmud";
    String email= "admin@mail.com";
    String message= "message field";

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
