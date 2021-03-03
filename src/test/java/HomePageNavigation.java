import utilities.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.PropertyFileReaderConfig;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class HomePageNavigation extends BaseClass {

    public WebDriver driver;
    public static final Logger log = LogManager.getLogger(HomePageNavigation.class.getName());


    @BeforeTest
    public void setup() throws IOException {
        this.driver = getDriver();
        log.info("Driver initialised");

        String URL = PropertyFileReaderConfig.fileRead("basicData").getProperty("URL");
        driver.get(URL);

    }


    @Test(dataProvider="getData")
    public void loginTest(String userName, String passWord) throws IOException {
        driver.getCurrentUrl();
        LandingPage lp = new LandingPage(driver);
        LoginPage lop = lp.clickSignIn();
        String errorText= lop.userDetailsInput(userName,passWord);
        Assert.assertEquals(errorText,"To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.");
        log.info("Navigated successfully");
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[1][2];
        data[0][0]="abc@abc.com";
        data[0][1]="abc";
        return data;
    }
}
