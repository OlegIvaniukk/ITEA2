package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private WebElement loginField = driver.findElement(By.id("login_field"));
    private WebElement pwField = driver.findElement(By.id("password"));
    private WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage successfullLogin(String login, String password) {
        loginField.sendKeys(login);
        pwField.sendKeys(password);
        signIn.click();
        return new MainPage(driver);
    }
}
