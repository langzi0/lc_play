package CodePad;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up: Could you do this in-place?
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class RotateImage_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    if (n == 0) {
      return;
    }
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = t;
      }
    }
  }
}