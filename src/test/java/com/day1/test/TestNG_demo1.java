package com.day1.test;

import org.testng.annotations.*;

public class TestNG_demo1 {
    @BeforeTest
    public void beforeTest1(){
        System.out.println("这是@beforeTest注解");
    }

    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("这是@beforeMethod注解");
    }

    @Test
    public  void testCase1(){
        System.out.println("这是@Test注解");
    }
    @Test
    public  void testCase2(){
        System.out.println("这是@Test注解2");
    }

    @AfterTest
    public  void afterTest(){
        System.out.println("这是@afterTest注解1");
    }

    @AfterMethod
    public  void afterMethod(){
        System.out.println("这是@afterMethod注解1");
    }
}
