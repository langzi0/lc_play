package CodePad;

import java.util.ArrayList;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the
 * sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not uniquely defined.
 *
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about
 * that.
 */

public class GrayCode extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public ArrayList<Integer> grayCode(int n) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (n == 0) {
      result.add(0);
      return result;
    }
    ;
    result.add(0);
    result.add(1);
    for (int i = 1; i < n; i++) {
      ArrayList<Integer> tmp = new ArrayList<Integer>(result);
      Integer a = 1 << i;
      for (int k = result.size() - 1; k >= 0; k--) {
        tmp.add(result.get(k) + a);
      }
      result = tmp;
    }
    return result;
  }
}