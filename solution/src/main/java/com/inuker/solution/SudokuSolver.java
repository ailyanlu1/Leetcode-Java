package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/5/9.
 */

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board.length == 0) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (check(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }

            int row0 = 3 * (row / 3) + i / 3;
            int col0 = 3 * (col / 3) + i % 3;
            if (board[row0][col0] == c) {
                return false;
            }
        }
        return true;
    }
}