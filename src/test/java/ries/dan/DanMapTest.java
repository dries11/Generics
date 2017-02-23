package ries.dan;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by danries on 2/22/17.
 */
public class DanMapTest {

    private DanMap<String,Integer> danMap;
    private DanMap<String, Integer> nullMap;
    private DanMap<String, Integer> unEqual;
    private DanMap<String, Integer> sameSizeUnequal;
    private DanMap<String, Integer> equal;
    private Set<String> keysExpected;
    private Collection<Integer> valuesExpected;

    @Before public void initializeNullMap() {
        nullMap = new DanMap<>();
    }

    @Before public void initializeDanMap() {
        danMap = new DanMap<>();
        danMap.put("Bryant", 53);
        danMap.put("Dan", 21);
        danMap.put("Carol", 51);
        danMap.put("Eliz", 17);
        danMap.put("Steph", 47);
    }

    @Before public void initializeUnequalMap() {
        unEqual = new DanMap<>();
        unEqual.put("Carmelo",34);
    }

    @Before public void initializeEqualMap(){
        equal = new DanMap<>();
        equal.putAll(danMap);
    }

    @Before public void initializeHashSetForKeys() {
        keysExpected = new HashSet<>();
        keysExpected.add("Bryant");
        keysExpected.add("Dan");
        keysExpected.add("Carol");
        keysExpected.add("Eliz");
        keysExpected.add("Steph");
    }

    @Before public void initializeArrayListForValues() {
        valuesExpected = new ArrayList<>();
        valuesExpected.add(53);
        valuesExpected.add(21);
        valuesExpected.add(51);
        valuesExpected.add(17);
        valuesExpected.add(47);
    }

    @Before public void initializeUnEqualMapOfSameSize(){
        sameSizeUnequal = new DanMap<>();
        sameSizeUnequal.put("Deebo", 53);
        sameSizeUnequal.put("Gucci", 21);
        sameSizeUnequal.put("Craig", 51);
        sameSizeUnequal.put("Felicia", 17);
        sameSizeUnequal.put("Red", 47);

    }

    @Test
    public void putTestNullBefore(){
        assertNull(nullMap.put("Dan",21));
    }

    @Test
    public void putTestValueInSpotBefore(){
        Object expected = 53;
        Object actual = danMap.put("Bryant",64);
        assertEquals("We expect to get the old value back of the replaced key value pair",expected,actual);
    }

    @Test
    public void clearTest(){
        int expected = 0;
        danMap.clear();
        int actual = danMap.size();
    }

    @Test
    public void containsKeyTestTrue(){
        assertTrue(equal.containsKey("Carol"));
    }

    @Test
    public void containsKeyTestFalse(){
        assertFalse(danMap.containsKey("Carmelo"));
    }

    @Test
    public void containsValueTestTrue(){
        assertTrue(danMap.containsValue(21));
    }

    @Test
    public void containsValueTestFalse(){
        assertFalse(danMap.containsValue(121));
    }

    @Test
    public void equalsTestTrue(){
        assertTrue(danMap.equals(equal));
    }

    @Test
    public void equalsTestFalseOneBigger(){
        assertFalse(danMap.equals(unEqual));
    }

    @Test
    public void equalsTestFalseKeyNonExistant(){
        assertFalse(danMap.equals(sameSizeUnequal));
    }

    @Test
    public void getTestKeyExists(){
        Object expected = 21;
        Object actual = danMap.get("Dan");
        assertTrue(expected==actual);
    }

    @Test
    public void getTestKeyDoesNotExist(){
        assertNull(danMap.get("Carmelo"));
    }

    @Test
    public void isEmptyFalse(){
        assertFalse(danMap.isEmpty());
    }

    @Test
    public void isEmptyTrue(){
        DanMap<Integer, Integer> gucciMane = new DanMap<>();
        assertTrue(gucciMane.isEmpty());
    }

    //Is this allowed??
    @Test
    public void keySet(){
        ArrayList<String> actual = equal.keySet();
        assertTrue(actual.size() == keysExpected.size());
        for (String string : actual){
            assertTrue(keysExpected.contains(string));
        }
    }

    @Test
    public void sizeTest(){
        int expected = 5;
        int actual = equal.size();
        assertTrue(expected==actual);
    }

    @Test
    public void putAllTest(){
        unEqual.putAll(equal);
        int sizeExpected = 6;
        int sizeActual = unEqual.size();
        assertTrue(sizeExpected==sizeActual);
    }

    @Test
    public void removeTestKeyExists(){
        Object actual = equal.remove("Dan");
        Object expected = 21;
        assertTrue(actual==expected);
    }

    @Test
    public void removeTestKeyNotExist(){
        assertNull(equal.remove("Hiphop"));
    }

    @Test
    public void valuesTest(){
        ArrayList<Object> actual = equal.values();
        assertTrue(actual.equals(valuesExpected));
    }


}
