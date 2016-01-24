package CodePad;

import java.util.ArrayList;
import java.util.Arrays;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note: Elements in a subset must be in non-descending order. The solution set must not contain
 * duplicate subsets. For example, If S = [1,2,3], a solution is:
 *
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */

public class Subsets extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
    subsets.add(new ArrayList<Integer>());
    for (int i = 0; i < S.length; i++) {
      int size = subsets.size();
      for (int j = 0; j < size; j++) {
        ArrayList<Integer> subset = new ArrayList<Integer>(
            subsets.get(j));
        subset.add(S[i]);
        subsets.add(subset);
      }
    }
    return subsets;
  }
}