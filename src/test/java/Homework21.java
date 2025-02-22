import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest{

    String playlistName = "Test";
    String newPlaylistName = "Test 1";

    @Test
    public void renamePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        String updatedPlaylistMsg = "Updated playlist \"Test 1.\"";

        loginPage.provideEmail("andrei.butsko@testpro.io").providePassword("SignZ1ex").clickSubmit();
        homepage.clickAddNewPlaylist();
        homepage.clickNewPlaylistBtn();
        homepage.setPlaylistName(playlistName);
        Thread.sleep(6000);
        homepage.doubleClick(By.cssSelector(".playlist:nth-child(3)"));
        homepage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(getNotificationMsg(),updatedPlaylistMsg);
    }




}
