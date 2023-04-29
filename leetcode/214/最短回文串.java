/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start

class Solution {
    public String shortestPalindrome(String t) {
        if (t.equals("")) {
            return "";
        }

        char[] p = t.toCharArray();
        char[] s = new StringBuilder(t).reverse().toString().toCharArray();
        int[] suffixArr = getSuffixArr(p);

        int j = 0;
        for (int i = 0; i < s.length && j < p.length;) {
            if (s[i] == p[j]) {
                ++i;
                ++j;
            } else if (j > 0) {
                j = suffixArr[j];
            } else {
                ++i;
            }
        }

        String suffixNonPalin = t.substring(j);

        return new StringBuilder(suffixNonPalin).reverse().toString() + t;
    }

    private int[] getSuffixArr(char[] p) {
        int[] suffixArr = new int[p.length];
        suffixArr[0] = -1;
        for (int i = 2, pre = 0; i < p.length;) {
            if (p[pre] == p[i - 1]) {
                suffixArr[i++] = ++pre;
            } else if (pre > 0) {
                pre = suffixArr[pre];
            } else {
                ++i;
            }
        }

        return suffixArr;
    }
}
// @lc code=end
