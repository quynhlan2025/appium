import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".inline-block.header__user-menu-item div.header__auth-btn")
    private WebElement loginSignUpButton;
//div[class*="border-sb-very-light-pink-three"] >span

    @FindBy(css = "div[class*=\"border-sb-very-light-pink-three\"] >span")
    private WebElement loginDialog;
    //div[class*="button-email"]

    @FindBy(css = "div[class*=\"button-email\"]")
    private WebElement emailDialog;

    //input[class*="text-sb-slate-grey"]
    @FindBy(css = "input[class*=\"text-sb-slate-grey\"]")
    private WebElement emailTextbox;

    @FindBy(css = "button[class*=\"w-full\"]")
    private WebElement continuteButton;

    //input[type="password"]
    @FindBy(css = "input[class*=\"text-base\"]")
    private WebElement passwordTextbox;

    public void clickLoginSignupButton(){
        loginSignUpButton.click();
    }

    public void clickLoginDialog(){
        loginDialog.click();
    }

    public void clickOnEmailDialog(){
        emailDialog.click();
    }

    public void enterEmail(){
        emailTextbox.sendKeys("quynhlan1308@gmail.com");
    }

    public void clickContinueButton(){
        continuteButton.click();
    }

    public void enterPassword(){
        passwordTextbox.sendKeys("12345678L@n");
    }
}
