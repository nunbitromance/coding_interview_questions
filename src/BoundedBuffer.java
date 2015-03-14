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