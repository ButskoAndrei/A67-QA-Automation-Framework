package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SongsPage extends BasePage {

    @FindBy(xpath = "//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")
    WebElement firstSong;
    @FindBy(css = ".playback")
    WebElement playBtn;
    @FindBy(css = ".items [draggable='true'] .fa-heart-o")
    WebElement unlikedSong;
    @FindBy(css = ".items .song-item:nth-of-type(1) .title")
    WebElement songTitle;

    public SongsPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstSong() {
        actions.contextClick(firstSong).perform();
        playBtn.click();
    }

    public String getSongTitle(){
        return songTitle.getText();
    }

    public void addSongToFav(){
        unlikedSong.click();
    }

    public void clickAllSongs() {
        By nextButtonLocator = By.xpath("//div[@class='side player-controls']//i[@class='next fa fa-step-forward control']");
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        driver.findElement(nextButtonLocator).click();
    }

    public void moveToSidePanelControl(){
        WebElement playerControls = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".side.player-controls")));
        actions.moveToElement(playerControls).perform();
    }

    public void clickNextSong() {
        By playButtonLocator = By.xpath("//div[@class='side player-controls']//i[@class='next fa fa-step-forward control']");
        wait.until(ExpectedConditions.elementToBeClickable(playButtonLocator));
        driver.findElement(playButtonLocator).click();

    }

    public void clickPlaySong() {
        By playButtonLocator = By.xpath("//span[@title='Play or resume']");
        wait.until(ExpectedConditions.elementToBeClickable(playButtonLocator));
        driver.findElement(playButtonLocator).click();

    }

    public boolean visibleSoundBar(){
        try {
            By soundBarLocator = By.xpath("//div[@class='media-info-wrap']//img[@alt='Sound bars']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarLocator));
            return driver.findElement(soundBarLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Helper method for searching songs
    public void searchSong(String songName) {
        // Wait for page to fully load
        By searchInputLocator = By.cssSelector("input[type='search']");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchInputLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputLocator));

        WebElement searchInput = driver.findElement(searchInputLocator);
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));

        searchInput.clear();
        searchInput.sendKeys(songName);

    }
    // Click View All button
    public void clickViewAllButton() {
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }

    public void clickAddToBtn() {
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[class='btn-add-to']")
        ));
        addToButton.click();
    }

    public void clickChoosePlaylist() {
        WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@id='songResultsWrappers']//li[contains(text(),'Test')]")));
        choosePlaylist.click();
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".notification-content")
        ));
        return notification.getText();
    }

}
