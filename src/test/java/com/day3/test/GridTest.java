package com.day3.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException,InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        WebDriver driver = new RemoteWebDriver(new URL("http://10.119.11.74:4444/wd/hub"),dc);

        driver.get("http://baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
//                {"ie"},
                {"chrome"}};
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws  MalformedURLException,InterruptedException{
        DesiredCapabilities dc = null;
        if (browser .contentEquals("firefox")) {
            dc = DesiredCapabilities.firefox();
        }else if(browser.contentEquals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else if(browser.contentEquals("ie")){
            dc = DesiredCapabilities.internetExplorer();
        }

        WebDriver driver = new RemoteWebDriver(new URL("http://10.119.11.74:4444/wd/hub"),dc);

        driver.get("http://baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }



}
