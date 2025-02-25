import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.LoginPage;


public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(username).providePassword(password).clickSubmit();
        Thread.sleep(2000);
        clickNextSong();
        clickPlaySong();
        visibleSoundBar();
        Assert.assertTrue(visibleSoundBar());
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

    public boolean visibleSoundBar(){
        WebElement bars = driver.findElement(By.xpath("//div[@class='media-info-wrap']//img[@alt='Sound bars']"));
        return bars.isDisplayed();
    }
}
