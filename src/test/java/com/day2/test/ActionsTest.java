package com.day2.test;

import com.day1.test.openTheChrome;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.Element;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class ActionsTest {
    WebDriver driver;

    @BeforeTest
    public void open(){

        driver = openTheChrome.openChrome();
//        System.setProperty("webdriver.chrome.driver", "F:\\selenium学习\\Selenium_Project\\drivers\\chromedriver.exe");//指定驱动路径
//        driver = new ChromeDriver();
    }

    @Test
    public void closeChrome1(){
        driver.get("https://www.baidu.com/");
//      先拿到右上角CSS的几个，然后根据下标执行
        List<WebElement> links;
        links = driver.findElements(By.className("mnav"));
        for(int i=0; i<links.size(); i++){
            System.out.println(links.get(i).getText());
        }
        links.get(2).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://map.baidu.com/");
    }

    @Test
    public void search(){
        driver.get("https://www.baidu.com/");
        driver.findElement((By.id("kw"))).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        //搜索完毕页面跳转
        String text = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"Selenium - Web Browser Automation");
    }

    @Test
    public void getValue(){
        driver.get("https://www.baidu.com/");
        //getAttribute代表传入某个属性的名字，并且获取他的值
        String value = driver.findElement(By.id("su")).getAttribute("value");
        System.out.println(value);
        Assert.assertEquals(value,"百度一下");
    }

    @Test
    public void isDisplayed(){
        driver.get("https://www.baidu.com/");
        //getAttribute代表传入某个属性的名字，并且获取他的值
        Boolean bl = driver.findElement(By.id("su")).isDisplayed();
        System.out.println(bl);
        Assert.assertTrue(bl);
    }

//    @Test
//    public void update() throws InterruptedException {
//        driver.get("http://dc.anosi.cn/#/register");
//        driver.findElement(By.xpath("//*[@id=\"companyForm\"]/div[8]/div/div[1]/div")).sendKeys("C:\\Users\\dajiba\\Desktop\\ae5d857d97752cbd5e663c4e7c9f95e.jpg");
//
//
//    }

    //截图百度首页
    @Test
    public void screen(){
        driver.get("https://www.baidu.com/");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(file,new File("D:\\test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
