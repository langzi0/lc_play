package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class CQuestion1 extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {

    //Call your test in Common/Main.jsava
//    lca(null, null, null);
  }


//  private void lca(TreeNode root, TreeNode l1, TreeNode l2) {
//
//    List<TreeNode> path1 = findPath(TreeNode , l1);
//    List<TreeNode> path2 = findPath(TreeNode , l2);
//  }
//
//  List<TreeNode> findPath(TreeNode root, TreeNode l)
//  {
//    if (root == null) return null;
//
//    if (root.val == l.val)
//    {
//      return  Arrays.asList(root);
//    }
//    List<TreeNode> left = findPath(root.left, l);
//    if (left != null)
//    {
//      left.add(0, root);
//      return left;
//    }
//    List<TreeNode> right = findPath(root.right, l);
//    if (right != null)
//    {
//      right.add(0, root);
//      return left;
//    }
//    return null;
//  }

}
