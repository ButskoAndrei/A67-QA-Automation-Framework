import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {


    @Test
    public void addSongToPlaylist() {
        // Login credentials (replace with your actual credentials)

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";

        // Login to the application
        login(username, password);

        // Search for a song (replace with your desired song)
        String songToSearch = "Pluto";
        searchSong(songToSearch);

        // Click View All button
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();

        // Click the first song in search results
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")
        ));
        firstSong.click();

        // Click ADD TO... button
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[class='btn-add-to']")
        ));
        addToButton.click();

        // Create a unique playlist name
        String playlistName = "Test";


            WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//section[@id='songResultsWrappers']//li[contains(text(),'Test 1')]")));
            choosePlaylist.click();



        // Wait for and verify the notification message
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".notification-content")
        ));

        String expectedMessage = "Added 1 song into \"Test 1\" ";
        String actualMessage = notification.getText();

        Assert.assertEquals(actualMessage, expectedMessage,
                "Notification message doesn't match expected message");


        tearDown();
    }
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize the ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Helper method for login
    protected void login(String username, String password) {
        driver.get("https://qa.koel.app/");

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

    }

    // Helper method for searching songs
    protected void searchSong(String songName) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']")));
        searchInput.clear();
        searchInput.sendKeys(songName);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
