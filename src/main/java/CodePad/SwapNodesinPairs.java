package CodePad;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only
 * nodes itself can be changed.
 *
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class SwapNodesinPairs extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    } else if (head.next == null) {
      return head;
    } else {
      ListNode nextList = swapPairs(head.next.next);
      ListNode tmp = head.next;
      head.next = nextList;
      tmp.next = head;
      return tmp;
    }
  }
}