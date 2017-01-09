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
    default void add(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Add.
     * @param iterable the iterable
     */
    default void add(Iterable<? extends T> iterable) {
        add(iterable.iterator());
    }

    /**
     * Add.
     * @param iterator the iterator
     */
    default void add(Iterator<? extends T> iterator) {
        if (iterator.hasNext()) {
            add(iterator.next());
            add(iterator);
        }
    }

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
