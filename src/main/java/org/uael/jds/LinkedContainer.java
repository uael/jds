package org.uael.jds;

import java.util.Iterator;

/**
 * The type Linked base.
 * @param <T> the type parameter
 */
abstract class LinkedContainer<T> extends LinkedCollection<T> implements Container<T> {
    /**
     * Instantiates a new Linked base.
     */
    LinkedContainer() {
        super();
    }

    /**
     * Instantiates a new Linked base.
     * @param values the values
     */
    @SafeVarargs
    LinkedContainer(T... values) {
        super(values);
    }

    /**
     * Instantiates a new Linked base.
     * @param iterable the iterable
     */
    LinkedContainer(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new Linked base.
     * @param iterator the iterator
     */
    LinkedContainer(Iterator<? extends T> iterator) {
        super(iterator);
    }

    @Override
    public T first() {
        return this.next.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new ContainerIt(this);
    }

    @Override
    public T last() {
        return this.prev.value;
    }

    @Override
    public T pop() {
        return this.unlink(this.prev, this.prev.prev, this.prev.next).value;
    }

    @Override
    public void push(T value) {
        this.insertBefore(this, value);
    }

    @SafeVarargs
    public final void push(T... values) {
        this.insertBefore(this, values);
    }

    @Override
    public void push(Iterable<? extends T> iterable) {
        this.insertBefore(this, iterable.iterator());
    }

    @Override
    public void push(Iterator<? extends T> iterator) {
        this.insertBefore(this, iterator);
    }

    /**
     * The type Container iterator.
     */
    class ContainerIt implements Iterator<T> {
        Container<T> container;

        /**
         * Instantiates a new Container iterator.
         * @param container the container
         */
        ContainerIt(Container<T> container) {
            this.container = container;
        }

        @Override
        public boolean hasNext() {
            return !container.isEmpty();
        }

        @Override
        public T next() {
            return container.pop();
        }
    }
}
