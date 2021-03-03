package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebElementUtilities {

    public WebDriver mouseHoverOver(WebDriver driver, WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        return driver;
    }

    public WebDriver clickElement(WebDriver driver, WebElement element)
    {
        (explicitWait(driver,element)).click();
        return driver;
    }

    public WebDriver sendText(WebDriver driver, WebElement element, String text)
    {
        element.sendKeys(text);
        return driver;
    }

    public String getText(WebElement element)
    {
        return element.getText();

    }

    public WebElement explicitWait(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }
}
