package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By newPlaylistBtn = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    By newPlaylist = By.cssSelector("li[data-testid = 'playlist-context-menu-create-simple']");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.xpath("//form[@name='create-simple-playlist-form']//input[@name='name']");
    By inputField = By.cssSelector("input[name='name']");
    By notificationLocator = By.xpath("//div[contains(text(), 'Created playlist')]");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void clickAddNewPlaylist() {
        findElement(newPlaylistBtn);
        click(newPlaylistBtn);

    }

    public void clickNewPlaylistBtn(){
        findElement(newPlaylist);
        click(newPlaylist);
    }

    public void setNewPlaylistName(String newPlaylistName){
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);

        findElement(notificationLocator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationLocator));
    }

    public void doubleClickPlaylist() {

        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String playlistName){

        findElement(inputField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(inputField).sendKeys(playlistName);
        findElement(inputField).sendKeys(Keys.ENTER);
    }

    public String getNotificationMsg(){

        return findElement(renamePlaylistSuccessMsg).getText();
    }
}
