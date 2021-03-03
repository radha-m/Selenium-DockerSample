package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DockerParallelTest {
    @Test
    public void test() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.CHROME);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);

        driver.get("https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/create-cluster-kubeadm/");
        Thread.sleep(5000);
        driver.quit();
}

    @Test
    public void test2() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.FIREFOX);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);

        driver.get("https://www.facebook.com/");
         Thread.sleep(5000);
        driver.quit();
    }
}
