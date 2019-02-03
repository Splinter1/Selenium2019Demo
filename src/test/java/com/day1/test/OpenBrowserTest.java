package com.day1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    @Test
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openFF1() {
        //此条程序有错，待调试
        System.setProperty("webdriver.firefox.bin", "F:\\Develop\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
    }
}
