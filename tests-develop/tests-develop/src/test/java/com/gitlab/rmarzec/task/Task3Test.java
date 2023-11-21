package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Task3Test {

    @Test
    public void Task3Test() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        webDriver.get("https://www.google.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement acceptAllButton = webDriver.findElement(By.id("L2AGLb"));
        acceptAllButton.click();
        WebElement inputField = webDriver.findElement(By.id("APjFqb"));
        inputField.sendKeys("HTML select tag - W3Schools");
        WebElement getLuckyButton = webDriver.findElement(By.name("btnI"));
        //Kliknięcie przycisku "Szczęśliwy traf" przy pomocy JavaScriptExecutora (sugestia zasłania przyciski)
        ((JavascriptExecutor) webDriver).executeScript("document.querySelector('div.aajZCb').style.display='none';");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", getLuckyButton);
        WebElement acceptCookies = webDriver.findElement(By.id("accept-choices"));
        acceptCookies.click();
        String pageUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(pageUrl, "https://www.w3schools.com/tags/tag_select.asp");
        WebElement tryItYourselfButton = webDriver.findElement(By.cssSelector("a.w3-btn.w3-margin-bottom"));
        tryItYourselfButton.click();
        //Zmiana karty
        Set<String> windows = webDriver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        webDriver.switchTo().window(childId);
        //Zmiana iframe
        webDriver.switchTo().frame(webDriver.findElement(By.id("iframeResult")));
        WebElement header = webDriver.findElement(By.xpath("//body/h1"));
        String headerText = header.getText();
        System.out.println(headerText);
        WebElement dropDownButton = webDriver.findElement(By.id("cars"));
        Select dropDown = new Select(dropDownButton);
        dropDown.selectByValue("opel");
        WebElement selectedOption = webDriver.findElement(By.xpath("//select/option[3]"));
        String name = selectedOption.getText();
        String value = selectedOption.getAttribute("value");
        System.out.println(name + ", " + value);
        Assert.assertTrue(name.equals("Opel"));
        Assert.assertTrue(value.equals("opel"));


        webDriver.quit();


    }
}
