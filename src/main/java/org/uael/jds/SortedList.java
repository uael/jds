package org.uael.jds;

import java.util.Iterator;

/**
 * The type Ordered list.
 * @param <T> the type parameter
 */
public class SortedList<T extends Comparable<T>> extends List<T> {
    /**
     * Instantiates a new Ordered list.
     */
    public SortedList() {
        super();
    }

    /**
     * Instantiates a new Ordered list.
     * @param values the values
     */
    @SafeVarargs
    public SortedList(T... values) {
        super(values);
    }

    /**
     * Instantiates a new Ordered list.
     * @param iterable the iterable
     */
    public SortedList(Iterable<? extends T> iterable) {
        super(iterable);
    }

    /**
     * Instantiates a new Ordered list.
     * @param iterator the iterator
     */
    public SortedList(Iterator<? extends T> iterator) {
        super(iterator);
    }

    private int compare(T left, T right) {
        if (left == right) {
            return 0;
        }
        if (left == null) {
            return 1;
        }
        if (right == null) {
            return -1;
        }
        return left.compareTo(right);
    }

    @Override
    Node<T> link(Node<T> node, Node<T> prev, Node<T> next) {
        if (prev == this) {
            if (next == this || this.compare(node.value, next.value) <= 0) {
                return super.link(node, prev, next);
            }
        }
        if (next == this) {
            if (prev == this || this.compare(node.value, prev.value) >= 0) {
                return super.link(node, prev, next);
            }
        }
        int byPrev = this.compare(node.value, prev.value);
        int byNext = this.compare(node.value, next.value);
        if (byPrev == 0 || byNext == 0) {
            return super.link(node, prev, next);
        }
        if (byPrev == 1 && byNext == 1) {
            return this.link(node, prev.next, next.next);
        }
        if (byNext == -1 && byPrev == -1) {
            return this.link(node, prev.prev, next.prev);
        }
        return super.link(node, prev, next);
    }
}
