package ries.dan;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/22/17.
 */
public class DanListTest {

    DanList<Integer> integers;
    DanList<String> strings;
    DanList<String> empty;

    @Before public void initialize() throws Exception {
        strings = new DanList<String>(4);
        integers = new DanList<Integer>();
    }

    @Test (expected = NegativeArraySizeException.class)
    public void createListShouldThrowException(){
        DanList<Array> errorList = new DanList<Array>(-2);
    }

    @Test
    public void addIntegerTest(){
        boolean expected = true;
        boolean actual = integers.add(3);
        assertTrue(expected == actual);
    }

    @Test
    public void addFailedTest(){
        DanList failed = new DanList(0);
        boolean actual = failed.add(1);
        assertFalse(actual);
    }

    @Before public void addIntsToDanList(){
        integers.add(3);
        integers.add(5);
        strings.add("H");
        strings.add("E");
        strings.add("L");
        strings.add("L");
        strings.add("O");
    }

    @Test
    public void addIntegerAtIndexInTheMiddleOfAList(){
        boolean expected = true;
        boolean actual  = integers.add(1,1);
        assertTrue(expected == actual);
    }

    @Before public void addMoreIntsToList(){
        integers.add(2);
        integers.add(6);
        integers.add(9);
        integers.add(5);
    }

    @Test
    public void removeAnIntegerAtIndexTest(){
        boolean expected = true;
        boolean actual = integers.remove(2);
        assertTrue(expected == actual);
    }

    @Test
    public void removeAnIntegerFirstOccurrence(){
        boolean expected = true;
        String toRemove = "L";
        boolean actual = strings.remove(toRemove);
        assertTrue(expected==actual);
    }

    @Test
    public void getFromIndexTest(){
        Object expected = "L";
        Object actual = strings.get(2);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void setByIndexTest(){
        Object expected = 5;
        Object actual = integers.set(3,4);
        assertEquals("We expect to get five back because it is being replaced at is index by 4",expected, actual);
    }

    @Test
    public void clearTest(){
        int expected = 0;
        integers.clear();
        int actual = integers.size();
        assertTrue(expected == actual);
    }

    @Before public void createNewList(){
        empty = new DanList<String>();
    }

    @Test
    public void isEmptyTestTrue(){
        boolean actual = empty.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void isEmptyTestFalse(){
        boolean actual = integers.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void containsTestTrue(){
        boolean actual = integers.contains(9);
        assertTrue(actual);
    }

    @Test
    public void containsTestFalse(){
        boolean actual = integers.contains(26);
        assertFalse(actual);
    }

}
