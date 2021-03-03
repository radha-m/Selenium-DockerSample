package pageObjects;

import utilities.WebElementUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public WebDriver driver;
    WebElementUtilities webutil = new WebElementUtilities();

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Sign-In')]")
    public WebElement txtSignin;

    @FindBy(how=How.XPATH, using="//input[@id='ap_email']") public WebElement email;
    @FindBy(how=How.XPATH, using="//input[@id='continue']") public WebElement btnContinue;
    @FindBy(how=How.XPATH, using="//input[@id='ap_password']") public WebElement password;
    @FindBy(how=How.XPATH, using="//input[@id='signInSubmit']") public WebElement btnSignIn;
    @FindBy(how=How.CSS, using="span.a-list-item") public WebElement txtError;



    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String userDetailsInput(String userName, String passWord)
    {
        String loginPage = webutil.getText(txtSignin);
        webutil.sendText(driver,email,userName);
        webutil.clickElement(driver,btnContinue);
        webutil.sendText(driver,password,passWord);
        webutil.clickElement(driver,btnSignIn);
        String errorText= webutil.getText(txtError);
        return errorText;
    }
}
