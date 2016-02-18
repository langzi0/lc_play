package CodePad;

import java.util.Arrays;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in
 * the right-hand column. 1,2,3 �� 1,3,2 3,2,1 �� 1,2,3 1,1,5 �� 1,5,1
 *
 * a c    f e d b
 *
 * => a d(next after c), b c e f
 */

public class NextPermutation_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160126, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    int[] a = new int[]{4, 8, 3, 2, 1};
    nextPermutation(a);

    a = new int[]{8, 4, 3, 2, 1};
    nextPermutation(a);

    a = new int[]{1, 2, 3, 4, 8};
    nextPermutation(a);

    a = new int[]{4, 8, 3, 2, 1};
    nextPermutation(a);

    a = new int[]{1, 2, 3, 4};

    for (int i = 0; i < 24; i++) {
      nextPermutation(a);
    }

    for (int i = 0; i < 24; i++) {
      nextP(a);
    }


  }

  public void nextP(int[] num) {
    int i1 = 0;
    int i2 = 0;
    int i = num.length - 1;
    int j = 0;
    while (i > 0 && num[i - 1] >= num[i]) {
      i--;
    }
    if (i == 0) {
      Arrays.sort(num);
      return;
    } else {
      i1 = i - 1;
    }
    j = i1 + 1;
    while (j < num.length && num[i1] < num[j]) {
      j++;
    }
    i2 = j - 1;
    int temp = num[i1];
    num[i1] = num[i2];
    num[i2] = temp;
    Arrays.sort(num, i1 + 1, num.length);
  }

  public void nextPermutation(int[] num) {

    int n = num.length;
    if (num == null || n <= 1) {
      return;
    }
    int i = n - 2;       //stop at i where num[i] > next value
    while (i >= 0) {
      if (num[i] < num[i + 1]) {
        break;
      }
      i--;
    }
    if (i != -1) { // find next bigger one than num[i]
      int k = i + 1;
      while (k + 1 < n && num[k + 1] > num[i]) {
        k++;
      }

      int temp = num[i];
      num[i] = num[k];
      num[k] = temp;
    }

    Arrays.sort(num, i + 1, n);

  }
}