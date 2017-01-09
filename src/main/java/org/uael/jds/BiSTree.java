package org.uael.jds;

import java.util.Iterator;

/**
 * The type Bi s tree.
 * @param <T> the type parameter
 */
public class BiSTree<T extends Comparable<T>> extends BiTree<AvlNode<T>> implements Collection<T> {

    /**
     * Instantiates a new Bi s tree.
     */
    public BiSTree() {
        super();
    }

    @Override
    public void add(T value) {
        insert(value);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Rotate left node.
     * @param node the node
     * @return the node
     */
    Node rotateLeft(Node node) {
        Node left = node.left;
        if (left.value.factor == Avl.LEFT_HEAVY) {
            node.left = left.right;
            left.right = node;
            return left;
        } else {
            Node grandchild = left.right;
            left.right = grandchild.left;
            grandchild.left = left;
            node.left = grandchild.right;
            grandchild.right = node;
            switch (grandchild.value.factor) {
                case LEFT_HEAVY:
                    node.value.factor = Avl.RIGHT_HEAVY;
                    left.value.factor = Avl.BALANCED;
                    break;
                case BALANCED:
                    node.value.factor = Avl.BALANCED;
                    left.value.factor = Avl.BALANCED;
                    break;
                case RIGHT_HEAVY:
                    node.value.factor = Avl.BALANCED;
                    left.value.factor = Avl.LEFT_HEAVY;
                    break;
            }
        }
        return node;
    }

    /**
     * Rotate right node.
     * @param node the node
     * @return the node
     */
    Node rotateRight(Node node) {
        Node right = node.left;
        if (right.value.factor == Avl.RIGHT_HEAVY) {
            node.right = right.left;
            right.left = node;
            return right;
        } else {
            Node grandchild = right.left;
            right.left = grandchild.right;
            grandchild.right = right;
            node.right = grandchild.left;
            grandchild.left = node;
            switch (grandchild.value.factor) {
                case LEFT_HEAVY:
                    node.value.factor = Avl.BALANCED;
                    right.value.factor = Avl.RIGHT_HEAVY;
                    break;
                case BALANCED:
                    node.value.factor = Avl.BALANCED;
                    right.value.factor = Avl.BALANCED;
                    break;
                case RIGHT_HEAVY:
                    node.value.factor = Avl.LEFT_HEAVY;
                    right.value.factor = Avl.BALANCED;
                    break;
            }
        }
        return node;
    }

    /**
     * Insert node.
     * @param value the value
     * @return the node
     */
    public Node insert(T value) {
        return insert(root, value);
    }

    /**
     * Insert node.
     * @param node  the node
     * @param value the value
     * @return the node
     */
    Node insert(Node node, T value) {
        if (node == null) {
            return insertLeft(null, new AvlNode<>(value));
        } else {
            int cmpval = node.value.compareTo(value);
            if (cmpval < 0) {
                if (node.left == null) {
                    node.insertLeft(new AvlNode<>(value));
                    switch (node.value.factor) {
                        case LEFT_HEAVY:
                            return rotateLeft(node);
                        case BALANCED:
                            node.value.factor = Avl.LEFT_HEAVY;
                            break;
                        case RIGHT_HEAVY:
                            node.value.factor = Avl.BALANCED;
                            break;
                    }
                } else {
                    return insert(node.left, value);
                }
            } else if (cmpval > 0) {
                if (node.right == null) {
                    node.insertRight(new AvlNode<>(value));
                    switch (node.value.factor) {
                        case LEFT_HEAVY:
                            node.value.factor = Avl.BALANCED;
                            break;
                        case BALANCED:
                            node.value.factor = Avl.RIGHT_HEAVY;
                            break;
                        case RIGHT_HEAVY:
                            return rotateRight(node);
                    }
                } else {
                    return insert(node.right, value);
                }
            } else if (node.value.hidden) {
                node.value.data = value;
                node.value.hidden = false;
            }
        }
        return node;
    }

    /**
     * Hide boolean.
     * @param value the value
     * @return the boolean
     */
    public boolean hide(T value) {
        return hide(root, value);
    }

    /**
     * Hide boolean.
     * @param node  the node
     * @param value the value
     * @return the boolean
     */
    boolean hide(Node node, T value) {
        if (node == null) {
            return false;
        }
        int cmpval = node.value.compareTo(value);
        if (cmpval < 0) {
            return hide(node.left, value);
        }
        if (cmpval > 0) {
            return hide(node.right, value);
        }
        node.value.hidden = true;
        return true;
    }

    /**
     * Lookup boolean.
     * @param value the value
     * @return the boolean
     */
    public boolean lookup(T value) {
        return lookup(root, value);
    }

    /**
     * Lookup boolean.
     * @param node  the node
     * @param value the value
     * @return the boolean
     */
    boolean lookup(Node node, T value) {
        if (node == null) {
            return false;
        }
        int cmpval = node.value.compareTo(value);
        if (cmpval < 0) {
            return lookup(node.left, value);
        }
        if (cmpval > 0) {
            return lookup(node.right, value);
        }
        return !node.value.hidden;
    }
}
