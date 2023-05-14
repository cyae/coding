/*
 * @lc app=leetcode.cn id=827 lang=java
 *
 * [827] 最大人工岛
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int M;
    int N;
    int[][] grid;
    int curColor;

    public int largestIsland(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;
        this.grid = grid;
        this.curColor = 1;

        int res = 0;
        HashMap<Integer, Integer> areas = new HashMap<Integer, Integer>();
        areas.put(0, 0);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ++curColor;
                    int area = getArea(i, j);
                    areas.put(curColor, area);
                    res = Math.max(res, area); // max area of a single island
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    final int x = i;
                    final int y = j;
                    Set<Integer> adjs = new HashSet<>() {
                        {
                            add(getColor(x, y - 1));
                            add(getColor(x, y + 1));
                            add(getColor(x - 1, y));
                            add(getColor(x + 1, y));
                        }
                    };
                    for (int color : adjs) {
                        area += areas.get(color);
                    }
                    res = Math.max(area, res);
                }
            }
        }

        return res;
    }

    private Integer getColor(int i, int j) {
        return i < 0 || j < 0 || i >= M || j >= N ? 0 : grid[i][j];
    }

    private Integer getArea(int i, int j) {
        if (i < 0 || j < 0 || i >= M || j >= N || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = curColor;

        return 1 + getArea(i + 1, j) + getArea(i - 1, j) + getArea(i, j + 1) + getArea(i, j - 1);
    }

}
// @lc code=end
