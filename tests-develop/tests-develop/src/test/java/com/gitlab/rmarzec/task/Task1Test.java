package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Task1Test {

    @Test
    public void Task1Test() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        webDriver.get("https://www.onet.pl/");
        String pageTitle = webDriver.getTitle();
        Assert.assertEquals(pageTitle, "Onet – Jesteś na bieżąco");
    }
}
