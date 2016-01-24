package CodePad;

/**
 * Given a linked list, determine if it has a cycle in it. Follow up: Can you solve it without using
 * extra space?
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */
public class LinkedListCycle extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
  }

  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode fast = head;
    ListNode late = head;
    do {
      fast = fast.next;
      late = late.next;
      if (late == null) {
        return false;
      } else {
        late = late.next;
        if (fast == late) {
          return true;
        }
      }
    } while (fast != null && late != null);
    return false;
  }
}
