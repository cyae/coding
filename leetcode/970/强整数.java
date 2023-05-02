/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (int a = 1; a <= bound; a *= x) {
            for (int b = 1; b <= bound; b *= y) {
                if (a + b <= bound) {
                    set.add(a + b);
                } else {
                    break;
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }

        res.addAll(set);
        return res;
    }
}
// @lc code=end
