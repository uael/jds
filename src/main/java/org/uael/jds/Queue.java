package org.uael.jds;

import java.util.Iterator;

/**
 * The type Queue.
 * @param <T> the type parameter
 */
public class Queue<T> extends LinkedContainer<T> {
    /**
     * Instantiates a new Queue.
     */
    public Queue() {
        super();
    }

    /**
     * Instantiates a new Queue.
     * @param values the values
     */
    @SafeVarargs
    public Queue(T... values) {
        super(values);
    }

    /**
     * Instantiates a new Queue.
     * @param iterable the iterable
     */
    public Queue(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new Queue.
     * @param iterator the iterator
     */
    public Queue(Iterator<? extends T> iterator) {
        super(iterator);
    }

    @Override
    public T pop() {
        return this.pop_front().value;
    }
}
