package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(int n, int open, int close, StringBuilder current, List<String> res) {
        if (current.length() == 2 * n) {
            res.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(n, open + 1, close, current, res);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (close < open) {
            current.append(')');
            backtrack(n, open, close + 1, current, res);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n)); //  [((())), (()()), (())(), ()(()), ()()()]
    }
}
