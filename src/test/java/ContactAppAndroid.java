import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ContactAppAndroid {
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
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");

        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        MobileElement iconAdd = driver.findElementById("com.android.contacts:id/floating_action_button_container");
        iconAdd.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//com.android.contacts:id/right_button

        MobileElement addContactOnDialog = driver.findElementById("com.android.contacts:id/left_button");
        addContactOnDialog.click();

        MobileElement imageButton = driver.findElementsByAccessibilityId("Add contact photo").get(0);
        imageButton.click();
        //
        MobileElement chooseImage = driver.findElementByXPath("//android.widget.TextView[@text='Choose photo']");
        chooseImage.click();

//        Actions action = new Actions(driver);
//        action.moveTo(element);
//        action.click();
//        action.perform();
        //scrollUsingTouchActionsByElements();

    }
    public void scrollUsingTouchActionsByElements(MobileElement startElement, MobileElement endElement) {
        TouchAction actions = new TouchAction(driver);
        actions.press(startElement).waitAction(Duration.ofSeconds(2)).moveTo(endElement).release().perform();
    }

  public void addContact(){

      MobileElement el = driver.findElementById("//com.android.contacts:id/floating_action_button_container");
      el.click();//


      MobileElement createContact = driver.findElementByXPath("//android.widget.Spinner[@text='Create account']");
      createContact.click();


      MobileElement itemForMySelf = driver.findElementByXPath("//android.view.MenuItem[@text='For myself']");
      itemForMySelf.click();

      MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@resource-id='firstName']");
      firstName.sendKeys("Lan");

      //
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@resource-id='lastName']");
      lastName.sendKeys("Nguyen");

      //android.view.MenuItem

      MobileElement nextButton = driver.findElementByXPath("//android.view.View[@resource-id='collectNameNext']");
      nextButton.click();
      //collectNameNext


      ////android.widget.EditText[@resource-id='firstName']
      System.out.println(System.getProperty("user.dir"));

  }
}
