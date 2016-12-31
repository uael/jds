package org.uael.jds;

import java.util.Objects;

/**
 * The type Node.
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
     * @param o the o
     * @return the node
     */
    final Node<T> find(Object o) {
        Node<T> node = this.next;
        while (node != this) {
            if (Objects.equals(node.value, o)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Next node.
     * @param index the index
     * @return the node
     */
    Node<T> next(int index) {
        Node<T> node = this.next;
        while (index-- > 0) {
            node = node.next;
        }
        return node;
    }

    /**
     * Prev node.
     * @param index the index
     * @return the node
     */
    Node<T> prev(int index) {
        Node<T> node = this.prev;
        while (index-- > 0) {
            node = node.prev;
        }
        return node;
    }
}
