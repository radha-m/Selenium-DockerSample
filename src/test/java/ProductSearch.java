import utilities.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import utilities.PropertyFileReaderConfig;


import java.io.IOException;


public class ProductSearch extends BaseClass {

    public WebDriver driver;
    public static final Logger log = LogManager.getLogger(ProductSearch.class.getName());

    @BeforeTest
    public void setup() throws IOException {
        this.driver = getDriver();
        log.info("Driver initialised");

        String URL = PropertyFileReaderConfig.fileRead("basicData").getProperty("URL");
        driver.get(URL);

    }

    @Test
    public void productSearchTest() throws IOException {
        driver.getCurrentUrl();
        LandingPage lp = new LandingPage(driver);
        lp.srchProduct("harry Potter");
        String result= lp.getSrchResult();
        Assert.assertTrue(result.contains("of over"));
        log.info("Search successfully");
    }
}
