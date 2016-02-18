package CodePad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
 * end = 0; } Interval(int s, int e) { start = s; end = e; } }
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

public class MergeIntervals_xbian_sort_adding_toCurrex extends InvokableBase {

  public static class Interval {

    int start;
    int end;

    public Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }


  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151120, 0, Category.LeetCode);
  }

  @Override
  public void run() {
// [1,3],[2,6],[8,10],[15,18],

    List<Interval> intervals = Arrays.asList(new Interval[]{
        new Interval(1, 3),
        new Interval(2, 6),
        new Interval(8, 10),
        new Interval(15, 18)
    });
    Util.assertEq("size of string", 3, merge(intervals).size());

   intervals = Arrays.asList(new Interval[]{
        new Interval(2, 6),
        new Interval(5, 10),
        new Interval(5, 10),
        new Interval(2, 3),
        new Interval(9, 18),
        new Interval(1, 3)
    });
    Util.assertEq("size of string", 1, merge(intervals).size());
  }

  public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, (Interval a, Interval b)-> a.start - b.start);
    Collections.binarySearch(intervals, new Interval(1,1), (Interval a, Interval b)-> a.start - b.start);
    int i = 0;
    ArrayList<Interval> listRet = new ArrayList<>();
    // pick out the first element,  keep on merge the new element into the current
    while(i < intervals.size())
    {
      Interval cur = intervals.get(i);

      i++;
      while(i< intervals.size() && cur.end >= intervals.get(i).start)
      {
        cur.end = Math.max(cur.end, intervals.get(i).end );
        i++;
      }
      listRet.add(cur);
    }

    return listRet;
  }


}