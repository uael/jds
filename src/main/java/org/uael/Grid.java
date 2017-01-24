package org.uael;

import org.uael.jds.Sequence;

/**
 * The type Grid.
 */
public class Grid {
    private Node[][] grid;
    private int l, L;

    /**
     * Instantiates a new Grid.
     * @param l the l
     * @param L the l
     */
    public Grid(int l, int L) {
        this.l = l;
        this.L = L;
        grid = new Node[l][L];
        for (int x = 0; x<l; x++) {
            for (int y = 0; y<L; y++) {
                Node n = at(x, y);
                for (int i = x-1; i<=x+1; i++) {
                    for (int j = y-1; j<=y+1; j++) {
                        Node s = at(i, j);
                        if (s != null) {
                            n.successors().add(s);
                        }
                    }
                }
            }
        }
    }

    /**
     * Instantiates a new Grid.
     * @param l the l
     */
    public Grid(int l) {
        this(l, l);
    }

    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Grid grid = new Grid(20, 20);
        grid.at(1, 1).setC(1);
        Sequence path = AStar.path(grid.at(0, 0), grid.at(2, 2));
        System.out.println();
    }

    /**
     * At node.
     * @param x the x
     * @param y the y
     * @return the node
     */
    public Node at(int x, int y) {
        if (x < 0 || y < 0 || x >= l || y >= L) {
            return null;
        }
        if (grid[x][y] == null) {
            grid[x][y] = new Node(x, y);
        }
        return grid[x][y];
    }

    /**
     * The type Node.
     */
    class Node extends AStarNode.Impl<Node> {
        public int x, y;

        /**
         * Instantiates a new Node.
         * @param x the x
         * @param y the y
         * @param c the c
         */
        public Node(int x, int y, double c) {
            super(c);
            this.x = x;
            this.y = y;
        }

        /**
         * Instantiates a new Node.
         * @param x the x
         * @param y the y
         */
        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        double internalCost(Node successor) {
            double var2 = successor.x - this.x;
            double var4 = successor.y - this.y;
            return Math.sqrt(var2 * var2 + var4 * var4);
        }

        @Override
        public String toString() {
            return "Node[" +
                + x +
                ", " + y +
                ']';
        }
    }
}
