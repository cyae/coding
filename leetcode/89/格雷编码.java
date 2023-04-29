/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ (i >> 1));
        }

        return res;
    }
}
// @lc code=end
