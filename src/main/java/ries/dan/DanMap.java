package ries.dan;

import java.util.*;

/**
 * Created by danries on 2/22/17.
 */

public class DanMap<K,V> {


    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public DanMap(){
        this.keys = new Object[5];
        this.values = new Object[5];
        this.size = 0;
    }

    public ArrayList<Object> values(){
        ArrayList<Object> values = new ArrayList<Object>();
        for (int i = 0; i < this.size; i++){
            values.add(this.values[i]);
        }
        return values;
    }

    public int size(){
        return this.size;
    }

    public Object remove(K key) {
        Object valueToReturn = null;
        Object[] newKeys = new Object[this.size - 1];
        Object[] newValues = new Object[this.size - 1];
        if (this.containsKey(key)) {
            for (int i = 0; i < this.size; i++) {
                int j = i;
                if (this.keys[i] != key) {
                    newKeys[i] = this.keys[i];
                    newValues[i] = this.values[i];
                } else {
                    valueToReturn = this.values[i];
                    this.size--;
                }
            }
            this.keys = newKeys;
            this.values = newValues;
            return valueToReturn;
        }
        return null;
    }

    public void putAll(DanMap<K, V> map){
        Object[] newKeys = new Object[this.size + map.size()];
        Object[] newValues = new Object[this.size + map.size()];
        int i = 0;
        while(i < this.size){
            newKeys[i] = this.keys[i];
            newValues[i] = this.values[i];
            i++;
        }
        for (K key : map.keySet()){
            this.put(key,map.get(key));
        }
    }

    public ArrayList<K> keySet(){
        ArrayList<K> keySet = new ArrayList<>();
        for (K key : (K[]) this.keys){
            keySet.add(key);
        }
        return keySet;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public V get(K key){
        for (int i = 0; i < this.keys.length; i++){
            if (this.keys[i] == key)
                return (V) this.values[i];
        }
        return null;
    }


    public boolean equals(DanMap<K,V> otherMap){
        int compare = 0;
        if (this.size == otherMap.size){
            for (K key : (K[]) this.keys){
                if (!otherMap.containsKey(key)){
                    compare++;
                }
            }
            if (compare == 0){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        Object[] cleanKeys = new Object[5];
        Object[] cleanValues = new Object[5];
        this.keys = cleanKeys;
        this.values = cleanValues;
    }

    public boolean containsValue(V val){
        for (Object value : this.values){
            if (val == value){
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(K k){
        for (Object key : this.keys){
            if (key == k){
                return true;
            }
        }
        return false;
    }

    public Object put(K key, V value){

        Object[] newKeys = new Object[this.size + 1];
        Object[] newValues = new Object[this.size + 1];
        Object valueToReturn = null;
        if (this.containsKey(key)){
            for (int i = 0; i < this.size; i++){
                if (this.keys[i] == key){
                    valueToReturn = this.values[i];
                    newKeys[i] = key;
                    newValues[i] = value;
                }
                else {
                    newKeys[i] = this.keys[i];
                    newValues[i] = this.values[i];
                }
            }
        }
        else{
            for (int j = 0; j < this.size + 1; j++) {
                if (j == this.size) {
                    newKeys[j] = key;
                    newValues[j] = value;
                } else {
                    newKeys[j] = this.keys[j];
                    newValues[j] = this.values[j];
                }
            }
        }
        this.keys = newKeys;
        this.values = newValues;
        this.size = newKeys.length;
        return valueToReturn;

//        int j = 0;
//        for (int i = 0; i < this.keys.length; i++){
//            if (this.keys[j] == key || this.keys[j + 1] != null){
//                newKeys[i] = key;
//                newValues[i] = value;
//                valueToReturn = this.values[i];
//            }
//            else if (this.keys[i] != null){
//                newKeys[i] = this.keys[j];
//                newValues[i] = this.values[j];
//                j++;
//            }
//            else if (this.keys[i] == null){
//                this.size = newKeys.length;
//                this.keys = newKeys;
//                this.values = newValues;
//                return valueToReturn;
//            }
//
//        }
//        return null;
    }

}
