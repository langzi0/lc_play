package CodePad;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class Sqrtx extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public int sqrt(int x) {
    double x0 = x / 2.0;
    double x1 = (x0 + x / x0) / 2.0;
    while (Math.abs(x1 - x0) > 0.00001) {
      x0 = x1;
      x1 = (x0 + x / x0) / 2.0;
    }
    return (int) x1;
  }
}