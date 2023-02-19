package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IssuesPage extends BasePage {
    private WebElement emptyIssuesTab = driver.findElement(By.xpath("//h3[text()='No results matched your search.']"));

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        String result = emptyIssuesTab.getText();
        return result;
    }
}
