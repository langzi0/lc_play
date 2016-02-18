package languageTip;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Created by @author  @since 9/20/15.
 */
public class ReadWriteSample extends InvokableBase {

  public static void main(String[] args) {

    // 1. using InputStreamReader, The wrapping code is hard to remember.
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter your name: ");

      String name = reader.readLine();
      System.out.println("Your name is: " + name);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // 2. using Scanner
    // System.in is an InputStream
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your nationality: ");
    String nationality = scanner.nextLine();  // nextFloat
    System.out.println("Your nationality is: " + nationality);

    System.out.print("Enter int: ");
    int y = scanner.nextInt();
    System.out.print("Enter double: ");
    double x = scanner.nextDouble();

    System.out.println(String.format("Your nationality is%d %f  ", y, x));

    /*
    3. Using Console class
    // using Console, will not working in IDE
    * */

    Console console = System.console();
    if (console == null) {
      System.out.println("No console: not in interactive mode!");
      System.exit(0);
    }

    System.out.print("Enter your username: ");
    String username = console.readLine();

    System.out.print("Enter your password: ");
    char[] password = console.readPassword();

    System.out.println("Thank you!");
    System.out.println("Your username is: " + username);
    System.out.println("Your password is: " + String.valueOf(password));

    // using Console with formatted prompt
    String job = console.readLine("Enter your job: ");

    String passport = console.readLine("Enter your %d (th) passport number: ", 2);

    System.out.println("Your job is: " + job);
    System.out.println("Your passport number is: " + passport);


  }

  void readAnArray(){

    int[] arrayOfInts = {1, 2, 3};
    Scanner s = new Scanner(Arrays.toString(arrayOfInts));

    while (s.hasNext()) {
      System.out.println(s.next());
    }

    System.out.println("input [1,2,3]: ");
    Scanner arrayScanner = new Scanner(Arrays.toString(arrayOfInts));
    String arrayString = arrayScanner.nextLine();  // nextFloat


  }

  @Override
  public Priority getRunPriority() {
    return new Priority(151122, 0, Category.LeetCode);
  }
  @Override
  public void run() {
    ReadWriteSample.main(null);
    new ReadWriteSample().readAnArray();
  }
}