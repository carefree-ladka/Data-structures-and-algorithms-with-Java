package DSA.Backtracking;


import java.util.*;

public class NQueens2 {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> d1 = new HashSet<>(); // row - col
        Set<Integer> d2 = new HashSet<>(); // row + col

        backtrack(res, board, 0, n, cols, d1, d2);

        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] board, int row, int n,
                                  Set<Integer> cols, Set<Integer> d1, Set<Integer> d2) {
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (char[] r : board) {
                current.add(new String(r));
            }
            res.add(current);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || d1.contains(row - col) || d2.contains(row + col)) continue;

            board[row][col] = 'Q';
            cols.add(col);
            d1.add(row - col);
            d2.add(row + col);

            backtrack(res, board, row + 1, n, cols, d1, d2);

            board[row][col] = '.';
            cols.remove(col);
            d1.remove(row - col);
            d2.remove(row + col);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> sol : solutions) {
            sol.forEach(System.out::println);
            System.out.println();
        }
        // Output: two valid solutions for 4-queens
    }
}
