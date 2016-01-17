package Question;

import java.util.stream.IntStream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author xbian We have an array of objects A and an array of indexes B. Reorder objects in array A
 *         with given indexes in array B. Do not change array A's length.
 *
 *         example:
 *
 *
 *         var A = [C, D, E, F, G]; var B = [3, 0, 4, 1, 2];
 *         sort(A, B); // A is now [D, F, G, C, E];
 */

public class FB9 extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151210, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    char[] A = new char[]{'C', 'D', 'E', 'F', 'G'};
    reorderUsingBspace(A, new int[]{3, 0, 4, 1, 2});//{4,3,1,0,2
    char[] target = new char[]{'D', 'F', 'G', 'C', 'E'};
    IntStream.range(0, A.length).forEach(i->{
      Util.assertEq("FB9", target[i], A[i]);});

    //Call your test in Common/Main.java

  }
//  *         var A = [C, D, E, F, G];
//            var B = [3, 0, 4, 1, 2];
//  *                  sort(A, B); // A is now [D, F, G, C, E];

  void reorderUsingBspace(char[] A, int[] B) {
    // change idx to correct way as well

    for (int i = 0; i< A.length; i++)
    {
      if (i != B[i])
      {
        // essentially, forward cur point(value, idx) to next point together
        // cur need to be stopped if it is posi again
        // posi ==> posnext ==> posNext ==> posi
        while(i != B[i])
        {
          // swap(A, i, B[i]);
          char c = A[i];
          A[i] = A[B[i]];
          A[B[i]] = c;
          // swap(B, i, B[i]);
          int t = B[i];
//          B[i] = B[B[i]];
//          B[B[i]] = t;  //Wrong as B[i] is not t any more.
          B[i] = B[t];
          B[t] = B[i];
        }
      }

    }

  }


    // do not touch B,  use only A + a new array
  void reorder(char[] A, int[] B) {
      // D==> 3, G ==> 4 == >E ==> 2 == G
    // if not using new v, since we can change A, we can also try to use the B index space
    boolean[] v = new boolean[A.length];
    // Do one iter, while next iter is not i then stop for this loop.
    for(int i =0; i< A.length; i++)
    {
      if (!v[i] && B[i] != i)
      {
        int iter = i;
        char save = A[iter];
        boolean firstTime = true;
        while(firstTime || iter != i )
        {
          firstTime = false;
          v[iter] = true;

          char temp = A[B[iter]];
          A[B[iter]] = save;
          save = temp;

          iter = B[iter];
        }
        B[iter] = save;
      }
    }

  }

}
