package ries.dan;

import javax.swing.*;
import java.lang.reflect.Array;


/**
 * Created by danries on 2/22/17.
 */
public class DanList<T> {

    private Object[] array;
    private int currentSize = 0;
    private int size = 0;

    //Initializes with initial size of five if no size is given
    public DanList(){
        this.array = new Object[5];
        this.currentSize = this.array.length;
    }

    //Initializer for size given
    public DanList(int size) throws NegativeArraySizeException{
        try {
            this.array = new Object[size];
            this.currentSize = size;
        }catch (NegativeArraySizeException e){
            System.out.println("Incorrect size, must be positive");
            throw e;
        }
    }

    //Adds an element to the ries.dan.DanList, Dynamic sizing

    public boolean add(T element){
        Object[] plusNewElement = new Object[this.currentSize + 1];
        for (int i = 0; i < this.currentSize; i++){
            if (array[i] == null){
                plusNewElement[i] = element;
                this.size++;
                this.array = plusNewElement;
                this.currentSize++;
                return true;
            }
            else {
                plusNewElement[i] = array[i];
            }
        }
        return false;
    }

    public boolean add(T element, int index){
        Object[] plusNewElement = new Object[this.currentSize + 1];
        int j = 0;
        for (int i = 0; i < this.currentSize; i++){
                if (index == i) {
                    plusNewElement[i] = element;
                } else {
                    plusNewElement[i] = this.array[j];
                    j++;
                }
            }
        this.size++;
        return true;
    }

    public boolean remove(int index){
        Object[] minusNewElement = new Object[this.currentSize - 1];
        int j = 0;
        for (int i = 0; i < this.currentSize; i++){
            if (i != index){
                minusNewElement[j] = this.array[i];
                j++;
            }
        }
        this.size--;
        this.array = minusNewElement;
        return true;
    }

    public boolean remove(T object){
        Object[] minuesNewElement = new Object[this.currentSize - 1];
        int j = 0;
        int instances = 0;
        for (int i = 0; i < this.currentSize; i++){
            if (this.array[i] != object || instances > 0){
                minuesNewElement[j] = this.array[i];
                j++;
            }
            else{
                instances++;
            }
        }
        this.size--;
        this.array = minuesNewElement;
        return true;
    }

    public T get(int index){
        T object;
        object = (T)this.array[index];
        return object;
    }

    public T set(int index, T object){
        T toReturn;
        toReturn = (T)this.array[index];
        this.array[index] = object;
        return toReturn;
    }

    public void clear(){
        Object[] cleanArray = new Object[5];
        this.array = cleanArray;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }
        return false;
    }

    public boolean contains(Object object){
        for (Object element : this.array){
            if (element == object)
                return true;
        }
        return false;
    }

}
