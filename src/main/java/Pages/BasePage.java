package Pages;

import org.openqa.selenium.WebDriver;


abstract public class BasePage {
    protected WebDriver driver;

//    private String titel;
//
//    protected Logger log;

    public BasePage(WebDriver driver) {
        this.driver = driver;
//        this.titel = titel;
//        this.titel = titel;
//        this.log = LogManager.getLogger(this.titel);
    }
}
