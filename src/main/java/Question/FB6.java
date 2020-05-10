package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class FB6 extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java

  }

  public int maxProduct(String[] words) {
    int maxSum = 0;
    for(int i = 0; i< words.length -1;i++)
      for (int j = i + 1; j< words.length; j++ )
        if (isCross(words[i], words[j]) && maxSum < words[i].length() * words[j].length())
          maxSum = words[i].length() * words[j].length();
    return maxSum;
  }

  boolean isCross(String s1, String s2)
  {
    boolean[] array = new boolean[26];
    for(int i=0; i< s1.length(); i++)
    {
      array[(int)s1.charAt(i) - (int)'a'] = true;
    }
    for(int i=0; i< s1.length(); i++)
    {
      if (array[(int)s1.charAt(i) - (int)'a']) return true;
    }
    return false;
  }

  public String removeDuplicateLetters(String s) {
    boolean[] bit = new boolean[26];
    for(int i=0;i<s.length();i++)
      bit[(int) s.charAt(i) - (int)'a'] = true;
    StringBuffer buff = new StringBuffer();
    for (int i=0; i< 26; i++)
      buff.append((char)(i + (int)'a'));
    return buff.toString();

  }
}
