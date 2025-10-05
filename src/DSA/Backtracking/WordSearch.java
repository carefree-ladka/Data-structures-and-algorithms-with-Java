package DSA.Backtracking;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) return true; // all chars matched

        // out of bounds or mismatch
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
                    || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found = dfs(board, r + 1, c, word, idx + 1) ||
                                dfs(board, r - 1, c, word, idx + 1) ||
                                dfs(board, r, c + 1, word, idx + 1) ||
                                dfs(board, r, c - 1, word, idx + 1);

        board[r][c] = temp; // restore

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE"));    // true
        System.out.println(exist(board, "ABCB"));   // false
    }
}

