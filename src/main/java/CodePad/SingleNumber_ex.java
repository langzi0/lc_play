package CodePad;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without
 * using extra memory?
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class SingleNumber_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {

  }

  public int singleNumber(int[] A) {
    int value = 0;
    for(int i =0; i< A.length; i++)
    {
      value ^= A[i];
    }
    return value;
  }
}