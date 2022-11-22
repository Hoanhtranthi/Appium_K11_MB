package src.tests.testng;

import org.testng.annotations.*;

public class TestNGHooksTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\tBeforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\tBeforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\tBeforeMethod");
    }

    @Test
    public void A1(){
        System.out.println("\t\t\t\tA1");
    }

    @Test
    public void A2(){
        System.out.println("\t\t\t\tA2");
    }
}
