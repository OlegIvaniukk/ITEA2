package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private WebElement issuesPage = driver.findElement(By.xpath("//a[@aria-label='Issues you created']"));

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public IssuesPage goToIssuesPage() {
        issuesPage.click();
        return new IssuesPage(driver);
    }
}
