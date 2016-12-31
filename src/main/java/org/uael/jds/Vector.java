package org.uael.jds;

import java.util.Iterator;

/**
 * The type Vector.
 * @param <T> the type parameter
 */
public class Vector<T> implements Sequence<T> {
    private int capacity;
    private transient Object[] data;
    private int size = 0;

    /**
     * Instantiates a new Vector.
     */
    public Vector() {
        this(10);
    }

    /**
     * Instantiates a new Vector.
     * @param capacity the capacity
     */
    public Vector(int capacity) {
        this.data = new Object[this.capacity = capacity];
    }

    /**
     * Instantiates a new Vector.
     * @param values the values
     */
    @SafeVarargs
    public Vector(T... values) {
        this();
        this.push(values);
    }

    /**
     * Instantiates a new Vector.
     * @param iterable the iterable
     */
    public Vector(Iterable<? extends T> iterable) {
        this();
        this.push(iterable);
    }

    /**
     * Instantiates a new Vector.
     * @param iterator the iterator
     */
    public Vector(Iterator<? extends T> iterator) {
        this();
        this.push(iterator);
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.data[i] = null;
        }
        this.size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void filter(Predicate<Boolean, T> predicate) {
        for (int index = 0; index < this.size; ++index) {
            if (!predicate.call((T) this.data[index])) {
                this.remove(index--);
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.data[index];
    }

    @Override
    public int indexOf(Object o) {
        int index;
        if (o == null) {
            for (index = 0; index < this.size; ++index) {
                if (this.data[index] == null) {
                    return index;
                }
            }
        } else {
            for (index = 0; index < this.size; ++index) {
                if (o.equals(this.data[index])) {
                    return index;
                }
            }
        }

        return -1;
    }

    @SafeVarargs
    @Override
    public final void insert(int index, T... values) {
        int length = values.length;
        this.resize(this.size + length);
        int i = this.size - index;
        if (i > 0) {
            System.arraycopy(this.data, index, this.data, index + length, i);
        }

        System.arraycopy(values, 0, this.data, index, length);
        this.size += length;
    }

    @Override
    public void insert(int index, T value) {
        this.resize(this.size + 1);
        System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
        this.data[index] = value;
        ++this.size;
    }

    @Override
    public DoubleIterator<T> iterator() {
        return new Itr();
    }

    @SafeVarargs
    @Override
    public final void push(T... values) {
        int length = values.length;
        this.resize(this.size + length);
        System.arraycopy(values, 0, this.data, this.size, length);
        this.size += length;
    }

    public void push(Collection<? extends T> collection) {
        this.push(collection.toArray());
    }

    @Override
    public void push(T value) {
        this.resize(this.size + 1);
        this.data[this.size++] = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Object object = this.data[index];
        int length = this.size - index - 1;
        if (length > 0) {
            System.arraycopy(this.data, index + 1, this.data, index, length);
        }
        this.data[--this.size] = null;
        return (T) object;
    }

    @Override
    public void resize(int capacity) {
        if (capacity - this.capacity > 0) {
            this.capacity = this.capacity + (this.capacity >> 1);
            if (this.capacity - capacity < 0) {
                this.capacity = capacity;
            }
            Object[] objects = new Object[this.capacity];
            System.arraycopy(this.data, 0, objects, 0, this.data.length);
            this.data = objects;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T value) {
        Object var3 = this.data[index];
        this.data[index] = value;
        return (T) var3;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void slice(int index, int length) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] objects = new Object[this.size];
        System.arraycopy(this.data, 0, objects, 0, this.size);
        return (T[]) objects;
    }

    @SafeVarargs
    @Override
    public final void unshift(T... values) {
        int length = values.length;
        this.resize(this.size + length);
        if (this.size > 0) {
            System.arraycopy(this.data, 0, this.data, length, this.size);
        }
        System.arraycopy(values, 0, this.data, 0, length);
        this.size += length;
    }

    /**
     * The type Itr.
     */
    class Itr implements DoubleIterator<T> {
        /**
         * The Index.
         */
        int index;
        /**
         * The Prev index.
         */
        int prevIndex;

        /**
         * Instantiates a new Itr.
         */
        Itr() {
            index = 0;
            prevIndex = size - 1;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public boolean hasPrevious() {
            return prevIndex >= 0 && prevIndex > size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) data[index++];
        }

        @Override
        @SuppressWarnings("unchecked")
        public T previous() {
            return (T) data[prevIndex++];
        }
    }
}
