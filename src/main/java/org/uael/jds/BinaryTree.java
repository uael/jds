package org.uael.jds;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * The type B tree.
 * @param <T> the type parameter
 */
public class BinaryTree<T> {
    /**
     * The Root.
     */
    public Node root;
    /**
     * The Size.
     */
    int size;

    /**
     * Instantiates a new B tree.
     */
    public BinaryTree() {
        size = 0;
        root = null;
    }

    public BinaryTree(T ...values) {
        this();
        List<Node> line = new List<>();
        Queue<T> queue = new Queue<>(values);
        if (!queue.isEmpty()) {
            line.push(insertLeft(queue.pop()));
        }
        while (!queue.isEmpty()) {
            for (Node node : line.copy()) {
                if (queue.isEmpty()) {
                    break;
                }
                line.push(node.insertLeft(queue.pop()));
                if (!queue.isEmpty()) {
                    line.push(node.insertRight(queue.pop()));
                }
                line.erase(node);
            }
        }
    }

    public void clear() {
        removeLeft();
        removeRight();
        root = null;
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree<?> binaryTree = (BinaryTree<?>) o;
        return size == binaryTree.size && (root != null ? root.equals(binaryTree.root) : binaryTree.root == null);
    }

    @Override
    public int hashCode() {
        int result = root != null ? root.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }

    /**
     * Insert left node.
     * @param value the value
     * @return the node
     */
    public Node insertLeft(T value) {
        return insertLeft(root, value);
    }

    /**
     * Insert left node.
     * @param node  the node
     * @param value the value
     * @return the node
     */
    Node insertLeft(Node node, T value) {
        if (node == null) {
            if (size > 0) {
                return null;
            }
            size++;
            return root = new Node(value);
        } else {
            return node.insertLeft(value);
        }
    }

    /**
     * Insert right node.
     * @param value the value
     * @return the node
     */
    public Node insertRight(T value) {
        return insertRight(root, value);
    }

    /**
     * Insert right node.
     * @param node  the node
     * @param value the value
     * @return the node
     */
    Node insertRight(Node node, T value) {
        if (node == null) {
            if (size > 0) {
                return null;
            }
            size++;
            return root = new Node(value);
        } else {
            return node.insertRight(value);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Left node.
     * @return the node
     */
    public Node left() {
        return root != null ? root.left : null;
    }

    /**
     * Remove left node.
     * @return the node
     */
    public Node removeLeft() {
        return root != null ? root.removeLeft() : null;
    }

    /**
     * Remove right node.
     * @return the node
     */
    public Node removeRight() {
        return root != null ? root.removeRight() : null;
    }

    /**
     * Right node.
     * @return the node
     */
    public Node right() {
        return root != null ? root.right : null;
    }

    /**
     * Show.
     */
    public void show() {
        JFrame f = new JFrame("A N-ary Tree vizualized with JTree");
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        if (root != null) {
            f.getContentPane().add(new JTree(root.toTreeNode()));
        }
        // Visualiser le cadre
        f.setVisible(true);
    }

    /**
     * Size int.
     * @return the int
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
            (root != null ? "root=" + root + ", size=" + size : "size=0") +
            '}';
    }

    /**
     * The type Node.
     */
    public class Node {
        /**
         * The Left.
         */
        Node left, /**
         * The Right.
         */
        right;
        /**
         * The Value.
         */
        public T value;

        /**
         * Instantiates a new Node.
         * @param value the value
         */
        Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            if (right != null ? !right.equals(node.right) : node.right != null) return false;
            return value != null ? value.equals(node.value) : node.value == null;
        }

        @Override
        public int hashCode() {
            int result = left != null ? left.hashCode() : 0;
            result = 31 * result + (right != null ? right.hashCode() : 0);
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        /**
         * Insert left node.
         * @param value the value
         * @return the node
         */
        public Node insertLeft(T value) {
            if (left != null) {
                return null;
            }
            size++;
            return left = new Node(value);
        }

        /**
         * Insert right node.
         * @param value the value
         * @return the node
         */
        public Node insertRight(T value) {
            if (right != null) {
                return null;
            }
            size++;
            return right = new Node(value);
        }

        /**
         * Is leaf boolean.
         * @return the boolean
         */
        boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * Left node.
         * @return the node
         */
        public Node left() {
            return left;
        }

        /**
         * Remove left node.
         * @return the node
         */
        public Node removeLeft() {
            Node ret = null;
            if (left != null) {
                left.removeLeft();
                ret = left;
                left = null;
            }
            return ret;
        }

        /**
         * Remove right node.
         * @return the node
         */
        public Node removeRight() {
            Node ret = null;
            if (right != null) {
                right.removeRight();
                ret = right;
                right = null;
            }
            return ret;
        }

        /**
         * Right node.
         * @return the node
         */
        public Node right() {
            return right;
        }

        @Override
        public String toString() {
            return "Node{" +
                "value=" + value +
                ", left=" + (left != null ? left : "null") +
                ", right=" + (right != null ? right : "null") +
                "}";
        }

        /**
         * To tree node default mutable tree node.
         * @return the default mutable tree node
         */
        public DefaultMutableTreeNode toTreeNode() {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode();
            node.setUserObject(value);
            if (left != null) {
                node.add(left.toTreeNode());
            }
            if (right != null) {
                node.add(right.toTreeNode());
            }
            return node;
        }
    }
}
