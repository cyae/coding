/*
 * @lc app=leetcode.cn id=715 lang=java
 *
 * [715] Range 模块
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class RangeModule {

    List<int[]> ranges;

    public RangeModule() {
        ranges = new ArrayList<int[]>();
    }

    public void addRange(int left, int right) {
        List<int[]> newRanges = new ArrayList<>();
        boolean inserted = false;

        for (int[] range : ranges) {
            if (range[0] > right && !inserted) {
                newRanges.add(new int[] { left, right });
                inserted = true;
            }

            if (range[1] < left || range[0] > right) {
                newRanges.add(range);
            } else {
                left = Math.min(left, range[0]);
                right = Math.max(right, range[1]);
            }
        }

        if (!inserted) {
            newRanges.add(new int[] { left, right });
        }

        ranges = newRanges;
    }

    public boolean queryRange(int left, int right) {
        int l = 0, r = ranges.size() - 1;
        for (; l <= r;) {
            int m = ((r - l) >> 1) + l;
            int[] curRange = ranges.get(m);
            if (curRange[1] < left) {
                l = m + 1;
            } else if (curRange[0] > right) {
                r = m - 1;
            } else {
                return curRange[0] <= left && curRange[1] >= right;
            }
        }

        return false;
    }

    public void removeRange(int left, int right) {
        List<int[]> newRanges = new ArrayList<>();

        for (int[] range : ranges) {
            if (range[1] <= left || range[0] >= right) {
                newRanges.add(range);
            } else {
                if (range[0] < left) {
                    newRanges.add(new int[] { range[0], left });
                }
                if (range[1] > right) {
                    newRanges.add(new int[] { right, range[1] });
                }
            }
        }

        ranges = newRanges;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
// @lc code=end
