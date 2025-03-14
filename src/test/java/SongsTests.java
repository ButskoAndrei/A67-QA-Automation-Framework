import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongsPage;
import java.net.MalformedURLException;

public class SongsTests extends BaseTest {
    private LoginPage loginPage;
    private SongsPage songsPage;
    private PlaylistPage playlistPage;
    private final String username = "andrei.butsko@testpro.io";
    private final String password = "SignZ1ex";

    @BeforeMethod
    public void setUpBrowser(){
        // Call the parent class's setup method to initialize the driver properly
        super.setUpBrowser();

        // Initialize page objects using the driver from BaseTest
        loginPage = new LoginPage(driver);
        songsPage = new SongsPage(driver);
        playlistPage = new PlaylistPage(driver);
    }

    @Test
    public void addSongToPlaylist() {
        // Step 1: Log in to the application
        loginPage.login(username,password);

        // Define test data and expected outcomes
        final String playlistName = "Test";
        final String songToSearch = "Pluto";
        final String expectedMessage = "Added 1 song into \"" + playlistName + "\" ";

        songsPage.searchSong(songToSearch);
        songsPage.clickViewAllButton();
        songsPage.clickFirstSong();
        songsPage.clickAddToBtn();
        playlistPage.createNewPlaylist(playlistName);
        //songsPage.clickChoosePlaylist();

          // Assert that the notification matches the expected message
        Assert.assertEquals(songsPage.getAddToPlaylistSuccessMsg(), expectedMessage,
                "Notification message doesn't match expected message");

    }

    @Test
    public void playSong() {
        // Log in to the application
        loginPage.login(username, password);
        songsPage.moveToSidePanelControl();
        songsPage.clickNextSong();
        songsPage.moveToSidePanelControl();
        songsPage.clickPlaySong();

        // Verify sound bar is visible
        Assert.assertTrue(songsPage.visibleSoundBar(),
                "Sound bar should be visible when song is playing");
    }


}
