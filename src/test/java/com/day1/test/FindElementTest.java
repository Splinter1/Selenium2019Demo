package com.day1.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementTest {
    WebDriver driver;

    @BeforeTest
     public void openChrome(){
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        driver = new ChromeDriver();
    }

    @Test
    public void findId() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(5000);
        WebElement keyField = driver.findElement(By.id("su"));
    }






    @AfterTest
    public void quitChrome(){
        driver.quit();
    }
}
