/*
 * @lc app=leetcode.cn id=89 lang=javascript
 *
 * [89] 格雷编码
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function (n) {
  if (n == 0) {
    return [0];
  }
  if (n == 1) {
    return [0, 1];
  }

  let res = [0, 1];
  for (let i = 1; i < n; i++) {
    let temp = [...res];
    let reverse = res.reverse();
    reverse = reverse.map(el => el + (1 << i));
    res = [...temp, ...reverse];
  }

  return res;
};
// @lc code=end
