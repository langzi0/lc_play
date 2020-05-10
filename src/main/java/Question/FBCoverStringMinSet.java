package Question;

import java.util.HashMap;
import java.util.Map;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 *
 * Given a random string S and another string T with unique elements, find the minimum consecutive
 * sub-string of S such that it contains all the elements in T. example: S='adobecodebanc' T='abc'
 * answer='banc'
 */

public class FBCoverStringMinSet extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151206, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    Util.assertEq("\"banc\", subCover(\"adobecodebanc\", \"abc\")", "banc",
                  subCover("adobecodebanc", "abc"));
  }

  Map<Character, Integer> buildMap(String T) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : T.toCharArray()) {

      Character chr = Character.valueOf(ch);
      if (!map.containsKey(chr)) {
        map.put(chr, 0);
      }
      map.put(Character.valueOf(ch), map.get(chr) + 1);

    }
    return map;
  }

  String subCover(String S, String T) {
    int len = S.length();
    int mins = 0;
    int mine = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      Map<Character, Integer> map = buildMap(T);
      if (!map.containsKey(Character.valueOf(S.charAt(i)))) {
        continue;
      }
      // Take i as a start
      int end = i;
      while (map.size() > 0 && end < len) {
        Character chr = Character.valueOf(S.charAt(end));
        if (map.containsKey(chr)) {
          int cnt = map.get(chr);
          if (cnt == 1) {
            map.remove(chr);
          } else {
            map.put(chr, cnt - 1);
          }
        }
        end++;
      }

      if (map.size() == 0 && end - i < mine - mins) {
        mine = end-1;
        mins = i;
      }


    }

    if (mine < len) {
      return S.substring(mins, mine + 1);
    }

    return null;

  }
}
