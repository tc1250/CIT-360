/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tcchr
 */
public class TestClassTest {

    public TestClassTest() {
    }

    /**
     * Test of getStringArray1 method, of class TestClass.
     */
    @Test
    public void testGetStringArray1() {
        System.out.println("getStringArray1");
        TestClass instance = new TestClass();
        String[] expResult = null;
        String[] result = instance.getStringArray1();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setStringArray1 method, of class TestClass.
     */
    @Test
    public void testSetStringArray1() {
        System.out.println("setStringArray1");
        String[] stringArray1 = {"strings", "are", "fun"};
        TestClass instance = new TestClass();
        instance.setStringArray1(stringArray1);
        assertArrayEquals(stringArray1, instance.stringArray1);
    }

    /**
     * Test of getStringArray2 method, of class TestClass.
     */
    @Test
    public void testGetStringArray2() {
        System.out.println("getStringArray2");
        TestClass instance = new TestClass();
        String[] expResult = null;
        String[] result = instance.getStringArray2();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setStringArray2 method, of class TestClass.
     */
    @Test
    public void testSetStringArray2() {
        System.out.println("setStringArray2");
        String[] stringArray2 = null;
        TestClass instance = new TestClass();
        instance.setStringArray1(stringArray2);
    }

    /**
     * Test of getTest1 method, of class TestClass.
     */
    @Test
    public void testGetTest1() {
        System.out.println("getTest1");
        TestClass instance = new TestClass();
        double expResult = 0.0;
        double result = instance.getTest1();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTest1 method, of class TestClass.
     */
    @Test
    public void testSetTest1() {
        System.out.println("setTest1");
        double test1 = 0.0;
        TestClass instance = new TestClass();
        instance.setTest1(test1);
    }

    /**
     * Test of isBool method, of class TestClass.
     */
    @Test
    public void testIsBool() {
        System.out.println("isBool");
        TestClass instance = new TestClass();
        boolean expResult = false;
        boolean result = instance.isBool();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBool method, of class TestClass.
     */
    @Test
    public void testSetBool() {
        System.out.println("setBool");
        boolean bool = false;
        TestClass instance = new TestClass();
        instance.setBool(bool);
        assertFalse(bool);
    }

    /**
     * Test of getStringArray3 method, of class TestClass.
     */
    @Test
    public void testGetStringArray3() {
        System.out.println("getStringArray3");
        TestClass instance = new TestClass();
        ArrayList expResult = null;
        ArrayList result = instance.getStringArray3();
        assertEquals(expResult, result);
        assertNull(instance.stringArray3); //THis actually fails, I assume because I tell it that it's a new ArrayList
        // I assumed since I hadn't added anything to it that it was null, but I am mistaken. This test taught me somethign about how creating 
        // variables works
    }

    /**
     * Test of setStringArray3 method, of class TestClass.
     */
    @Test
    public void testSetStringArray3() {
        System.out.println("setStringArray3");
        ArrayList stringArray3 = new ArrayList();
        stringArray3.add("Crickey");
        TestClass instance = new TestClass();
        instance.setStringArray3(stringArray3);
        assertNotNull(instance.stringArray3);
    }

    /**
     * Test of add method, of class TestClass.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        TestClass instance = new TestClass();
        instance.setTest1(1.1);
        instance.setTest2(2.2);
        double expResult = 3.3;
        double result = instance.add(instance.test1, instance.test2);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class TestClass.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        TestClass instance = new TestClass();
        instance.setTest1(2.2);
        instance.setTest2(1.1);
        double expResult = 1.1;
        double result = instance.subtract(instance.test1, instance.test2);
        assertNotSame(expResult, result); //because I've written the subtract class wrong, assertNotSame passes (indicating an error with the function)
    }

    /**
     * Test of compareArrays method, of class TestClass.
     */
    @Test
    public void testCompareArrays() {
        System.out.println("compareArrays");
        String[] array1 = null;
        String[] array2 = null;
        int expResult = 0;
        int result = TestClass.compareArrays(array1, array2);
        assertEquals(expResult, result);
    }

    /**
     * Demonstrating the use of assertSame Also using assertTrue: I set the bool
     * to True in instance1, I call assertTrue on the bool from instance2, it
     * wouldn't pass if they didn't point to the same object
     */
    @Test
    public void testObjects() {
        TestClass instance1 = new TestClass();
        TestClass instance2 = instance1;
        instance1.setBool(true);
        assertTrue(instance2.bool);
        assertSame(instance1, instance2);
    }

    /**
     * Demonstrating the use of assertThat
     */
    @Test
    public void testThat() {
        TestClass instance1 = new TestClass();
        TestClass instance2 = new TestClass();
        TestClass instance3 = instance1;

        instance1.setTest1(12.234);
        assertThat(instance3.getTest1(), is(instance1.getTest1())); //should pass
        assertThat(instance2.getTest1(), is(instance1.getTest1())); // should fail
    }

}
