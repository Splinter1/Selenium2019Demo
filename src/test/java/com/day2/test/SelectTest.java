package com.day2.test;

import com.day1.test.openTheChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectTest {
    WebDriver driver;
    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
    }

    @Test
    public void select(){
        driver.get("chrome://settings/");
        WebElement selectEl = driver.findElement(By.id("zoomLevel"));
        Select select = new Select(selectEl);
        //通过索引选取
        select.selectByIndex(1);
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
