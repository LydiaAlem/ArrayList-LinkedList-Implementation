import java.util.Arrays;

public class ArrayList<T extends Comparable<T>> implements List<T>{
    //Instance Variables
    private T[] array;
    private int size = 0; //checks index 0, using it for size()
    private boolean isSorted;


    @SuppressWarnings("unchecked") //gets rid of underlined stuff
    public ArrayList() { //Constructor
        array = (T[]) new Comparable[2];
        this.isSorted = true;
    }
//O(1)
    public void growCopy(){
        array = Arrays.copyOf(array, array.length + 1);
    }

//O(1)
    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        } else {
            this.growCopy();
            array[this.size()] = element;
            isSorted = false;
        }
        size++;
        return true;
    }

 //O(n)
    @Override
    //check if index is less than 0 or greater than this.size()
    public boolean add(int index, T element) {
        if ((element == null) || (index < 0 || index > this.size())) {
            return false;
        } else {
            this.growCopy();
            for (int i = this.size; i > index; i--) {
                if (i >   index) {
                    array[i] = array[i - 1];
                }
            }
            array[index] = element;
            size++;
            return true;
        }
    }
    //Completed
    @SuppressWarnings("unchecked") //DONE
    public void clear() {
        array = (T[]) new Comparable[2];
        size = 0;
        isSorted = true;
    }

 //O(1)
    @Override
    public T get(int index) { 
        if(index < 0 || index >=this.size()){
            return null;
            }
        else{
            return array[index];
        }
    }

 //O(n)
    @Override
    public int indexOf(T element) {
        if(element == null){
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
        }


 //O(1)
    @Override
    public boolean isEmpty() {
        if(size == 0){
            isSorted = true;
            return true;
        }
        return false;
    }

 //O(1)
    @Override
    public int size() {
        return size;
    }
    
 //O(n^2)
    @Override
    public void sort() {
        for (int i = 0; i < this.size() - 1; i++)
        for (int j = 0; j < this.size()-i-1; j++)
            if (array[j] != null && array[j].compareTo(array[j + 1]) > 0) {
                T temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
    }




 //O(n)
    @Override
    public T remove(int index) {

        if ((index < 0 || index > this.size()) || array[index] == null) { //seeing if oob or null
            return null;
        }
            T out = array[index];
            for (int i = index; i < this.size() - 1; i++) {
                array[i] = array[i+1];
            }
            size--;
            return out;
        }
 //O(n)
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

 //O(n)
    @Override
    public void reverse() {
        for(int i = 0; i < size / 2; i++){
            T temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        this.checkSort();
    }

     //O(n^2)
    @SuppressWarnings("unchecked")
    @Override

    public void merge(List<T> otherList) {
        if(otherList == null){
            return;
        }
        ArrayList<T> other = (ArrayList<T>) otherList;
        T[] newArray = (T[]) new Comparable[this.size() + other.size()];
        this.sort();
        other.sort();
        this.checkSort();

        int i = 0, j= 0, k= 0;
        while (i < this.size() && j < other.size()) {
            if (array[i].compareTo(other.get(j)) < 0) {
                newArray[k++] = array[i++];
            }
            else {
                newArray[k++] = other.get(j++);
            }
        }
        while (i < this.size()) {
            newArray[k++] = array[i++];
        }
        while (j < other.size()) {
            newArray[k++] = other.get(j++);
        }
        array = newArray;
        size += other.size();
    }

 //O(n^2)
    @Override
    public void pairSwap() {

        int i = 0;
        int j = 1;
        while(i < this.size() && j < this.size()){
            T temp = array[i];
            T first = array[j];
            T second = temp;
            array[i] = first;
            array[j] = second;
            i+=2;
            j+=2;
        }
        this.checkSort();
    }
 //O(n)
    public boolean checkSort(){
        if(this.size() == 0){
            isSorted = true;
            return true;
        }
        for(int i = 0; i< this.size() -1; i++){
            if(array[i].compareTo(array[i+1]) > 0){ //this is jst like saying array[i]> array[i+1]
                isSorted = false;
                return false;
            }
        }
        return true;
    }
     //O(1)
    @Override
    public boolean isSorted() {
        return isSorted;
    }
     //O(n)
    public String toString(){
        String out = "";
        for(int i = 0; i< this.size(); i++){
            out += array[i] + "\n";
        }
        return out;
    }

}

