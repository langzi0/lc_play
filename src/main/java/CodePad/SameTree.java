package CodePad;

/**
 * Same TreeSep 3 '12 Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the
 * same value.
 *
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import sharedDataStructure.TreeNode;

public class SameTree extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if ((p == null && q != null) || (p != null && q == null)) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    } else {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }
}