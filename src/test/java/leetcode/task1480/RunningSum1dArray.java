package leetcode.task1480;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RunningSum1dArray {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{1, 3, 6, 10}, s.runningSum(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, s.runningSum(new int[]{1, 1, 1, 1, 1}));
        assertArrayEquals(new int[]{3, 4, 6, 16, 17}, s.runningSum(new int[]{3, 1, 2, 10, 1}));
    }
}

class Solution {
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            sums[i] = runningSum;
        }
        return sums;

    }
}