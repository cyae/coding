/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private class Info {
        TreeNode node;
        int id;
        int level;

        public Info(TreeNode node, int id, int level) {
            this.node = node;
            this.id = id;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Deque<Info> queue = new LinkedList<>();
        queue.offer(new Info(root, 1, 0));
        int prevId = 1;
        int prevLevel = 0;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int curLevel = info.level;
            int curId = info.id;

            if (curLevel > prevLevel) {
                prevLevel = curLevel;
                prevId = curId;
            }
            res = Math.max(res, curId - prevId + 1);

            TreeNode curNode = info.node;
            if (curNode.left != null) {
                queue.offer(new Info(curNode.left, curId << 1, curLevel + 1));
            }
            if (curNode.right != null) {
                queue.offer(new Info(curNode.right, (curId << 1) + 1, curLevel + 1));
            }
        }

        return res;
    }
}
// @lc code=end
