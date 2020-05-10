package CodePad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation
 * sequence from start to end, such that:
 *
 * Only one letter can be changed at a time Each intermediate word must exist in the dictionary For
 * example,
 *
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 *
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length
 * 5.
 *
 * Note:
 *
 * Return 0 if there is no such transformation sequence. All words have the same length. All words
 * contain only lowercase alphabetic characters.
 */

public class WordLadder_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160206, 1, Category.LeetCode);
  }

  @Override
  public void run() {

    HashSet dict = new HashSet();
    for(String s : new String[]{"hot","dot","dog","lot","log"}) dict.add(s);
    Util.assertEq("found", true, findPath("hit", "cog", dict));
    Util.assertEq("found", true, findPath("hit", "nza1", dict));
    Util.assertEq("found", 5, shortestPathLength("hit", "cog", dict));
    Util.assertEq("found", 0, shortestPathLength("hit", "nza1", dict));
  }
  public List<String> shortestPath(String start, String end,
                                HashSet<String> dict){
    // Assume start and end not in dict;
    dict.add(end);
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    Map<String, String> pres = new HashMap<>();
    queue.add(start);
    visited.add(start);
    while(!queue.isEmpty())
    {
      String curWord = queue.remove();
      for(String word : dict)
      {
        if (!visited.contains(word) && isNebr(word, curWord))
        {
          visited.add(word);
          pres.put(word, curWord);
          if (isNebr(end, word))
          {
            List<String> ret = new LinkedList<>();
            ret.add(0, end);
            ret.add(0, word);

            String tem=  word;
            while(pres.containsKey(tem))
            {
              tem = pres.get(tem);
              ret.add(0, tem);
            }
          }
          queue.add(word);
        }
      }
    }
    return new LinkedList<>();
  }
  // Remember the level of each node, but root using 0, each level = previous level + 1;
  public int shortestPathLength(String start, String end,
                                HashSet<String> dict){
    // Assume start and end not in dict;
    dict.add(end);
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    Map<String, Integer> levels = new HashMap<>();
    queue.add(start);
    visited.add(start);
    levels.put(start, 1);

    while(!queue.isEmpty())
    {
      String curWord = queue.remove();
      for(String word : dict)
      {
        if (!visited.contains(word) && isNebr(word, curWord))
        {
          visited.add(word);
          levels.put(word, levels.get(curWord) + 1);
          if (isNebr(end, word))
          {
            return levels.get(word) + 1;
          }
          queue.add(word);
        }
      }
    }
    return 0;
  }

  //To see it covers the end point
  public boolean findPath(String start, String end,
                          HashSet<String> dict){
    // Assume start and end not in dict;
    dict.add(end);
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(start);
    visited.add(start);
    while(!queue.isEmpty())
    {
      String curWord = queue.remove();
      for(String word : dict)
      {
        if (!visited.contains(word) && isNebr(word, curWord))
        {
          visited.add(word);
          if (isNebr(end, word))
          {
            return true;
          }
          queue.add(word);
        }
      }
    }
    return false;
  }

  private boolean isNebr(String word, String curWord) {
    if (word.equals(curWord))
      return false;
    if (word.length() == curWord.length())
    {
      for(int i = 0; i< word.length(); i++)
      {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          char[] chs = word.toCharArray();
          chs[i] = ch;
          if (curWord.equals(new String(chs)))
            return true;
        }
      }
    }
    return false;
  }


  public int ladderLength(String start, String end, HashSet<String> dict) {
    if (dict.isEmpty()) {
      return 0;
    }
    int currentLevel = 1, nextLevel = 0;
    int steps = 0;
    boolean found = false;
    HashSet<String> visited = new HashSet<String>();

    Queue<String> q = new LinkedList<String>();
    q.add(start);
    while (!q.isEmpty()) {
      String st = q.remove();
      currentLevel--;
      if (st.equals(end)) {
        steps++;
        found = true;
        break;
      } else {
        for (int i = 0; i < st.length(); i++) {
          StringBuffer sb = new StringBuffer(st);
          for (int j = 0; j < 26; j++) {
            sb.setCharAt(i, (char) ('a' + j));
            String next = sb.toString();
            if (dict.contains(next) && !visited.contains(next)) {
              q.add(next);
              visited.add(next);
              nextLevel++;
            }
          }
        }
      }
      if (currentLevel == 0) {
        steps++;
        currentLevel = nextLevel;
        nextLevel = 0;
      }
    }

    return found ? steps : 0;
  }
}