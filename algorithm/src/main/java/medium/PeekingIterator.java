package medium;

import java.util.Iterator;

/**
 * Problem:
 * No: 284
 * Link: https://leetcode.com/problems/peeking-iterator/
 * <p/>
 * Analysis:
 * Guava has a PeekingIterator interface and an implementation in Iterators class which is named PeekingImpl.
 * This implementation refers to Iterators.PeekingImpl.
 */
public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private boolean hasPeeked;//when hasPeeked is true, iterator.next() is equals to peekingIterator.next().next()
    private int peekedElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            hasPeeked = true;
            peekedElement = iterator.next();
        }
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeeked) {
            hasPeeked = false;
            return peekedElement;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }

    @Override
    public void remove() {
        if (hasNext()) {
            iterator.remove();
        }
    }
}
