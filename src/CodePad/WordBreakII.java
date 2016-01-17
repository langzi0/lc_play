package CodePad;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where
 * each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class WordBreakII extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151114, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    Set<String> dict = new HashSet<>();

    Arrays.asList("a", "b").stream().forEach(p->dict.add(p));
    Arrays.asList(new String[]{
        //    "cat", "cats", "and", "sand", "dog"
        "ca", "ab", "b", "a", "ba", "ab", "c"

    }).forEach(p -> dict.add(p));

    Arrays.asList("a", "b").get(0);

    String src =
        // "catsanddog";
         "abcabcabcabc";
    buildWordList(src, dict, new LinkedList<String>(), 0, src.length());
  }

  //  each step will be    ;


  public void buildWordList(String src, Set<String> dict, List<String> wordList, int start, int n) {

    // start to shortest to longest word at this point.
    if (start == n) {
      System.out.println(StringUtils.join(wordList, ","));
    }
    int j = start;
    while (j < n) {
      String test = src.substring(start, j + 1);
      if (dict.contains(test)) {
        wordList.add(test);
        buildWordList(src, dict, wordList, j + 1, n);
        wordList.remove(wordList.size() - 1);
      }
      j++;
    }
  }

}
