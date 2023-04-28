/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0)) {
            sb.append("-");
        }

        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);

        sb.append(divisor / dividend);
        divisor %= dividend;
        if (divisor == 0) {
            return sb.toString();
        }

        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (divisor != 0) {
            if (map.containsKey(divisor)) {
                sb.insert(map.get(divisor), "(");
                sb.append(")");
                break;
            }

            map.put(divisor, sb.length());
            divisor *= 10;
            sb.append(divisor / dividend);
            divisor %= dividend;
        }

        return sb.toString();
    }
}
// @lc code=end
