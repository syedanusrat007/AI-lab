/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pancake;

import java.util.List;
import java.util.*;


public abstract class Solver implements Comparable {

  Solver pathParent;
  float costFromStart;
  float estimatedCostToGoal;


  public float getCost() {
    return costFromStart + estimatedCostToGoal;
  }


  public int compareTo(Object other) {
    float thisValue = this.getCost();
    float otherValue = ((Solver)other).getCost();

    float v = thisValue - otherValue;
    return (v>0)?1:(v<0)?-1:0; 
  }


 
  public abstract float getCost(Solver node);


 
  public abstract float getEstimatedCost(Solver node);

  public abstract List getNeighbors();
  
  public static class PriorityList extends LinkedList {

    public void add(Comparable object) {
      for (int i=0; i<size(); i++) {
        if (object.compareTo(get(i)) <= 0) {
          add(i, object);
          return;
        }
      }
      addLast(object);
    }
  }



  protected List constructPath(Solver node) {
    LinkedList path = new LinkedList();
    while (node.pathParent != null) {
      path.addFirst(node);
      node = node.pathParent;
    }
    return path;
  }


 
  public List findPath(Solver startNode, Solver goalNode) {

    PriorityList openList = new PriorityList();
    LinkedList closedList = new LinkedList();

    startNode.costFromStart = 0;
    startNode.estimatedCostToGoal = 
      startNode.getEstimatedCost(goalNode);
    startNode.pathParent = null;
    openList.add(startNode);

    while (!openList.isEmpty()) {
      Solver node = (Solver)openList.removeFirst();
      if (node == goalNode) {
      
        return constructPath(goalNode);
      }

      List neighbors = node.getNeighbors();
      for (int i=0; i<neighbors.size(); i++) {
        Solver neighborNode =
          (Solver)neighbors.get(i);
        boolean isOpen = openList.contains(neighborNode);
        boolean isClosed =
          closedList.contains(neighborNode);
        float costFromStart = node.costFromStart +
          node.getCost(neighborNode);

    
        if ((!isOpen && !isClosed) ||
          costFromStart < neighborNode.costFromStart)
        {
          neighborNode.pathParent = node;
          neighborNode.costFromStart = costFromStart;
          neighborNode.estimatedCostToGoal =
            neighborNode.getEstimatedCost(goalNode);
          if (isClosed) {
            closedList.remove(neighborNode);
          }
          if (!isOpen) {
            openList.add(neighborNode);
          }
        }
      }
      closedList.add(node);
    }

   
    return null;
  }

}


