package us.piit.base;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import us.piit.reporting.ExtentManager;
import us.piit.reporting.ExtentTestManager;
import us.piit.utility.Utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class CommonAPI {

    Logger log = LogManager.getLogger(CommonAPI.class.getName());
    Properties prop = Utility.loadProperties();
    String browserstackUsername = prop.getProperty("browserstack.username");
    String browserstackPassword = prop.getProperty("browserstack.password");

    String implicitWait = prop.getProperty("implicit.wait","5");
    String windowMaximize = prop.getProperty("browser.maximize","true");
    String takeScreenshots = prop.getProperty("take.screenshots","true");
    WebDriver driver;



    //report setup from line 48 to 105
    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite(groups = {"before"})
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(groups = {"before"})
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod(groups = {"after"})
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (takeScreenshots.equalsIgnoreCase("true")){
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            }
        }
        driver.quit();
    }
    @AfterSuite(groups = {"after"})
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }



    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@hub-cloud.browserstack.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@ondemand.saucelabs.com:80/wd.hub"), cap);
        }
    }
    public void getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("chrome browser open success");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("firefox browser open success");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            log.info("edge browser open success");
        }
    }

    @Parameters({"useCloudEnv", "envName", "os", "osVersion", "browserName", "browserVersion", "url"})
    @BeforeMethod(groups = {"before"})
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://www.google.com") String url) throws MalformedURLException {
        if (useCloudEnv.equalsIgnoreCase("true")) {
            getCloudDriver(envName, os, osVersion, browserName, browserVersion, browserstackUsername, browserstackPassword);
        }else if (useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver(browserName);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait)));
        if (windowMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }
        driver.get(url);
    }

    @AfterMethod(groups = {"after"})
    public void tearDown() {
        //close browser
        driver.quit();
        log.info("browser close success");
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                              selenium methods
    //------------------------------------------------------------------------------------------------------------------.

    public WebDriver getDriver() {return driver;}
    public String getCurrentTitle() {return driver.getTitle();}
    public String getElementText(WebElement element) {return element.getText();}
    public void clickOn(WebElement element) {element.click();}
    public void clear(WebElement element){element.clear();}
    public void typeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    public void typeTextEnter(WebElement element, String text){
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }
    public void hoverOver(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void hoverOverAndClick(WebDriver driver,WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void selectOptionFromDropdown(WebElement dropdown, String option){
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(option);
        }catch (Exception e){
            select.selectByValue(option);
        }
    }

    public void selectOptionFromDropDown(WebElement element, String value){
        WebElement dropdown = element;
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public void switchToTab(int index) {
        // Get a list of all the open window handles
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // Switch to the specified tab by index
        driver.switchTo().window(tabs.get(index));
    }
    public void switchToCurrentlyActiveWindow() {
        // Get the handle of the currently active window
        String currentHandle = driver.getWindowHandle();
        // Loop through all the open windows and switch to the next one
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }
    public void waitForElementToBeVisible(WebDriver driver, int duration, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public boolean isVisible(WebElement element) {return element.isDisplayed();}

    public boolean isInteractible(WebElement element) {return element.isEnabled();}

    public boolean isChecked(WebElement element) {return element.isSelected();}

    //         public void scrollToElement(String locator){
//              Actions actions = new Actions(driver);
//               actions.scrollToElement(driver.findElement(By.xpath(locator))).build().perform();
//               actions.scrollToElement(driver.findElement(By.cssSelector(locator))).build().perform();
////             try {
////                 actions.scrollToElement(driver.findElement(By.cssSelector(locator))).build().perform();
////             }catch (Exception e){
////                 actions.scrollToElement(driver.findElement(By.xpath(locator))).build().perform();
////             }
//         }
    public void scrollToCoordinates(int x, int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).build().perform();
    }
    public void scrollToView(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void scrollToElement(int x, int y){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x,y).click().build().perform();
    }
    public void moveSlider(WebElement element, int xOffset, int yOffset, WebDriver driver) {
        WebElement slider = element;
        Actions builder = new Actions(driver);
        builder.clickAndHold(slider);
        builder.moveByOffset(xOffset, yOffset).build().perform();
        builder.release().build().perform();

    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWithJavascript(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void clickWithActions(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

    }
    public void scrollToElementwJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void captureScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("screenshots"+File.separator+"ScalledupitBlogTestScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void takeScreenshot(String screenshotName){
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(Utility.currentDir+ File.separator +"screenshots"+ File.separator + screenshotName+" "+df.format(date)+".jpeg"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}

