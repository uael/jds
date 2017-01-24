package org.uael;

import org.uael.jds.*;
import org.uael.jds.List;

import java.awt.*;

public class Vector2 extends Point implements AStarNode<Vector2> {
    private double g, h;
    private Vector2 parent;
    private Queryable<Vector2> successors = new List<>();

    public Vector2() {
        super();
    }

    public Vector2(Point point) {
        super(point);
    }

    public Vector2(int i, int i1) {
        super(i, i1);
    }

    @Override
    public double cost(Vector2 successor) {
        return this.distance(successor);
    }

    @Override
    public double g() {
        return g;
    }

    @Override
    public double h() {
        return h;
    }

    @Override
    public Vector2 parent() {
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
    public void setParent(Vector2 node) {
        this.parent = node;
    }

    @Override
    public Queryable<Vector2> successors() {
        return successors;
    }

    @Override
    public String toString() {
        return super.toString()+"{" +
            "g=" + g +
            ", h=" + h +
            ", parent=" + parent +
            '}';
    }
}
