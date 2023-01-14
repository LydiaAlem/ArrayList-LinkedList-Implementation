import java.util.Arrays;

public class ArrayList<T extends Comparable<T>> implements List<T>{
    private T[] array;
    private int size = 0; 
    private boolean isSorted;

    /* Default constuctor, initializes the size of array to 2, and makes the list sorted.     */
    @SuppressWarnings("unchecked")
    public ArrayList() { 
        array = (T[]) new Comparable[2];
        isSorted = true;
    }

    /**
        @return -> if successfully added an element into the arraylist.
        @param -> the element that needs to be added
    */
    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        } 
        else {
            array = Arrays.copyOf(array, array.length + 1);
            array[this.size()] = element;
        }
        size++;
        this.checkSort();
        return true;
    }
    
    /**
        @return -> if successfully added an element to the correct index
        @param -> index and element
    */
    @Override
    public boolean add(int index, T element) {
        if ((element == null) || (index < 0 || index > this.size())) {
            return false;
        } 
        else {
            array = Arrays.copyOf(array, array.length + 1);
            for (int i = this.size; i > index; i--) {
                if (i >   index) {
                    array[i] = array[i - 1];
                }
            }
            array[index] = element;
            size++;
            this.checkSort();
            return true;
        }
    }
    
    /**
        @return -> VOID
        @param -> NOTHING
    */
    @SuppressWarnings("unchecked") 
    @Override
    public void clear() {
        array = (T[]) new Comparable[2];
        size = 0;
        isSorted = true;
    }

    /**
        @return -> the element you want to add
        @param -> the element you want to get
    */
    @Override
    public T get(int index) { 
        if(index < 0 || index >=this.size()){
            return null;
            }
        else{
            return array[index];
        }
    }
    
    /**
        @return -> the element you want to find 
        @param -> the index
    */
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
        this.checkSort();
        return -1;
      }

    /**
        @return -> a boolean is the list IS empty
        @param -> NOTHING
    */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            isSorted = true;
            return true;
        }
        return false;
    }
    
    /**
        @return -> size of list
        @param -> NOTHING
    */
    @Override
    public int size() {
        return size;
    }
    
    /**
        @return -> VOID
        @param -> NOTHING
        @purpose -> sorting the list with insertion sort
    */
    @Override
    public void sort() {
        for (int i = 1; i < this.size(); ++i) {
            T ele = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(ele) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = ele;
            isSorted = true;
        }
    }
    
    /**
        @return -> the removed element
        @param -> index
    */
    @Override
    public T remove(int index) {
        if ((index < 0 || index > this.size()) || array[index] == null) {
            this.checkSort();
            return null;
        }
        T out = array[index];
        for (int i = index; i < this.size() - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
        this.checkSort();
        return out;
    }
    
    /**
        @return -> VOID
        @param -> an element
        @purpose -> This method is counting the number of occurrences of the given element in an array.
                     then creating a new array of that size with only the given element. 
                     It then sets the original array to this new array,
    */
    @Override
    public void equalTo (T element){
            int count = 0;
            if (element == null) { 
                return;
            }
            for (int i = 0; i < this.size(); i++) { /
                if (array[i].compareTo(element) == 0) {
                    count++;
                }
            }
            T[] newArray = (T[]) new Comparable[this.size() - (this.size() - count)];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = element;
            }
            array = newArray;
            size = newArray.length; 
            this.checkSort();
        }

    
    /**
        @return -> VOID
        @param -> NOTHING
        @purpose -> reverses the list
    */ 
   @Override
    public void reverse() {
        int half = size/2;
        int x = 0;
        while(x< half){
            T temp = array[x];
            array[x] = array[size - x - 1];
            array[size - x - 1] = temp;
            x++;
        }
        this.checkSort();
    }
    
    /**
        @return -> VOID
        @param -> another ArrayList
        @purpose -> merges two arrays together and creates a new list
    */ 
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
        isSorted = true;

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
        this.checkSort();
        size += other.size();
    }

    /**
        @return -> VOID
        @param -> NOTHING
        @purpose ->swapping every two elements in the array.
    */ 
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
    }
    
    /**
        @return -> (boolean) if the list is sorted, and updates the global variable 'isSorted' accordingly.
        @param -> NOTHING
        @purpose -> a helper function for checking if the list IS sorted
    */ 
    @Override
    public boolean checkSort() {
        if (this.size() == 1 || this.size() == 0) {
            isSorted = true;
            return true;
        }
        int i = 0;
        while (i < this.size() - 1) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                isSorted = false;
                return false;
            }
            i++;
        }
        isSorted = true;
        return true;
    }
    
    /**
        @return -> (boolean) if the list is sorted
        @param -> NOTHING
        @purpose -> calls the global variable 'isSorted' accordingly.
    */ 
    @Override
    public boolean isSorted() {
        return isSorted;
    }
    
    /**
        @return -> a string representation of the array
        @param -> NOTHING
        @purpose -> to display the array
    */
    @Override
    public String toString(){
        String out = "";
        int i = 0;
        while (i < this.size()){
            out += array[i] + "\n";
            i++;
        }
        return out; }
    }
}
