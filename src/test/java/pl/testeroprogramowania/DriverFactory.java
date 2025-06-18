package pl.testeroprogramowania;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    static WebDriver getDriver() {
        if(driver==null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

}
