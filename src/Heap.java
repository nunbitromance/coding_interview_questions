public class Heap<E extends Comparable<E>> {

    private E arr[];
    private int last;
    private int capacity;

    public Heap() {
        arr = new E[11];
        last = 0;
        capacity = 7;
    }

    public Heap(int cap) {
        arr = new E[cap + 1];
        last = 0;
        capacity = cap;
    }

    public int size() {
        return last;
    }

    //
    // returns the number of elements in the heap
    //

    public boolean isEmpty() {
        return size() == 0;
    }

    //
    // is the heap empty?
    //

    public E min() throws HeapException {
        if (isEmpty())
            throw new HeapException("The heap is empty.");
        else {
            E temp = arr[0];
            swap(arr, 0, last);
            last--;
            downHeapBubble();
            return temp;
        }
    }

    //
    // returns element with smallest key, without removal
    //

    private int compare(Object x, Object y) {
        return ((E) x).compareTo((E) y);
    }

    public void insert(E e) throws HeapException {
        if (size() == capacity)
            throw new HeapException("Heap overflow.");
        else{
            last++;
            S[last] = e;
            upHeapBubble();
        }       
    }

    // inserts e into the heap
    // throws exception if heap overflow
    //

    public E removeMin() throws HeapException {
        if (isEmpty())
            throw new HeapException("Heap is empty.");
        else {
            E min = min();
            S[1] = S[last];
            last--;
            downHeapBubble();
            return min;
        }
    }

    //
    // removes and returns smallest element of the heap
    // throws exception is heap is empty
    //

    /**
     * downHeapBubble() method is used after the removeMin() method to reorder the elements
     * in order to preserve the Heap properties
     */
    private void downHeapBubble(){
        int index = 0;
        while (true){
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            if (arr[left] < arr[right]) {
                swap(arr, index, left);
                index = left;
            } else {
                swap(arr, index, right);
                index = right;
            }
        }
    }

    /**
     * upHeapBubble() method is used after the insert(E e) method to reorder the elements
     * in order to preserve the Heap properties 
     */
    private void upHeapBubble(){
        int index = size();
        while (index > 0){
            int parent = index / 2;
            swap(index,parent);
            index = parent;
        }       
    }

    /**
     * Swaps two integers i and j
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Object temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }

    /**
     * the method is used in the downHeapBubble() method
     * @param leftChild
     * @param rightChild
     * @return min of left and right child, if they are equal return the left
     */
    private int findMin(int leftChild, int rightChild) {
        if (compare(S[leftChild], S[rightChild]) <= 0)
            return leftChild;
        else
            return rightChild;
    }

    public String toString() {
        String s = "[";
        for (int i = 1; i <= size(); i++) {
            s += S[i];
            if (i != last)
                s += ",";
        }
        return s + "]";
    }
    //
    // outputs the entries in S in the order S[1] to S[last]
    // in same style as used in ArrayQueue
    //

}

HeapException.java:

public class HeapException extends RuntimeException {
    public HeapException(){};
    public HeapException(String msg){super(msg);}
}
