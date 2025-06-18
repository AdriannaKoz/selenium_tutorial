package pl.testeroprogramowania;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = {SampleTestListener.class})
public class FirstTest extends BaseTest {

    WebDriver driver;
    @Test
    public void firstTest() throws InterruptedException {
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

        WebElement para = driver.findElement(By.cssSelector("p"));
        //String paraText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertTrue(para.isDisplayed());
        Assert.assertTrue(para.isDisplayed(), "element is not displayed"); //z wiadomością w przypadku niepojawienia
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("pojawiłem"));
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!"); //sprawdzamy, czy tekst sie zgadza
        //Assert.assertEquals(para.getText(), "Dopiero", "Teksty są różne"); //druga wartość tekstowa -> wiadomość, że teksty są różne
        //Gdy jest błąd na asercji - test nie jest kontynuowany
        driver.quit();
    }

    @Test @Ignore
    public void secondTest() throws InterruptedException {
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

        SoftAssert softAssert = new SoftAssert();
        WebElement para = driver.findElement(By.cssSelector("p"));
        //String paraText = driver.findElement(By.cssSelector("p")).getText();
        softAssert.assertEquals(para.isDisplayed(), true);
        softAssert.assertTrue(para.isDisplayed());
        softAssert.assertTrue(para.isDisplayed(), "element is not displayed"); //z wiadomością w przypadku niepojawienia
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("pojawiłem"));
        softAssert.assertEquals(para.getText(), "Dopiero się pojawiłe", "Pierwsza assercja"); //sprawdzamy, czy tekst sie zgadza
        softAssert.assertEquals(para.getText(), "Dopiero", "Teksty są różne"); //druga wartość tekstowa -> wiadomość, że teksty są różne
        driver.quit();
        softAssert.assertAll();

    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));


//        wait.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                List<WebElement> elements = driver.findElements(locator);
//                if(elements.size()>0){
//                    System.out.println("Element jest na stronie");
//                    return true;
//                } else {
//                    System.out.println("Elementu nie ma na stronie");
//                    return false;
//                }
//
//            }
//        });


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
