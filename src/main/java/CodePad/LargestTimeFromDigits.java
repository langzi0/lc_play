package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class LargestTimeFromDigits extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/200916, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    new LargestTimeFromDigits().largestTimeFromDigits(
        new int[]{
            1,2,3,4});
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
  }


   private Result maxMinute(int[] array, int pos){
         return null;

   }

    public String largestTimeFromDigits(int[] arr) {
      //get first two number first.

      for (int i = 0; i< 4; i++){
        for (int j = i; j < 4; j++){
          swap(arr, i, j);
          int val = evalMin(arr);
          if (val > nmin){
            copyInts(arr, arrsave);
            nmin = val;
          }
          swap(arr, i, j);
        }
      }
      if (nmin == -1)
        return "";
      return String.format("%1d%1d:%1d%1d", arrsave[0], arrsave[1], arrsave[2], arrsave[3]);

    }

    int [] arrsave = new int[4];
    int nmin = -1;

    void perm(int[] arr, int i, int j){
      if (i == j) {
        int val = evalMin(arr);
        if (val > nmin){
          copyInts(arr, arrsave);
          nmin = val;
        }
        return;
      }

      for (int x = i; x <= j; x ++){
        swap(arr, i, j);
        perm(arr, i+1, j);

        swap(arr, i, j);
      }
    }


    private void copyInts(int[] arrFrom, int[] arrTo){
      for (int i = 0; i< arrFrom.length; i++){
        arrTo[i] = arrFrom[i];
      }
    }

    private int evalMin(int[] arr){
      int n = -1;
      int hr = arr[0] * 10 + arr[1];
      if (hr <= 24) {
        int min = arr[2] * 10 + arr[3];
        if (min <= 59){
          if (!( hr == 24 && min == 0)){
            n = hr * 60 + min;
          }
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
