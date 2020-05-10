package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class GQuestion2 extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
  }


  public String addOne(String input){
    char[] array = input.toCharArray();
    int len = array.length;
    int i = len - 1;
    while(i >= 0)
    {
      char cur = array[i];
      array[i] = nextChar(cur);
      if (cur != '9')
      break;
      i--;
    }

    // if i is < 0, then we know there is a carrier.
    return ((i<0)? "1" : "") + new String(array);

  }

  char nextChar(char digit)
  {
    int val = (int) digit;
    val = (val - (int)('0') + 1)%10;
    return (char)( val + (int)('0'));
  }

}