/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 统计各位数字都不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int len = 1; len <= n; len++) {
            res += A(10, len) - A(9, len - 1);
        }

        return res;
    }

    private int A(int m, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (m - i);
        }

        return res;
    }
}
// @lc code=end
