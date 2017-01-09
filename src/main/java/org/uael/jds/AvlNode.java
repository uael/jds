package org.uael.jds;

/**
 * The type Avl node.
 * @param <T> the type parameter
 */
class AvlNode<T extends Comparable<T>> implements Comparable<T> {
    T data;
    boolean hidden;
    Avl factor;

    /**
     * Instantiates a new Avl node.
     * @param data   the data
     * @param hidden the hidden
     * @param factor the factor
     */
    AvlNode(T data, boolean hidden, Avl factor) {
        this.data = data;
        this.hidden = hidden;
        this.factor = factor;
    }

    /**
     * Instantiates a new Avl node.
     * @param value the value
     */
    AvlNode(T value) {
        this(value, false, Avl.BALANCED);
    }

    @Override
    public int compareTo(T t) {
        return data != null ? data.compareTo(t) : (t == null ? 0 : -1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvlNode<?> avlNode = (AvlNode<?>) o;
        if (hidden != avlNode.hidden) return false;
        if (data != null ? !data.equals(avlNode.data) : avlNode.data != null) return false;
        return factor == avlNode.factor;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (hidden ? 1 : 0);
        result = 31 * result + factor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AvlNode{" +
            "data=" + data +
            ", hidden=" + hidden +
            ", factor=" + factor +
            '}';
    }
}
