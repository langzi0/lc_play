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
import Common.Util;

/**
 * Given an array of strings, return all groups of strings that are anagrams to each other in each subgroup. Note: All inputs will
 * be in lower-case.
 *
 * I think we should sort each words, then register each to the sorted words which will be claimed
 * as group
 */
public class Anagrams_ex_star extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160221, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    List<List<String>> ret;
    ret = anagrams(new String[]{"BAT", "TAB", "AT", "ABT", "TA"});
    Util.assertEq(2, ret.size());

    ret = anagrams(new String[]{"BAT", "TAB", "AT", "you", "ABT", "TA"});
    Util.assertEq(3, ret.size());
    ret = anagrams(new String[]{"BAT", "TAB", "A", "A", "TA"});
    Util.assertEq(3, ret.size());

    // We need to convert each string to its root and check if its root has happened in a map. if so, add it there
  }


  public List<List<String>> anagrams(String[] strs){
    Map<String, List<String>> rootList = new HashMap<>();
    for(String s: strs){
      String root = getRoot(s);
      if (!rootList.containsKey(root))
      {
        rootList.put(root, new ArrayList<String>());
      }
      rootList.get(root).add(s);
    }

    return rootList.values().stream().collect(Collectors.toList());
  }

  private String getRoot(String s) {
    char[] chs = s.toCharArray();
    Arrays.sort(chs);
    return new String(chs);
  }


  public List<List<String>> anagrams1(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    for(String s : strs)
    {
      String sorted = getOder(s);
      if (!map.containsKey(sorted))
      {
        map.put(sorted, new ArrayList<>());
      }
      List<String> list = map.get(sorted);
      list.subList(1, 2);
      list.add(s);
    }
    return map.values().stream().collect(Collectors.toList());
  }

  private String getOder(String s)
  {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return chars.toString();
  }

  private String sort(String s) {
    char[] chs = s.toCharArray();
    Arrays.sort(chs);
    //Arrays.sort(chs,0,1);
    return new String(chs);
  }

  public List<List<String>> anagrams2(String[] strs) {
    System.out.println("input:" + StringUtils.join(Arrays.asList(strs), ","));
    Map<String, List<String>> mapRootToList = new HashMap<>();
    for (String s : strs) {
      String root = sort(s);
      if (!mapRootToList.containsKey(root)) {
        mapRootToList.put(root, new ArrayList<>());
      }
      mapRootToList.get(root).add(s);
    }


    mapRootToList.entrySet().stream().forEach(p -> {
      System.out.println(StringUtils.join(p.getValue(), ","));
    });

    return mapRootToList.entrySet().stream().map(p->p.getValue()).collect(Collectors.toList());
  }
}