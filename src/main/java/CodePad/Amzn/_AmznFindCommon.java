package CodePad.Amzn;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

import java.util.HashSet;

public class _AmznFindCommon extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/200930, 2, Category.LeetCode);
  }


  @Override
  public void run() {
    String hey=     gcdOfStrings("ABCABC", "ABC");
    hey= gcdOfStrings("ABABAB", "ABAB");
    hey= gcdOfStrings("ABCDEF", "ABC");
    hey= gcdOfStrings("ABCABC", "ABC");
    hey= gcdOfStrings("LEET", "CODE");
    if (hey != null)
      {return; };

  }

  /*
* For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
Example 4:

Input: str1 = "ABCDEF", str2 = "ABC"
Output: ""


Constraints:

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1 and str2 consist of English uppercase letter
* */

  public String gcdOfStrings(String str1, String str2) {

    HashSet<String> pat1 = pattens(str1);

    HashSet<String> pat2 = pattens(str2);

    int size = 0;
    String sret = "";

    for(String s: pat2){
      if (pat1.contains(s) && s.length() > size){
        sret = s;
      }
    }

    return sret;
  }

  HashSet<String> pattens(String str){
    HashSet<String> result = new HashSet<>();
    for(int i = 1; i<= str.length() ; i++ ){
      int len = i;
      if (str.length() / len * len == str.length() && str.substring(0, i).repeat(str.length() / len).equals(str)){
        result.add(str.substring(0, i));
      }
    }
    return result;
  }



}