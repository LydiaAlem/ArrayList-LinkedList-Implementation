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
 
/  //Completed
    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        } else {
            this.growCopy(); //creates a new array from old array and allocate one more element
            array[this.size()] = element;
            isSorted = false;
            size++;
            return true;
        }//Completed
    }
//Completed!
@Override

    public boolean add(int index, T element) {
        if ((element == null) || (index < 0 || index >= this.size())) {
            return false;
        } else {
            this.growCopy();
            for (int i = this.size - 1; i > index; i--) {
                if (i > index) {
                    array[i] = array[i - 1];
                }
            }
            array[index] = element;
            return true;
        }
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
        for(int i = 0; i <this.size(); i++){
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
 }
//Lydia 
    public void sort() {
        for(int i = 0; i< this.size() - 1; i++){ //convert into i < array.size()
            for(int j = 0; j< this.size() - 1 - i; j++){//convert into j < array.size()
                if (array[j].compareTo(array[j+1])<0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        }
    }
}
//Lydia 
    @Override
    public T remove(int index) {
        try{
            for(int i = 0; i<= this.size(); i++){
                if(array[i] == (array[index])){
                    array[i] = null;
                    return array[i];
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }
        return null;
    }
//Bilese
     @Override
        public void equalTo (T element){
            int count = 0;
            if (element == null) { //making sure element is NOT null
                return;
            }
            for (int i = 0; i < this.size(); i++) { //seeing if their exists an element thats in array
                if (array[i].compareTo(element) == 0) {
                    count++;
                }
            }
            T[] newArray = (T[]) new Comparable[this.size() - (this.size() - count)];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = element;
            }
            array = newArray;
            size = newArray.length; //resizing size

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
        if(otherList == null){
            return;
        }
        ArrayList<T> other = (ArrayList<T>) otherList;
        T[] newArray = (T[]) new Comparable[this.size() + other.size()];
        this.sort();
        other.sort();
        isSorted = true;

        for(int i = 0; i< this.size(); i++){
            newArray[i] = array[i];
        }
        for(int j = 0; j< other.size(); j++){
            newArray[this.size() + j] = other.get(j); //
            if(newArray[j].compareTo(other.get(j)) > 0){
                newArray[j] = other.get(j);
            }
        }

        array = newArray; //making the original array NOW equal to the merged array
        size += other.size();
    }
//Lydia
    @Override
    public void pairSwap() {
        // TODO Auto-generated method stub
        
    }
 public boolean checkSort(){
        for(int i = 0; i< this.size() -1; i++){
            if(array[i].compareTo(array[i+1]) > 0){ //this is jst like saying array[i]> array[i+1]
                return false;
            }
        }
        return true;
    }

//Bilese-completed
    @Override
    public boolean isSorted() {
        return isSorted;
    }
}
