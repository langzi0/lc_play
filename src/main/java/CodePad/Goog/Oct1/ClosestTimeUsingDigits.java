package CodePad.Goog.Oct1;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class ClosestTimeUsingDigits  extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/201001, 2, Category.LeetCode);
  }


  @Override
  public void run() {
    nextClosestTime("19:34");
    nextClosestTime("23:59");
  }
  public  String nextClosestTime(String time) {
    return "";

  }

}
