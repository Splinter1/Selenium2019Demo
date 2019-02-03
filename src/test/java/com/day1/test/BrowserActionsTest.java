package com.day1.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserActionsTest{
    /**
     * 打开chrome
     * 打开百度
     * 等待5秒
     * 关闭浏览器
     */
    WebDriver driver;
//    @BeforeTest
//    public void open(){
//        openTheChrome.openChrome();
//    }




    @Test
    public void closeChrome1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void closeChrome2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        //浏览器后退
        driver.navigate().back();
        //等待3秒
        Thread.sleep(3000);
        //浏览器前进
        driver.navigate().forward();
        //等待3秒
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void freshBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        //刷新浏览器
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void SizeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        //设置浏览器大小
        Dimension dimension = new Dimension(1366,768);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //最大化浏览器
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void getUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        //刷新浏览器
        String Url = driver.getCurrentUrl();
        Thread.sleep(3000);
        driver.quit();
        System.out.println(Url);
        Assert.assertEquals(Url,"https://www.baidu.com/");
    }


}


