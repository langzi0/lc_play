package Lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * Created by @author  @since 8/10/15.
 */
public class JavaLang extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(151029, 01, Category.notClassified);
  }

  public void run() {

    run_lamdaAsFunction();
    method_parameter_modifiation();
    run_lamdaAsStream();
    run_interface_anonymous_class();
  }

// 111111111111111111111111111111111111111111111111111111
  // Anonymous class
  class ProgrammerInterview  {
    public void read() {
      System.out.println("Programmer Interview!");
    }
  }

  class Website {
    /*  This creates an anonymous inner class: new inner class return */

    ProgrammerInterview pInstanceOfInnerclass = new ProgrammerInterview() {
      public void read() {
        System.out.println("anonymous ProgrammerInterview");
      }
    };
    ProgrammerInterview pInstanceOfProgrammerInterview = new ProgrammerInterview();
    }

// 22222222222222222222222222222222222222222222222222222222222222222222

  // Anonymous interface
  interface Handler<E> {

    // Foo() is the name of the inner class converted to
    void handle(E e);
  }

  // new Anoymouse class object Sytax:
  // new operator;
  // the name of an interface to implement(Handler or a class to extend
  // () : for interface no constructor parameter, but for class to extend, you can put paraemeters
  // body, same as a class declaration body, but extends the interface/class name.
  // ; // end of instances which is should be assigned to a variable.

  private void run_interface_anonymous_class() {

    // This is to create an interface referring to
    // anonymous inner class without a name.
    // An anonymous class is defined and instantiated in a single succinct expression using the new operator.

    // this content inside{} is anonymous innerclass's instance and handed to Handler interface.

    //  http://www.programmerinterview.com/index.php/java-questions/java-anonymous-class-example/
    // new Foo(){ void someMethod()}

    // { void someMethod()} is the inner anonymous class.

    Handler<Integer> handler = x -> {
      String i = "0";
      System.out.print(i);
    };

// pass in the variable into the anonymous class.
//    int myVariable = 1;
//
//    handler = new Handler<Integer>() {
//      private int anonVar;
//      public void handle(Integer e) {
//        // How would one access myVariable here?
//        // It's now here:
//        System.out.println("Initialized with value: " + e.toString());
//      }
//      private Handler init(int var){
//        anonVar = var;
//        return this;
//      }
//    }.init(myVariable)  );
    Util.ref(handler);
  }


//

  class MyClass {
    public int val;
  }

  void checkVar(Integer xi, int[] ar/* will change value in caler */,
                MyClass myObject/* will change value in caler */) {
    // All the raw type wrapped
    // Integer type is immutable,  which is like String, so xi will only pass a value into the method
    xi = 1;

    // this will be passed back as the address of ar is passed, still changing the old address pointed content.
    ar[0] = 1;
    myObject.val = 1;
  }

  void method_parameter_modifiation() {

    // all primitive  boxer are immutable.
    Integer xi = 1;

    // iArray.length is the final int
    int[] iArray = new int[]{1};

    MyClass myObject = new MyClass();

    checkVar(xi, iArray, myObject);

    Util.assertEq("Integer xi  not modified", 1, xi);
    Util.assertEq("int array elements  modified", 1, iArray[0]);
    Util.assertEq("myObject", 1, myObject.val);

  }

  void run_lamdaAsFunction() {
    //Before Java 8:
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Before Java8, too much code for too little to do");
      }
    }).start();

    //Java 8 way:
    new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

    // Read more:http:
    //javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3mKi4BiYI
  }

  void run_lamdaEventHandling() {

    //Prior Java 8 :
    List features0 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    for (Object feature : features0) {
      System.out.println((String) feature);
    }

//In Java 8:
    List features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    features1.forEach(n -> System.out.println(n));

// Even better use Method reference feature of Java 8
// method reference is denoted by :: (double colon) operator
// looks similar to score resolution operator of C++
    features1.forEach(System.out::println);

  }

  void run_lamdaAsStream() {
    List<Foo> fooList = new ArrayList<>();
    fooList.add(new Foo(1, "n1"));
    fooList.add(new Foo(2, "n2"));
    fooList.remove(0);
    int x = fooList.size();
    fooList.toArray();

    for (Foo foo : fooList) {

    }

    Stream<Foo> stream = fooList.stream();
    //Stream<Person> parallelStream = persons.parallelStream();
    Stream<Foo> filterSterm = stream.filter(p -> p.value > 1);
    filterSterm.forEach(p -> System.out.println(p.name));

    //Typical filter , map, forEach do action

    stream.filter(p -> p.value == 2)
        .map(p -> new Bar(p.value * p.value))
        .forEach(bar -> System.out.println("bar is" + bar.bar));
  }

  class Foo {

    public Foo(int v, String n) {
      value = v;
      name = n;
    }

    int value = 0;
    String name = "me";
  }

  class Bar {

    public int bar;

    public Bar(int bar) {
      this.bar = bar;
    }
  }
}
