package org.uael.jds;

import java.util.Iterator;

/**
 * The type Stack.
 * @param <T> the type parameter
 */
public class Stack<T> extends LinkedContainer<T> implements Container<T> {
    /**
     * Instantiates a new Stack.
     */
    public Stack() {
        super();
    }

    /**
     * Instantiates a new Stack.
     * @param values the values
     */
    @SafeVarargs
    public Stack(T... values) {
        super(values);
    }

    /**
     * Instantiates a new Stack.
     * @param iterable the iterable
     */
    public Stack(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new Stack.
     * @param iterator the iterator
     */
    public Stack(Iterator<? extends T> iterator) {
        super(iterator);
    }
}
