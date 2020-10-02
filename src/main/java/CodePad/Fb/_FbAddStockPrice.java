package CodePad.Fb;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

public class _FbAddStockPrice extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/201001, 2, Category.LeetCode);
  }


  @Override
  public void run() {
    productExceptSelfHelper(1, 2 ,3 ,4);
    productExceptSelfHelper(1, 2 );
    productExceptSelfHelper(1, 2, 3 );

    maxProfit(new int[]{7,1,5,3,6,4});

  }


  /*
   * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Note that you cannot sell a stock before you buy one.

 Example 1:

 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
              Not 7-1 = 6, as selling price needs to be larger than buying price.
 Example 2:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
   * */
  public int maxProfit(int[] prices) {

    int profit = 0;
    if (prices != null && prices.length >=2){


      int lowsofar = prices[0];

      for(int i = 1; i< prices.length; i++){

        if (prices[i-1] < prices[i]) {
          if (prices[i] - lowsofar > profit)
            profit = prices[i] - lowsofar;
        }else {
          if (prices[i] < lowsofar) {
            lowsofar = prices[i];
          }
        }

      }
    }

    return profit;
  }

  private int[] productExceptSelfHelper(int ... ints){
    return productExceptSelf(ints);
  }


  /*
  Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
  Example:
  Input:  [1,2,3,4]
  Output: [24,12,8,6]
  Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

  Note: Please solve it without division and in O(n).

  Follow up:
  Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
  you can initialize an output array, then prefix list firststored there.  Then you can still calculate the suffice on the fly. and times it in to suffix product temp variable.
  * */
  public int[] productExceptSelf(int[] nums) {

    // using the prefix and suffix:
    // prefix[0--n-1]
    // suffix[0--n-1]

    int[] output = new int[nums.length];
    output[nums.length - 1] = nums[nums.length -1];
    for(int i = nums.length -2; i >= 0; i--){
      output[i] = output[i + 1] * nums[i];
    }
    int prefix = nums[0];
    output[0] = output[1];
    // nums:    1  2  3  4
    // outputs: 24 24 12  4
    for(int i = 1; i <= nums.length - 2; i++){
       output[i] = prefix * output[i + 1];
       prefix *= nums[i];
    }
    output[nums.length - 1] = prefix;
    return output;
  }
}
