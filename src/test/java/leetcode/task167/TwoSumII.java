package leetcode.task167;

public class TwoSumII {
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIdx = 0;
        int rightIdx = numbers.length-1;
        int currentSum = numbers[leftIdx] + numbers[rightIdx];
        while(currentSum != target){
            if(currentSum<target){
                leftIdx++;
            }else{
                rightIdx--;
            }
            currentSum = numbers[leftIdx] + numbers[rightIdx];

        }
        return new int[]{leftIdx+1, rightIdx+1};
    }
}