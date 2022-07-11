package leetcode.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfSortedArrays {

    @Test
    public void test() {

        assertEquals(2.0, new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.5, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        assertEquals(2.0, new Solution().findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{}));
    }

}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        Solver s = new Solver(nums1, nums2);

        if (totalSize % 2 == 0) {
            //middle one
            int first = 0;
            for (int i = 0; i < totalSize / 2; i++) {
                first = s.pickNext();
            }
            int second = s.pickNext();
            return (first + second) / 2.0;
        } else {
            int middle = 0;
            for (int i = 0; i < (totalSize + 1) / 2; i++) {
                middle = s.pickNext();
            }
            return middle;
        }
    }


    class Solver {
        int[] nums1;
        int[] nums2;

        int current1 = -1;
        int current2 = -1;

        public Solver(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }

        int pickNext() {
            boolean canProceedWith1 = current1 + 1 < nums1.length;
            boolean canProceedWith2 = current2 + 1 < nums2.length;
            if (!canProceedWith1) {
                return pickSecondList();
            }
            if (!canProceedWith2) {
                return pickFirstList();
            }
            if (nums1[current1 + 1] < nums2[current2 + 1]) {
                return pickFirstList();
            }
            return pickSecondList();
        }

        int pickFirstList() {
            current1++;
            return nums1[current1];
        }

        int pickSecondList() {
            current2++;
            return nums2[current2];
        }


    }

}
