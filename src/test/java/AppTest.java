import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class AppTest {
    public static URL url;
    public static DesiredCapabilities capabilities;
    //    public static IOSDriver<IOSElement> driver;
    public static AppiumDriverLocalService service = null;
    public static AppiumServiceBuilder builder;
    public static AndroidDriver<MobileElement> driver;


    //1
    @BeforeSuite
    public void setupAppium() throws MalformedURLException {
        //2
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(URL_STRING);

//// ios
//        capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "iOS");
//        capabilities.setCapability("platformVersion", "13.7");
//        capabilities.setCapability("automationName", "XCUITest");
//        capabilities.setCapability("useNewWDA", false);
//        capabilities.setCapability("xcodeOrgId", "68FFZ78A85");
//        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//        capabilities.setCapability("uuid", "AE7CCDB5-8965-4A2A-894F-5745C979C0C9");
////        capabilities.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_IPA_FILE]");
//        capabilities.setCapability("deviceName", "iPhone SE (2nd generation)");
//        capabilities.setCapability("bundleId", "com.apple.MobileAddressBook");
//        driver = new IOSDriver<IOSElement>(url, capabilities);
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.resetApp();
//        MobileElement el = driver.findElementByAccessibilityId("Search");
//        el.click();

        //Android
        capabilities = new DesiredCapabilities();
//        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el = driver.findElementById("com.android.calculator2:id/digit_5");
        el.click();
        System.out.println(System.getProperty("user.dir"));
//        Actions action = new Actions(driver);
//        action.moveTo(element);
//        action.click();
//        action.perform();




    }

    //5
//    @AfterSuite
//    public void uninstallApp() throws InterruptedException {
//        driver.removeApp("com.apple.MobileAddressBook");
//    }
//    //6
//    @Test (enabled=true) public void myFirstTest() throws InterruptedException {
//        driver.resetApp();
//    }
}