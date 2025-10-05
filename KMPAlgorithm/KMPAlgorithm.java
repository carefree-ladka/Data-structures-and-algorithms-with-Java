package DSA.KMPAlgorithm;

public class KMPAlgorithm {

    // Preprocess the pattern to create LPS array
    private static int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fall back in the pattern
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP search function
    public static void KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1]; // continue searching for next match
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";

        KMPSearch(pat, txt); // 10
    }
}
