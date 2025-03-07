package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email){

        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){

        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
        return this;
    }

    public LoginPage login(String email, String password) {
        return provideEmail(email).providePassword(password).clickSubmit();
    }
}
