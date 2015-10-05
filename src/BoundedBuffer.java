
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
