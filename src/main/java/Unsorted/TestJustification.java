package Unsorted;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
"This    is    an",
"example  of text",
"justification.  "
]
 */

public class TestJustification extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160203, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    //fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    //fullJustify(new String[]{"What","must","be","shall","be."}, 12);
    fullJustify(new String[]{"Imagination","is","more","important","than","knowledge."}, 11);
  }
  // 22:43  ==> 23:26
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<List<String>> lines = new ArrayList<List<String>>();

    int i = 0;
    int curSize = 0;
    List<String> curLine = new ArrayList<>();

    while(i < words.length)
    {
      if (words[i].length() + curSize > maxWidth || (curSize == 0 && words[i].length() == maxWidth))
      {
        lines.add(curLine);
        curLine = new ArrayList<>();
        curSize = 0;
      }

      curSize += words.length + 1;
      curLine.add(words[i]);
      i++;
    }

    List<String> list = lines.stream().map(p -> ProcessLine(p, maxWidth)).collect(Collectors.toList());
    list.add(ProcessLastLine(curLine, maxWidth));
    // curLine is the last line here.
    return list;

  }

  private String ProcessLastLine(List<String> curLine, int maxWidth) {

    return String.join(" ", curLine);
  }

  private String ProcessLine(List<String> curLine, int maxWidth) {
    int len = curLine.stream().map(p->p.length()).mapToInt(Integer::intValue).sum();

    if (curLine.size() == 1)
      return curLine.get(0) + new String(new char[maxWidth - curLine.get(0).length()]).replace('\0', ' ');
    int base = (-len + maxWidth) / (curLine.size() - 1);
    int left = (-len + maxWidth) % (curLine.size() - 1);
    String line = "";
    for(int i =0; i< curLine.size() - 1; i++)
    {
      line += curLine.get(i);
      line += new String(new char[base + ((i<left)? 1:0)]).replace('\0', ' ');
    }
    return line;
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for(String str : strs)
    {
      char[] chars = str.toCharArray();
      Arrays.sort(chars, 0, chars.length);
      String sortStr = new String(chars);
      if (!map.containsKey(sortStr))
        map.put(sortStr, new ArrayList<>());
      List<String> listStr = map.get(sortStr);
      listStr.add(str);

    }
    return map.values().stream().collect(Collectors.toList());


  }
}
