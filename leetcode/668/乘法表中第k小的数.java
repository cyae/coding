/*
 * @lc app=leetcode.cn id=668 lang=java
 *
 * [668] 乘法表中第k小的数
 */

// @lc code=start
class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (m > n) {
            return findKthNumber(n, m, k);
        }

        int l = 1, r = m * n;
        for (; l < r - 1;) {
            int mid = ((r - l) >> 1) + l;
            if (isValid(mid, m, n) >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return isValid(l, m, n) >= k ? l : r;
    }

    private int isValid(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += (Math.min(n, mid / i));
        }

        return count;
    }
}
// @lc code=end
