import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String playlistName = "Test";
    String newPlaylistName = "Test 1";

    @Test
    public void renamePlaylist() {


        String updatedPlaylistMsg = "Updated playlist \"Test 1.\"";

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";

        login(username,password);
        clickAddBtn();
        clickNewPlaylistBtn();
        createNewPlaylist();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getNotificationMsg(),updatedPlaylistMsg);
    }

    public void clickAddBtn() {
        WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id='sidebar']//i[@title='Create a new playlist']")));
        addBtn.click();
    }

    public void clickNewPlaylistBtn() {
        WebElement newPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        newPlaylistBtn.click();
    }

    public void createNewPlaylist(){
        WebElement inputNewPlaylistField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']//input[@name='name']")));
        inputNewPlaylistField.sendKeys(playlistName);
        inputNewPlaylistField.sendKeys(Keys.ENTER);

        By notificationLocator = By.xpath("//div[contains(text(), 'Created playlist')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationLocator));
    }

    public void doubleClickPlaylist() {

        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName);
        inputField.sendKeys(Keys.ENTER);
    }
}
