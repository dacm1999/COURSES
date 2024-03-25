package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {


    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach excuses before the execution of each test method");
    }
    @AfterEach
    void tearDownAfterEach(){
        System.out.println("Running @AfterEach");
        System.out.println("");
    }

    @BeforeAll
    static void setupBeforeEachClass(){
        System.out.println("@BeforeAll excuses only once before all test method execution in the class");
    }
    @AfterAll
    static void setupAfterAll(){
        System.out.println("@AfterAll excuses only once after all test methods execution in the class");
    }
    
    @Test
    void testEqualsAndNotEquals(){

        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2,4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1,9), "1+9 must not be 6");
    }
    @Test
    void testNullAndNotNull(){
        System.out.println("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "DanielContreras";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should n be null");

    }
}
