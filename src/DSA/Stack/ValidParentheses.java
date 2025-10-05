package DSA.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) { // Opening bracket
                stack.push(c);
            } else if (map.containsKey(c)) { // Closing bracket
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // If string has invalid characters
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));      // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));      // false
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}"));    // true
    }
}

