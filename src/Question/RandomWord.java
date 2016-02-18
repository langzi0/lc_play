package Question;

import java.util.Random;
import java.util.stream.IntStream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/19/15
 */
public class RandomWord extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151019, 01, Category.LeetCode);
  }

  //Starting: 13:15
  @Override
  public void run() {

    int[][] matrix = GetProbMatrix();
    String randWord;
    randWord = GenerateWord(matrix);
    System.out.println(randWord);
    randWord = GenerateWord(matrix);
    System.out.println(randWord);
    randWord = GenerateWord(matrix);
    System.out.println(randWord);
    randWord = GenerateWord(matrix);
    System.out.println(randWord);
    randWord = GenerateWord(matrix);
    System.out.println(randWord);

  }

  final int NUM = 26 + 1;

  int[][] GetProbMatrix() {
    // null, 'a' to 'z'
    int[][] freq = new int[NUM][NUM];
    Random random = new Random();
    IntStream.range(0, NUM).forEach(i -> {
      IntStream.range(0, NUM).forEach(j -> {
        if (j == 0) {
          if (i!=0)
              freq[i][j] = random.nextInt(10000);
        } //  else if (j == NUM -1){}
        else {
          freq[i][j] = freq[i][j-1] + new Random().nextInt(10000);
        }
      });
    });

    return freq;
  }

  String GenerateWord(int[][] prob) {
    StringBuilder sb = new StringBuilder();

    int idx = GetNextChar(prob, 0, prob[0][NUM - 1]);
    while (true) {
      if (idx == NUM -1) {
        break;
      }
      sb.append((char)('a' + idx));
      idx = GetNextChar(prob, idx, prob[idx][NUM - 1]);
    }
    return sb.toString();
  }

  private int GetNextChar(int[][] prob, int row, int v) {
    int rand = new Random().nextInt(v);
    for(int i=0; i<NUM; i++){
      if (rand < prob[row][i])
        return i;
    }

    Random random = new Random();
    random.nextInt(100);
    return -1;
  }


}
