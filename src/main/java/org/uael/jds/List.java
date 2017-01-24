package org.uael.jds;

import java.util.Iterator;

/**
 * The type List.
 * @param <T> the type parameter
 */
public class List<T> extends LinkedSequence<T> implements Queryable<T> {
    /**
     * Instantiates a new List.
     */
    public List() {
        super();
    }

    /**
     * Instantiates a new List.
     * @param values the values
     */
    @SafeVarargs
    public List(T... values) {
        super(values);
    }

    /**
     * Instantiates a new List.
     * @param iterable the iterable
     */
    public List(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new List.
     * @param iterator the iterator
     */
    public List(Iterator<? extends T> iterator) {
        super(iterator);
    }

    /**
     * Count int.
     * @param predicate the predicate
     * @return the int
     */
    public int count(Predicate<Boolean, T> predicate) {
        return this.count(this.next, predicate);
    }

    private int count(Node<T> node, Predicate<Boolean, T> predicate) {
        if (node == this) {
            return 0;
        }
        return (predicate.call(node.value) ? 1 : 0) + this.count(node.next, predicate);
    }

    /**
     * Select list.
     * @param <U>       the type parameter
     * @param predicate the predicate
     * @return the list
     */
    public <U> List<U> select(Predicate<U, T> predicate) {
        return this.select(this.next, new List<>(), predicate);
    }

    private <U> List<U> select(Node<T> node, List<U> result, Predicate<U, T> predicate) {
        if (node == this) {
            return result;
        }
        result.push(predicate.call(node.value));
        return this.select(node.next, result, predicate);
    }

    /**
     * Where list.
     * @param predicate the predicate
     * @return the list
     */
    public List<T> where(Predicate<Boolean, T> predicate) {
        return this.where(this.next, new List<>(), predicate);
    }

    private List<T> where(Node<T> node, List<T> result, Predicate<Boolean, T> predicate) {
        if (node == this) {
            return result;
        }
        if (predicate.call(node.value)) {
            result.push(node.value);
        }
        return this.where(node.next, result, predicate);
    }

    public List<T> copy() {
        return new List<>(this);
    }
}
