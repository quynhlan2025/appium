import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppAndroid {
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

        MobileElement add = driver.findElementById("com.android.calculator2:id/op_add");
        add.click();

        MobileElement el2 = driver.findElementById("com.android.calculator2:id/digit_5");
        el2.click();


        MobileElement equal = driver.findElementById("com.android.calculator2:id/eq");
        equal.click();

        //android:id/content
        MobileElement content = driver.findElementById("com.android.calculator2:id/result");
        System.out.println(content.getText());



        System.out.println(System.getProperty("user.dir"));

//        Actions action = new Actions(driver);
//        action.moveTo(element);
//        action.click();
//        action.perform();

    }
}
