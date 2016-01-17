package CodePad;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given an array of strings, return all groups of strings that are anagrams. Note: All inputs will
 * be in lower-case.
 *
 * I think we should sort each words, then register each to the sorted words which will be claimed
 * as group
 */
public class Anagrams_ex_star extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151015, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    anagrams(new String[]{"BAT", "TAB", "AT", "ABT", "TA"});
    anagrams(new String[]{"BAT", "TAB", "AT", "you", "ABT", "TA"});
    anagrams(new String[]{"BAT", "TAB", "A", "A", "TA"});

//    .stream()
//        .forEach(p -> System.out.println(p));
//

    // We need to convert each string to its root and check if its root has happend in a map. if so, add it there
  }

  private String sort(String s) {
    char[] chs = s.toCharArray();
    Arrays.sort(chs);
    return new String(chs);
  }

  public List<List<String>> anagrams(String[] strs) {
    System.out.println("input:" + StringUtils.join(Arrays.asList(strs), ","));
    Map<String, List<String>> mapRootToList = new HashMap<>();
    for (String s : strs) {
      String root = sort(s);
      if (!mapRootToList.containsKey(root)) {
        mapRootToList.put(root, new ArrayList<String>());
      }
      mapRootToList.get(root).add(s);
    }


    mapRootToList.entrySet().stream().forEach(p -> {
      System.out.println(StringUtils.join(p.getValue(), ","));
    });

    return mapRootToList.entrySet().stream().map(p->p.getValue()).collect(Collectors.toList());
  }
}