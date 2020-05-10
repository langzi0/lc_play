package sharedDataStructure;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public String toString() {
    return Integer.valueOf(val).toString();}


  public static void showPreOrder(TreeNode root, boolean printNull) {
    System.out.println("Show preorder");
    preOrder(root, printNull);
    System.out.println("\nShow preorder end");
  }
    public static void preOrder(TreeNode root, boolean printNull)
  {
    if (root == null) {
      if (printNull)
        System.out.print(" null,");

      return;
    }
    System.out.print(" " + root.val + ",");
    preOrder(root.left, printNull);
    preOrder(root.right, printNull);
  }

  public static TreeNode buildTreeFromPreorderWithNull(Integer[] input)
  {
    if (input == null)
    {
      /*
      *    4
      *      3
      * 2
      *    1
      *
      * */
      input = new Integer[]{2, 1, null, null, 4, 3, null, null, null};
    }

    TreeNode root = null;
    _pos = 0;
    root = build(input);
    return root;
  }
  private static int _pos;
  private static TreeNode build(Integer[] t)
  {

    Integer val = t[_pos++];
    if  ( val == null)
      return null;
    TreeNode node = new TreeNode(val);
    node.left = build(t);
    node.right = build(t);
    return node;
  }

}