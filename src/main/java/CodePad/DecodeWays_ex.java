package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits, determine the total
 * number of ways to decode it.
 *
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */

public class DecodeWays_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151215, 5, Category.LeetCode);
  }

  @Override
  public void run() { //026
    Util.assertEq(2, numDecodings("261"));
    Util.assertEq(3, numDecodings("126"));
    Util.assertEq(1, numDecodings("1"));
    Util.assertEq(0, numDecodings("026"));
    Util.assertEq(3, numDecodingsNonRecursive("111"));
    Util.assertEq(1, numDecodingsNonRecursive("10"));


  }

  public int numDecodings(String s) {
    if (s.length() == 0) {
      return 0;
    }
    return numDecodings(s, 0);
  }

  public int numDecodingsNonRecursive(String s) {

    if (s.length() == 0) {
      return 0;
    }

    int len = s.length();
    int[] count = new int[len];
    // count[i] = count[i + 1] + cond * count[i+2]
    if (valid(s.charAt(len - 1))) {
      count[len - 1] = 1;
    }
    if (len == 1) {
      return count[0];
    }

    count[len - 2] = 0;
    if (valid(s.charAt(len - 2), s.charAt(len - 1))) {
      count[len - 2]++;
    }

    if (valid(s.charAt(len - 2))) {
      count[len - 2] += count[len - 1];
    }

    if (len == 2) {
      return count[0];
    }

    for (int i = count.length - 3; i >= 0; i--) {
      count[i] = 0;
      if (valid(s.charAt(i))) {
        count[i] += count[i + 1];
      }
      if (valid(s.charAt(i), s.charAt(i + 1))) {
        count[i] += count[i + 2];
      }
    }

    return count[0];


  }

  private boolean valid(char c) {
    return c <= '9' && c >= '1';
  }

  private boolean valid(char c1, char c2) {
    return c1 == '1' || (c1 == '2' && c2 <= '6' && c2 >= '0');
  }


  public int numDecodings(String s, int cur) {
    int cnt = 0;
    if (cur == s.length()) {
      return 1;
    }

    if (cur <= s.length() - 1) {
      if (s.charAt(cur) != '0') {
        cnt += numDecodings(s, cur + 1);
      }
    }

    if (cur <= s.length() - 2) {
      if (s.charAt(cur) == '1') {
        cnt += numDecodings(s, cur + 2);
      }
      if (s.charAt(cur) == '2') {
        if (s.charAt(cur + 1) <= '6' && s.charAt(cur + 1) >= '0')
        // Not good for recursion, as we have to do the same calculation again and again
        {
          cnt += numDecodings(s, cur + 2);
        }
      }
    }
    return cnt;
  }

}