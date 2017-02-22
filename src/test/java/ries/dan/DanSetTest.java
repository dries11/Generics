package ries.dan;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by danries on 2/22/17.
 */
public class DanSetTest {

    private DanSet<Integer> integerDanSet;
    private Integer[] collectionForAddAll;

    @Before public void initialize(){
        integerDanSet = new DanSet<Integer>();
    }

    @Test
    public void addTestTrue(){
        boolean actual = integerDanSet.add(3);
        assertTrue(actual);
    }

    @Before public void addNumbers(){
        integerDanSet.add(1);
    }

    @Test
    public void addTestExpectingFalseBecauseOfDuplicates(){
        boolean actual = integerDanSet.add(1);
        assertFalse(actual);
    }

    @Before public void makeANewCollectionForTests(){
        collectionForAddAll = new Integer[]{1,2,3,4,5};
    }

    @Test
    public void addAllTest(){
        boolean actual = integerDanSet.addAll(collectionForAddAll);
        assertTrue(actual);
    }

}
