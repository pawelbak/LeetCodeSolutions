package leetcode.task977;

public class SquaresSortedArray {
}
class Solution {
    int[] results;

    int leftIdx;
    int rightIdx;

    private void init(int len) {
        results = new int[len];
        leftIdx = 0;
        rightIdx = len - 1;
    }

    public int[] sortedSquares(int[] nums) {
        init(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int left = abs(nums[leftIdx]);
            int right = abs(nums[rightIdx]);
            if (left > right) {
                results[nums.length-1-i] = square(left);
                leftIdx++;

            } else {
                results[nums.length-1-i] = square(right);
                rightIdx--;
            }
        }
        return results;
    }

    private int square(int x) {
        return x * x;
    }

    private int abs(int x) {
        if (x < 0) {
            return -1 * x;
        }
        return x;
    }
}