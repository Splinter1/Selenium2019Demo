package com.day2.test;

import com.day1.test.openTheChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest2 {
    WebDriver driver;

    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    public void rightClick(){
        driver.get("http://baidu.com/");
        WebElement buttenbaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        //下方为点击事件，需要先把上方的搜索按钮传进去，perform一定要用哦
        actions.contextClick(buttenbaidu).perform();
    }

    @Test
    public void move(){
        driver.get("http://baidu.com/");
        //xpath语法：找到关于更多产品的text,并且定位！
        WebElement buttenbaidu = driver.findElement(By.xpath("//*[text()='更多产品']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttenbaidu).perform();
    }

    @Test
    public void moreSelect(){
        driver.get("http://baidu.com/");
        driver.get("");
        WebElement select = driver.findElement(By.id(""));
        List<WebElement> list = driver.findElements(By.id(""));

        Actions actions = new Actions(driver);
        //按住Shift，点击第一个选项，点击第三个选项，松开Shift
        actions.keyDown(Keys.SHIFT).click(list.get(0)).
                                    click(list.get(2)).
                                    keyUp(Keys.SHIFT).
                                    perform();
    }

    @Test
    public void saveHtml() throws AWTException {
        driver.get("http://baidu.com/");
        Robot  robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);

        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Test
    public  void  Updata (){
        driver.get("http://baidu.com/");
        driver.findElement(By.className("soutu-btn")).click();

        driver.findElement(By.className("upload-pic")).sendKeys("C:\\Users\\dajiba\\Desktop\\ae5d857d97752cbd5e663c4e7c9f95e.jpg");

    }


    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
