package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example, a = "11" b = "1" Return "100".
 */
public class AddBinary_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151207, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    eq("equal ", addBinary("1", "1111111111111111111111"),
       addBinary1("1", "1111111111111111111111"));
    eq("equal", addBinary("0", "1111111111111111111111"),
       addBinary1("0", "1111111111111111111111"));
    eq("equal", addBinary("0", "0"), addBinary1("0", "0"));
  }

  public String addBinary1(String a, String b) {
    int ia = a.length();
    int ib = b.length();

    int i = 0;
    if (ia == 0 || ib == 0) {
      throw new IllegalArgumentException("input");
    }
    String s = "";

    int carry = 0;
    while (i < ia && i < ib) {
      int sum = (a.charAt(ia - i - 1) - '0' + carry + b.charAt(ib - i - 1) - '0');
      s = (sum % 2 == 0 ? "0" : "1") + s;
      carry = sum / 2;
      i++;
    }

    while (i < ia) {
      int sum = (a.charAt(ia - i - 1) - '0' + carry);
      s = (sum % 2 == 0 ? "0" : "1") + s;
      carry = sum / 2;
      i++;
    }
    while (i < ib) {
      int sum = (carry + b.charAt(ib - i - 1) - '0');
      s = (sum % 2 == 0 ? "0" : "1") + s;
      carry = sum / 2;
      i++;
    }

    if (carry == 1) {
      s = "1" + s;
    }
    return s;
  }


  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int da = 0;
    int db = 0;
    int adv = 0;
    StringBuffer result = new StringBuffer();
    while (i >= 0 && j >= 0) {
      da = a.charAt(i--) == '0' ? 0 : 1;
      db = b.charAt(j--) == '0' ? 0 : 1;
      int d = da + db + adv;
      result.append(d % 2 == 0 ? '0' : '1');
      adv = d >> 1;
    }
    if (i >= 0) {
      while (i >= 0) {
        da = a.charAt(i--) == '0' ? 0 : 1;
        int d = da + adv;
        result.append(d % 2 == 0 ? '0' : '1');
        adv = d >> 1;
      }
    } else if (j >= 0) {
      while (j >= 0) {
        db = b.charAt(j--) == '0' ? 0 : 1;
        int d = db + adv;
        result.append(d % 2 == 0 ? '0' : '1');
        adv = d >> 1;
      }
    }
    if (adv == 1) {
      result.append('1');
    }
    return result.reverse().toString();
  }

}