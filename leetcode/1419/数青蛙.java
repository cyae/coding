/*
 * @lc app=leetcode.cn id=1419 lang=java
 *
 * [1419] 数青蛙
 */

// @lc code=start
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int frog = 0;
        int res = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c' -> {
                    ++c;
                    ++frog;
                }
                case 'r' -> ++r;
                case 'o' -> ++o;
                case 'a' -> ++a;
                case 'k' -> {
                    ++k;
                    --frog;
                }
            }
            res = Math.max(frog, res);
            if (c < r || r < o || o < a || a < k) { // sequential
                return -1;
            }
        }

        return c != r || r != o || o != a || a != k ? -1 : res;
    }
}
// @lc code=end
