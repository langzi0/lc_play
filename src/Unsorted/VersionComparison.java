package Unsorted;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class VersionComparison extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160131, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
//    Util.assertEq(-1, compareVersion("0.14", "3.12"));
    Math.min(1,2);
  }

//  class MaxMin implements Comparable<MaxMin> {
//
//    List<Integer> verList;
//
//    public MaxMin(String version) {
//      //String[] ver1 = StringUtils.splitString(version, ".");
//
////      verList = Arrays.stream(version.split("\\.")).map(p -> new Integer(Integer.parseInt(p)));
////      max = Integer.parseInt(version.substring(0,idx));
////      min = Integer.parseInt(version.substring(idx + 1, version.length()));
//
//    }
//
//    @Override
////    public int compareTo(MaxMin mm) {
////      if (this.max < mm.max) {
////        return -1;
////      } else if (this.max > mm.max) {
////        return 1;
////      } else if (this.min < mm.min) {
////        return -1;
////      } else if (this.min > mm.min) {
////        return 1;
////      } else {
////        return 0;
////      }
//    }
//  }
//
//  public int compareVersion(String version1, String version2) {
//    return new MaxMin(version1).compareTo(new MaxMin(version2));
//  }

}
