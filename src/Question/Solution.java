package Question;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new INSTRUCTIONS This is a programming test
 * To get familiarized with our coding environment, try our Sample Test
 * https://www.hackerrank.com/tests/sample You are free to choose any language from the list and
 * code If the code area contains the function signature, just complete the function alone, we'll
 * take care of the main function, headers, etc If you're expected to write the full code, it'd be
 * mentioned in the code area. All inputs are from STDIN and output to STDOUT. If you're using Java,
 * use the classname as 'Solution' To understand more about the environment, time limits, etc. you
 * can read the FAQ here You can print to console to debug your code using the appropriate print
 * command for each language (Eg: cout for C++, printf for C, etc.) It is okay to use reference
 * language documentation or use an IDE that has code completion features. However it is not
 * acceptable to consult/copy code from any source including a website, book, or friend/colleague to
 * complete these tests.
 *
 * I will not consult/copy code from any source including a website, book, or friend/colleague to
 * complete these tests, though may reference language documentation or use an IDE that has code
 * completion features.
 */

public class Solution extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151111, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java

    try {
      Solution.main(new String[]{});
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main1(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.println("how many times you want to input two ints and adds up?");
    int n = sc.nextInt();
    for (int t = 0; t < n; t++) {
      System.out.println("input a?");
      int a = sc.nextInt();

      System.out.println("input b?");
      int b = sc.nextInt();

      System.out.println(a + b);
    }
  }

  public static void main(String[] args) throws Exception {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("input size of maxtrix");
//    int size = scanner.nextInt();
//    IntStream.rangeClosed(1, size).forEach(i -> {
//      StringBuilder str = new StringBuilder();
//      IntStream.rangeClosed(1, size - i).forEach(p -> str.append(" "));
//      IntStream.rangeClosed(1, i).forEach(p -> str.append("#"));
//      System.out.println(str);
//    });

//    Map<String, String> map = new HashMap<>();
//    map.values().stream();
//    map.entrySet().stream()
//        .forEach(p -> System.out.println(p.getKey() + p.getValue()));
//    Set<Integer> set = new HashSet<>();
//    set.add(1);
//    set.stream().forEach(p -> Util.show(p.getClass().getName()));


    Util.show("begins");
    Util.show(palindrome("a"));
    Util.show(palindrome("aabaa"));

//    Util.show(palindrome("ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
//    Util.show(palindrome("aba"));
//    Util.show(palindrome("aba"));
//    Util.show(palindrome("aba"));
//    Util.show(palindrome("aba"));

    Util.show("ends");

  }


  static int palindrome(String str) {
    if (str == null)
      return 0;
    int length = str.length();
    int palindromeCount = 0;

    Set<String> checkedSubString = new HashSet<>();
    for (int i = 0; i < length; i++) {
      for (int j = i ; j < length; j++) {
        String subString = str.substring(i, j + 1);
        if (checkedSubString.contains(subString)) {
          continue;
        }
        checkedSubString.add(subString);
        if (isPalindrome(subString.toCharArray())) {
          palindromeCount++;
        }
      }
    }
    return palindromeCount;
  }

  private static boolean isPalindrome(char[] chars) {
    int length = chars.length;
    int startIdx = 0;
    while (startIdx < length / 2) {
      if (chars[startIdx] != chars[length - 1 - startIdx]) {
        return false;
      }
      startIdx++;
    }
    return true;
  }
}
