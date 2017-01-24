package org.uael;

import org.uael.jds.Collection;

public interface AStarNode {
  double cost(AStarNode successor);

  double f();

  double g();

  AStarNode parent();

  void setG(double g);

  void setParent(AStarNode node);

  Collection<AStarNode> successors();
}
