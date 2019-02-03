package com.day3.test;

import com.day1.test.openTheChrome;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class JSTest {
    WebDriver driver;

    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    public void exJS() {
        driver.get("http://baidu.com/");
        //强制将drive转换成JS
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //运行JS脚本
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"qwe\")");
    }



    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
