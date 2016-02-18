package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class Combination extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151202, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    System.out.println("3 vs 2 : ");
    PrintProcess(3, 2);
    System.out.println("1 vs 2 : ");
    PrintProcess(1,2);
    System.out.println("0 vs 2 : ");
    PrintProcess(0,2);
  }

  class Pair{ public int a; public int b;}
  public void PrintProcess(int a, int b)
  {
    int[] sel = new int[a + b];
    select(sel, 0, 0, a, b);

  }

  void select(int[] sel, int ai, int bi , int a, int b)
  {
    if (ai == a && bi == b)
    {
      printResult(sel);
    }

    if (ai < a)
    {
      sel[ai + bi] = 0;
      select(sel, ai + 1, bi, a ,b);
    }

    if (bi < b)
    {
      sel[ai + bi] = 1;
      select(sel, ai, bi + 1, a ,b);
    }

  }

  private void printResult(int[] sel) {
    int ai = 0;
    int bi = 0;
    int i = 0;
    System.out.println("starting: ");
    while( i< sel.length )
    {

      if (sel[i] == 0)
        ai ++;
      else
        bi ++;
      System.out.println(String.format("<%d,%d>", ai, bi));
      i++;
    }

  }
}
