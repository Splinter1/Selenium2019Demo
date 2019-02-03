package com.day2.test;

import com.day1.test.openTheChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Wait {
    WebDriver driver;

    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
        //全局等待
        //当元素没找到时，等待10秒，若10秒后找到了就立即向下走
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //显示等待
        //连续等待需要找的值，等待最多10秒
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
    }

    @Test
    public void select(){
        driver.get("http://baidu.com/");



    }




    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
