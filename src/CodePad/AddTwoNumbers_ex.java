package CodePad;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Input: (2 -> 4 -> 3) + (5 -> 6 ->
 * 4) Output: 7 -> 0 -> 8
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class AddTwoNumbers_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151005, 2, Category.LCBian);
  }

  @Override
  public void run() {
    TestCase1();
    TestCase2();
  }


  private void TestCase1() {
    // adding
    ListNode l1234 = create(1234);
    eq("1234", 1234, collect(l1234));
  }

  private ListNode create(int i) {
    ListNode node = new ListNode(i % 10);
    ListNode p = node;
    while ((i = i / 10) != 0) {
      p.next = new ListNode(i % 10);
      p = p.next;
    }

    return node;
  }

  private Integer collect(ListNode num) {
    int position = 1;
    Integer i = 0;
    while (num != null) {
      i += position * num.val;
      position *= 10;
      num = num.next;
    }
    return i;
  }

  private void TestCase2() {
    eq("", new Integer(33333), collect(addTwoNumbers(create(11111), create(22222))));
    eq("", new Integer(10000), collect(addTwoNumbers(create(11), create(9989))));
    eq("", new Integer(111), collect(addTwoNumbers(create(0), create(111))));
    eq("", new Integer(111), collect(addTwoNumbers(create(111), create(0))));
    eq("", new Integer(0), collect(addTwoNumbers(create(0), create(0))));
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode head = new ListNode(0);
    ListNode p3 = head;
    int carrier = 0;
    final int BASE = 10;
    while(l1 != null && l2 != null)
    {
      carrier += l1.val + l2.val;
      p3.next = new ListNode(carrier % BASE);
      carrier /= BASE;
      p3 = p3.next;
    }
    while(l1 != null)
    {
      carrier += l1.val;
      p3.next = new ListNode(carrier % BASE);
      carrier /= BASE;
      p3 = p3.next;
    }
    while(l2 != null)
    {
      carrier += l2.val;
      p3.next = new ListNode(carrier % BASE);
      carrier /= BASE;
      p3 = p3.next;
    }
    return head.next;
  }
}