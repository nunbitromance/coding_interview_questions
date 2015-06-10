public static class BoundedArrayBuffer<E> { // comparable to Java Concurrency in Practice 12.1
    private final Semaphore empty;
    private final Semaphore full = new Semaphore(0);
    private final E[] items;
    private int head = 0;
    private int tail = 0;

    public BoundedArrayBuffer(int capacity) {
        empty = new Semaphore(capacity);
        items = (E[])new Object[capacity];
    }

    public boolean offer(E e) throws InterruptedException {
        empty.acquire();
        synchronized (this) {
            items[tail] = e;
            tail = (++tail == items.length) ? 0 : tail;
        }
        full.release();
        return true;
    }

    public E poll() throws InterruptedException {
        full.acquire();
        E e;
        synchronized (this) {
            e = items[head];
            head = (++head == items.length) ? 0 : head;
        }
        empty.release();
        return e;
    }

    public boolean isEmpty() {
        return full.availablePermits() == 0;
    }

    public boolean isFull() {
        return empty.availablePermits() == 0;
    }
}

// second implementation using one atomic integer
public class BoundedBlockingQueue<E> {  
   private final Queue<E> queue = new LinkedList<E>();  
   private final int capacity;  
   private final AtomicInteger count = new AtomicInteger(0);  

   public BoundedBlockingQueue(int capacity) {  
     if (capacity <= 0)  throw new InvalidArgumentException("The capacity of the queue must be > 0.");
     this.capacity = capacity;  
   }  
   
   public int size() {  
     return count.get();  
   }  
   
   public synchronized void add(E e) throws RuntimeException {  
     if (e == null) throw new NullPointerException("Null element is not allowed.");  
   
     int oldCount = -1;
     while (count.get() == capacity) wait();  
   
     queue.add(e);  
     oldCount = count.getAndIncrement();  
     if (oldCount == 0) {
       notifyAll(); // notify other waiting threads (could be producers or consumers)  
     }
   }  
   
   public synchronized E remove() throws NoSuchElementException {  
     E e;  
   
     int oldCount = -1;
     while (count.get() == 0) wait();  
  
     e = queue.remove();  
     oldCount = count.getAndDecrement();  
     if (oldCount == this.capacity) {
       notifyAll(); // notify other waiting threads (could be producers or consumers)  
     }
     return e;
   } 
 
   /* Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty. */
   public E peek() {  
     if (count.get() == 0) return null;  
     synchronized(this) {
       return queue.peek();  
     }
   }  
 }  
