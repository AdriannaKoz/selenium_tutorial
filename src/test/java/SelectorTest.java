import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By buttonId = By.id("clickOnMe"); //dedykowana metoda statyczna
        //element WebElement
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname
        By firstName = By.name("fname");
        WebElement fistNameInput = driver.findElement(firstName);
        driver.findElement(By.name("fname")); //- dopuszczalny, można też:
        //WebElement fistNameInput = driver.findElement(By.name("fname"));
        //topSecret - <p hidden="" class="topSecret">This paragraph should be hidden.</p> - ukryty selektor, ale selenium go widzi

        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden); // można też tak  WebElement paraHiddenClass = driver.findElement(paraHidden);

        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator); // wypluje listę inputów
        System.out.println(inputs.size());

        By linkText = By.linkText("Visit W3Schools.com!"); // podaje się wartość stąd: <a href="https://www.w3schools.com">Visit W3Schools.com!</a>
        WebElement schoolLink = driver.findElement(linkText);

        //znalezienie części testu

        By partialLink = By.partialLinkText("Visit");
        WebElement schoolPartial = driver.findElement(partialLink);

    }
}
