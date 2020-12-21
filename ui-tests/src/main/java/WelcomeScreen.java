import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeScreen extends BasePage {

    private static final Logger log = LogManager.getLogger(WelcomeScreen.class.getName());

    @FindBy(id = "name")
    private WebElement textField;
    private static String textFieldS = "name";

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButton;
    private static String submitButtonS = "//input[@value='Submit']";

    @FindBy(xpath = "//div//b[1]")
    private WebElement customerName;
    private static String customerNameS = "//div//b[1]";




    public void open() {
        driver.get("http://localhost:3000");
        sleep(1);
        driver.manage().window().maximize();
        sleep(4);
    }

    public void clickSubmitButton() {
        waitForElementPVC(By.xpath(submitButtonS));
        assert isElementPresent(By.xpath(submitButtonS));
        submitButton.click();
        log.info("Submit button is clicked");
        assert customerName.isDisplayed();
    }

    public void submitName(String userName){
        waitForElementPVC(By.id(textFieldS));
        assert isElementPresent(By.id(textFieldS));
        textField.click();
        log.info("Text field is clicked");
        textField.sendKeys(userName);
        log.info("Name provided in text field");
        clickSubmitButton();
        waitForElementPV(By.xpath(customerNameS));
        assert customerName.getText().equals(userName);
    }

}
