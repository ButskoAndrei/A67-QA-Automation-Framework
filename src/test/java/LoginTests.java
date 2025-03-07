import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void registrationNavigation(){
        // Make sure we're on the login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));

        // Find and click the registration link
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='registration']")));
        registrationLink.click();

        // Verify navigation
        wait.until(ExpectedConditions.urlContains("registration"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");
    }

    @Test
    public void loginEmptyEmailPassword() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[type='email']")));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
    }
}
