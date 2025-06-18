package pl.testeroprogramowania;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SecondTest2 extends BaseTest {
        WebDriver driver;
        @Test
        public void waitTest() throws InterruptedException {
            driver = new ChromeDriver();
            //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
            driver.findElement(By.id("clickOnMe")).click();
            //  Thread.sleep(5000);
            //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // WebElement para = driver.findElement(By.cssSelector("p"));
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofSeconds(10));
            wait.ignoring(NoSuchElementException.class);
            wait.pollingEvery(Duration.ofSeconds(1));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));

            // driver.findElement(By.cssSelector("p"));

            waitForElementToExist(By.cssSelector("p"));


            String paraText = driver.findElement(By.cssSelector("p")).getText();
            Assert.assertEquals(paraText, "Dopiero się pojawiłem!"); //sprawdzamy, czy tekst sie zgadza
            driver.quit();
        }



        public void waitForElementToExist(By locator) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.ignoring(NoSuchElementException.class);
            wait.withTimeout(Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofSeconds(1));


            wait.until((driver) -> {
                List<WebElement> elements = driver.findElements(locator);
                if(elements.size()>0){
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Elementu nie ma na stronie");
                    return false;
                }

            });



        }

    }
