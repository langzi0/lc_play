package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

import java.util.Arrays;

public class LargestTimeFromDigits extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/200925, 0, Category.LeetCode);
  }

  @Override
  public void run() {

    Result r = run1(new int[]{1,2,3,4});
    r = run1(new int[]{5,5,5,5});
    r = run1(new int[]{0,0,0,0});
    r = run1(new int[]{1,0,0,0});
    r = run1(new int[]{9,5,2,3});

  }


  private Result run1(int[] casex){
    Result result = new Result();
    new LargestTimeFromDigits().maxMinute(casex, 0, result);
    if (result.maxMin > 0){

    }return result;
  }
  /*
  *
  *
  *Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.

Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.



Example 1:

Input: A = [1,2,3,4]
Output: "23:41"
Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.
Example 2:

Input: A = [5,5,5,5]
Output: ""
Explanation: There are no valid 24-hour times as "55:55" is not valid.
Example 3:

Input: A = [0,0,0,0]
Output: "00:00"
Example 4:

Input: A = [0,0,1,0]
Output: "10:00"


Constraints:

arr.length == 4
0 <= arr[i] <= 9
  *
  *
  *
  * */

  class Result {
    int maxMin = -1;
    int[] array = new int[4];
    int cnt = 0;
  }

  // Swap pos with pos -  pos.length -1
  // We want to share a gbobal variable of result, another way is to use a carried with variable

   private void maxMinute(int[] array, int pos, Result result){
         if (pos< array.length - 1){
           for (int i = pos; i< array.length; i++) {
             swap(array, pos, i);
             maxMinute(array, pos + 1, result);
             swap(array, pos, i);
           }
         } else {
           result.cnt ++;
           if (evalMin(array) > result.maxMin){
             result.maxMin = evalMin(array);
             result.array = Arrays.copyOf(array, array.length);
           }
         }

   }

    private int evalMin(int[] arr){
      int n = -1;
      int hr = arr[0] * 10 + arr[1];
      if (hr <= 23) {
        int min = arr[2] * 10 + arr[3];
        if (min <= 59){
            n = hr * 60 + min;
          }
        }
      return n;
    }

    private void swap(int[] arr, int i, int j){
      if (i == j)
        return;
      int val = arr[i];
      arr[i] = arr[j];
      arr[j] = val;
    }
  }
