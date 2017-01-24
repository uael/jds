package org.uael;

import org.uael.jds.List;
import org.uael.jds.Sequence;

public class AStar<T extends AStarNode> {
  public AStarNode start, goal;
  private Sequence<T> visited = new List<>(), unvisited = new List<>();

  public AStar(AStarNode start, AStarNode goal) {
    if (start == null || goal == null || start.equals(goal)) {
      throw new IllegalArgumentException();
    }
    this.start = start;
    this.goal = goal;
  }

  public Sequence<T> path() {
    return null;
  }
}
