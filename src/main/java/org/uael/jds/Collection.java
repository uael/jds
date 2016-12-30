package org.uael.jds;

/**
 * The interface Collection.
 * @param <T> the type parameter
 */
public interface Collection<T> extends Iterable<T> {
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
