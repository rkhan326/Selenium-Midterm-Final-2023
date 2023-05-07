package razia;

import org.testng.Assert;
import us.piit.SetUp;

public class LoginTest extends SetUp {
    public void validCredential() {
        String expectedTitle = "My Account - Welcome to Worldwide Electronics Store";
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
