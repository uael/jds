package org.uael.jds;

import java.util.Iterator;

/**
 * The interface Iterator.
 * @param <T> the type parameter
 */
public interface DoubleIterator<T> extends Iterator<T> {
    /**
     * Has previous boolean.
     * @return the boolean
     */
    boolean hasPrevious();

    /**
     * Previous t.
     * @return the t
     */
    T previous();
}
