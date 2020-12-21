import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    static WebDriver driver;
    public static int AJAX_WAIT_TIME = 5;
    protected WebDriverWait wait = new WebDriverWait(driver, AJAX_WAIT_TIME);
    private static final Logger log = LogManager.getLogger(BasePage.class.getName());

    public BasePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, AJAX_WAIT_TIME), this);
        driver.manage().window().maximize();
    }

    public void open() {
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
    }

    public void close() {
        driver.quit();
    }


    public boolean isElementPresent(By by){
        List<WebElement> elementList = driver.findElements(by);
        int size = elementList.size();
        if (size > 0){
            log.info("Element found " + by );
        }else {
            log.info("Element not present " + by);
        }
        return size > 0;
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException ignored) {}
    }

    public void waitForElementVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        log.info("Element is visible" + by);
    }

    public void waitForElementClickability(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        log.info("Element is clickable" + by);
    }

    public void waitForElementPresence(By by){
        wait.withMessage("Page Didn't Load").until(ExpectedConditions.presenceOfElementLocated(by));
        log.info("Element is present" + by);
    }


    public void waitForElementPV(By by){
        waitForElementPresence(by);
        waitForElementVisibility(by);
        assert isElementPresent(by);
    }


    public void waitForElementPVC(By by){
        waitForElementPresence(by);
        waitForElementVisibility(by);
        waitForElementClickability(by);
        assert isElementPresent(by);
    }

}
