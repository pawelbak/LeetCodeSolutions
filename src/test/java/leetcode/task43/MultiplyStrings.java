package leetcode.task43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyStrings {

    @Test
    public void test() {
        assertEquals("56088", new Solution().multiply("123", "456"));
        assertEquals("0", new Solution().multiply("0", "123"));
        assertEquals("123456789", new Solution().multiply("123456789", "1"));
    }

}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }


        int[] partialSums = new int[2 * Math.max(num1.length(), num2.length())];
        for (int i = 0; i < partialSums.length; i++) {
            partialSums[i] = 0;
        }
        for (int i = 0; i < num2.length(); i++) {
            int digit2 = toInt(num2.charAt(num2.length() - 1 - i));
            for (int j = 0; j < num1.length(); j++) {
                int digit1 = toInt(num1.charAt(num1.length() - 1 - j));
                int multiplied = digit1 * digit2;
                partialSums[partialSums.length - 1 - i - j] += multiplied;
            }
        }

        //recalculate overflows
        int overflow = 0;
        for (int i = 0; i < partialSums.length; i++) {
            int sum = partialSums[partialSums.length - 1 - i] + overflow;
            int leftover = sum % 10;
            partialSums[partialSums.length - 1 - i] = leftover;
            overflow = (sum - leftover) / 10;
        }

        boolean proceedingZero = true;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < partialSums.length; i++) {
            if (partialSums[i] == 0 && proceedingZero) {
                //skip;
            } else {
                proceedingZero = false;
                result.append(partialSums[i]);
            }
        }
        return result.toString();

    }

    private int toInt(char c) {
        return c - '0';
    }

}