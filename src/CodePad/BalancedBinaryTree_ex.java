package CodePad;

/**
 * Balanced Binary TreeOct 9 '12 Given a binary tree, determine if it is height-balanced. For this
 * problem, a height-balanced binary tree is defined as a binary tree in which every node's two
 * subtrees' depth are never differ by more than 1.
 *
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */


import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import sharedDataStructure.TreeNode;

public class BalancedBinaryTree_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151018, 5, Category.LeetCode);
  }

  @Override
  public void run() {

    System.out.println(isBalanced(TreeNode.buildTreeFromPreorderWithNull(null)));

    System.out.println(isBalanced(TreeNode.buildTreeFromPreorderWithNull(
        new Integer[]{2, null, 4, 3, null, null, 5, null, null})));

    System.out.println(isBalanced(TreeNode.buildTreeFromPreorderWithNull(
        new Integer[]{null})));

    System.out.println(isBalanced(TreeNode.buildTreeFromPreorderWithNull(
        new Integer[]{1, null, 2, null, 3, null, null})));

    System.out.println(isBalanced(TreeNode.buildTreeFromPreorderWithNull(
        new Integer[]{2, null, null})));
  }

  private boolean isBalanced(TreeNode root) {
    TreeNode.showPreOrder(root, true);

    Boolean isB = true;
    Status status = depth(root);
    return status.isB;
  }

  class Status {
    // no need to use public as default is same package level visibility
    int depth;
    boolean isB;

    Status(int depth, boolean isB) {
      this.depth = depth;
      this.isB = isB;
    }
  }

  private Status depth(TreeNode root) {
    // each tree return depth, and is
    if (root == null) {
      return new Status(0, true);
    }

    Status rd = depth(root.right);
    Status ld = depth(root.left);

    return new Status(rd.depth > ld.depth ? rd.depth + 1 : ld.depth + 1,
                      rd.isB && ld.isB && (ld.depth - rd.depth < 2 && rd.depth - ld.depth < 2));

  }

  private Status checkTree(TreeNode root)
  {
    if (root == null)
      return new Status(0, true);
    Status sl = checkTree(root.left);
    Status sr = checkTree(root.right);
    return new Status(Math.max(sl.depth, sr.depth) + 1, sl.isB && sr.isB && Math.abs(sl.depth - sr.depth)<=1);

  }


  public boolean determine(TreeNode root) {
    // we need to know left and right depth,  -1 to represent it is unbalanced.
    // We return result of MaxDepth and  -1;

    Status status = checkTree(root);

    return status.isB;


  }


  public int determineOld(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftDepth = determineOld(root.left);
      int rightDepth = determineOld(root.right);
      if (leftDepth < 0 || rightDepth < 0
          || Math.abs(leftDepth - rightDepth) > 1) {
        return -1;
      }
      return Math.max(leftDepth, rightDepth) + 1;
    }
  }
}