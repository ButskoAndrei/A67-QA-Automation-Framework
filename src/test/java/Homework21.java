import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist() {

        String playlistName = "Test";
        String newPlaylistName = "Test 1";
        String updatedPlaylistMsg = "Updated playlist \"Test 1.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        //homePage.clickAddNewPlaylist();
        //homePage.clickNewPlaylistBtn();
        //homePage.setNewPlaylistName(playlistName);
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getNotificationMsg(),updatedPlaylistMsg);
    }
}
