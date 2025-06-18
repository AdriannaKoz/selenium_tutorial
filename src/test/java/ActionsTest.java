import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActionsTest {
    @Test
    public void  uploadFile() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");


        Actions actions = new Actions(driver);
        //actions.contextClick().perform(); //klik prawym przyciskiem
        //actions.contextClick(driver.findElement(By.id("myFile"))).perform(); //klik prawym przyciskiem w konkretnym elemencie
        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform();
    }
}
