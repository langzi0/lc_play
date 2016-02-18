package Question;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 *
 *
 * Given a set of ranges: (e.g. S = {(1, 4), (30, 40), (20, 91) ,(8, 10), (6, 7), (3, 9), (9, 12),
 * (11, 14)}. And given a target range R (e.g. R = (3, 13) - meaning the range going from 3 to 13).
 * Write an algorithm to find the smallest set of ranges that covers your target range. All of the
 * ranges in the set must overlap in order to be considered as spanning the entire target range. (In
 * this example, the answer would be {(3, 9), (9, 12), (11, 14)}.
 *
 *
 * 1. m segments, pick out n segments to cover target <s,t>.    C(m,n) pick n out, we need cover the
 * first region
 *
 * say, we picked up one first. Then we need to find select from one of n that covers the end point
 * and further. We need to sort the segments, so that we pick choices up/down by sequence
 */

public class FBCoveringSegment extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151208, 3, Category.LeetCode);
  }

  @Override
  public void run() {
    List<Segment> list = findMinCoverSegmentSet(Arrays.asList(
        new Segment[]{new Segment(1, 4), new Segment(30, 40), new Segment(20, 91),
                      new Segment(8, 10), new Segment(6, 7), new Segment(3, 9), new Segment(9, 12),
                      new Segment(11, 14)}), new Segment(3, 13));

    Util.show("Output:FBCoveringSegment ");
    if (list != null) {
      Util.assertEq("(3,9),(9,12),(11,14)", StringUtils.join(list.stream().map(
                                     p -> p.toString()).collect(Collectors.toList()),
                                 ","));
    }
  }

  class Segment {

    public int start;
    public int end;

    public Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "(" + Integer.valueOf(start) + "," + Integer.valueOf(end) + ")";
    }

    public boolean coverTargetBegin(Segment target)  // reduces start of target
    {
      return ((target.start < this.end && target.start >= this.start));
    }

    public Segment minus(Segment seg) {
      if (seg.end >= this.end) {
        return null;
      }
      return new Segment(seg.end, this.end);
    }
  }

  private List<Segment> minSegments;
  private int sizeMinSegmetns = Integer.MAX_VALUE;

  public List<Segment> findMinCoverSegmentSet(List<Segment> input, Segment target) {
    List<Segment>
        listSort =
        input.stream().sorted((s1, s2) -> s1.start - s2.start).collect(Collectors.toList());
    ArrayList<Segment> arraySort = new ArrayList<>(listSort);

    //We want it to be sorted, so that we are following a sequence. Also it help reduce
    // for each segment in the list, add a seg if it covers further in target, select it
    select(arraySort, 0, new ArrayList<>(), target);
    if (sizeMinSegmetns == Integer.MAX_VALUE) {
      return null;
    }
    return minSegments;
  }

  // This is also a combination problem, where select Ci = 0/1, i=0, n-1;

  private void select(ArrayList<Segment> array, int cur, List<Segment> selected, Segment target) {
    for (; cur < array.size(); cur++) {

      Segment curSeg = array.get(cur);
      // Since it is sorted, a little optimization, will avoid huge set issue.
      if (curSeg.start > target.end)
        break;
      if (curSeg.coverTargetBegin(target)) {
        Segment newTarget = target.minus(curSeg);
        List<Segment> temp = new ArrayList<>();
        selected.stream().forEach(a -> temp.add(a));
        temp.add(curSeg);
        if (newTarget == null) {
          if (temp.size() < sizeMinSegmetns) {
            minSegments = temp;
            sizeMinSegmetns = temp.size();
          }
        } else {
          select(array, cur + 1, temp, newTarget);
        }
      }

    }
  }
}
