package leetcode.task567;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
}
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> templateHistogram = prepareHistogram(s1);
        int templateLength = s1.length();
        int substringStart = 0;
        Map<Character, Integer> substringHistogram = prepareHistogram(s2.substring(substringStart, substringStart + templateLength));
        if (histogramsEqual(templateHistogram, substringHistogram)) {
            return true;
        }
        while (substringStart < s2.length() - templateLength) {
            popFromHistogram(substringHistogram, s2.charAt(substringStart));
            substringStart++;
            pushToHistogram(substringHistogram, s2.charAt(substringStart + templateLength-1));
            if (histogramsEqual(templateHistogram, substringHistogram)) {
                return true;
            }
        }
        return false;
    }

    private Map<Character, Integer> prepareHistogram(String someString) {
        Map<Character, Integer> histogram = new HashMap<>();
        for (int i = 0; i < someString.length(); i++) {
            char c = someString.charAt(i);
            pushToHistogram(histogram, c);
        }
        return histogram;
    }

    private boolean histogramsEqual(Map<Character, Integer> histogram1, Map<Character, Integer> histogram2) {
        for (Character c : histogram1.keySet()) {
            if (!histogram1.get(c).equals(histogram2.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }

    private void pushToHistogram(Map<Character, Integer> histogram, char c) {
        histogram.putIfAbsent(c, 0);
        int current = histogram.get(c);
        histogram.put(c, current + 1);
    }

    private void popFromHistogram(Map<Character, Integer> histogram, char c) {
        int current = histogram.get(c);
        histogram.put(c, current - 1);
    }
}