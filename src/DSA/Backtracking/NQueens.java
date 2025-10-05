package DSA.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n]; // row - col + n
        boolean[] d2 = new boolean[2 * n]; // row + col

        backtrack(res, board, 0, n, cols, d1, d2);
        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] board, int row, int n,
                                  boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (char[] r : board) {
                current.add(new String(r));
            }
            res.add(current);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols[col] || d1[row - col + n] || d2[row + col]) continue;

            board[row][col] = 'Q';
            cols[col] = true;
            d1[row - col + n] = true;
            d2[row + col] = true;

            backtrack(res, board, row + 1, n, cols, d1, d2);

            board[row][col] = '.';
            cols[col] = false;
            d1[row - col + n] = false;
            d2[row + col] = false;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> sol : solutions) {
            sol.forEach(System.out::println);
            System.out.println();
        }
    }
}
