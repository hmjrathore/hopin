import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UiTest {
    WelcomeScreen page;
    CustomerListScreen page1;
    ContactsDetailScreen page2;

    @BeforeClass
    public void setup() {
        final String OS = "MAC OS";
        String DRIVER_PATH = "src/main/resources/drivers/chromedriver_mac";

        switch (OS) {
            case "UBUNTY":
                DRIVER_PATH = "src/main/resources/drivers/chromedriver_ubuntu";
                break;
            case "WINDOWS":
                DRIVER_PATH = "src/main/resources/drivers/chromedriver_win.exe";
                break;
        }

        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        BasePage.driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        page.close();
    }

    @Test
    public void verifyCompanySizeIsCorrect() {
        page = new WelcomeScreen();
        page.open();
        page.submitName("hello");
        page1 = new CustomerListScreen();
        page1.customerListScreenPageRendering();
        page1.verifyCorrectSize(1);
    }

    @Test
    public void verifyCompanySizeIsCorrect1() {
        page = new WelcomeScreen();
        page.open();
        page.submitName("hello");
        page1 = new CustomerListScreen();
        page1.customerListScreenPageRendering();
        page1.verifyCorrectSize(3);
    }

    @Test
    public void openCustomerContactDetailFromList() {
        page = new WelcomeScreen();
        page.open();
        page.submitName("hello");
        page1 = new CustomerListScreen();
        page1.customerListScreenPageRendering();
        page1.openCustomerContactDetail(3);
        page2 = new ContactsDetailScreen();
        page2.verifyThatPageHasLoaded();
        page2.verifyCustomername();
    }
}
