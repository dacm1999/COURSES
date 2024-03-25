package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class DemoUtilsTest {


    DemoUtils demoUtils;


    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals and not equals")
    void testEqualsAndNotEquals(){
        assertEquals(6, demoUtils.add(2,4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1,9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and NotNull")
    void testNullAndNotNull(){
        String str1 = null;
        String str2 = "DanielContreras";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should n be null");

    }


//    @AfterEach
//    void tearDownAfterEach(){
//        System.out.println("Running @AfterEach");
//        System.out.println("");
//    }
//
//    @BeforeAll
//    static void setupBeforeEachClass(){
//        System.out.println("@BeforeAll excuses only once before all test method execution in the class");
//    }

//    @AfterAll
//    static void setupAfterAll(){
//        System.out.println("@AfterAll excuses only once after all test methods execution in the class");
//    }
}
