/*
 * @lc app=leetcode.cn id=2423 lang=java
 *
 * [2423] 删除字符使频率相同
 */

// @lc code=start
class Solution {
    public boolean equalFrequency(String word) {
        int[] freqs = new int['z' + 1];
        for (char ch : word.toCharArray()) {
            freqs[ch]++;
        }
        for (char ch : word.toCharArray()) {
            freqs[ch]--;
            if (isValid(freqs)) {
                return true;
            }
            freqs[ch]++;
        }

        return false;
    }

    private boolean isValid(int[] freqs) {
        int flag = -1;
        for (int freq : freqs) {
            if (freq != 0 && freq != flag) {
                if (flag == -1) {
                    flag = freq;
                    continue;
                }
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
