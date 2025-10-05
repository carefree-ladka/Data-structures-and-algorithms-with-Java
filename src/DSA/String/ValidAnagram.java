package DSA.String;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s1, s2));
    }

    public boolean isAnagram(String s, String t) {
        final char A = 'a';
        if (s.length() != t.length())
            return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - A]++;
            counter[t.charAt(i) - A]--;
        }

        return Arrays.stream(counter).allMatch((i) -> counter[i] == 0);
    }
}
