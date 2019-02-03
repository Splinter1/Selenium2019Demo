package com.day1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowerTest {

    @Test
    public void closeChrome(){
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        //关闭当前窗口
        driver.close();
    }

    @Test
    public void closeChrome2(){
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        //关闭浏览器，并且不残留进程
        driver.quit();
    }


}
