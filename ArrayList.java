public class ArrayList<T extends Comparable<T>> implements List<T>{
    //Instance Variables
    private T[] array;
    private int size = 0; //checks index 0
    private boolean isSorted;


@SuppressWarnings("unchecked") //gets rid of underlined stuff
    public ArrayList(ArrayList<T> a, boolean isSorted) { //Constructor
        array = (T[]) new Comparable[2];
        this.isSorted = true;
    }
    
    public ArrayList() {
    }
    
    //Completed -Lydia
    public boolean add(T element) {
        if(element == null){
            isSorted = true; //not sure
            return false;
        }
        else {
            array[size] = element;
            size++;
            return true;
        }
    }
//Bilese
    @Override
    public boolean add(int index, T element) {
        return false;
    }
//Completed -Lydia
    @SuppressWarnings("unchecked")
    public void clear() {
        array = (T[]) new Comparable[2];
        size = 0;
        }
        
    

 //Completed -Lydia
    public T get(int index) {
        if(index >= 0){
            if(index < array.length){
                return array[index];
            }
        }
        return null;
    }
 
 //Almost complete
    @Override
    public int indexOf(T element) {
        for(int i = 0; i<= size; i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return 0; //double-check
       
        
    }
//Completed-Lydia
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }
//Completed-Lydia
    @Override
    public int size() {
      
        int size = 0;
        for(int i = 0; i<= array.length; i++){
             size += 1;
         }
    
        return size;
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T remove(int index) {
        return T;
    }

    @Override
    public void equalTo(T element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reverse() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void merge(List<T> otherList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pairSwap() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isSorted() {
        // TODO Auto-generated method stub
        return false;
    }
    
}

