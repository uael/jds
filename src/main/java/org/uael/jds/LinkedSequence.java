package org.uael.jds;

import java.util.Iterator;
import java.util.Objects;

/**
 * The type Linked base.
 * @param <T> the type parameter
 */
abstract class LinkedSequence<T> extends LinkedContainer<T> implements Sequence<T> {
    /**
     * Instantiates a new Linked base.
     */
    LinkedSequence() {
        super();
    }

    /**
     * Instantiates a new Linked base.
     * @param values the values
     */
    @SafeVarargs
    LinkedSequence(T... values) {
        super(values);
    }

    /**
     * Instantiates a new Linked base.
     * @param iterable the iterable
     */
    LinkedSequence(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new Linked base.
     * @param iterator the iterator
     */
    LinkedSequence(Iterator<? extends T> iterator) {
        super(iterator);
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean contains(Object value) {
        return this.find(value) != null;
    }

    @Override
    public boolean contains(Object... values) {
        for (Object object : values) {
            if (this.find(object) == null) {
                return false;
            }
        }
        return values.length > 0;
    }

    @Override
    public boolean contains(Iterable<?> iterable) {
        return this.contains(iterable.iterator());
    }

    @Override
    public boolean contains(Iterator<?> iterator) {
        return !iterator.hasNext() || this.contains(iterator.next()) && this.contains(iterator);
    }

    private void erase(int from, int to) {
        if (to == from) {
            this.remove(from);
        }
        if (to < from) {
            return;
        }
        this.remove(from);
        this.remove(to);
        this.erase(from + 1, to - 1);
    }

    @Override
    public boolean erase(Object value) {
        Node<T> node = this.find(value);
        if (node != null) {
            this.unlink(node);
            return true;
        }
        return false;
    }

    @Override
    public boolean erase(Object... values) {
        int removed = 0;
        for (Object object : values) {
            if (this.erase(object)) {
                removed++;
            }
        }
        return values.length == removed;
    }

    @Override
    public boolean erase(Iterable<?> iterable) {
        return this.erase(iterable.iterator());
    }

    @Override
    public boolean erase(Iterator<?> iterator) {
        int removed = 0, count = 0;
        while (iterator.hasNext()) {
            count++;
            if (this.erase(iterator.next())) {
                removed++;
            }
        }
        return count == removed;
    }

    @Override
    public void filter(Predicate<Boolean, T> predicate) {
        this.filter(this.next, predicate);
    }

    /**
     * Filter.
     * @param node      the node
     * @param predicate the predicate
     */
    private void filter(Node<T> node, Predicate<Boolean, T> predicate) {
        if (node == this) {
            return;
        }
        if (!predicate.call(node.value)) {
            this.unlink(node);
        }
        this.filter(node.next, predicate);
    }

    @Override
    public T get(int index) {
        return this.next(index).value;
    }

    @Override
    public int indexOf(Object object) {
        return indexOf(this.next, object, 0);
    }

    private int indexOf(Node<T> node, Object object, int index) {
        if (node == this) {
            return -1;
        }
        return Objects.equals(node.value, object) ? index : indexOf(node.next, object, index + 1);
    }

    @Override
    public void insert(int index, T value) {
        this.insertBefore(this.next(index), value);
    }

    @Override
    @SafeVarargs
    public final void insert(int index, T... values) {
        this.insertBefore(this.next(index), values);
    }

    @Override
    public void insert(int index, Iterable<? extends T> iterable) {
        this.insertBefore(this.next(index), iterable.iterator());
    }

    @Override
    public void insert(int index, Iterator<? extends T> iterator) {
        this.insertBefore(this.next(index), iterator);
    }

    @Override
    public DoubleIterator<T> iterator() {
        return new SequenceIt(this);
    }

    @Override
    public T remove(int index) {
        return this.unlink(this.next(index)).value;
    }

    @Override
    public void resize(int capacity) {
        if (capacity < this.size()) {
            this.slice(0, capacity);
        }
    }

    @Override
    public T set(int index, T value) {
        return this.next(index).value = value;
    }

    @Override
    public T shift() {
        return this.unlink(this.next, this.next.prev, this.next.next).value;
    }

    @Override
    public void slice(int index, int length) {
        this.erase(0, index - 1);
        this.erase(length - 1, this.size - 1);
    }

    @Override
    public void unshift(T value) {
        this.insertAfter(this, value);
    }

    @Override
    @SafeVarargs
    public final void unshift(T... values) {
        this.insertAfter(this, values);
    }

    @Override
    public void unshift(Iterable<? extends T> iterable) {
        this.insertAfter(this, iterable.iterator());
    }

    @Override
    public void unshift(Iterator<? extends T> iterator) {
        this.insertAfter(this, iterator);
    }

    /**
     * The type Sequence iterator.
     */
    class SequenceIt implements DoubleIterator<T> {
        Node<T> current, end;

        /**
         * Instantiates a new Sequence iterator.
         * @param end the end
         */
        SequenceIt(Node<T> end) {
            this.end = end;
            this.current = end;
        }

        @Override
        public boolean hasNext() {
            return current.next != end;
        }

        @Override
        public boolean hasPrevious() {
            return current.prev != end;
        }

        @Override
        public T next() {
            return (current = current.next).value;
        }

        @Override
        public T previous() {
            return (current = current.prev).value;
        }
    }
}
