package leetcode.task412;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
}
class Solution {
    List<String> answers;

    public List<String> fizzBuzz(int n) {
        List<String> answers = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            String answer = "";
            if(i%3==0){
                answer +="Fizz";
            }
            if(i%5==0){
                answer+="Buzz";
            }
            if(answer.equals("")){
                answer+=String.valueOf(i);
            }
            answers.add(answer);
        }
        return answers;
    }
}