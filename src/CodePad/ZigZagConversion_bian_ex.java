package CodePad;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N A P L S I I G Y   I   R        And then read line by line: "PAHNAPLSIIGYIR" Write
 * the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should return
 * "PAHNAPLSIIGYIR".
 */

public class ZigZagConversion_bian_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151114, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    String out = getZigZag("PAYPALISHIRING", 3);
      System.out.println(out);
    Util.assertEq("PAHNAPLSIIGYIR", out);

    testHint();
  }

  private String getZigZag(String text, int n) {
    StringBuilder[] lines = new StringBuilder[n];
    for(int i =0; i< lines.length ;i++) lines[i] = new StringBuilder();
    int i = 0;
    for (Character ch : text.toCharArray()) {
      int cat = i % (2 * n -2);
      if (cat <= n-1)
        lines[cat].append(ch);
      else
        lines[2 * n -2 -cat].append(ch);
      i++;
    }
    return StringUtils
        .join(Arrays.asList(lines)
                  .stream()
                  .map(p -> p.toString()).collect(
                Collectors.toList()), "");
  }
  private void testHint(){
   System.out.println(getHint("1807",
                            "7810"));
  }


  public String getHint(String secret, String guess) {
    //
    char[] sArray= secret.toCharArray();
    char[] gArray= guess.toCharArray();


    int countSecret[] = new int[10];
    int countGuess[] = new int[10];
    int bull = 0;
    for(int i=0; i< sArray.length; i++)
    {
      int sx = (int) sArray[i] - (int) '0';
      countSecret[sx] ++ ;

      int gx = (int) gArray[i] - (int) '0';
      countGuess[gx] ++ ;

      if (sx == gx)
        bull ++;
    }
    int cow = -bull;
    for (int i=0; i< 10; i++)
    {
      cow += Math.min(countSecret[i], countGuess[i]);
    }
    return Integer.toString(bull)+"A"+Integer.toString(cow)+"B";
  }

}