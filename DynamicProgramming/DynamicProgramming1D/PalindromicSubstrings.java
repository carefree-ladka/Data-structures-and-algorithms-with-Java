package DSA.DynamicProgramming.DynamicProgramming1D;

public class PalindromicSubstrings {

    private static int expandAroundCorner(String s, int i, int j) {

        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;


    }

    public static int countSubstrings(String s) {
        int count = 0;
        if (s.isEmpty()) return 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCorner(s, i, i); // Even size
            count += expandAroundCorner(s, i, i + 1); // Odd size
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));// 3
        System.out.println(countSubstrings("aaa"));// 6
    }
}
