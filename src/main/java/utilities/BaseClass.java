package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {


    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeTest

    public void initialiseDriver(String browser) throws IOException {



        if(browser.equalsIgnoreCase("chrome"))
        {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(BrowserType.CHROME);

            //Set Browser to ThreadLocalMap
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));

        }
        else if(browser.equalsIgnoreCase("firefox"))
        {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(BrowserType.FIREFOX);
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));

        }



    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
    @AfterTest
    public void closeDriver() throws IOException {
           getDriver().close();


    }

    public String getScreenShots(String testName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ss = ts.getScreenshotAs(OutputType.FILE);
        String destLocation=System.getProperty("user.dir")+"/reports/"+testName+".png";
        try {
            org.apache.commons.io.FileUtils.copyFile(ss,new File(destLocation));
        } catch (IOException e) {

        }

        return destLocation;

    }
}
