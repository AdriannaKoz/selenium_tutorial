import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {
    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        By buttonId = By.xpath("//button[@id='clickOnMe']"); //dedykowana metoda statyczna
        //element WebElement
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement fistNameInput = driver.findElement(firstName);
        driver.findElement(By.name("fname")); //- dopuszczalny, można też:
        //WebElement fistNameInput = driver.findElement(By.name("fname"));
        //topSecret - <p hidden="" class="topSecret">This paragraph should be hidden.</p> - ukryty selektor, ale selenium go widzi

        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden); // można też tak  WebElement paraHiddenClass = driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator); // wypluje listę inputów
        System.out.println(inputs.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']"); // podaje się wartość stąd: <a href="https://www.w3schools.com">Visit W3Schools.com!</a>
        WebElement schoolLink = driver.findElement(linkText);

        //znalezienie części testu

        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement schoolPartial = driver.findElement(partialLink);

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortpath = By.xpath("//ul");
        driver.findElement(shortpath);

        By seconElement = By.xpath("(//input)[2]");
        driver.findElement(seconElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        //dowolny elemenyt z name; findelement, bo jesli jest więcej elementów to element wyrzuci błąd
        By elementWithAtribute = By.xpath("//*[@name]");
        driver.findElements(elementWithAtribute);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//button[@id!='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name, 'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name, 'user')]");
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']");

        driver.findElement(attrEq);
        driver.findElements(attrNotEq);
        driver.findElements(attrCont);
        driver.findElements(startsWith);
        driver.findElements(endsWith);

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::ul");
        By parent = By.xpath("//div/..");
        By anc = By.xpath("//div/ancestor::body");
        By foll = By.xpath("//img/following::*");
        By follSib = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*");
        By precSin = By.xpath("//img/preceding-sibling::*");

        driver.findElements(child);
        driver.findElements(desc);
        driver.findElements(parent);
        driver.findElements(anc);
        driver.findElements(foll);
        driver.findElements(follSib);
        driver.findElements(prec);
        driver.findElements(precSin);

        By divAndLinks = By.xpath("//a | //div");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='name' or @id='fname']");

        driver.findElement(divAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);


    }
}
