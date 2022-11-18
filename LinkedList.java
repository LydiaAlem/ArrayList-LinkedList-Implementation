import java.util.*;
public class LinkedList<T extends Comparable<T>> implements List<T> {
    //Class Attributes:
    private int size = 0;
    private Node<T> first;
    private boolean isSorted;

    public LinkedList() {
        first = new Node<T>(null);
        isSorted = true;
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        Node<T> newNode = new Node<T>(element, null);
        if (first == null) {
            first = new Node<T>(element);
        }
        else {
            Node<T> ptr = first;
            while (ptr.getNext() != null) {
                    ptr = ptr.getNext();
                }
                newNode.setNext(ptr.getNext());
                ptr.setNext(newNode);

            }
            isSorted = false;
            size++;
            return true;
        }

    @Override
    public boolean add(int index, T element) {
        if (element == null || index < 0 || index >= size) {
            return false;
        } else {
            int i = 0;
            Node<T> newNode = new Node<T>(element);
            if (index == 0) {
                newNode.setNext(first.getNext());
                first.setNext(newNode);
                size++;
                return true;
            }
            else if (index == 1) {
                newNode.setNext(first.getNext().getNext());
                first.getNext().setNext(newNode);
                size++;
                return true;
            }
            Node<T> newNode2 = first;
            while ((newNode2.getNext().getNext()) != null && i < index) {
                i++;
                newNode2 = newNode2.getNext();
                }

            newNode.setNext(newNode2.getNext());
            newNode2.setNext(newNode);
            size++;
            return true;
                }
            }


    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        Node<T> ptr;
        if (index >= size || index < 0) {
            return null;
        }
        ptr = first.getNext();
        for (int i = 0; i < index; i++) {
            ptr = ptr.getNext();
        }
        return ptr.getData();
    }

    @Override
    public int indexOf(T element) {
        if (element != null && !isEmpty()) {
            Node<T> temp = first;
            int i = 0;
            while (temp != null) {
                if (temp.getData().compareTo(element) == 0) {
                    return i;
                }
                i++;
                temp = temp.getNext();
                }
            }
            return -1;
    }

    @Override
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        T temp;
        Node<T> index;
        Node<T> ptr = first.getNext();
        if (first.getNext() == null) {
            return;
        }
        else{
            while (ptr != null){
                index = ptr.getNext();
                while (index != null){
                    if (ptr.getData().compareTo(index.getData()) > 0){
                        temp = ptr.getData();
                        ptr.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                ptr = ptr.getNext();
            }
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> trail = first;
        Node<T> ptr = first.getNext();
        for (int i = 0; i < index; i++) {
            trail = ptr;
            ptr = ptr.getNext();
        }
        trail.setNext(ptr.getNext());
        size--;
        return ptr.getData();
    }

    @Override
    //TA
    public void equalTo(T element) {
        if (element != null) {
            int count = 0;
            Node<T> ptr = first.getNext();
            Node<T> temp1 = new Node<T>(null);
            Node<T> temp2 = ptr;
            while (ptr != null) {
                if (ptr.getData().compareTo(element) == 0) {
                    temp2.setNext(ptr);
                    temp2 = temp2.getNext();
                    count++;
                }
                ptr = ptr.getNext();
            }
            temp2.setNext(null);
            first = temp1;
            size = count;
        }
    }

    @Override
    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = first.getNext();
        Node<T> next = null;
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        first.setNext(prev);
    }

    @Override
    //TA
    public void merge(List<T> otherList) {
        // for the mergeSize do size + otherSize
        // at the end make the mergeList your mainList
        // there are different cases for both mainList and otherList
        // some of them are like if both are null or one or the other is null
    }

    @Override
    public void pairSwap() {
        Node<T> ptr = first.getNext();
        while(ptr != null && ptr.getNext() != null){
            T k = ptr.getData();
            ptr.setData(ptr.getNext().getData());
            ptr.getNext().setData(k);
            ptr = ptr.getNext().getNext();
        }
    }

    @Override
    public boolean isSorted() {
        Node<T> index;
        Node<T> ptr = first;
        index = ptr.getNext();
        if (ptr.getData().compareTo(index.getData()) > 0) {
            index = index.getNext();
            ptr = ptr.getNext();
            return false;
        }
        return true;
    }
}

