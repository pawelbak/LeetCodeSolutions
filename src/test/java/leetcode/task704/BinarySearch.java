package leetcode.task704;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(4, solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        assertEquals(-1, solution.search(new int[]{-3}, 2));
        assertEquals(0, solution.search(new int[]{-3}, -3));
        assertEquals(0, solution.search(new int[]{-3, -2}, -3));
        assertEquals(1, solution.search(new int[]{-3, -2}, -2));
        assertEquals(-1, solution.search(new int[]{-3, -2}, 11));
        assertEquals(0, solution.search(new int[]{-4, -3, -2}, -4));
        assertEquals(1, solution.search(new int[]{-4, -3, -2}, -3));
        assertEquals(2, solution.search(new int[]{-4, -3, -2}, -2));
        assertEquals(-1, solution.search(new int[]{-4, -3, -2}, -5));
        assertEquals(3, solution.search(new int[]{-5, -4, -3, -2}, -2));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        return subsearch(nums, target, 0, nums.length-1);
    }

    public int subsearch(int[] nums, int target, int start, int end) {
        int arrSize = end - start+1;
        if (arrSize == 0) {
            return -1;
        }
        if (arrSize == 1) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int middleIndex;
        if (arrSize % 2 == 0) {
            middleIndex = start + (arrSize / 2) - 1;
        } else {
            middleIndex = start + ((arrSize - 1) / 2);
        }
        if (nums[middleIndex] == target) {
            return middleIndex;
        } else if (nums[middleIndex] > target) {
            return subsearch(nums, target, start, middleIndex-1);
        } else {
            return subsearch(nums, target, middleIndex+1, end);
        }
    }
}