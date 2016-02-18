package Question;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class FindPairWithGivingDiff extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151214, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    String res = StringUtils.join(getPairs(new int[]{1, 2, 3, 5, 6, 8, 9, 11, 12, 13}, 3).stream().map(
        p -> "(" + Integer.valueOf(p.x).toString() + ',' + Integer.valueOf(p.y) + ")").collect(
        (Collectors.toList())), ",");
    Util.assertEq("", res, "" );
  }

  class Pair {

    public int x;
    public int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  List<Pair> getPairs(int[] A, int k) {
    if (A.length <= 1) {
      return null;
    }
    int ix = 0;
    int iy = 1;
    List<Pair> ret = new ArrayList<>();
    while (iy < A.length) {
      if (A[ix] + k == A[iy]) {
        ret.add(new Pair(A[ix], A[iy]));
        ix++;
        iy++;
      } else if (A[ix] + k < A[iy]) {
        if (ix < iy - 1)
        {
          ix ++;
        }
        else { // have to jump iy
          iy ++;
        }

      } else {
        iy ++;
      }
    }

    return ret;

  }


/*Given an array of positive, unique, increasingly sorted numbers A, e.g. A = [1, 2, 3, 5, 6, 8, 9, 11, 12, 13]. Given a positive value K, e.g. K = 3. Output all pairs in A that differ exactly by K.
e.g. 2, 5
3, 6
5, 8
6, 9
8, 11
9, 12
what is the runtime for your code?

*/


}
