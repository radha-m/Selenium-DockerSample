package pageObjects;

import utilities.WebElementUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

    public WebDriver driver;
    WebElementUtilities webutil = new WebElementUtilities();

    @FindBy(how = How.XPATH, using = "//a[@id='nav-link-accountList']")
    public WebElement nav_login;

    @FindBy(how=How.CSS, using="span.nav-action-inner") public WebElement signIn;
    @FindBy(how=How.CSS, using="#twotabsearchtextbox") public WebElement srchBox;
    @FindBy(how=How.CSS, using="#nav-search-submit-button") public WebElement srch_glass;
    @FindBy(how=How.CSS, using=".a-section.a-spacing-small.a-spacing-top-small>span") public WebElement srch_result;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickSignIn()
    {
        webutil.clickElement(driver,nav_login);
        LoginPage lop = new LoginPage(driver);
        return lop;
    }

    public void srchProduct(String product)
    {
        webutil.sendText(driver,srchBox,product);
        webutil.clickElement(driver,srch_glass);
    }

    public String getSrchResult()
    {
        String result = webutil.getText(srch_result);
        return result;
    }

}
