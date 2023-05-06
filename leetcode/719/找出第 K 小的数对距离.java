/*
 * @lc app=leetcode.cn id=719 lang=java
 *
 * [719] 找出第 K 小的数对距离
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // BF
    public int smallestDistancePairBF(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums[nums.length - 1];
        int[] count = new int[N + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count[nums[j] - nums[i]]++;
            }
        }
        for (int i = 0; i < N; i++) {
            k -= count[i];
            if (k <= 0) {
                return i;
            }
        }

        return 0;
    }

    // DP
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        for (int r = nums[nums.length - 1] - nums[0]; l <= r;) {
            final int m = ((r - l) >> 1) + l;
            final int count = getSmallerNum(m, nums);
            if (count >= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private int getSmallerNum(int m, int[] nums) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (; j < nums.length && nums[j] - nums[i] <= m;) {
                ++j;
            }
            count += j - i - 1;
        }

        return count;
    }
}
// @lc code=end
