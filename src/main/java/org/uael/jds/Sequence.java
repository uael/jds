package org.uael.jds;

import java.util.Iterator;
import java.util.Objects;

/**
 * The interface Sequence.
 * @param <T> the type parameter
 */
public interface Sequence<T> extends Container<T>, DoubleIterable<T> {
    /**
     * Capacity int.
     * @return the int
     */
    int capacity();

    /**
     * Contains boolean.
     * @param value the value
     * @return the boolean
     */
    boolean contains(Object value);

    /**
     * Contains boolean.
     * @param values the values
     * @return the boolean
     */
    boolean contains(Object... values);

    /**
     * Contains boolean.
     * @param iterable the iterable
     * @return the boolean
     */
    boolean contains(Iterable<?> iterable);

    /**
     * Contains boolean.
     * @param iterator the iterator
     * @return the boolean
     */
    boolean contains(Iterator<?> iterator);

    /**
     * Erase boolean.
     * @param value the value
     * @return the boolean
     */
    boolean erase(Object value);

    /**
     * Erase boolean.
     * @param values the values
     * @return the boolean
     */
    boolean erase(Object... values);

    /**
     * Erase boolean.
     * @param iterable the iterable
     * @return the boolean
     */
    boolean erase(Iterable<?> iterable);

    /**
     * Erase boolean.
     * @param iterator the iterator
     * @return the boolean
     */
    boolean erase(Iterator<?> iterator);

    /**
     * Filter.
     */
    default void filter() {
        filter(Objects::nonNull);
    }

    /**
     * Filter.
     * @param predicate the predicate
     */
    void filter(Predicate<Boolean, T> predicate);

    /**
     * Get t.
     * @param index the index
     * @return the t
     */
    T get(int index);

    /**
     * Index of int.
     * @param o the o
     * @return the int
     */
    int indexOf(Object o);

    /**
     * Insert.
     * @param index the index
     * @param value the value
     */
    void insert(int index, T value);

    /**
     * Insert.
     * @param index  the index
     * @param values the values
     */
    void insert(int index, T... values);

    /**
     * Insert.
     * @param index    the index
     * @param iterable the iterable
     */
    void insert(int index, Iterable<? extends T> iterable);

    /**
     * Insert.
     * @param index    the index
     * @param iterator the iterator
     */
    void insert(int index, Iterator<? extends T> iterator);

    /**
     * Remove t.
     * @param index the index
     * @return the t
     */
    T remove(int index);

    /**
     * Resize.
     * @param capacity the capacity
     */
    void resize(int capacity);

    /**
     * Set t.
     * @param index the index
     * @param value the value
     * @return the t
     */
    T set(int index, T value);

    /**
     * Shift t.
     * @return the t
     */
    T shift();

    /**
     * Slice.
     * @param index  the index
     * @param length the length
     */
    void slice(int index, int length);

    /**
     * Unshift.
     * @param value the value
     */
    void unshift(T value);

    /**
     * Unshift.
     * @param values the values
     */
    void unshift(T... values);

    /**
     * Unshift.
     * @param iterable the iterable
     */
    void unshift(Iterable<? extends T> iterable);

    /**
     * Unshift.
     * @param iterator the iterator
     */
    void unshift(Iterator<? extends T> iterator);
}
