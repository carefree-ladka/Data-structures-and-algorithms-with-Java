package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    private record Direction(int dx, int dy, char move) {
    }

    // All possible directions
    private static final Direction[] DIRS = {
            new Direction(1, 0, 'D'), // Down
            new Direction(0, -1, 'L'), // Left
            new Direction(0, 1, 'R'), // Right
            new Direction(-1, 0, 'U') // Up
    };

    public static List<String> findPaths(int[][] maze) {
        List<String> res = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];

        if (maze[0][0] == 1) {
            backtrack(maze, 0, 0, visited, "", res);
        }

        return res;
    }

    private static void backtrack(int[][] maze, int row, int col, boolean[][] visited, String path, List<String> res) {
        int n = maze.length;

        if (row == n - 1 && col == n - 1) {
            res.add(path);
            return;
        }

        visited[row][col] = true;

        for (Direction dir : DIRS) {
            int newRow = row + dir.dx();
            int newCol = col + dir.dy();

            if (isSafe(maze, newRow, newCol, visited)) {
                backtrack(maze, newRow, newCol, visited, path + dir.move(), res);
            }
        }

        visited[row][col] = false; // backtrack
    }

    private static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
        int n = maze.length;
        return row >= 0 && col >= 0 && row < n && col < n
                       && maze[row][col] == 1 && !visited[row][col];
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(findPaths(maze)); // [DDRDRR, DRDDRR]
    }
}
