package org.uael.jds;

import java.util.Iterator;

/**
 * The interface Collection.
 * @param <T> the type parameter
 */
public interface Collection<T> extends Iterable<T> {
    /**
     * Add.
     * @param value the value
     */
    void add(T value);

    /**
     * Add.
     * @param values the values
     */
    @SuppressWarnings("unchecked")
    void add(T... values);

    /**
     * Add.
     * @param iterable the iterable
     */
    void add(Iterable<? extends T> iterable);

    /**
     * Add.
     * @param iterator the iterator
     */
    void add(Iterator<? extends T> iterator);

    /**
     * Clear.
     */
    void clear();

    /**
     * Is empty boolean.
     * @return the boolean
     */
    boolean isEmpty();

    /**
     * Size int.
     * @return the int
     */
    int size();
}
