package org.uael.jds;

import java.util.Iterator;

/**
 * The type Reversed.
 * @param <T> the type parameter
 */
public class Reversed<T> implements Iterable<T> {
    private DoubleIterable<T> iterable;

    /**
     * Instantiates a new Reversed.
     * @param iterable the iterable
     */
    public Reversed(DoubleIterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        final DoubleIterator<T> it = iterable.iterator();
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return it.hasPrevious();
            }

            @Override
            public T next() {
                return it.previous();
            }
        };
    }
}
