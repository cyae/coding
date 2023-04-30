/*
 * @lc app=leetcode.cn id=664 lang=java
 *
 * [664] 奇怪的打印机
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int strangePrinter(String s) {
        final int n = s.length();

        // 区间DP, 考虑枚举区间和分割点
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); // 求min
        }
        // 单个字母需要打印一次
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) { // 枚举区间
            for (int st = 0; st + len - 1 < n; st++) {
                int ed = st + len - 1;
                dp[st][ed] = 1 + dp[st + 1][ed]; // edge case 1: k == st
                for (int k = st + 1; k < ed; k++) { // 枚举分割点
                    if (s.charAt(k) == s.charAt(st)) {
                        dp[st][ed] = Math.min(dp[st][ed], dp[st][k - 1] + dp[k + 1][ed]);
                    }
                }
                if (s.charAt(st) == s.charAt(ed)) { // edge case 2: k == ed
                    dp[st][ed] = Math.min(dp[st][ed], dp[st][ed - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
