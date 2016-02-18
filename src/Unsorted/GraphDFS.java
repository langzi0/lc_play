package Unsorted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 * Visit from a point to another only diagonally.
 */

public class GraphDFS extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160204, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    Util.assertEq(9, findStep(new int[10][10], new Pos(0, 0), new Pos(9, 9)));
    Util.assertEq(5, findStep(new int[10][10], new Pos(5, 0), new Pos(0, 5)));

  }

  boolean reachable(Pos start, Pos end)
  {

    Queue<Pos> queue = new LinkedList<>();
    if (end.equals(start))
      return true;
    queue.add(start);

    while(!queue.isEmpty())
    {
      Pos cur = queue.remove();
     // visit(start, -1, -1, end)
    }

    return false;
  }

  class Pos {

    int x;
    int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean equals(Object obj) {
      String s = "ss";
      s.substring(0,6);

      boolean[] xch = new boolean[256];

      for(char ch : s.toCharArray()) {
        int i = ch;
        int j = 'c';
        xch[ch] = true;
      }
      List<Integer> list = new ArrayList<>();
      list.iterator();

      return obj != null && obj instanceof Pos && ((Pos) obj).x == this.x && (((Pos) obj).y == this.y);
      }

    public int hashCode(){

      int[][] data = new int[][]{{1,2,3},{3,4,5, 6}};
     //  return x <<16 & y;
      return 0;
    }
  }

  // when use hash based on object, you can not create a new object temp.
  //
  int findStep(int[][] b, Pos start, Pos end) {

    int[][] depth = new int[b.length][b[0].length];
    for(int i=0;i<b.length;i++) for(int j=0;j<b[0].length;j++)depth[i][j]=-1;
//  How mark visisted,  how to remember next level(map);  do we only care about last end result? or process accross the path?
    // if Matrix, you can not use position object, as you need to define the hashcode. not only equals.
    Queue<Pos> q = new LinkedList<>();
    q.add(start);
    depth[start.x][start.y] = 0;
    if (end == start) {
      return 0;
    }
    while (!q.isEmpty()) {
      Pos elem = q.remove();
      // Status status; if not not lucky to have depth.get(end), then we use status to return result.
      if (visit(elem, new Pos(elem.x - 1, elem.y - 1), b, end, q, depth) ||
          visit(elem, new Pos(elem.x - 1, elem.y + 1), b, end, q, depth) ||
          visit(elem, new Pos(elem.x + 1, elem.y + 1), b, end, q, depth) ||
          visit(elem, new Pos(elem.x + 1, elem.y - 1), b, end, q, depth)) {
        return depth[end.x][end.y];
      }
    }
    return -1;
  }

  boolean visit(Pos elem, Pos visit, int[][] b, Pos end, Queue q, int[][] depth) {
    if (visit.x >= 0 && visit.y >= 0 && visit.x < b.length && visit.y < b[0].length && depth[visit.x][visit.y]==-1) {
      depth[visit.x][visit.y] = depth[elem.x][elem.y] + 1;
      if (visit.equals(end)) {
        return true;
      }
      q.add(visit);
    }
    return false;
  }
}
