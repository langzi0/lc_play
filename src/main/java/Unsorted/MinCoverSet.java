package Unsorted;

import java.util.Set;
import java.util.TreeSet;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * Q4) two arrays given to you. First array contains number s. Second array contains key values.
 *
 * We need to find smallest window in first array which covers all second array elements. e.g:
 *
 * Input= {6,7,1,3,2,4,5,2,3,1,2,5} Keys = {2,5,1}
 *
 * answer: from 9th index to 11th index is the smallest window
 */

public class MinCoverSet extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160205, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    //  a0---- a10
    //   t0 - t3
    // F
    Util.assertEq(3, minCoverSet(new Integer[]{6, 7, 1, 3, 2, 4, 5, 2, 3, 1,2,5}, new Integer[]{2,5,1}));
  }

  class Range {

    boolean failed;
    int start;
    int end;

    public Range() {
    }

    public Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  void getCoverRange(Integer[] ori, Integer[] key, int start, Range range) {
    int s = start;
    if (s >= ori.length) {range.failed = true; return;}
    Set set = new TreeSet<Integer>();
    for (Integer k : key) {
      set.add(k);
    }
    while ( s < ori.length && !set.contains(ori[s])) {
      s++;
    }
    int e = s;
    set.remove(ori[s]);
    while (set.size() > 0) {
      e++;
      if (e < ori.length) {
        if (set.contains(ori[e])) {
          set.remove(ori[e]);
        }
      } else {
        range.failed = true;
        break;
      }
    }
    range.start = s;
    range.end = e;
  }

  int minCoverSet(Integer[] ori, Integer[] key) {
    int s = 0;
    Range range = new Range();
    int size = Integer.MAX_VALUE;
    do {
      getCoverRange(ori, key, s, range);
      if (!range.failed) {
        size = Math.min(size, range.end - range.start + 1);
        s = range.start + 1;
      }
    } while (!range.failed);

    return size;
  }
// optimize

}
