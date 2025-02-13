import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String newPlaylistName = "Test 1";


    @Test
    public void renamePlaylist(){


        String updatedPlaylistMsg = "Updated playlist \"Test 1.\"";

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";

        login(username,password);
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getNotificationMsg(),updatedPlaylistMsg);
    }

    public void doubleClickPlaylist() {
        Actions actions = new Actions(driver);
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.contextClick(playlistElement).perform();
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-edit-102622']")));
        editButton.click();
    }

    public void enterNewPlaylistName(){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName);
        inputField.sendKeys(Keys.ENTER);
    }
}
