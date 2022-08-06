import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class WebTest {
    WebDriver driver;
    String url="https://www.goshopback.vn/";
    @Test
    public void login() {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.get(url);
       LoginPage loginPage = new LoginPage(driver);
       loginPage.clickLoginSignupButton();
       loginPage.clickLoginDialog();
       loginPage.clickOnEmailDialog();
       loginPage.enterEmail();
       loginPage.clickContinueButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       loginPage.enterPassword();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       loginPage.clickContinueButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }

}

