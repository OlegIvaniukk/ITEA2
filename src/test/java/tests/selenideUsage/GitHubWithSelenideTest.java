package tests.selenideUsage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

@Listeners({ScreenShooter.class})
public class GitHubWithSelenideTest extends BaseTest {

    @Test
    public void successfulLogin() {
        open("https://github.com/login");
        $(By.id("login_field")).sendKeys("ep.olejan777@gmail.com");
        $(By.id("password")).sendKeys("Ivaniuk1598753");
        $(By.xpath("//input[@type='submit']")).click();
        $(By.xpath("//summary[@aria-label='View profile and more']")).shouldBe(Condition.visible);
        screenshot("screenshotName");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] credsData() {
        return new Object[][]{
                {"login1", "password1"},
                {"login2", "password2"},
                {"login3", "password3"},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void failedLogin(String login, String password) {
        open("https://github.com/login");
        $(By.id("login_field")).sendKeys(login);
        $(By.id("password")).sendKeys(password);
        $(By.xpath("//input[@type='submit']")).click();
        $(By.xpath("//div[contains(text(), 'Incorrect')]")).shouldHave(Condition.text("Incorrect username or password."));
    }
}
