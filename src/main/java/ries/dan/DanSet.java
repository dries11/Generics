package ries.dan;

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
                return false;
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
        int i;
        for (i = 0; i < collection.length; i++){
            combined[i] = collection[i];
        }
        for (int j = 0; j < this.list.length; j++){
            for (Object element : combined){
                if (element != this.list[j]){
                    combined[i] = this.list[j];
                }
            }
        }
        if (combined.length == this.size + collection.length){
            this.size = combined.length;
            this.list = combined;
            return true;
        }
        else
            return false;
    }

}
