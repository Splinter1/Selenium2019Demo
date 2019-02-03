package com.day1.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

    //校验a==a；
    @Test
    public void asserEqualTest(){
        String a = "asd";
        String b = "asd1";

        Assert.assertEquals(a,b,"message代码");
    }
    @Test
    public  void asserNotEqualtest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }

}
