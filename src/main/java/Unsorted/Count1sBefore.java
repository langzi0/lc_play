package Unsorted;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class Count1sBefore extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160128, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java

    Util.assertEq(3, countDigitOne(1));
    Util.assertEq(3, countDigitOne(10));
    Util.assertEq(3, countDigitOne(100));

  }
  public int countDigitOne(int n) {
    if(n <= 0) return 0;
    if(n < 10) return 1;
    // Important trick to get largest base like 843=> 100 m  2345 => 1000, use Long.toString to decimal.
    int base = (int)Math.pow(10, Long.toString(n).length() - 1);  // get first base
    // take first base -1 's 1s and if digit is 1, treat differently, and plus ending residue's one.
    // it scales to problem 1/10
    int k = n / base;
    return countDigitOne(base - 1) * k +
           (k == 1 ? (n-base+1) : base) +
           countDigitOne(n % base);
  }
  public class Solution {
    public int countDigitOne(int n) {
      // 1
      // 10- 19
      // 21 ...  91
      // 100- 199
      // 201
      // [3-9]10-[3-9]19

      // abcd...
      // f(a) = (a-2)
      return 1;


    }


    private int[] findOne(int num)
    {
      //cnt[i] store < 10 ** num
      int[] cnt = new int[num];
      cnt[0] = 0;  // < 10

      for(int i = 1; i<= num; i++)
      {
        cnt[i] = cnt[i-1] * 9; //
        //cnt[i] += 10 **(i-1);

      }
      return cnt;
    }

  }

}
