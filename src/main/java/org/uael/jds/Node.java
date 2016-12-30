package org.uael.jds;

import java.util.Objects;

/**
 * The type Node.
 *
 * @param <T> the type parameter
 */
class Node<T> {
    transient Node<T> prev, next;
    T value;

    /**
     * Instantiates a new Node.
     */
    Node() {
        this.prev = this;
        this.next = this;
    }

    /**
     * Instantiates a new Node.
     *
     * @param value the value
     */
    Node(T value) {
        this();
        this.value = value;
    }

    /**
     * Clear.
     */
    void clear() {
        this.value = null;
        this.next = this;
        this.prev = this;
    }

    /**
     * Find node node.
     *
     * @param o the o
     * @return the node
     */
    final Node<T> find(Object o) {
        return this.next.find(this, o);
    }

    private Node<T> find(Node<T> end, Object o) {
        if (Objects.equals(this.value, o)) {
            return this;
        }
        return this.next != end ? this.next.find(end, o) : null;
    }

    /**
     * Next node.
     *
     * @param index the index
     * @return the node
     */
    Node<T> next(int index) {
        return index <= 0 ? this.next : this.next.next(index - 1);
    }

    /**
     * Prev node.
     *
     * @param index the index
     * @return the node
     */
    Node<T> prev(int index) {
        return index <= 0 ? this.prev : this.prev.prev(index - 1);
    }
}
