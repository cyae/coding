/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int lengthLongestPath(String input) {
        String[] files = input.split("\n");

        List<String> dirs = new ArrayList<>();
        int res = 0;
        for (String file : files) {
            int i = 0;
            while (i < file.length() && file.charAt(i) == '\t') {
                i++;
            }

            while (dirs.size() <= i) {
                dirs.add(null);
            }
            dirs.set(i, file.substring(i));

            // File contains "."ext
            if (dirs.get(i).indexOf(".") != -1) {
                int count = i;
                for (int j = 0; j <= i; j++) {
                    count += dirs.get(j).length();
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}
// @lc code=end
