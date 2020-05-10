package CodePad;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once.
 *
 * For example, Given board =
 *
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

public class WordSearch_ex_x extends InvokableBase {

  @Override
  public Priority getRunPriority() {
    return new Priority(/*yymdd*/160131, 2, Category.LeetCode);
  }

  @Override
  public void run() {

    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    Util.assertEq(true, findWord(board, "ABCCED"));
    Util.assertEq(true, findWord(board, "SEE"));
    Util.assertEq(false, findWord(board, "ABCB"));
  }

  boolean findWord(char[][] board, String word) {
    boolean[][] selected = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (search(board, selected, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean search(char[][] board, boolean[][] selected, int i, int j, String word, int cur) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || selected[i][j]) {
      return false;
    }
    if (board[i][j] != word.charAt(cur)) {
      return false;
    }

    selected[i][j] = true;
    if (cur == word.length() - 1) {
      return true;
    }
    boolean ret
        = search(board, selected, i - 1, j, word, cur + 1) ||
          search(board, selected, i + 1, j, word, cur + 1) ||
          search(board, selected, i , j-1, word, cur + 1) ||
          search(board, selected, i , j+1, word, cur + 1);
    if (ret) {
      return true;
    }
    selected[i][j] = false;
    return false;
  }
}