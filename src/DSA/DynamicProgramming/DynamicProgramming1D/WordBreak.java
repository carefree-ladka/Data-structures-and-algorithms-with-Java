package DSA.DynamicProgramming.DynamicProgramming1D;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string is always breakable

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further for this i
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
    }
}
