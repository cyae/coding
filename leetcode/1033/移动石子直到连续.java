/*
 * @lc app=leetcode.cn id=1033 lang=java
 *
 * [1033] 移动石子直到连续
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = new int[] { a, b, c };
        Arrays.sort(stones);

        final int maxMoves = stones[2] - stones[0] - 2;
        if (maxMoves == 0) {
            return new int[] { 0, 0 };
        }
        final int minMoves = Math.min(stones[2] - stones[1], stones[1] - stones[0]) <= 2 ? 1 : 2;
        return new int[] { minMoves, maxMoves };
    }
}
// @lc code=end
