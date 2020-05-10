package Question;

import java.util.ArrayList;
import java.util.List;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 */

public class FB4 extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151216, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java

    Integer
        n = 2;
    System.out.println("n=" +  n.toString());
    grayCode(n).forEach(p -> System.out.print(Integer.valueOf(p).toString() + " "));
    System.out.println("");

    n = 3;
    System.out.println("n=" +  n.toString());
    grayCode(n).forEach(p -> System.out.print(Integer.valueOf(p).toString() + " "));
    System.out.println("");
  }

  public List<Integer> grayCode(int n) {
// for i = 0, n-1,  it first get 0, 1.  then adding 1 plus reversing existing set
//  11, 10    then adding another 1, plus reverse set,
    ArrayList<Integer> result = new ArrayList<>();
    result.add(0);
    result.add(1);
    for (int i = 1; i < n; i++) {
      int curCount = result.size();
      // push back all element in result in reverse order
      while (curCount != 0) {
        curCount--;
        int curNum = result.get(curCount);
        curNum += (1<<i);
        result.add(curNum);
      }
    }
    return result;

  }

  // start from 0, then
}
