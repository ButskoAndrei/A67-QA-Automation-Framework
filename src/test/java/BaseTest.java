import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected String baseUrl;

    // Static initialization of WebDriverManager
    static {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    @Parameters(value = {"BaseURL"})
    public void setupClass(String url) {

        this.baseUrl = url;
    }

    @BeforeMethod
    public void setUpBrowser(){
        // Initialize the driver
        try {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource issues
        options.addArguments("--no-sandbox"); // Bypass OS security model

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


        // Initialize wait and actions
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

            // Maximize window
            driver.manage().window().maximize();

        }
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
            } catch (Exception e) {
                System.out.println("Error during driver cleanup: " + e.getMessage());
            }
        }
    }


}