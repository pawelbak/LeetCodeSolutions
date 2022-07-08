package leetcode.task13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToInteger {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(1, solution.romanToInt("I"));
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(14, solution.romanToInt("XIV"));
        assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }
}
class Solution {

    enum RomanDigit {
        I("I", 1),
        V("V", 5),
        X("X", 10),
        L("L", 50),
        C("C", 100),
        D("D", 500),
        M("M", 1000);

        RomanDigit(String letter, int value) {
            this.letter = letter;
            this.value = value;
        }

        String letter;
        int value;

        public static RomanDigit parse(String s) {
            for (RomanDigit digit : RomanDigit.values()) {
                if (digit.letter.equals(s)) {
                    return digit;
                }
            }
            throw new RuntimeException("Invalid letter");
        }

    }

    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return RomanDigit.parse(s).value;
        } else {
            RomanDigit d1 = RomanDigit.parse(s.substring(0, 1));
            RomanDigit d2 = RomanDigit.parse(s.substring(1, 2));

            if (isTouple(d1, d2)) {
                return (d2.value - d1.value) + romanToInt(s.substring(2));
            } else {
                return d1.value + romanToInt(s.substring(1));
            }
        }
    }

    private boolean isTouple(RomanDigit d1, RomanDigit d2) {
        return d1.value < d2.value;
    }


}
