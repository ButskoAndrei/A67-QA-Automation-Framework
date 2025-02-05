import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";


        login(username,password);
        Thread.sleep(2000);
        clickNextSong();
        clickPlaySong();
        visibleSoundBar();

    }


    public void clickNextSong() throws InterruptedException {
         WebElement stepForward = driver.findElement(By.xpath("//div[@class='side player-controls']//i[@class='next fa fa-step-forward control']"));
         stepForward.click();
         Thread.sleep(2000);
    }

    public void clickPlaySong() throws InterruptedException {
        WebElement playSong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        playSong.click();
        Thread.sleep(2000);
    }

    public Boolean visibleSoundBar(){
        WebElement bars = driver.findElement(By.xpath("//div[@class='media-info-wrap']//img[@alt='Sound bars']"));
        return bars.isDisplayed();
    }
}
