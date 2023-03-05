package tests;


import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        BasicConfigurator.configure();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\ITEA2\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
