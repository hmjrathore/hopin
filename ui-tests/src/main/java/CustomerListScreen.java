import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CustomerListScreen extends BasePage {

    private static final Logger log = LogManager.getLogger(CustomerListScreen.class.getName());


    @FindBy(xpath = "//div//b[1]")
    WebElement userName;
    private static String userNameS = "//div//b[1]";

    @FindBy(xpath = "//tbody/tr//a")
    private List<WebElement> customerNAmes;
    private static String customerNameS = "//tbody/tr//a";

    @FindBy(xpath = "(//tbody/tr//td[2])")
    private List<WebElement> noOfEmployees;


    @FindBy(xpath = "(//tbody/tr//td[3])")
    private List<WebElement> companySize;


    public void customerListScreenPageRendering(){
        waitForElementPV(By.xpath(userNameS));
        assert userName.getText().equals(userName.getText());
    }

    public void openCustomerContactDetail(int row){
        waitForElementPVC(By.xpath(customerNameS));
        customerNAmes.get(row).click();
        sleep(2);
        log.info("Customer detail info is open");
    }

    public String getSize(int row){
        String size = "Big";
        String nOfEmployInGivenRow = noOfEmployees.get(row).getText();
        int i = Integer.parseInt(nOfEmployInGivenRow);
        if (i <= 10) {
            size = "Small";
        }else if (i <=1000){
            size = "Medium";
        }
        System.out.println(size);
        return size;
    }

    public void verifyCorrectSize(int row){
        Assert.assertEquals(companySize.get(row).getText(),getSize(row), "Company size for '" + customerNAmes.get(row).getText() + "' is");
    }

}
