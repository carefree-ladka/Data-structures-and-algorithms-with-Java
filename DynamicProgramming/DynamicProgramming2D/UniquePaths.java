package DSA.DynamicProgramming.DynamicProgramming2D;

import java.util.ArrayDeque;
import java.util.Queue;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = (i == 0 || j == 0 ? 1 : dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    public static int bfs(int m, int n) {
        int[][] ways = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        ways[0][0] = 1;

        int[][] directions = {
                {0, 1}, // right
                {1, 0}  // down
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < m && nc < n) {
                    boolean firstVisit = ways[nr][nc] == 0;
                    ways[nr][nc] += ways[r][c];
                    if (firstVisit) {
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return ways[m - 1][n - 1];
    }

    public static int uniquePathsTopDown(int m, int n) {
        int[][] memo = new int[m][n];
        return dfs(m - 1, n - 1, memo);
    }

    private static int dfs(int r, int c, int[][] memo) {
        // Base case: reached top-left corner
        if (r == 0 && c == 0) return 1;

        // Out of bounds
        if (r < 0 || c < 0) return 0;

        // Already computed
        if (memo[r][c] > 0) return memo[r][c];

        // Paths = from top + from left
        memo[r][c] = dfs(r - 1, c, memo) + dfs(r, c - 1, memo);
        return memo[r][c];
    }

    public static int uniquePaths1DSpaceOptimized(int m, int n) {
        // always iterate over smaller dimension to save space
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // left + top (top is already in dp[j])
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3)); // 6
        System.out.println(uniquePaths(3, 7)); // 28
    }
}
