package CodePad;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;
import sharedDataStructure.TreeNode;

/**
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */

public class BinaryTreeInorderTraversal_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151209, 1, Category.LeetCode);
  }

  @Override
  public void run() {

    TreeNode root = TreeNode.buildTreeFromPreorderWithNull(
        new Integer[]{2, 1, null, null, 4, 3, null, null, null}
    );

    List<Integer> list = inorderTraversal(root);
    Util.show(
        StringUtils.join(list.stream().map(p -> p.toString()).collect(Collectors.toList()), ","));

  }


  public List<Integer> inorderTraversal(TreeNode root) {
    TreeNode p = root;
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> out = new ArrayList<>();
    while (p != null) {
      stack.push(p);
      p = p.left;
    }

    while (!stack.isEmpty()) {
      TreeNode t = stack.pop();
      out.add(t.val);

      p = t.right;
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
    }

    return out;
  }

  public int findDept(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int dl = findDept(root.left);
    int dr = findDept(root.right);
    return Math.max(dl, dr) + 1;
  }


  public List<TreeNode> findPath(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    if (root.val == target) {
      List<TreeNode> list = new ArrayList<>();
      list.add(root);
      return list;
    }

    List<TreeNode> listLeft = findPath(root.left, target);
    if (listLeft != null && listLeft.size() > 0) {
      listLeft.add(0, root);
      return listLeft;
    }

    List<TreeNode> listRight = findPath(root.right, target);
    if (listRight != null && listRight.size() > 0) {
      listRight.add(0, root);
      return listRight;
    }

    return null;
  }

// inorder traversal without recursive
  // Not done yet.


}