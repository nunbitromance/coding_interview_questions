class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        if(iterator.hasNext()){
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = next;
        next = iter.hasNext() ? iter.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
  }
