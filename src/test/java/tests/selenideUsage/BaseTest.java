package tests.selenideUsage;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1000";
        Configuration.headless = false;
    }

    @AfterMethod
    public void treetDown(){
        Selenide.closeWebDriver();
    }



}
