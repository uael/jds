package org.uael.jds;

import java.util.Iterator;

/**
 * The interface Container.
 * @param <T> the type parameter
 */
public interface Container<T> extends Collection<T> {
    @Override
    default void add(T value) {
        push(value);
    }

    @Override
    default void add(T[] values) {
        push(values);
    }

    @Override
    default void add(Iterable<? extends T> iterable) {
        push(iterable);
    }

    @Override
    default void add(Iterator<? extends T> iterator) {
        push(iterator);
    }

    /**
     * First t.
     * @return the t
     */
    T first();

    /**
     * Last t.
     * @return the t
     */
    T last();

    /**
     * Pop t.
     * @return the t
     */
    T pop();

    /**
     * Push.
     * @param value the value
     */
    void push(T value);

    /**
     * Push.
     * @param values the values
     */
    @SuppressWarnings("unchecked")
    void push(T... values);

    /**
     * Push.
     * @param iterable the iterable
     */
    void push(Iterable<? extends T> iterable);

    /**
     * Push.
     * @param iterator the iterator
     */
    void push(Iterator<? extends T> iterator);
}
