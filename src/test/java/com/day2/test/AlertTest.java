package com.day2.test;

import com.day1.test.openTheChrome;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;
    @BeforeTest
    public void open(){
        driver = openTheChrome.openChrome();
    }

    @Test
    public void AlertClick(){
        driver.get("");
        driver.findElement(By.className("")).click();
        //switchTo代表控制权移交,移交之前建议先线程等待alert  1秒钟
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    //此弹窗先先点击取消按钮，再次点击确定按钮
    public void Confirm(){
        driver.get("");
        driver.findElement(By.className("")).click();
        Alert alert = driver.switchTo().alert();
        //此为取消按钮
        alert.dismiss();
        //再次点击时，建议线程沉睡1秒
        alert.accept();
    }

    @Test
    //此弹窗需要输入文字再次点击确定按钮
    public void Prompt(){
        driver.get("");
        driver.findElement(By.className("")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("此为输入文本");
        alert.accept();
    }

    @Test
    //此弹窗会有文字，此方法用于获取文本
    public void getText(){
        driver.get("");
        driver.findElement(By.className("")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
    }



    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
