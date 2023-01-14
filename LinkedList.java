public class LinkedList<T extends Comparable<T>> implements List<T> {
    //Class Attributes:
    private int size = 0;
    private Node<T> headr;
    private boolean isSorted;

    public LinkedList() {
        headr = new Node<T>(null);
        isSorted = true;
    }

    public boolean checkSorted() {
        Node<T> top = headr.getNext();
        if (top == null) {
            return true;
        }
        while(top.getNext() != null){
            if(top.getData().compareTo(top.getNext().getData()) > 0){
                isSorted = false;
                return false;
            }
            top = top.getNext();
        }
        iSorted = true;
        return true;
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        Node<T> newNode = new Node<T>(element, null);
        if (headr == null) {
            headr = new Node<T>(element);
        }
        else {
            Node<T> ptr = headr;
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(newNode);
        }
        checkSorted();
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (element == null || index < 0 || index >= size) {
            return false;
        } else {
            int i = 0;
            Node<T> noder = new Node<T>(element);
            if (index == 0) {

                noder.setNext(headr.getNext());
                headr.setNext(noder);

                size++;
                return true;
            }
            Node<T> header = headr;
            while ((header.getNext().getNext()) != null && i < index) {
                i++;
                header = header.getNext();
            }

            noder.setNext(header.getNext());
            header.setNext(noder);
            checkSorted();
            size++;
            return true;
        }
    }


    @Override
    public void clear() {
        headr = null;
        isSorted = true;
        size = 0;
    }

    @Override
    public T get(int index) {
        Node<T> header;
        if (index >= size || index < 0) {
            return null;
        }
        header = headr.getNext();
        int i = 0;
        //
        while (i < index) {
            header = header.getNext();
            i++;

        }
        return header.getData();
    }

    @Override
    public int indexOf(T element) {
        if (element != null && !isEmpty()) {
            Node<T> head = headr;
            int i = 0;
            while (head != null) {
                if (head.getData().compareTo(element) == 0) {
                    return i;
                }
                i++;
                head = head.getNext();
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        T temp;
        Node<T> index;
        Node<T> header = headr.getNext();
        if (header != null) {
            while (header != null){
                index = header.getNext();
                while (index != null){
                    if (header.getData().compareTo(index.getData()) > 0){
                        temp = header.getData();
                        header.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                header = header.getNext();
            }
        }
        else{
            return;
        }
        isSorted = true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> trailer = headr;
        Node<T> temp = headr.getNext();
        int j = 0;
        while (j < index){
            trailer = temp;
            temp = temp.getNext();
            j++;
        }
        trailer.setNext(temp.getNext());
        size--;
        return temp.getData();
    }

    @Override
    public void equalTo(T element) {
        Node<T> head = headr.getNext();
        Node<T>  temp = new Node<T>(null);
        Node<T> otherTemp = temp;
        if (element != null) {
            int count = 0;
            while (head != null) {
                if (head.getData().compareTo(element) == 0) {
                    otherTemp.setNext(head);
                    otherTemp = otherTemp.getNext();
                    count++;
                }
                head = head.getNext();
            }
            otherTemp.setNext(null);
            headr = temp;
            size = count;
        }
    }

    @Override
    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = headr.getNext();
        Node<T> next = null;
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        headr.setNext(prev);
    }

    @Override
    //TA
    public void merge(List<T> otherList) {
        LinkedList<T> other = (LinkedList<T>) otherList;
        sort();
        other.sort();
        int mergedSize = size + other.size;
        if (headr.getNext() == null || other.headr.getNext() == null) {
            return; }
        Node<T> merged = new Node<T>(null);
        Node<T> ptr = merged;
        Node<T>  temp1 = headr.getNext();
        Node<T> otherTemp = other.headr.getNext();
        while(temp1 != null && otherTemp != null) {
            Node<T> temp;
            if (temp1.getData().compareTo(otherTemp.getData()) > 0) {
                temp = otherTemp;
                otherTemp = otherTemp.getNext();
            }
            else {
                temp = temp1;
                temp1 = temp1.getNext();
            }
            ptr.setNext(temp);
            ptr = ptr.getNext();
        }
        if (temp1 == null) {
            ptr.setNext(otherTemp);
        }
        else if (otherTemp == null) {
            ptr.setNext(temp1);
        }
        isSorted = true;
        size = mergedSize;
        headr = merged;
    }

    @Override
    public void pairSwap() {
        Node<T> ptr = headr.getNext();
        while(ptr != null && ptr.getNext() != null){
            T k = ptr.getData();
            ptr.setData(ptr.getNext().getData());
            ptr.getNext().setData(k);
            ptr = ptr.getNext().getNext();
        }
    }

    @Override
    public boolean isSorted() {
        return isSorted;
    }
}

