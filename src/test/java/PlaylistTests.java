import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

import java.net.MalformedURLException;

import static java.sql.DriverManager.getDriver;

public class PlaylistTests extends BaseTest {

    String playlistName = "Test";
    String newPlaylistName = "Test 1";

    private LoginPage loginPage;
    private HomePage homePage;
    private PlaylistPage playlistPage;

    @BeforeMethod(dependsOnMethods = "setUpBrowser")
    public void setupPageObjects(){
        // Initialize page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        playlistPage = new PlaylistPage(driver);
    }

    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"Test 1.\"";

        loginPage.provideEmail("andrei.butsko@testpro.io").providePassword("SignZ1ex").clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img.avatar")));
        homePage.clickAddNewPlaylist();
        homePage.clickNewPlaylistBtn();
        homePage.setPlaylistName(playlistName);
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".playlist:nth-child(3)")));
        homePage.doubleClick(By.cssSelector(".playlist:nth-child(3)"));
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getNotificationMsg(),updatedPlaylistMsg);
    }

    @Test
    public void deletePlaylist() {

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test 1.\"";

        loginPage.provideEmail(username).providePassword(password).clickSubmit();
        // Wait for complete login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img.avatar")));
        playlistPage.clickChoosePlaylist();
        playlistPage.clickDeleteBtn();
        //clickOkButton();
        Assert.assertEquals(playlistPage.getDeletePlaylistMessage(),expectedPlaylistDeleteMessage);

    }




}

