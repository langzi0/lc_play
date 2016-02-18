package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class CombinationOfCoins extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(151215, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.
    printCombination(100);
  }
/*给1， 2， 5面值的纸币，有多少种组合凑
出100 块钱。
*/

  void printCombination(int input)
  {
    int[] coins = new int[]{1,2,5};

    int[] cnts = new int[coins.length];
    select(coins, cnts, 0, input);
  }

  void select(int[] coins, int[] cnts, int cur, int left)
  {
    if (left == 0)
    {
      for(int j= cur; j< cnts.length; j++)
        cnts[j] = 0;
      output(coins, cnts);
      return;
    }

    if (cur == cnts.length)
      return;

    for(int i = 0; i<= left/coins[cur]; i++)
    {
      cnts[cur] = i;
      select(coins, cnts, cur + 1, left - i * coins[cur]);
    }
  }

  private void output(int[] coins, int[] cnts) {
    System.out.println(String.format("%d * %d + %d * %d + %d * %d", coins[0],
                                     cnts[0], coins[1], cnts[1], coins[2], cnts[2]  ));
  }

}
