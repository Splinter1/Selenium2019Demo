package com.day3.test;

import com.day1.test.openTheChrome;
import com.po.page.regist;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    WebDriver driver;

    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://mail.163.com/");
    }

    @Test
    public void openRegister() throws InterruptedException {
        Thread.sleep(5000);
        String handle1 = driver.getWindowHandle();

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        //运行JS脚本
//        js.executeScript("document.getElementsByTagName(\"iframe\")[0].name=122");


        driver.switchTo().frame(0);
        driver.findElement(regist.register) .click();
        //移交窗口控制权
        for(String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
           driver.switchTo().window(handles);
        }
        String title = driver.getTitle();
        Assert.assertEquals(title,"注册网易免费邮箱 - 中国第一大电子邮件服务商");
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
