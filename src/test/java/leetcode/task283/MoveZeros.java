package leetcode.task283;

public class MoveZeros {
}
class Solution {
    public void moveZeroes(int[] nums) {
        int insertIdx = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertIdx++] = nums[i];
            }
        }
        for(int i = insertIdx;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}