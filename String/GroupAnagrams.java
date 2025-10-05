package DSA.String;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] counter = new int[26];
            for (char c : word.toCharArray()) {
                counter[c - 'a']++;
            }

            String key = Arrays.toString(counter);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs)); // [[eat, tea, ate], [bat], [tan, nat]]
    }
}
