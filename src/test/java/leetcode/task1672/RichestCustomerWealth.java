package leetcode.task1672;

public class RichestCustomerWealth {
}
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int customer = 0;customer<accounts.length;customer++){
            int customerSum = 0;
            for(int bank = 0;bank<accounts[customer].length;bank++){
                customerSum +=accounts[customer][bank];
            }
            if(customerSum>maxWealth){
                maxWealth = customerSum;
            }
        }
        return maxWealth;
    }
}