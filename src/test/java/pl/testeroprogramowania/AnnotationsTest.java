package pl.testeroprogramowania;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationsTest {
    @FindBys({
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th")
    }) //FindBys musi być nad listą
    List<WebElement> elements;

    @FindAll({
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th")
    }) //FindBys musi być nad listą
    List<WebElement> elements1;

    @Test
    public void performAction() {
        WebDriver driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        System.out.println(elements.size());
        System.out.println(elements1.size());
    }
}
