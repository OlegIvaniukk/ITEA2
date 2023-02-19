package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new LoginPage(driver);
    }
}
