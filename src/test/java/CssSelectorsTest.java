import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
    public void findElements (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe"); //jeśli chcemy znaleźć element css zdefiniowany jako id musimy użyć #
        driver.findElement(cssId);

        //druga metoda
        By cssClass = By.cssSelector(".topSecret"); //zastąpienie klasy selektorem css - . na początku
        driver.findElement(cssClass);

        //trzecia metoda
        By cssTag = By.cssSelector("input"); //tag (input) nie wymaga niczego extra
        driver.findElement(cssTag).sendKeys("Pierwszy"); //wprowadzenie wartości do pierwszego elementu

        //znalezienie fname (id inputu) <label for="fname"> First name:</label>
        By cssName = By.cssSelector("[name='fname']"); //zamiast name może być href albo class i wtedy np. "[class='topSecret']"
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']"); //zamiast name może być href albo class i wtedy np. "[class='topSecret']"
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElement(all);

        By ulInsideDiv = By.cssSelector("div ul"); //pierwsze li naszej listy
        By trInTable = By.cssSelector("table tr"); //szukamy w całym table, a nie tylko w tbody
        By trInBody = By.cssSelector("tbody tr"); // szukamy tylko w tbody

        driver.findElement(ulInsideDiv);
        driver.findElement(trInTable);
        driver.findElement(trInBody);

        //pierwszy ul, który jest dzieckiem div
        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody >tr");

        driver.findElement(firstChildUlInDiv);
        driver.findElement(firstChildTrInTbody);

        //pierwszy tag form zaraz po label
        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");

        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormsAfterLabel);

        //
        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");
        By attrEnds = By.cssSelector("[name$='name']");
        By attrStarts = By.cssSelector("[name^='f']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrEnds);
        driver.findElement(attrStarts);

        //konkretne dzieci
        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By thirdChild = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);

    }
}
