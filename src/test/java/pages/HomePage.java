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
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    public void clickAddNewPlaylist() {
        WebElement newPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        newPlaylistBtn.click();
    }

    public void clickNewPlaylistBtn(){
        WebElement playlistNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid = 'playlist-context-menu-create-simple']")));
        playlistNew.click();
    }

    public void setPlaylistName(String playlistName){
        WebElement inputNewPlaylistField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']//input[@name='name']")));
        inputNewPlaylistField.sendKeys(playlistName);
        inputNewPlaylistField.sendKeys(Keys.ENTER);

        //By notificationLocator = By.xpath("//div[contains(text(), 'Created playlist')]");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(notificationLocator));
    }

    public void enterNewPlaylistName(String newPlaylistName){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName);
        inputField.sendKeys(Keys.ENTER);
    }
}
