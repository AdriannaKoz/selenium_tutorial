import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingTestSelector {

    @Test
        public void bookingSelectorTestDevTools() throws IOException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://www.booking.com/index.pl.html");
        WebElement herobanner = driver.findElement(By.cssSelector("[data-testid='herobanner-subtitile']"));
        WebElement reject = driver.findElement(By.id("onetrust-reject-all-handler"));
        WebElement wyszukiwarka = driver.findElement(By.name("ss"));
        WebElement zameldowanie = driver.findElement(By.cssSelector("[data-testid=\"date-display-field-start\"]"));
        WebElement search = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        reject.click();
        herobanner.click();
        actions.doubleClick(herobanner);
        //herobanner.sendKeys(Keys.CONTROL, "a"); sendkeys nie działa, bo element jest nieedytowalny
        wyszukiwarka.click();
        wyszukiwarka.sendKeys("Warszawa");
        zameldowanie.click();
        WebElement dataTrzeciCzerwca = driver.findElement(By.cssSelector("[aria-label=\"Wt 3 czerwiec 2025\"]"));
        dataTrzeciCzerwca.click();
        WebElement dataPiatyCzerwca = driver.findElement(By.cssSelector("[aria-label=\"Cz 5 czerwiec 2025\"]"));
        dataPiatyCzerwca.click();
        search.click();
        WebElement closeWindow = driver.findElement(By.cssSelector("[aria-label=\"Zamknij okno logowania.\"]"));
        closeWindow.click();
        WebElement firstOption = driver.findElement(By.linkText("Zobacz dostępność"));
        firstOption.click();
        //actions.doubleClick(search);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss");
        String timestamp = now.format(formatter);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File booking = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/test/resources/booking" + timestamp + ".png");
        FileUtils.copyFile(booking, destinationFile);
        //driver.quit();


    }
}
