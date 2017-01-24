package org.uael.jds;

/**
 * The interface Predicate.
 * @param <U> the type parameter
 * @param <T> the type parameter
 */
public interface Predicate<U, T> {
    /**
     * Call u.
     * @param item the item
     * @return the u
     */
    U call(T item);
}
