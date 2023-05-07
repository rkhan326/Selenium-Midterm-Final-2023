package razia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import us.piit.SetUp;


import static org.openqa.selenium.Platform.getCurrent;

public class Login extends SetUp {
    public void validCredential() {
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        typeText("#user-name","standard_user");
        log.info("enter username success");
        typeText("#password","secret_sauce");
        log.info("enter password success");
        clickOn("#login-button");
        log.info("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = getElementText("//span[contains(text(),'Products')]");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");
    }


}
