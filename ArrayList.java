public class ArrayList<T extends Comparable<T>> implements List<T>{
    //Instance Variables
    ArrayList <T> a= new ArrayList();
    private boolean isSorted;



    public ArrayList(ArrayList<T> a, boolean isSorted) { //Constructor
        this.a = a; //error
        this.isSorted = true;




    }
    
    public ArrayList() {
    }
    @Override
    public boolean add(T element) {
        if(element != null){
            a.add(-1, element);
            isSorted = false;
            return true;
        }
        return false;
        
    }

    @Override
    public boolean add(int index, T element) {
        if(element != null && index < a.size()){
            a.add(index, element);
            isSorted = false;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for(int i = 0; i <= a.size(); i++){
            a.remove(i);
            isSorted = true;
        }
        
    }

    @Override
    public T get(int index) {
        if(index < a.size()){
            T element = a.get(index);
            return element;
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        if(a.indexOf(element) == 0){
            return a.indexOf(element);
        }
        
    }

    @Override
    public boolean isEmpty() {
        if(a.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
      
        int size = 0;
        for(int i = 0; i<= a; i++){
             size += 1;
         }
    
        return size;
    }

    @Override
    public void sort() {
        a.sort();
        
    }

    @Override
    public T remove(int index) {
        T remove = a.remove(index);
        return remove;
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

