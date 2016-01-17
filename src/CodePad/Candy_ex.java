package CodePad;

import java.util.ArrayList;
import java.util.Arrays;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * There are N children standing in a line. Each child is assigned a rating value. You are giving
 * candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy. Children with a higher rating get more candies than
 * their neighbors. 1.5, 1.7 1.89384 1.9, 0.001,  local min should get one candies. find in
 * betweens, then assign higher
 *
 *
 * What is the minimum candies you must give?
 */

public class Candy_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151212, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    Util.assertEq("", 1, getNumOfCandies(new double[]{0}));
    Util.assertEq("", 3, getNumOfCandies(new double[]{1,2}));
    Util.assertEq("", 3, getNumOfCandies(new double[]{2,1}));
    Util.assertEq("", 5, getNumOfCandies(new double[]{1,0,1}));
    Util.assertEq("", 7, getNumOfCandies(new double[]{1,1,0,1}));
    Util.assertEq("", 3, getNumOfCandies(new double[]{1,1,1}));
  }

  class Rate {

    public int count;
    public int numOfCandies;
    public double rating;

    Rate(double rating, int count, int numOfCandies) {
      this.count = count;
      this.numOfCandies = numOfCandies;
      this.rating = rating;
    }
  }

  Rate[] UniqueRatings(double[] ratings) {
    ArrayList<Rate> rateList = new ArrayList<>(ratings.length);

    rateList.add(new Rate(ratings[0], 1, 0));
    int i = 1;
    while (i < ratings.length) {
      if (ratings[i] == ratings[i - 1]) {
        Rate rate = rateList.get(rateList.size() - 1);
        rate.count++;
      } else {
        rateList.add(new Rate(ratings[i], 1, 0));
      }
      i++;
    }

    Rate[] rates = new Rate[rateList.size()];
    rateList.toArray(rates);
    return rates;
  }

  Integer getNumOfCandies(double[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    Rate[] rates = UniqueRatings(ratings);
    if (rates.length == 1) {
      rates[0].numOfCandies = 1;
    }
    if (rates.length > 1) {
      for (int i = 0; i < rates.length; i++) {
        if (i == 0) {
          if (rates[i].rating < rates[i + 1].rating) {
            int seed = i + 1;
            rates[i].numOfCandies = 1;
            while (seed < rates.length && rates[seed - 1].rating < rates[seed].rating ) {
              rates[seed].numOfCandies = rates[seed - 1].numOfCandies + 1;
              seed ++;
            }
          }
        } else if (i == rates.length - 1) {
          if (rates[i - 1].rating > rates[i].rating) {
            rates[i].numOfCandies = 1;
            int seed = i - 1;
            while (seed >= 0 && rates[seed].rating > rates[seed + 1].rating) {
              rates[seed].numOfCandies =
                  Math.max(rates[seed].numOfCandies, rates[seed + 1].numOfCandies + 1);
              seed --;
            }

          }
        } else {
          if (rates[i].rating < rates[i + 1].rating && rates[i - 1].rating > rates[i].rating) {
            int seed = i + 1;
            rates[i].numOfCandies = 1;
            while (seed < rates.length && rates[seed - 1].rating < rates[seed].rating ) {
              rates[seed].numOfCandies = rates[seed - 1].numOfCandies + 1;
              seed++;
            }
            seed = i - 1;
            while (seed >= 0 && rates[seed].rating > rates[seed + 1].rating ) {
              rates[seed].numOfCandies =
                  Math.max(rates[seed].numOfCandies, rates[seed + 1].numOfCandies + 1);
              seed --;
            }

          }
        }
      }
    }
    return Arrays.stream(rates).map(r -> (r.numOfCandies * r.count)).mapToInt(
        Integer::intValue).sum();

  }
}