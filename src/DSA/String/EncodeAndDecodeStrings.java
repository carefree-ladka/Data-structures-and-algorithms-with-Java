package DSA.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EncodeAndDecodeStrings {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            String word = s.substring(j + 1, j + 1 + length);
            result.add(word);
            i = j + 1 + length;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("lint", "code", "love", "you");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded); //  4#lint4#code4#love3#you
        System.out.println("Decoded: " + decode(encoded)); // [lint, code, love, you]
    }
}
