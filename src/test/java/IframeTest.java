import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class IframeTest {

    @Test
    public void testNewWindow(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));//szukamy atrybutu, który ma src...
        driver.switchTo().frame(iframe);
        //driver.switchTo().frame(0);// - po indeksie wejście do iFrame'a
        driver.findElement(By.id("fname")).sendKeys("Ada");
        driver.switchTo().defaultContent(); //powrót
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }
}
