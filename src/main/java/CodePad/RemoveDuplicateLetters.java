package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class RemoveDuplicateLetters extends InvokableBase {
  // Add this class to Common/Main.java

  public Priority getRunPriority() {
    return new Priority(160115, 0, Category.LeetCode);
  }

  public void run() {

    {//Call your test in Common/Main.java
//      eq("", "abc", removeDuplicateLetters("cabc"));
//      eq("", "abc", removeDuplicateLetters("cccbbaacaaabcccc"));
//
//      // Failed!!!    c should be selected,  even b is the first to be selelcted, how ever since will be select next time,
//      eq("Case for wrong algorithm", "bca", removeDuplicateLetters("bcba"));
    }
// NOT DONE>>>>>>>>>>>>>>>>>>>>>
    {
      // how to improve, when see the first cnt==1 letter, you need select the smallest letter out in the prefix!!!
      eq("", "bca", removeDuplicateLettersI("bcba"));
      eq("", "abc", removeDuplicateLetters("cabc"));
      eq("", "abc", removeDuplicateLetters("cccbbaacaaabcccc"));

    }
  }

  public String removeDuplicateLettersI(String s) {
    int[] counts = new int[26];
    for (char ch : s.toCharArray()) {
      counts[(int) ch - (int) 'a']++;
    }

    // check until you hit the first unique letter, then select the smallest letter among the current prefix
    // Then do it again from beginning

    // no unique letter?
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < s.length(); i++) {

      if (counts[i] == 1) {
        char min = 255;
        for (int j = 0; j <= i; j++) {
          if (counts[(int) s.charAt(j) - (int) 'a'] > 0 && s.charAt(j) < min) {
            min = s.charAt(j);
          }
        }
        sb.append(min);
        counts[(int)min -(int)'a'] = 0;
        // remove the latter before min char.

      }
    }
    return sb.toString();

  }

  public String removeDuplicateLetters(String s) {
    int[] cnts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      cnts[(int) s.charAt(i) - (int) 'a']++;
    }

    StringBuffer buff = new StringBuffer();

    // a       4    6
    // b 1   3   5
    // c   2          7

    // count the occurences of each letter
    // keep the smallest non-zero index in the array,
    // reduce 1, if not select it.
    int head = getNext(cnts, 0);
    for (int i = 0; i < s.length(); i++) {
      int idx = (int) s.charAt(i) - (int) 'a';
      if ((cnts[idx]) == 0) {
        continue;
      }
      // if this is first in line char, select it.
      else if (idx == head || cnts[idx] == 1) {
        cnts[idx] = 0;
        buff.append(s.charAt(i));
        head = getNext(cnts, head);
      } else {
        cnts[idx]--;

      }
    }
    return buff.toString();

  }

  int getNext(int[] cnts, int idx) {
    int i = idx;
    while (i < cnts.length && cnts[i] == 0) {
      i++;
    }
    return i;
  }
}
