package Question;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */
//http://www.careercup.com/page?pid=facebook-interview-questions  facebook
public class FBQuestions extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151201, 3, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    Question1();
    Question3();

    Util.show("isSumOfConsectivePosistiveIntegers");
    Util.assertEq(" Assert continuous sum", true,
                  isSumOfConsectivePosistiveIntegers(new int[]{1, 3, 5, 7, 9}, 8));
    Util.assertEq(" Assert continuous sum", false, isSumOfConsectivePosistiveIntegers(new int[]{ 3, 5, 7}, 9));
    Util.assertEq(" Assert continuous sum", true, isSumOfConsectivePosistiveIntegers(new int[]{ 3}, 3));
    Util.assertEq(" Assert continuous sum", false, isSumOfConsectivePosistiveIntegers(new int[]{ 5}, 9));


  }

  void Question1() {
    // Write a function to find how many valid letters are in a
    // string of digits give the mapping: a -> 1 b -> 2 ... z - > 26 ex)
    // '123' =>1, 12, 23 => 'a', 'l', 'w'
    String digitsStr = "122";
    int count = numOfValidStringCoding(digitsStr);
    Util.assertEq(3, count);

    Util.assertEq(3, numOfValidStringCoding(digitsStr));
    Util.assertEq(3, count);

  }

  private int count = 0;

  private int numOfValidStringCoding(String str) {
    count = 0;
    findValid(str, 0);
    return count;
  }

  void findValid(String str, int start) {
    int n = str.length();
    if (start == n) {
      count++;
      return;
    }

    Character chStart = str.toCharArray()[start];
    if (chStart.equals('1')) {
      findValid(str, start + 1);
      if (start + 1 < n) {
        findValid(str, start + 2);
      }
    } else if (chStart.equals('2')) {
      findValid(str, start + 1);
      if (start + 1 < n) {
        Character chStart1 = str.toCharArray()[start + 1];
        if (chStart1 <= '6') {
          findValid(str, start + 2);
        }
      }
    }
  }

  void Question2() {
    //How to find if a binary tree was "complete"
    // (i.e, if all leaf nodes were either at the maximum
    // depth or max depth-1, and were 'pressed' along the left side of the tree)

  /*  We should BFS browsing the tree, if we start to see a node has one or 0 children, then all the node after that
  should have 0 child.

*/
    /*
    * Given a random string S and another string T with unique elements, find the minimum consecutive sub-string of S such that it contains all the elements in T.
example:
S='adobecodebanc'
T='abc'
answer='banc'

maintain a set for T,   S has n * (n-1) subcontinuous substring.

starting 0 to S.length,
  ending from start to n,
  mark off each element in a treeSet of T. treeSet has no elements.
    * */

    /*
    *Given a set of ranges:
(e.g. S = {(1, 4), (30, 40), (20, 91) ,(8, 10), (6, 7), (3, 9), (9, 12), (11, 14)}.
And given a target range R (e.g. R = (3, 13) - meaning the range going from 3 to 13).
 Write an algorithm to find the smallest set of ranges that covers your target range.
 All of the ranges in the set must overlap in order to be considered as spanning the
 entire target range. (In this example, the answer would be {(3, 9), (9, 12), (11, 14)}.

 start from 3, find one seg that covers 3, then find the next point needs to cover,
 keep on brack tracing and remember the solution's steps.
    *
     */
/*
*


change to another word with one letter change.

Adding word to graph.
Node {
List<Node> next;
}
AddNodeToGraph(){
Build up the graph relationship

}

All less efficiency in interview:
  1. checkIf isNext(String w1, String w2){

  }






*
* */

  }

  void Question3() {

    // Find the morphing from start to end word.
    Util.assertEq("\"cat\", \"dog\"", true, findPath("cat", "dog", new HashSet<>(Arrays.asList("cot", "cog", "tog", "tag"))));
    Util.assertEq("\"cat\", \"mag\"", true, findPath("cat", "mag", new HashSet<>(Arrays.asList("cot", "cog", "tog", "tag"))));
    Util.assertEq("\"cat\", \"mao\"", false, findPath("cat", "mao", new HashSet<>(Arrays.asList("cot", "cog", "tog", "tag"))));


    Util.assertEq("\"cat\", \"dog\"", "cat,cot,cog,dog", StringUtils
        .join(findPathWithNodeList("cat", "dog", new HashSet<>(
            Arrays.asList("cot", "cog", "tog", "tag"))), ","));
    Util.assertEq("\"cat\", \"mag\"", "cat,cot,cog,tog,tag,mag", StringUtils
        .join(findPathWithNodeList("cat", "mag", new HashSet<>(
        Arrays.asList("cot", "cog", "tog", "tag"))), ","));
    Util.assertEq("\"cat\", \"mao\"", "", StringUtils
        .join(findPathWithNodeList("cat", "mao", new HashSet<>(
        Arrays.asList("cot", "cog", "tog", "tag"))), ","));
    Util.assertEq("\"cat\", \"cat\"", "cat", StringUtils
        .join(findPathWithNodeList("cat", "mao", new HashSet<>(
            Arrays.asList("cot", "cog", "tog", "tag"))), ","));

  }

  // Remember the path/cnt to the node from start. You can add a point back to the parent node.

  class Node{
    public String val;
    public Node parent;
    public Node(String val, Node node){this.val = val; this.parent = node;}
  }
  List<String> findPathWithNodeList(String start, String target, Set<String> dict) {
    Set<String> visited = new HashSet<>();
    // Adding target to dict, so we can hit target natually.
    dict.add(target);
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(start, null));
    visited.add(start);
    if (target.equals(start)) {
      List<String> path = new ArrayList<String>();
      path.add(start);
      return path;
    }

    while (!queue.isEmpty()) {
      Node curNode  = queue.poll();
      String cur = curNode.val;
      // Visit available neighbors
      for (String word : dict) {
        if (!visited.contains(word) && isNeighbor(word, cur)) {
          Node node = new Node(word, curNode);

          if (target.equals(word)) {
            List<String> path = new ArrayList<>();
            while(node != null)
            {
              path.add(0, node.val);
              node = node.parent;
            }
            return path;
          }
          visited.add(word);
          queue.add(node);
        }
      }
    }

    return new ArrayList<String>();

  }


  Boolean findPath(String start, String target, Set<String> dict) {
    Set<String> visited = new HashSet<>();
    // Adding target to dict, so we can hit target natually.
    dict.add(target);
    Queue<String> queue = new LinkedList<>();
    queue.add(start);
    visited.add(start);
    List<String> path = new ArrayList<String>();
    path.add(start);
    if (target.equals(start)) {
      return true;
    }

    while (!queue.isEmpty()) {
      String cur = queue.poll();
      // Visit available neighbors
      for (String word : dict) {
        if (!visited.contains(word) && isNeighbor(word, cur)) {
          if (target.equals(word)) {
            return true;
          }
          visited.add(word);
          queue.add(word);
        }
      }
    }

    return false;

  }

  private boolean isNeighbor(String word, String cur) {
    if (Objects.equals(word, cur) || word == null || cur == null || word.length() != cur.length()) {
      return false;
    }
    char[] c1 = word.toCharArray();
    char[] c2 = cur.toCharArray();
    int cnt = 0;
    for(int i = 0; i< c1.length; i++)
    {
      if (c1[i] != c2[i]) {
        cnt++;
        if (cnt > 1)
          return false;
      }
    }
    return true;
  }


  /*
  *
* Given an array of positive integers (excluding zero) and a target number. Detect whether there is a set of consecutive elements in the array that add up to the target.

Example: a = {1, 3, 5, 7, 9}
target = 8

output = true ({3, 5})

or target = 15
output = true : {3, 5, 8}

Remember consective sum.
sum[0..n-1]
for(sum[i] check if sum[i] + target is inside the following up list.
  * */

  boolean isSumOfConsectivePosistiveIntegers(int[] a, int target)
  {
    if (a.length == 0)
      return false;
    int s = 0;
    int e = 0;
    int sum = a[0];

    while(s<= e && e<a.length)
    {
      if (sum == target)
        return true;
      else if (sum< target)
      {
        e++;
        if ( e < a.length) {
          sum += a[e];
        }
      }
      else {
        s++;
        if (s<= e)
        {
          sum -= a[s-1];
        }
      }
    }
    return false;
  }
}
