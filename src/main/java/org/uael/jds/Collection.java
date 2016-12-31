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
            this.add(value);
        }
    }

    /**
     * Add.
     * @param iterable the iterable
     */
    default void add(Iterable<? extends T> iterable) {
        this.add(iterable.iterator());
    }

    /**
     * Add.
     * @param iterator the iterator
     */
    default void add(Iterator<? extends T> iterator) {
        while (iterator.hasNext()) {
            this.add(iterator.next());
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
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Size int.
     * @return the int
     */
    int size();

    @SuppressWarnings("unchecked")
    default T[] toArray() {
        Object[] objects = new Object[this.size()];
        Iterator<T> iterator = this.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            objects[index++] = iterator.next();
        }
        return (T[]) objects;
    }
}
