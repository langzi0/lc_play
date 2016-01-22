package Unsorted;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author xbian
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class Q18 extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151001, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
  }

}
