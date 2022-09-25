package leetcode.task35;

public class SearchInsertPosition {
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        return findIfIsOrFits(nums, 0, nums.length - 1, target);
    }

    public int findIfIsOrFits(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else if (nums[start] > target) {
                return indexBefore(start, start);
            } else {
                return start + 1;
            }
        }
        int middle = findMiddleOrLeft(start, end);
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return findIfIsOrFits(nums, start, indexBefore(start, middle), target);
        } else {
            return findIfIsOrFits(nums, middle + 1, end, target);
        }
    }

    private int findMiddleOrLeft(int start, int end) {
        int length = end - start;
        if (length % 2 == 0) {
            return start + (length / 2);
        } else {
            return start + ((length - 1) / 2);
        }
    }

    private int indexBefore(int x) {
        return x > 0 ? x - 1 : 0;
    }

    private int indexBefore(int start, int x) {
        if (x == start) {
            return start;
        }
        return indexBefore(x);
    }
}