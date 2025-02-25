import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() {


        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test 1.\"";

        String username = "andrei.butsko@testpro.io";
        String password = "SignZ1ex";

        HomePage homepage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(username).providePassword(password).clickSubmit();
        clickChoosePlaylist();
        clickDeleteBtn();
        //clickOkButton();
        Assert.assertEquals(homepage.getNotificationMsg(),expectedPlaylistDeleteMessage);

    }

    public void clickChoosePlaylist() {
        WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@id='sidebar']//a[contains(text(),'Test 1')]")));
        choosePlaylist.click();
    }

    public void clickDeleteBtn() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-test='song-list-controls']//button[@title='Delete this playlist']")));
        deleteBtn.click();
    }

    /*public void clickOkButton() throws InterruptedException {
        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElement(By.xpath("//div[@class='dialog']//button[@class='ok']")));
        okButton.click();
    }*/


}
