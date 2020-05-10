package languageTip;

import java.lang.reflect.Method;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Created by @author  @since 9/20/15.
 */
public class ReflectionSample extends InvokableBase {

  public static void main(String args[]) {
    try {
      Class c = Class.forName("java.sql.Connection");
      Method m[] = c.getDeclaredMethods();
      for (int i = 0; i < 3; i++) {
        System.out.println(String.format("m[%d]= %s", i, m[i].toString()));
      }
    } catch (Throwable e) {
      System.err.println(e);
    }
  }


  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    ReflectionSample.main(null);
  }
}