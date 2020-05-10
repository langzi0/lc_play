package Unsorted;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class Q17
    extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
  }

}
