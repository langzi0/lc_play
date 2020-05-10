package CodePad;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and
 * index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class TwoSum_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151118, 0, Category.LeetCode);
  }

  @Override
  public void run() {

    int[] result = twoSum(new int[]{1, 3, -2, 9, 6, -3}, 0);
    System.out.println(Integer.toString(result[0]) + " " +  Integer.toString(result[1]));
  }

  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Set<Integer>> map = new HashMap<>();

    for(int i = 0; i< numbers.length; i++)
    {
      if (!map.containsKey(numbers[i]))
        map.put(numbers[i], new LinkedHashSet<>());
      Set<Integer> set = map.get(numbers[i]);
      set.add(i);
    }

    for(int i = 0; i< numbers.length; i++)
    {
      if (map.containsKey(-numbers[i]))
      {
        Set<Integer> set = map.get(-numbers[i]);
        for(Integer choice: set)
        {
          if (i< choice)
          {
            return new int[]{i, choice};
          }
        }
      }


    }
    return null;
  }

  public class NumPos{
    public int val;
    public int idx;
    public NumPos(int val, int idx)
    {
      this.val = val;
      this.idx = idx;
    }
  }

  public class Num {

    private int value;
    private int index;

    public Num(int value, int index) {
      super();
      this.value = value;
      this.index = index;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }
}