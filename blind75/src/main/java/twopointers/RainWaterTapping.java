package twopointers;

import java.net.StandardSocketOptions;

import static java.lang.System.out;

public class RainWaterTapping {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};


        out.println(tapWaterCount(arr));
    }
    public static int tapWaterCount(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int res = 0;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = height[0];
        rightmax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        for (int j = n-2; j >= 0; j--) {
            rightmax[j] = Math.max(rightmax[j+1], height[j]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(leftmax[i], rightmax[i]) - height[i];
        }

        return res;
    }

}
