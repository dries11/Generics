package ries.dan;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/22/17.
 */
public class DanSetTest {

    private DanSet<Integer> integerDanSet;
    private Integer[] collectionForAddAllFail;
    private Integer[] collectionForAddAllPass;

    @Before public void initializeIntegerSet(){
        integerDanSet = new DanSet<>();
        integerDanSet.add(1);
        integerDanSet.add(2);
        integerDanSet.add(3);
    }

    @Before public void initializeIntegerSetEqualToOther(){
        collectionForAddAllFail = new Integer[]{1,2,3};
    }

    @Before public void makeANewCollectionForTests(){
        collectionForAddAllPass = new Integer[]{1,2,3,4,5};
    }

    @Test
    public void addTestTrue(){
        assertTrue(integerDanSet.add(4));
    }

    @Test
    public void addTestExpectingFalseBecauseOfDuplicates(){
        boolean actual = integerDanSet.add(1);
        assertFalse(actual);
    }

    @Test
    public void addAllTestTrueNoDuplicates(){
        boolean actual = integerDanSet.addAll(collectionForAddAllPass);
        assertTrue(actual);
    }

    @Test
    public void addAllTestFalseAllDuplicates(){
        boolean actual = integerDanSet.addAll(collectionForAddAllFail);
        assertFalse(actual);
    }

    @Test
    public void sizeTest(){
        int expected = 3;
        int actual = integerDanSet.size();
        assertTrue(expected==actual);
    }

    @Test
    public void clearTest(){
        int expected = 0;
        integerDanSet.clear();
        int actual = integerDanSet.size();
        assertTrue(expected==actual);
    }

    @Test
    public void containsTrueTest(){
        assertTrue(integerDanSet.contains(1));
    }

    @Test
    public void containsFalseTest(){
        assertFalse(integerDanSet.contains(40));
    }

    @Test
    public void isEmptyTestTrue(){
        DanSet danSet = new DanSet();
        assertTrue(danSet.isEmpty());
    }

    @Test
    public void isEmptyTestFalse(){
        assertFalse(integerDanSet.isEmpty());
    }

    @Test
    public void removeElementTestElementExists(){
        assertTrue(integerDanSet.remove(2));
    }

    @Test
    public void removeElementTestElementNotExist(){
        assertFalse(integerDanSet.remove(4));
    }

    @Test
    public void toArrayTestTrue(){
        Object[] expected = new Integer[]{1,2,3};
        Object[] actual = integerDanSet.toArray();
        assertTrue(Arrays.equals(expected,actual));
    }
}
