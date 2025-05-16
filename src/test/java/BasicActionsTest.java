import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        driver.findElement(By.id("fname")).sendKeys("Adrianna");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear(); //czyszczenie pola
        usernameInput.sendKeys("admin"); //jeśli nie wyczyścimy pola, które ma już tekst (tj. jeśli nie jest puste), tekst zostanie dopisany do tego, który już jest
        //usernameInput.sendKeys(Keys.ENTER);
        usernameInput.sendKeys(Keys.TAB); //ponowne kliknięcie nic nie zmienie, bo jesteśmy w polu usernameInput - żeby przejśc dalej, musilibyśmy znaleźć input "hasło" i następnie kliknąc "Tab"

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='female']")).click();

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        //klasa do obsługiwania selectów w Selenium
        Select cars = new Select(selectCar); //ta klasa dostarcza nam pewne metody
        cars.selectByIndex(2); //po indexie - numeracja od 0
        cars.selectByContainsVisibleText("Saab"); //po tekście w selectach
        cars.selectByValue("volvo"); //po value <option value="volvo">Volvo</option>

        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }
}
