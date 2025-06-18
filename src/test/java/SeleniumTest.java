import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {

        WebDriver driver = getDriver("chrome", false);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //przejście do okna z plikami cookies - usunięte, bo google coś zmieniło
        driver.switchTo().frame(0);
        // znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        //kliknięcie na przycisk
        agreeButton.click();
        //powrót do pierwotnego okna
        driver.switchTo().defaultContent();
        //znajdź pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        //wprowadź wartośc "Selenium do pola"
        searchField.sendKeys("Selenium");
        //zasymuluj naciśnięcie enter
        searchField.sendKeys(Keys.ENTER);
        //znakeźć rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
        //Assercja, czy znaleziono element (true)
        Assert.assertTrue(result.isDisplayed());


    }

    public WebDriver getDriver(String browser, boolean headless) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                if (headless) chromeOptions.addArguments("--headless=new");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                if (headless) firefoxOptions.addArguments("--headless=new");
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                if (headless) edgeOptions.addArguments("--headless=new");
                return new EdgeDriver(edgeOptions); // <
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
