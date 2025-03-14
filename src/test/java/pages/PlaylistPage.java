package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PlaylistPage extends BasePage {


    @FindBy(css = "[id='songResultsWrapper'] [placeholder='Playlist name']")
    WebElement newPlaylistNameInput;

    @FindBy(css = ".playlist.playlist:nth-of-type(3)")
    WebElement thirdPlaylist;

    @FindBy(css = "[data-testid='inline-playlist-name-input']")
    WebElement playlistNameInput;

    @FindBy(css = ".playlist.playlist:nth-of-type(3) a")
    WebElement thirdPlaylistName;

    @FindBy(css = ".playlist.favorites")
    WebElement favoritesPlaylist;

    @FindBy(css = ".favorites .virtual-scroller .title")
    WebElement favoriteSongTitle;

    @FindBy(css = ".favorites [draggable='true'] .text-maroon")
    List<WebElement> likedSongs;


    public PlaylistPage(WebDriver driver) {
        super(driver);
    }

    public void goToFavorites(){
        favoritesPlaylist.click();
    }

    public String getFirstFavoritesTitle(){
        return favoriteSongTitle.getText();
    }


    public void createNewPlaylist(String playlistName) {
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        newPlaylistNameInput.sendKeys(Keys.ENTER);
    }

    public boolean doesCustomPlaylistExist() {
        return thirdPlaylist.isDisplayed();
    }

    public void renamePlaylist(String newName) {
        actions
                .doubleClick(thirdPlaylist)
                .perform();
        playlistNameInput.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE)); // this should work for Mac to remove existing text
        //  input.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.DELETE)); // this should work for Windows
        playlistNameInput.sendKeys(newName);
        actions
                .sendKeys(ENTER)
                .perform();
    }

    public void clickChoosePlaylist() {
        // First wait for the sidebar to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("sidebar")));

        // Then try to find the playlist
        try {
            WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//nav[@id='sidebar']//a[contains(text(),'Test 1')]")));
            choosePlaylist.click();
        } catch (TimeoutException e) {
            // If the playlist doesn't exist, we need to create it first
            System.out.println("Playlist 'Test 1' not found, may need to be created first");
            throw e; // Re-throw to fail the test, or handle differently
        }
    }

    public void clickDeleteBtn() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-test='song-list-controls']//button[@title='Delete this playlist']")));
        deleteBtn.click();
    }

    /*public void clickOkButton() throws InterruptedException {
        WebElement okButton = driver.findElement(By.xpath("//div[@class='dialog']//button[@class='ok']"));
        okButton.click();
        Thread.sleep(2000);
    }*/

    public String getDeletePlaylistMessage(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


    public String getThirdPlaylistName() {
        return thirdPlaylistName.getText();
    }

    public void unselectAllFavorites() throws InterruptedException {
        int size = likedSongs.size();
        for (int i = size-1; i >= 0; i--) {
            likedSongs.get(i).click();
            Thread.sleep(1000);
        }
    }
}
