package CodePad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers. Elements in a combination (a1, a2, ? ,
 * ak) must be in non-descending order. (ie, a1 ? a2 ? ? ? ak). The solution set must not contain
 * duplicate combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is:
 * [7] [2, 2, 3]
 */

public class CombinationSum_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    Scanner scan = new Scanner(System.in);
    Integer i = scan.nextInt();
  }

  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
                                                      int target) {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> solution = new ArrayList<Integer>();
    Arrays.sort(candidates);
    combinationSum(candidates, 0, 0, target, ret, solution);
    return ret;
  }

  private void combinationSum(int[] candidates, int start, int sum,
                              int target, ArrayList<ArrayList<Integer>> ret,
                              ArrayList<Integer> solution) {
    if (sum == target) {
      ret.add(new ArrayList<Integer>(solution));
      return;
    }
    if (start > candidates.length - 1) {
      return;
    }
    int times = 0;
    while (true) {
      if (sum > target) {
        for (int h = 0; h < times; h++) {
          solution.remove(solution.size() - 1);
        }
        break;
      }
      combinationSum(candidates, start + 1, sum, target, ret, solution);
      sum += candidates[start];
      solution.add(candidates[start]);
      times++;
    }

    char c = 'c';


    }



/*Given a set of candidate positive numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
*/

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    List<Integer> intList = IntStream.of(candidates).boxed().sorted().collect(Collectors.toList());
    List<Integer> distList = new ArrayList<>();
    for (Integer i : intList) {
      if (distList.isEmpty() || distList.get(distList.size() - 1) != i) {
        distList.add(i);
      }
    }

    List<List<Integer>> listInt = new ArrayList<>();


  return null;

  }

  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    Integer[] x = IntStream.of(candidates).boxed().sorted().toArray(Integer[]::new);

    List<Integer> intList = IntStream.of(candidates).boxed().sorted().collect(Collectors.toList());
    List<Integer> distList = new ArrayList<>();

    for (Integer i : intList) {
      if (!distList.isEmpty() || distList.get(distList.size() - 1) != i) {
        distList.add(i);
      }
    }

    ArrayList<ArrayList<Integer>> cnt = new ArrayList<ArrayList<Integer>>();
    cnt = GetResultFrom(distList, target);
    return null;

  }

  private ArrayList<ArrayList<Integer>> GetResultFrom(List<Integer> distList, int target) {
    int i = 0;
    ArrayList<ArrayList<ArrayList<Integer>>> map = new ArrayList<ArrayList<ArrayList<Integer>>>();
    map.set(i++, new ArrayList<ArrayList<Integer>>());

    while (i <= target) {
      // check i - distList[0:n-1]'s map solution.
      ArrayList<ArrayList<Integer>> curi = new ArrayList<ArrayList<Integer>>();


    }

  return null;
  }
}