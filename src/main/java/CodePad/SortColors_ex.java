package CodePad;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Follow up: A rather straight forward solution is a two-pass algorithm using counting sort. First,
 * iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of
 * 0's, then 1's and followed by 2's.
 *
 * Could you come up with an one-pass algorithm using only constant space?
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

public class SortColors_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151216, 4, Category.LeetCode);
  }

  @Override
  public void run() {
    int[] A = new int[]{2,1,1,0,2};
    sortColors(A);
    Util.assertEq(0, A[0]);
  }

  public void sortColors(int[] nums) {
    int end0=0; int i=0; int start2=nums.length-1;
    while(i<=start2)
    {// ensure it is 000(0=<s-1)1111(i=0/1/2)?????(e+1=>)222

      if(0==nums[i]){
        swap(nums, i, end0);
        end0++;
        i++;
      }else if(2==nums[i]){
        swap(nums, start2, i);
        start2--;
      }else{
        i++;
      }
    }
  }

  public void sortColors1(int[] A) {
    // s = -1; end = n;
    // collected 0s so far ending at s;
    // collected 1s so far starting at n
    // for i = 0 : n-1  between A[i] and A[s] it will be all 1s.
   // ensure it is 000(0=<s-1)1111(i=0/1/2)?????(e+1=>)222

    // or we can use count sort.
    int s = -1;
    int e = A.length;
    int i = 0;
    while(i < e)
    {
      if (A[i] == 0)
      {
        s++;
        swap(A, i, s);
        i++;
      } else if (A[i] == 2){
        swap(A, i, e - 1);
        e --;
        // no i++ here, as it might be 2 swapped here.
      }
      else {
        i++;
      }
    }
  }

  void swap(int[] A, int i, int j)
  {
    int temp = A[i]; A[i] = A[j]; A[j] = temp;
  }
}