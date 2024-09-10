package com.problems.mid;

public class IsInterleave {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    // f(s1) + f(s2) = f(s3)

    // f(i,j)表示s1的前i个元素和s2的前j个元素能否组测s3的前（i+j）个元素，

    // 如果此时s1的第i个元素等于s3的第i+j个元素，此时f(i,j)取决

    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
        f[0][0] = true;
        for (int l1 = 0; l1 < s1.length(); ++l1) {
            for (int l2 = 0; l2 < s2.length(); ++l2) {
                if (l1 > 0) {
                    f[l1][l2] = s1.charAt(l1 - 1) == s3.charAt(l1 + l2 - 1) && f[l1 - 1][l2];
                }
                if (l2 > 0) {
                    f[l1][l2] = s2.charAt(l2 - 1) == s3.charAt(l1 + l2 - 1) && f[l1][l2 - 1];
                }
            }
        }

        return f[s1.length()][s2.length()];

    }
}
