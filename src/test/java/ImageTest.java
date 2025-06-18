import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

    WebDriver driver;
    @Test
    public void elementExistTest() {
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement image = driver.findElement(By.tagName("img"));
        //System.out.println(image.getAttribute("naturalHeight"));

        String height = image.getAttribute("naturalHeight");

        Assert.assertEquals("0",height);

    }

}
