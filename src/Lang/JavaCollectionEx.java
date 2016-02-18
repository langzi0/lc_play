package Lang;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * Created by @author  @since 8/10/15.
 */

public class JavaCollectionEx extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(151104, 01, Category.notClassified);
  }

  public void run() {
    //new, add element, iterate, remove, check

    array_list_init();
    list_ops();
    queue_ops();
    stack_ops();
    map_ops();
    set_ops();
    heap_ops();
    collection_ops();

  }

  private void collection_ops() {
    Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};

    Integer max = Collections.max(Arrays.asList(values));
    Util.show(max);
  }

  // if you have control on your own class use Comparable interface like here
  class Foo implements Comparable<Foo> {

    @Override
    public int compareTo(Foo o) {
      return this.intValue - o.intValue;
    }

    public Foo(int v, String n) {
      intValue = v;
      strValue = n;
    }

    public int intValue = 0;
    public String strValue = "me";
  }

  private void heap_ops() {
    //Comparator used to compare Foo from outside of Foo(especially you can not own the code, say compare
    // for Foo's string length);
    Comparator<Foo> fooComparator = new Comparator<Foo>() {
      @Override
      public int compare(Foo o1, Foo o2) {
        return o1.strValue.compareTo(o2.strValue);
      }
    };

    Thread t = new Thread(() -> {
    });
    t.run();
    //new Callable<Integer>(()->{});
    // BasicJavacTask task = new BasicJavacTask(()->{});
    //Same use lamda
    Comparator<Foo> sameFooCompartor = (Foo o1, Foo o2) -> o1.strValue.compareTo(o2.strValue);
    Util.ref((sameFooCompartor));

    // Same as priorityQueue, prirotyQueue not allow null element and it is a mini queue
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int heapSize = 10;
    IntStream.range(0, 1000).forEach(i -> {
      if (heap.size() > heapSize) {
        heap.poll();
      }
      heap.add(-i); // - max, make a max queue
    });

    System.out.println("heapSort result" + StringUtils.join(
        heap.stream()
            .map(p -> p.toString())
            .collect(Collectors.toList()), ","));

    //
    PriorityQueue<Foo>
        fooHeap =
        new PriorityQueue<Foo>((Foo f1, Foo f2) -> f2.intValue - f1.intValue);
    IntStream.range(0, 100).forEach(i -> {
      // char is a
      fooHeap.add(new Foo(i, new String(Character.toString((char) ('a' + (i % 26))))));
      if (fooHeap.size() > heapSize) {
        fooHeap.poll();
      }
    });
    System.out.println("heapSort result" + StringUtils.join(
        fooHeap.stream()
            .map(p -> Integer.toString(p.intValue) + ":" + p.strValue)
            .collect(Collectors.toList()), ","));
  }

  public class GraphNode {

    public List<GraphNode> nbrs = new ArrayList<>();
    public int val;
    public int
        inDegree;
        // For DAG, remember how man incoming node, for bidiectional, it is the size of nbrs.

    public GraphNode(int val) {
      this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof GraphNode)) {
        return false;
      }
      if (obj == this) {
        return true;
      }
      return ((GraphNode) obj).val == this.val;
    }
  }

  private void set_ops() {
    visitGraphBFS();
  }

  GraphNode buildGraph() {
    Integer[] values = new Integer[]{0, 1, 2, 3, 4, 5};

    int max = Collections.max(Arrays.asList(values));

    List<GraphNode> nodeList =
        Arrays.stream(values)
            /*
            There is one subtle difference here, which is very important:
          mapToObj(String::valueOf)
          I map the IntStream to a Stream<String> here, if you use the regular map method,
           then it only takes an IntUnaryOperator and thus you must stay within int.

           you have to box the ints because flatMap on primitives doesn't have any type-conversion overloads like flatMapToObj (doesn't exist);

assign to List rather than ArrayList as the Collectors methods make no guarantee as to the specific type they return (as it happens it currently is  ArrayList, but you can't rely on that);

use rangeClosed for this kind of situation.
            */
            .map(p -> new GraphNode(p))
            .collect(Collectors.toList());
    Map<Integer, List<Integer>> map1 = new HashMap<>(); //   0-1-2-5     0-3-5  // DAG node
    map1.put(0, Arrays.asList(1, 3));
    map1.put(1, Arrays.asList(2));
    map1.put(2, Arrays.asList(5));
    map1.put(3, Arrays.asList(5));
    map1.put(4, Arrays.asList());
    map1.put(5, Arrays.asList());
    map1.entrySet()
        .forEach(
            p -> p.getValue().forEach(i -> nodeList.get(p.getKey()).nbrs.add(nodeList.get(i))));

    return nodeList.get(0);
  }

  // We will visit a node, mark visited immediately and add it to queue(this make sure it will visited once and enque once)
// queue store visited but not expanded node.


//  void DFS(GraphNode node, List<GraphNode> seq, Set<>) {
//
//  }

  void visitGraphDFS() {
    GraphNode root = buildGraph();
    HashSet<GraphNode> visisted = new HashSet<GraphNode>();
    Queue<GraphNode> queue = new LinkedList<GraphNode>();

    Util.show("visitGraph starts");
    visisted.add(root);
    Util.show(root.val);
    queue.add(root);

    Util.show("visitGraph ends");
  }

  void visitGraphBFS() {
    GraphNode root = buildGraph();
    HashSet<GraphNode> visisted = new HashSet<GraphNode>();
    Queue<GraphNode> queue = new LinkedList<GraphNode>();

    Util.show("visitGraph starts");
    visisted.add(root);
    Util.show(root.val);
    queue.add(root);

    while (!queue.isEmpty()) {
      GraphNode head = queue.poll();
      //BFS, you could add a node, which has not visited but in queue to be visited again.
      // to make visit only once, you have to let the queue maintain just visited nodes.
      head.nbrs.stream()
          .forEach(p -> {
            if (!visisted.contains(p)) {
              visisted.add(p);
              Util.show(p.val);
              queue.add(p);
            }
          });
    }
    Util.show("visitGraph ends");
  }


  private void map_ops() {

  }

  private void stack_ops() {

  }

  private void queue_ops() {

  }

  private void list_ops() {

    Integer[] in = new Integer[]{1, 2, 4, 6, 7, 3, 2, 2, 4};
    List<Integer> list = Arrays.asList(in);
    LinkedList<Integer> listLinked = new LinkedList(list);
    listLinked.remove(new Integer(2));

    Util.show("list_ops start");

    HashSet<Integer> set = new HashSet<>();

    Iterator<Integer> iter = listLinked.iterator();
    while (iter.hasNext()) {
      Integer val = iter.next();
      Util.show("processing:" + val);
      if (set.contains(val)) {
        iter.remove();
        Util.show("Remove " + val);
      } else {
        set.add(val);
      }
    }

    Util.show(StringUtils
                  .join(listLinked.stream().map(p -> p.toString()).collect(Collectors.toList()),
                        ","));
    Util.show("list_opsend");
  }

  void array_list_init() {
    String str = "abc";
    String[] a = {str, "S"};  // initializer, compiler allows this.
    a = new String[]{"s", "S"};  //We are good here, compiler convert it.
    // a= {"s", "S"};  //not allowed

    String[][] strs = new String[][]
        {{str, str},
         {str, str}};
    int r = strs.length;
    int c = strs[0].length;
    for (String[] row : strs) {
      for (String str1 : row) {
        Util.ref(str1);
      }
    }

    List<String> listString = new ArrayList<>(Arrays.asList(new String[]{"1", "2"}));
    Util.ref(listString);

    List<String> linkListString = new LinkedList<>(Arrays.asList(new String[]{"1", "2"}));
    Util.ref(linkListString);

    Queue<Integer> queueInt = new LinkedList<Integer>();
    queueInt.add(3);
    queueInt.add(2);
    Integer i = queueInt.peek();
    Util.assertEq(3, i);
    i = queueInt.poll();
    Util.assertEq(3, i);
    i = queueInt.poll();
    Util.assertEq(2, i);


  }


}
