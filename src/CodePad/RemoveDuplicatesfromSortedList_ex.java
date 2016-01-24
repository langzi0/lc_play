package CodePad;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */

public class RemoveDuplicatesfromSortedList_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    int cur = head.val;
    ListNode p = head.next;
    ListNode prev = head;
    while (p != null) {
      if (p.val == cur) {
        prev.next = p.next;
        p = prev.next;
      } else {
        cur = p.val;
        prev = prev.next;
        p = p.next;
      }
    }
    return head;
  }
}