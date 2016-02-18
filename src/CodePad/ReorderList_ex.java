package CodePad;

/**
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln, reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2->...
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class ReorderList_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public void reorderList(ListNode head) {
    //
  }

  private ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode prev = null;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}