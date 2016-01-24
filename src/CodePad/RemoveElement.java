package CodePad;

/**
 * Given an array and a value, remove all instances of that value in place and return the new
 * length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class RemoveElement extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public int removeElement(int[] A, int elem) {
    if (A.length == 0) {
      return 0;
    } else {
      int p = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i] != elem) {
          A[p++] = A[i];
        }
      }
      return p;
    }
  }
}