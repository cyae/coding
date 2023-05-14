/*
 * @lc app=leetcode.cn id=1054 lang=java
 *
 * [1054] 距离相等的条形码
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }

        int[][] barcodeAndFreq = new int[barcodes.length][2];
        for (int i = 0; i < barcodes.length; i++) {
            barcodeAndFreq[i] = new int[] { map.get(barcodes[i]), barcodes[i] };
        }
        Arrays.sort(barcodeAndFreq, (p1, p2) -> p2[0] != p1[0] ? p2[0] - p1[0] : p1[1] - p2[1]);

        int i = 0;
        for (int[] e : barcodeAndFreq) {
            barcodes[i] = e[1];
            i += 2;
            if (i >= barcodes.length) {
                i = 1;
            }
        }

        return barcodes;
    }
}
