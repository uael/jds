package org.uael.jds;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The type Linked base.
 * @param <T> the type parameter
 */
abstract class LinkedCollection<T> extends Node<T> implements Collection<T> {
    /**
     * The Size.
     */
    int size = 0;

    /**
     * Instantiates a new Linked base.
     */
    LinkedCollection() {
        super();
    }

    /**
     * Instantiates a new Linked base.
     * @param values the values
     */
    @SafeVarargs
    LinkedCollection(T... values) {
        super();
        this.insertBefore(this, values);
    }

    /**
     * Instantiates a new Linked base.
     * @param iterable the iterable
     */
    LinkedCollection(Iterable<? extends T> iterable) {
        super();
        this.insertBefore(this, iterable.iterator());
    }

    /**
     * Instantiates a new Linked base.
     * @param iterator the iterator
     */
    LinkedCollection(Iterator<? extends T> iterator) {
        super();
        this.insertBefore(this, iterator);
    }

    @Override
    public void clear() {
        super.clear();
        this.size = 0;
    }

    /**
     * Insert after node.
     * @param node  the node
     * @param value the value
     * @return the node
     */
    final Node<T> insertAfter(Node<T> node, T value) {
        return this.link(new Node<>(value), node, node.next);
    }

    /**
     * Insert after node.
     * @param node   the node
     * @param values the values
     * @return the node
     */
    @SafeVarargs
    final Node<T> insertAfter(Node<T> node, T... values) {
        Node<T> n = node;
        for (T value : values) {
            n = this.insertAfter(n, value);
        }
        return n;
    }

    /**
     * Insert after node.
     * @param node     the node
     * @param iterator the iterator
     * @return the node
     */
    final Node<T> insertAfter(Node<T> node, Iterator<? extends T> iterator) {
        if (!iterator.hasNext()) {
            return node;
        }
        return this.insertAfter(this.insertAfter(node, iterator.next()), iterator);
    }

    /**
     * Insert before node.
     * @param node  the node
     * @param value the value
     * @return the node
     */
    final Node<T> insertBefore(Node<T> node, T value) {
        return this.link(new Node<>(value), node.prev, node);
    }

    /**
     * Insert before node.
     * @param node   the node
     * @param values the values
     * @return the node
     */
    @SafeVarargs
    final Node<T> insertBefore(Node<T> node, T... values) {
        Node<T> n = node;
        for (T value : values) {
            n = this.insertBefore(node, value);
        }
        return n;
    }

    /**
     * Insert before node.
     * @param node     the node
     * @param iterator the iterator
     * @return the node
     */
    final Node<T> insertBefore(Node<T> node, Iterator<? extends T> iterator) {
        if (!iterator.hasNext()) {
            return node;
        }
        return this.insertAfter(this.insertBefore(node, iterator.next()), iterator);
    }

    /**
     * Link node.
     * @param node the node
     * @param prev the prev
     * @param next the next
     * @return the node
     */
    Node<T> link(Node<T> node, Node<T> prev, Node<T> next) {
        this.size++;
        node.next = prev.next;
        node.prev = next.prev;
        prev.next = node;
        next.prev = node;
        return node;
    }

    @Override
    Node<T> next(int index) {
        if (index >= this.size) {
            throw new NoSuchElementException();
        }
        if (index < this.size >> 1) {
            return super.next(index);
        } else {
            return super.prev(this.size - index - 1);
        }
    }

    @Override
    Node<T> prev(int index) {
        if (index >= this.size) {
            throw new NoSuchElementException();
        }
        if (index < this.size >> 1) {
            return super.prev(index);
        } else {
            return super.next(this.size - index - 1);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * Unlink node.
     * @param node the node
     * @return the node
     */
    final Node<T> unlink(Node<T> node) {
        return unlink(node, node.prev, node.next);
    }

    /**
     * Unlink node.
     * @param node the node
     * @param prev the prev
     * @param next the next
     * @return the node
     */
    Node<T> unlink(Node<T> node, Node<T> prev, Node<T> next) {
        if (this.size <= 0) {
            return node;
        }
        this.size--;
        next.prev = prev;
        prev.next = next;
        node.prev = node;
        node.next = node;
        return node;
    }
}
