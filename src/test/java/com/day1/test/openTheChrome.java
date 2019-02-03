package com.day1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openTheChrome {
    public static WebDriver openChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        return new ChromeDriver();
    }
}
