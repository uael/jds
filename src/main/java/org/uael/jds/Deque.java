package org.uael.jds;

import java.util.Iterator;

/**
 * The type Deque.
 * @param <T> the type parameter
 */
public class Deque<T> extends LinkedSequence<T> {
    /**
     * Instantiates a new Deque.
     */
    public Deque() {
        super();
    }

    /**
     * Instantiates a new Deque.
     * @param values the values
     */
    @SafeVarargs
    public Deque(T... values) {
        super(values);
    }

    /**
     * Instantiates a new Deque.
     * @param iterable the iterable
     */
    public Deque(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new Deque.
     * @param iterator the iterator
     */
    public Deque(Iterator<? extends T> iterator) {
        super(iterator);
    }

    @Override
    public DoubleIterator<T> iterator() {
        return new DequeIt(this);
    }

    /**
     * The type Deque it.
     */
    class DequeIt extends ContainerIt implements DoubleIterator<T> {

        /**
         * Instantiates a new Container iterator.
         * @param container the container
         */
        DequeIt(Sequence<T> container) {
            super(container);
        }

        @Override
        public boolean hasPrevious() {
            return !container.isEmpty();
        }

        @Override
        public T previous() {
            return ((Sequence<T>)container).shift();
        }
    }
}
