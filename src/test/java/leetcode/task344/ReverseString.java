package leetcode.task344;

public class ReverseString {
}
class Solution {
    public void reverseString(char[] s) {
        int leftIdx = 0;
        int rightIdx = s.length-1;
        while(leftIdx<rightIdx){
            char tmp = s[leftIdx];
            s[leftIdx] = s[rightIdx];
            s[rightIdx] = tmp;
            rightIdx--;
            leftIdx++;
        }
    }
}