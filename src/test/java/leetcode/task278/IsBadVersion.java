package leetcode.task278;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsBadVersion {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(5, solution.findMiddleOrLeft(5, 5));
        assertEquals(5, solution.findMiddleOrLeft(5, 6));
        assertEquals(5, solution.findMiddleOrLeft(4, 6));
        assertEquals(5, solution.findMiddleOrLeft(4, 7));
        assertEquals(5, solution.firstBadVersion(5));
        assertEquals(5, solution.firstBadVersion(6));
        assertEquals(5, solution.firstBadVersion(7));
//        assertEquals(1702766719, solution.firstBadVersion(2126753390));
    }
}

class VersionControl {
    public boolean isBadVersion(int version) {
        if (version >= 4) {
            return true;
        }
        return false;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return findBetween(1, n);
    }

    public int findBetween(int start, int end) {
        if (start == end) {
            if (isBadVersion(start)) {
                return start;
            }
            return start + 1;
        }
        int middle = findMiddleOrLeft(start, end);
        if (isBadVersion(middle)) {
            return findBetween(start, middle);
        } else {
            return findBetween(middle + 1, end);
        }

    }

    public int findMiddleOrLeft(int left, int right) {
        int length = right - left;

        if (length % 2 == 0) {
            return left + (length / 2);
        } else {
            return left + ((length - 1) / 2);
        }

    }

}
