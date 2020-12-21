import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsDetailScreen extends BasePage {

    @FindBy(xpath = "//b[text()='Name:']//parent::p")
    private WebElement customerNameContactDetail;
    String customerNameContactDetailS = "//b[text()='Name:']//parent::p";


    public void verifyCustomername(){
        waitForElementPV(By.xpath(customerNameContactDetailS));
        String a = customerNameContactDetail.getText();
    }

    public void verifyThatPageHasLoaded() {
        waitForElementPV(By.tagName("h1"));
    }
}
