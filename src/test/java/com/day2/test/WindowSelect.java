package com.day2.test;

import com.day1.test.openTheChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WindowSelect {
    WebDriver driver;
    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
    }

    @Test
    public void select(){
        driver.get("http://news.baidu.com/");
        //获取当前窗口句柄
        String handle1 = driver.getWindowHandle();
        driver.findElement(By.id("imgplayer")).click();
//        driver.switchTo().window(handle1);
//        driver.findElement(By.id("ww")).sendKeys("ww");
        //控制权移交给新的窗口
        for(String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
            String title = driver.getTitle();
            System.out.println(title);
    }




    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
