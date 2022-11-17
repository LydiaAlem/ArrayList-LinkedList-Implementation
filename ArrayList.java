import java.util.Arrays; //Needed when copying/creating arrays

public class ArrayList<T extends Comparable<T>> implements List<T>{
    //Class Attributes
    private T[] array;
    private int size = 0; //checks index 0, using it for size()
    private boolean isSorted;
    
/*
I used size() instead of array.length in every method except size()
*/

//Constructor
@SuppressWarnings("unchecked") //gets rid of underlined stuff
    public ArrayList(ArrayList<T> a, boolean isSorted) { //Constructor
        array = (T[]) new Comparable[2];
        this.isSorted = true;
    }
 
//Completed-Lydia
    @Override
    public boolean add(T element) {
        if(element == null){
            return false;
        }
        else {
            array = Arrays.copyOf(array, size() + 1); //creates a new array from old array and allocate one more element
            array[size() - 1] = element;
            isSorted = false;
            return true;
        }
    }
//Bilese
    @Override
    public boolean add(int index, T element) {//use INSERTION/BUBBLE/SELECTION method from canvas page
        return false;
    }
//Completed-Lydia
    @SuppressWarnings("unchecked") //DONE
    public void clear() {
        array = (T[]) new Comparable[2];
        size = 0;
    }
//Completed-Lydia
    @Override
    public T get(int index) {
        if(index >= 0){ //checks if the index isnt illegal
            if(index < size()){
                return array[index];
            }
        }
        return null;
    }
//Completed-Lydia
    @Override
    public int indexOf(T element) {
        for(int i = 0; i <size(); i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return 0;
    }

//Completed-Lydia
    @Override 
    public boolean isEmpty() {
        if(size() == 0){ 
            isSorted = true;
            return true;
        }
        return false;
    }

//Completed
    @Override 
    public int size() {
        int size = 0;
        for(int i = 0; i< array.length; i++){
            size += 1;
        }
        return size;
    }
//Bilese
    @Override
    public void sort() {
    }
//Lydia 
    public void sort() {
        for(int i = 0; i< array.length - 1; i++){ //convert into i < array.size()
            for(int j = 0; j< array.length - 1 - i; j++){//convert into j < array.size()
                if (array[j].compareTo(array[j+1])<0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        }
    }
}

//Bilese
    @Override
    public void equalTo(T element) {
        // TODO Auto-generated method stub
        
    }
//Completed-Lydia
    @Override
    public void reverse() {
        T temp;
        int length = size();
        for(int i = 0; i< length / 2; i++){
            temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
//Bilese
    @Override
    public void merge(List<T> otherList) {
        // TODO Auto-generated method stub
        
    }
//Lydia
    @Override
    public void pairSwap() {
        // TODO Auto-generated method stub
        
    }
//Bilese-completed
    @Override
    public boolean isSorted() {
        return isSorted;
    }
}
