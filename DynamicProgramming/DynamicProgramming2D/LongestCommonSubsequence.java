package DSA.DynamicProgramming.DynamicProgramming2D;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private static int dfs(String text1, String text2, int[][] memo, int i, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dfs(text1, text2, memo, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(
                    dfs(text1, text2, memo, i + 1, j),
                    dfs(text1, text2, memo, i, j + 1));
        }
        return memo[i][j];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] memo = new int[n1 + 1][n2 + 1];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dfs(text1, text2, memo, 0, 0);
    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "abc";
        System.out.println(longestCommonSubsequence(text1, text2)); // 3
    }
}
