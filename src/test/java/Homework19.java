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


public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test 1.\"";

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";

        login(username,password);
        Thread.sleep(2000);
        clickChoosePlaylist();
        clickDeleteBtn();
        //clickOkButton();
        Assert.assertEquals(getDeletePlaylistMessage(),expectedPlaylistDeleteMessage);

    }

    public void clickChoosePlaylist() throws InterruptedException {
        WebElement choosePlaylist = driver.findElement(By.xpath("//nav[@id='sidebar']//a[contains(text(),'Test 1')]"));
        choosePlaylist.click();
        Thread.sleep(2000);
    }

    public void clickDeleteBtn() throws InterruptedException {
        WebElement deleteBtn = driver.findElement(By.xpath("//div[@data-test='song-list-controls']//button[@title='Delete this playlist']"));
        deleteBtn.click();
        Thread.sleep(2000);
    }

    /*public void clickOkButton() throws InterruptedException {
        WebElement okButton = driver.findElement(By.xpath("//div[@class='dialog']//button[@class='ok']"));
        okButton.click();
        Thread.sleep(2000);
    }*/

    public String getDeletePlaylistMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}
