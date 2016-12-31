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
    default boolean contains(Object value) {
        return this.indexOf(value) >= 0;
    }

    /**
     * Contains boolean.
     * @param values the values
     * @return the boolean
     */
    default boolean contains(Object... values) {
        for (Object object : values) {
            if (!this.contains(object)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Contains boolean.
     * @param iterable the iterable
     * @return the boolean
     */
    default boolean contains(Iterable<?> iterable) {
        return this.contains(iterable.iterator());
    }

    /**
     * Contains boolean.
     * @param iterator the iterator
     * @return the boolean
     */
    default boolean contains(Iterator<?> iterator) {
        return !iterator.hasNext() || this.contains(iterator.next()) && this.contains(iterator);
    }

    /**
     * Erase boolean.
     * @param value the value
     * @return the boolean
     */
    default boolean erase(Object value) {
        int i = indexOf(value);
        return i >= 0 && remove(this.indexOf(value)) != null;
    }

    /**
     * Erase boolean.
     * @param values the values
     * @return the boolean
     */
    default boolean erase(Object... values) {
        int count = 0, removed = 0;
        for (Object object : values) {
            count++;
            if (this.erase(object)) {
                removed++;
            }
        }
        return count == removed;
    }

    /**
     * Erase boolean.
     * @param iterable the iterable
     * @return the boolean
     */
    default boolean erase(Iterable<?> iterable) {
        return this.erase(iterable.iterator());
    }

    /**
     * Erase boolean.
     * @param iterator the iterator
     * @return the boolean
     */
    default boolean erase(Iterator<?> iterator) {
        int count = 0, removed = 0;
        while (iterator.hasNext()) {
            count++;
            if (this.erase(iterator.next())) {
                removed++;
            }
        }
        return count == removed;
    }

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

    @Override
    default T first() {
        if (this.size() <= 0) {
            return null;
        }
        return this.get(0);
    }

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
    default void insert(int index, T... values) {
        for (T value : values) {
            this.insert(index, value);
        }
    }

    /**
     * Insert.
     * @param index    the index
     * @param iterable the iterable
     */
    default void insert(int index, Iterable<? extends T> iterable) {
        this.insert(index, iterable.iterator());
    }

    /**
     * Insert.
     * @param index    the index
     * @param iterator the iterator
     */
    default void insert(int index, Iterator<? extends T> iterator) {
        while (iterator.hasNext()) {
            this.insert(index++, iterator.next());
        }
    }

    @Override
    default T last() {
        if (this.size() <= 0) {
            return null;
        }
        return this.get(Math.max(this.size() - 1, 0));
    }

    @Override
    default T pop() {
        if (this.size() <= 0) {
            return null;
        }
        return this.remove(Math.max(this.size() - 1, 0));
    }

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
    default T shift() {
        return this.remove(0);
    }

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
    default void unshift(T value) {
        this.insert(0, value);
    }

    /**
     * Unshift.
     * @param values the values
     */
    default void unshift(T... values) {
        for (int i = values.length; i >= 0; i--) {
            this.unshift(values[i]);
        }
    }

    /**
     * Unshift.
     * @param iterable the iterable
     */
    default void unshift(Iterable<? extends T> iterable) {
        this.unshift(iterable.iterator());
    }

    /**
     * Unshift.
     * @param iterator the iterator
     */
    default void unshift(Iterator<? extends T> iterator) {
        if (iterator.hasNext()) {
            this.unshift(iterator.next());
        }
        while (iterator.hasNext()) {
            this.insert(1, iterator.next());
        }
    }
}
