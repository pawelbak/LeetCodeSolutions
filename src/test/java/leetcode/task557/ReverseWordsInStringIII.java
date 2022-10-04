package leetcode.task557;

public class ReverseWordsInStringIII {
}
class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int lastSpace = -1;
        for (int i= 0;i<=str.length;i++){
            if(i==str.length || str[i]==' '){
                revertArrayPart(str, lastSpace+1, i-1);
                lastSpace=i;
            }
        }
        return new String(str);
    }

    private void revertArrayPart(char[] chars, int startIdx, int endIdx){
        int s = startIdx;
        int e = endIdx;

        while(s<e){
            char tmp= chars[s];
            chars[s] = chars[e];
            chars[e] = tmp;
            s++;
            e--;
        }
    }


}