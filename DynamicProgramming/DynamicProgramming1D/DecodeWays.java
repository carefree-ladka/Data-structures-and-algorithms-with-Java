package DSA.DynamicProgramming.DynamicProgramming1D;

public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int next = 1;  // ways to decode from i+1
        int nextNext = 0; // ways to decode from i+2

        for (int i = n - 1; i >= 0; i--) {
            int ways = s.charAt(i) == '0' ? 0 : next;

            if (i + 1 < n && (s.charAt(i) == '1' ||
                    (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                ways += nextNext;
            }

            nextNext = next;
            next = ways;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("12"));  // 2
        System.out.println(numDecodings("06"));  // 0
    }
}
