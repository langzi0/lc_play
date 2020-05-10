package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class FirstBadVersion extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151216, 0, Category.LeetCode);
  }

  @Override
  public void run() {

    int n = 4;
    Util.assertEq(n / 2, firstBadVersion(n));
    n = 5;
    Util.assertEq(n / 2, firstBadVersion(n));
    n = 6;
    Util.assertEq(n / 2, firstBadVersion(n));
    n = 2;
    Util.assertEq(n / 2, firstBadVersion(n));

    //Call your test in Common/Main.java
  }

  /*
  * Leetcode: FindFirst Bad Version
  * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

  1....i-1
           i....n

  * */

  int firstBadVersion(int n) {
    Boolean[] cache = new Boolean[n + 1];
    int s = 0;
    int e = n;
    while (s < e) {
      int mid = s + (e - s) / 2;
      if (mid == s) {
        return e;
      }
      if (mid == 0 || !isBadVersion(mid, n)) {

        s = mid;
      } else {
        e = mid;
      }
    }
    return e;


  }

  Boolean isBadVersion(int i, int n) {
    int rand = n / 2;

    if (i >= 1 || i <= n) {
      return i >= rand;
    }
    throw new RuntimeException("no,no");
  }


}
