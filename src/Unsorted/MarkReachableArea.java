package Unsorted;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class MarkReachableArea extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160130, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    Cell[][] mat;


    mat = convert(new int[][]{
        {1, 0, 1},
        {1, 2, 1},
        {1, 1, 1}});

    markMatrix(mat);



    mat = convert(new int[][]{
        {1, 0, 1},
        {2, 3, 4},
        {0, 5, 0}});

    markMatrix(mat);


    mat = convert(new int[][]{
        {1, 0, 1},
        {1, 2, 1},
        {1, 1, 1}});

    markMatrix(mat);

  }

  Cell[][] convert(int[][] mat)
  {
    Cell[][] ret = new Cell[mat.length][mat[0].length];
    for(int i =0; i< mat.length ;i++)
      for(int j =0; j< mat[0].length; j++)
        ret[i][j] = new Cell(mat[i][j]);
    return ret;

  }
  class Cell {

    int e; // elevation
    boolean isP;
    boolean isA;
    Cell(int e){
      this.e = e;
    }

    @Override
    public String toString() {
      return "isP:" + Boolean.toString(isP) + "isA:" + Boolean.toString(isA);
    }
  }

  void markMatrix(Cell[][] mat) {
    int M = mat.length;
    int N = mat[0].length;
    for (int i = 0; i < M; i++) {
      DFSBoth(mat, i, 0, true);
      DFSBoth(mat, i, N - 1, false);
    }
  }

  void DFSBoth(Cell[][] mat, int i, int j , boolean isP) {
    boolean[][] v = new boolean[mat.length][mat[0].length];
    DFSVisitBoth(mat, v, i, j, Integer.MIN_VALUE, isP);
  }
  void DFSVisitBoth(Cell[][] mat, boolean[][] v, int i, int j, int elevation, boolean isP) {

    if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || v[i][j] || (isP && mat[i][j].isP)
        || (!isP && mat[i][j].isA) || elevation > mat[i][j].e) {
      return;
    }
    v[i][j] = true;
    if (isP) mat[i][j].isP = true;
    else mat[i][j].isA = true;
    DFSVisitBoth(mat, v, i + 1, j, mat[i][j].e, isP);
    DFSVisitBoth(mat, v, i - 1, j, mat[i][j].e, isP);
    DFSVisitBoth(mat, v, i, j - 1, mat[i][j].e, isP);
    DFSVisitBoth(mat, v, i, j + 1, mat[i][j].e, isP);
  }
}
