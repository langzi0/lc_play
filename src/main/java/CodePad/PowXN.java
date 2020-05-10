package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Implement pow(x, n)
 */

public class PowXN extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public double pow(double x, int n) {
    if (n == 0) {
      return 1;
    } else if (n % 2 == 0) {
      double d = pow(x, n / 2);
      return d * d;
    } else if (n > 0) {
      double d = pow(x, (n - 1) / 2);
      return d * d * x;
    } else {
      double d = pow(x, (n + 1) / 2);
      return d * d / x;
    }
  }
}