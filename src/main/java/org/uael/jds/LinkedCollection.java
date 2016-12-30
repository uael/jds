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
        this.push_back(values);
    }

    /**
     * Instantiates a new Linked base.
     * @param iterable the iterable
     */
    LinkedCollection(Iterable<? extends T> iterable) {
        super();
        this.push_back(iterable.iterator());
    }

    /**
     * Instantiates a new Linked base.
     * @param iterator the iterator
     */
    LinkedCollection(Iterator<? extends T> iterator) {
        super();
        this.push_back(iterator);
    }

    /**
     * Back node.
     * @return the node
     */
    final Node<T> back() {
        return this.prev;
    }

    @Override
    public void clear() {
        super.clear();
        this.size = 0;
    }

    /**
     * Front node.
     * @return the node
     */
    final Node<T> front() {
        return this.next;
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
    final Node<T> insertAfter(Node<T> node, T... values) {
        return this.insertAfter(node, values, 0);
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

    private Node<T> insertAfter(Node<T> node, T[] values, int index) {
        if (index >= values.length) {
            return node;
        }
        return this.insertAfter(this.insertAfter(node, values[index]), values, index + 1);
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
    final Node<T> insertBefore(Node<T> node, T... values) {
        return this.insertBefore(node, values, 0);
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

    private Node<T> insertBefore(Node<T> node, T[] values, int index) {
        if (index >= values.length) {
            return node;
        }
        return this.insertAfter(this.insertBefore(node, values[index]), values, index + 1);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
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

    /**
     * Pop back node.
     * @return the node
     */
    final Node<T> pop_back() {
        return this.unlink(this.prev, this.prev.prev, this.prev.next);
    }

    /**
     * Pop front node.
     * @return the node
     */
    final Node<T> pop_front() {
        return this.unlink(this.next, this.next.prev, this.next.next);
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

    /**
     * Push back node.
     * @param value the value
     * @return the node
     */
    final Node<T> push_back(T value) {
        return this.insertBefore(this, value);
    }

    /**
     * Push back node.
     * @param values the values
     * @return the node
     */
    @SafeVarargs
    final Node<T> push_back(T... values) {
        return this.insertBefore(this, values);
    }

    /**
     * Push back node.
     * @param iterator the iterator
     * @return the node
     */
    final Node<T> push_back(Iterator<? extends T> iterator) {
        return this.insertBefore(this, iterator);
    }

    /**
     * Push front node.
     * @param value the value
     * @return the node
     */
    final Node<T> push_front(T value) {
        return this.insertAfter(this, value);
    }

    /**
     * Push front node.
     * @param values the values
     * @return the node
     */
    @SafeVarargs
    final Node<T> push_front(T... values) {
        return this.insertAfter(this, values);
    }

    /**
     * Push front node.
     * @param iterator the iterator
     * @return the node
     */
    final Node<T> push_front(Iterator<? extends T> iterator) {
        return this.insertAfter(this, iterator);
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
