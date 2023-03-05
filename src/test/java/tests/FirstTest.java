package tests;

import Pages.HomePage;
import Pages.IssuesPage;
import Pages.LoginPage;
import Pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void mainTest() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfullLogin("ep.olejan777@gmail.com", "Ivaniuk1598753");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToIssuesPage();
        IssuesPage issuesPage = new IssuesPage(driver);
        Assertions.assertEquals("No results matched your search.", issuesPage.getText());
    }
}
