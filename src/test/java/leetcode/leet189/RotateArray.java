package leetcode.leet189;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArray {
    @Test
    public void test() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};

        new Solution().rotate(nums1, 4);
        new Solution().rotate(nums2, 2);

        assertArrayEquals(new int[]{1}, nums1);
        assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums2);
    }
}


class Solution {
    public void rotate(int[] nums, int k) {
        int unifiedK = k % nums.length;
        int pivot = nums.length-1-unifiedK;
        revertArray(nums, 0, pivot);
        revertArray(nums, pivot+1, nums.length - 1);
        revertArray(nums, 0, nums.length - 1);
    }

    private void revertArray(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
            revertArray(arr, start, end);
        }
    }

}
