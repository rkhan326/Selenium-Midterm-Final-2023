package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class RegisterPage extends CommonAPI {

    Logger log = LogManager.getLogger(RegisterPage.class.getName());
    public RegisterPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement registerMenuLocator;
    @FindBy(css= "#gender-male")
    WebElement radioButtonLocator;
    @FindBy(css = "#FirstName")
    WebElement firstNameLocator;
    @FindBy(css = "#LastName")
    WebElement lastNameLocator;
    @FindBy(css = "#Email")
    WebElement emailLocator;
    @FindBy(css = "#Company")
    WebElement companyNameLocator;

    @FindBy(css = "#Password")
    WebElement passwordLocator;
    @FindBy(css = "#ConfirmPassword")
    WebElement confirmPasswordLocator;
    @FindBy(css = "#register-button")
    WebElement registerButtonLocator;

    //*****Reusable Methods*****

    public void clickOnRegisterMenu(){
        clickOn(registerMenuLocator);
        log.info("click on Register menu Success");
    }
    public void clickOnRadioButton(){
        clickOn(radioButtonLocator);
        log.info("click on Radio Button Success");
    }
    public void typeFirstName (String firstName){
        typeText(firstNameLocator,firstName);
        log.info("type firstName success");
    }
    public void typeLastName (String lastName){
        typeText(lastNameLocator,lastName);
        log.info("type lastName success");
    }
    public void typeEmail (String email){
        typeText(emailLocator,email);
        log.info("type email success");
    }
    public void typeCompanyName (String companyName){
        typeText(companyNameLocator,companyName);
        log.info("type company Name success");
    }
    public void typePassword (String password){
        typeText(passwordLocator,password);
        log.info("type password success");
    }
    public void typeConfirmPassword (String confirmPassword){
        typeText(confirmPasswordLocator,confirmPassword);
        log.info("type confirmPassword success");
    }
    public void clickOnRegisterButton(){
        clickOn(registerMenuLocator);
        log.info("click on click On Register Button menu Success");
    }


}
