package Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class BSTIterator extends InvokableBase {


  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    BSTIterator t = new BSTIterator(null);
  }

  public class TreeNode {

    int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
      val = x;
      if (val == -999999) {
        val = Integer.MIN_VALUE;
      }
    }
  }

  Stack<TreeNode> stack;
  TreeNode current;

  public BSTIterator() {
  }

  public BSTIterator(TreeNode root) {
    stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    current = null;
    if (!stack.empty()) {
      current = stack.pop();
    }

    List<TreeNode> listNodes = Arrays.asList(new TreeNode[]{new TreeNode(2), new TreeNode(1)});
    Collections.sort(listNodes, (TreeNode t1, TreeNode t2) -> t1.val - t2.val);
    Collections.binarySearch(listNodes, new TreeNode(5),
                             (TreeNode t1, TreeNode t2) -> t1.val - t2.val);
    listNodes.sort((TreeNode t1, TreeNode t2) -> t1.val - t2.val);
    Iterator<TreeNode> it = listNodes.iterator();
    while (it.hasNext()) {
      TreeNode t = it.next();

    }

  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return (current != null);
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeNode node = current;
    if (current.right != null) {
      TreeNode cur = current.right;
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
    }
    current = null;
    if (!stack.empty()) {
      current = stack.pop();
    }

    return node.val;
  }
}
