package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.ElectronicMenuPage;

public class ElectronicMenuTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    @Test(priority = 1)
    public void cameraAndPhotoMenu(){
        ElectronicMenuPage electronicMenuPage=new ElectronicMenuPage(getDriver());

        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover Over Electronic menu
        electronicMenuPage.hoverOverElectronicMenu(getDriver());
        //click on Camera and Photo menu
        electronicMenuPage.hoverOverCameraAndPhotoMenuAndClick(getDriver());
        //click on product
        electronicMenuPage.selectProduct();
        //check we are cameraAndPhoto page
        String expectedDesktopsPageHeader = "Nikon D5500 DSLR";
        String actualDesktopsPageHeader = electronicMenuPage.checkCameraAndPhotoPageIsOpen();
        Assert.assertEquals(expectedDesktopsPageHeader, actualDesktopsPageHeader);
        waitFor(1);


    }
    @Test(priority = 2)
    public void cellPhonesMenu(){
        ElectronicMenuPage electronicMenuPage=new ElectronicMenuPage(getDriver());

        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover Over Electronic menu
        electronicMenuPage.hoverOverElectronicMenu(getDriver());
        //click on Cell Phone menu
        electronicMenuPage.hoverOverCellPhoneMenuAndClick(getDriver());
        //click on product
        electronicMenuPage.selectPhone();
        //check we are cameraAndPhoto page
        String expectedDesktopsPageHeader = "HTC One M8 Android L 5.0 Lollipop";
        String actualDesktopsPageHeader = electronicMenuPage.checkPhonePageIsOpen();
        Assert.assertEquals(expectedDesktopsPageHeader, actualDesktopsPageHeader);
        waitFor(1);


    }
}
