package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class Task2Test {
    @Test
    public void Task2Test() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        webDriver.get("https://pl.wikipedia.org/wiki/Wiki");
        WebElement languageButton = webDriver.findElement(By.id("p-lang-btn-checkbox"));
        languageButton.click();
        List<WebElement> languages = webDriver.findElements(By.xpath("//a[@class='autonym']"));
        for (WebElement language : languages) {
            String languageName = language.getText();
            String languageUrl = language.getAttribute("href");

            System.out.println(languageName);

            if (languageName.equalsIgnoreCase("English")) {
                System.out.println(": " + languageUrl);
            }
        }

    }
}

        


