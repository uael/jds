package org.uael.jds;

/**
 * The interface Double iterable.
 * @param <T> the type parameter
 */
public interface DoubleIterable<T> extends Iterable<T> {
    /**
     * Desc reversed.
     * @return the reversed
     */
    default Reversed<T> desc() {
        return new Reversed<>(this);
    }

    @Override
    DoubleIterator<T> iterator();
}
