package DSA.Stack;

import module java.base;

public class BasicCalculatorII {

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (i == s.length() - 1 || (!Character.isDigit(ch) && ch != ' ')) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                    default -> throw new IllegalArgumentException("Illegal operator");
                }

                sign = ch;
                num = 0;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }

    void main() {
        IO.println(calculate("3+2*2")); // 7
        IO.println(calculate(" 3/2 ")); // 1
        IO.println(calculate(" 3+5 / 2 ")); // 5
    }
}
