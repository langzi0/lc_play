package Common;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class ContainsNearbyAlmostDuplicate extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
  }

//http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/

  // This is assume no elements should show up twice in the least.
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;

    TreeSet<Integer> set = new TreeSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      int c = nums[i];
      if ((set.floor(c) != null && c <= set.floor(c) + t)
          || (set.ceiling(c) != null && c >= set.ceiling(c) -t))
        return true;

      set.add(c);

      if (i >= k)
        set.remove(nums[i - k]);
    }

    return false;

  }

  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;

    SortedSet<Long> set = new TreeSet<Long>();

    for (int j = 0; j < nums.length; j++) {
      long leftBoundary = (long) nums[j] - t;
      long rightBoundary = (long) nums[j] + t + 1;
      SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);

      if (!subSet.isEmpty())
        return true;

      set.add((long) nums[j]);

      if (j >= k) {
        set.remove((long) nums[j - k]);
      }
    }

    return false;
  }
}
