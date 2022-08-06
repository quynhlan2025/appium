import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppIOS {

    public static URL url;
    public static DesiredCapabilities capabilities;
    public static IOSDriver<IOSElement> driver;
    public static AppiumDriverLocalService service = null;
    public static AppiumServiceBuilder builder;


    @BeforeSuite
    public void setupAppium() throws MalformedURLException {
        //2
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(URL_STRING);
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "13.7");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("useNewWDA", false);
        capabilities.setCapability("xcodeOrgId", "68FFZ78A85");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("uuid", "AE7CCDB5-8965-4A2A-894F-5745C979C0C9");
//        capabilities.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_IPA_FILE]");
        capabilities.setCapability("deviceName", "iPhone SE (2nd generation)");
        capabilities.setCapability("bundleId", "com.apple.MobileAddressBook");
        driver = new IOSDriver<IOSElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.resetApp();
        MobileElement addIcon = driver.findElementByAccessibilityId("Add");
        addIcon.click();

        MobileElement firstNameTextBox = driver.findElementByXPath("//XCUIElementTypeTextField[@name='First name']");
        firstNameTextBox.sendKeys("lan");

        MobileElement lastNameTextbox = driver.findElementByAccessibilityId("Last name");
        lastNameTextbox.sendKeys("Nguyen");

        MobileElement companyTextbox = driver.findElementByAccessibilityId("Last name");
        lastNameTextbox.sendKeys("Sophera Viet Nam");

        MobileElement doneButton = driver.findElementByAccessibilityId("Done");
       doneButton.click();


        //add.click();

        ////
        //XCUIElementTypeTextField[@name='First name']
    }
}
