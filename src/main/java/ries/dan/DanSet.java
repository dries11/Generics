package ries.dan;


import java.util.Arrays;

/**
 * Created by danries on 2/22/17.
 */
public class DanSet<T> {

    private Object[] list;
    private int currentSize = 0;
    private int size = 0;

    //Initialized with a size of five
    public DanSet(){
        this.list = new Object[5];
        this.currentSize = this.list.length;
    }

    public boolean add(T element){
        Object[] plusNewElement = new Object[this.currentSize + 1];
        for (int i = 0; i < this.currentSize; i++){
            if (this.list[i] == element){
                break;
            }
            if (list[i] == null){
                plusNewElement[i] = element;
                this.size++;
                this.list = plusNewElement;
                this.currentSize++;
                return true;
            }
            else{
                plusNewElement[i] = list[i];
            }
        }
        return false;
    }

    public boolean addAll(T[] collection){
        Object[] combined = new Object[this.currentSize + collection.length];
        int combineActualSize = 0;
        int i;
        for (i = 0; i < this.size; i++){
            combined[i] = this.list[i];
            combineActualSize++;
        }
        for (int j =0; j < collection.length; j++){
            int countIfSeen = 0;
            for (Object element : combined){
                if (element == collection[j]){
                    countIfSeen++;
                }
            }
            if (countIfSeen == 0){
                combined[i] = collection[j];
                i++;
                combineActualSize++;
            }
        }
        if (this.size < combineActualSize){
            this.size = combined.length;
            this.list = combined;
            return true;
        }
        else
            return false;
    }

    public void clear(){
        Object[] cleanSweep = new Object[5];
        this.list = cleanSweep;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean contains(T object){
        for (Object element : this.list){
            if (object == element){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }else
            return false;
    }

    public boolean remove(T object){
        Object[] minusOne = new Object[this.size];
        int j = 0;
        for (int i = 0; i < this.size; i++){
            if (this.list[i] != object){
                minusOne[j] = this.list[i];
                j++;
            }
            else
                this.size--;
        }
        this.list = minusOne;
        if (this.size == minusOne.length){
            return false;
        }
        else
            return true;
    }

    public Object[] toArray(){
        return Arrays.copyOf(this.list,this.size);
    }

}
