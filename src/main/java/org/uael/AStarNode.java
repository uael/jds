package org.uael;

import org.uael.jds.List;
import org.uael.jds.Queryable;

public interface AStarNode<T extends AStarNode<T>> extends Comparable<T> {
    @Override
    default int compareTo(T aStarNode) {
        return Double.compare(f(), aStarNode.f());
    }

    double cost(T successor);

    default double f() {
        return g() + h();
    }

    double g();

    double h();

    T parent();

    void setG(double g);

    void setH(double h);

    void setParent(T node);

    Queryable<T> successors();

    abstract class Impl<T extends Impl<T>> implements AStarNode<T> {
        private double g, h, c;
        private T parent;
        private Queryable<T> successors = new List<>();

        public void setC(double c) {
            this.c = c;
        }

        public Impl(double c) {
            this.c = c;
        }

        public Impl() {
            this(0);
        }

        @Override
        public final double cost(T successor) {
            return c + internalCost(successor);
        }

        abstract double internalCost(T successor);

        @Override
        public double g() {
            return g;
        }

        @Override
        public double h() {
            return h;
        }

        @Override
        public T parent() {
            return parent;
        }

        @Override
        public void setG(double g) {
            this.g = g;
        }

        @Override
        public void setH(double h) {
            this.h = h;
        }

        @Override
        public void setParent(T node) {
            this.parent = node;
        }

        @Override
        public Queryable<T> successors() {
            return successors;
        }
    }
}
