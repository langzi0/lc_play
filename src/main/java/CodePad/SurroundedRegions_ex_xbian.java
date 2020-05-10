
package CodePad;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 *
 * For example,
 *
 * X X X X X O O X X X O X X O X X After running your function, the board should be:
 *
 * X X X X X X X X X X X X X O X X
 */

public class SurroundedRegions_ex_xbian extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/151016, 0, Category.LeetCode);
  }


  @Override
  public void run() {

    String[] as = new String[]{"000000" };
    char[][] a = input(as);

    output(a);

    solve(a);
    System.out.println("");
    output(a);
  }

  char[][] input(String[] as)
  {
    char[][] a = new char[as.length][as[0].length()];
    System.out.println(String.format("size %d, %d ", as.length, as[0].length()));
    IntStream.
        range(0, as.length)
        .forEach(i -> {
          IntStream.range(0, as[0].length())
              .forEach(
                  j -> {
                    a[i][j] = as[i].charAt(j);
                  }

              );
        });
    return a;
  }

  void output(char[][] a) {

    IntStream.range(0, a.length)
        .forEach(i -> {
                   IntStream.range(0, a[0].length).forEach(j -> {
                     System.out.print(a[i][j]);
                   });
                   System.out.println("");
                 }
        );
  }


  char[][] b;
  int c, r;

  public void solve(char[][] board) {
    // finding all areas connected to a edge.
    r = board.length;
    if (r < 1) {
      return;
    }
    c = board[0].length;
    if (c < 1) {
      return;
    }
    b = board;

    // Process rows
    // mark good Os as Y,
    for (int j = 0; j < c; j++) {
      process(0, j);
      process(r - 1, j);
    }

    //process cols
    for (int i = 0; i < r; i++) {
      process(i, 0);
      process(i, c - 1);
    }

    //Mark NonY to X,
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        //Mark NonY to X,
        if (b[i][j] != 'Y') {
          b[i][j] = 'X';
        }
        // Mark Y back to O,
        if (b[i][j] == 'Y') {
          b[i][j] = 'O';
        }
      }
    }

  }

  void process(int i, int j) {
    processWithQueue(i, j);
  }

  void process_recursive(int i, int j) {
    if (!(i >= 0 && i < r && j >= 0 && j < c)) {
      return;
    }
    if (b[i][j] == 'Y' || b[i][j] == 'X') {
      return;
    }
    b[i][j] = 'Y';
    process(i - 1, j);
    process(i + 1, j);
    process(i, j - 1);
    process(i, j + 1);
  }


  class Pos {

    public int r;
    public int c;

    Pos(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public void processWithQueue(int i, int j) {
    // LinkedList -> Queue
    if (b[i][j] == 'Y' || b[i][j] == 'X') {
      return;
    }
    Queue<Pos> q = new LinkedList<>();
    q.add(new Pos(i, j));
    while (!q.isEmpty()) {
      Pos p = q.remove();
      b[p.r][p.c] = 'Y';
      add(q, p.r + 1, p.c);
      add(q, p.r - 1, p.c);
      add(q, p.r, p.c - 1);
      add(q, p.r, p.c + 1);
    }
  }

  private void add(Queue<Pos> q, int i, int j) {
    if (!(i >= 0 && i < r && j >= 0 && j < c)) {
      return;
    }
    if (b[i][j] == 'Y' || b[i][j] == 'X') {
      return;
    }
    q.add(new Pos(i, j));
  }
}