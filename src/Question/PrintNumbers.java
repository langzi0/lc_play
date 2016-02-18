package Question;

import java.util.stream.IntStream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 */
public class PrintNumbers extends InvokableBase {

  // The problem is to print the numbers 1 to 100, but for every number divisible by 3 print "FIZZ",
  // for every number divisible by 5 print "BUZZ" and for every number divisible by both 3 and 5 print "FIZZBUZZ".
  static void printNumber() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
      if (i%15 == 0)
        System.out.println("FIZZBUZZ");
      else if (i%3 == 0)
        System.out.println("FIZZ");
      else if (i%5 ==0 )
        System.out.println("BUZZ");
    });
  }

  public static void main(String[] args) {
    for (int index = 1; index <= 100; index++) {
      if ((index % 3 == 0) && (index % 5 == 0)) {
        System.out.println("FIZZBUZZ");
      } else if (index % 3 == 0) {
        System.out.println("FIZZ");
      } else if (index % 5 == 0) {
        System.out.println("BUZZ");
      } else {
        System.out.println(index);
      }
    }
  }

  //
//    1
//        2
//    FIZZ
//    4
//    BUZZ
//        FIZZ
//    7
// Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151028, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    new PrintNumbers().printNumber();
  }

}
