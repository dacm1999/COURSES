package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
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

    @Test
    @DisplayName("Same and NotSame")
    void testSameAndNotSame(){
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(),demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str,demoUtils.getAcademyDuplicate(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("True or false")
    void testTrueOrFalse(){
        int grandeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(grandeOne,gradeTwo),"This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo,grandeOne),"This should return false");
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
