package DSA.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParentheses {

    private record Pair(int left, int right, String str) {
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Deque<Pair> stack = new ArrayDeque<>(List.of(new Pair(0, 0, "")));

        while (!stack.isEmpty()) {
            Pair state = stack.pop();

            if (state.str().length() == 2 * n) {
                res.add(state.str());
                continue;
            }

            if (state.left() < n) {
                stack.push(new Pair(state.left() + 1, state.right(), state.str() + "("));
            }

            if (state.right() < state.left()) {
                stack.push(new Pair(state.left(), state.right() + 1, state.str() + ")"));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3)); // [()()(), ()(()), (())(), (()()), ((()))]
    }
}

