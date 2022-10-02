package leetcode.task3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestUniqueSubstring {
    @Test
    public void test() {
        assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new Solution().lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, new Solution().lengthOfLongestSubstring(" "));
    }
}


class Solution {
    Map<Character, Integer> substringMap = new HashMap<>();
    int longestSubstring = 0;
    int rightPointer = 0;
    int leftPointer = 0;


    public int lengthOfLongestSubstring(String s) {
        while (rightPointer < s.length()) {
            if (isSubstringUnique()) {
                pushChar(s.charAt(rightPointer));
                rightPointer++;
                if (isSubstringUnique()) {
                    longestSubstring = max(longestSubstring, rightPointer - leftPointer);
                }
            } else {
                popChar(s.charAt(leftPointer));
                leftPointer++;
            }
        }

        return longestSubstring;
    }

    private boolean isSubstringUnique() {
        for (Integer value : substringMap.values()) {
            if (value > 1) return false;
        }
        return true;
    }

    private void pushChar(char c) {
        Integer val = substringMap.getOrDefault(c, 0);
        substringMap.put(c, val + 1);
    }

    private void popChar(char c) {
        Integer val = substringMap.get(c);
        substringMap.put(c, val - 1);
    }

    private int max(int a, int b) {
        if (a > b) return a;
        return b;
    }


}