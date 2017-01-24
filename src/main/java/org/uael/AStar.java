package org.uael;

import org.uael.jds.List;
import org.uael.jds.Sequence;
import org.uael.jds.SortedList;

public class AStar<T extends AStarNode<T>> {
    public T start, goal;
    private Sequence<T> visited = new SortedList<>(), unvisited = new SortedList<>();

    public AStar(T start, T goal) {
        if (start == null || goal == null) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.goal = goal;
        unvisited.push(this.start);
    }

    public Sequence<T> path() {
        T p = null;
        while (!unvisited.isEmpty() && !goal.equals(p)) {
            p = unvisited.shift();
            visited.push(p);
            if (goal.equals(p)) {
                break;
            } else {
                for (T n : p.successors().where(node -> !visited.contains(node))) {
                    double g = p.g() + n.cost(p);
                    if (unvisited.contains(n)) {
                        if (g < n.g()) {
                            unvisited.erase(n);
                            n.setG(g);
                            n.setParent(p);
                            unvisited.push(n);
                        }
                    } else {
                        n.setParent(p);
                        n.setG(g);
                        n.setH(n.cost(goal));
                        unvisited.push(n);
                    }
                }
            }
        }
        Sequence<T> path = new List<>();
        while (p != null) {
            path.unshift(p);
            p = p.parent();
        }
        return path;
    }

    public static <T extends AStarNode<T>> Sequence<T> path(T start, T goal) {
        AStar<T> aStar = new AStar<>(start, goal);
        return aStar.path();
    }
}
