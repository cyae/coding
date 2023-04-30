/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        if (n == 2) {
            return Arrays.asList(0, 1);
        }

        int[] degrees = new int[n];
        HashMap<Integer, List<Integer>> adjs = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            degrees[from]++;
            degrees[to]++;
            adjs.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            adjs.computeIfAbsent(to, Key -> new ArrayList<>()).add(from);
        }

        // Topological sort
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
            }
        }

        int[] vis = new int[n];
        for (int count = 0; !queue.isEmpty() && count != n - 1 && count != n - 2;) {
            // get every outmost node, and push its adj into the queue
            for (int size = queue.size(); size > 0; size--) {
                int outmost = queue.poll();
                count++;
                vis[outmost] = 1;
                for (int adj : adjs.getOrDefault(outmost, new ArrayList<>())) {
                    degrees[adj]--;
                    if (degrees[adj] == 1) {
                        queue.offer(adj);
                    }
                }
            }
            if (count == n - 1 || count == n - 2) {
                break;
            }
        }

        LinkedList<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
// @lc code=end
