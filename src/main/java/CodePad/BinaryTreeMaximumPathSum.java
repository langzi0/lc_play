package CodePad;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import sharedDataStructure.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example: Given the below binary tree,
 *
 * 1 / \ 2 3 Return 6.
 */

public class BinaryTreeMaximumPathSum extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public int maxPathSum(TreeNode root) {
    MyInt maxSum = new MyInt(Integer.MIN_VALUE);
    findMaxSum(root, maxSum);
    return maxSum.getValue();
  }

  public int findMaxSum(TreeNode root, MyInt maxSum) {
    if (root == null) {
      return 0;
    }
    int cpath = 0;
    int left = findMaxSum(root.left, maxSum);
    int right = findMaxSum(root.right, maxSum);
    cpath = Math.max(root.val, Math.max(root.val + left, root.val + right));
    maxSum.setValue(Math.max(maxSum.getValue(),
                             Math.max(root.val + left + right, cpath)));
    return cpath;
  }

  public class MyInt {

    private int value;

    public MyInt(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

  }
}