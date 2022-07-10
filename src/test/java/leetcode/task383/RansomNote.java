package leetcode.task383;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RansomNote {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(false, solution.canConstruct("a", "b"));
        assertEquals(false, solution.canConstruct("aa", "ab"));
        assertEquals(true, solution.canConstruct("aa", "aab"));
    }
}

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, AtomicInteger> magazineMap = stringToMap(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            String charI = String.valueOf(ransomNote.charAt(i));
            int charactersLeft = magazineMap.get(charI).decrementAndGet();
            if (charactersLeft < 0) {
                return false;
            }
        }
        return true;

    }

    private Map<String, AtomicInteger> stringToMap(String s) {
        Map<String, AtomicInteger> charsMap = emptyMap();
        for (int i = 0; i < s.length(); i++) {
            String charI = String.valueOf(s.charAt(i));
            charsMap.get(charI).incrementAndGet();
        }
        return charsMap;
    }

    private Map<String, AtomicInteger> emptyMap() {
        Map<String, AtomicInteger> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(String.valueOf(c), new AtomicInteger(0));
        }
        return map;
    }

}
