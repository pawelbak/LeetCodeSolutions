package leetcode.task36;

public class ValidSudoku {
}
class Solution {
    char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return areDistinct(board[0])
                && areDistinct(board[1])
                && areDistinct(board[2])

                && areDistinct(board[3])
                && areDistinct(board[4])
                && areDistinct(board[5])

                && areDistinct(board[6])
                && areDistinct(board[7])
                && areDistinct(board[8])

                && areDistinct(board[0][0], board[1][0], board[2][0],  board[3][0], board[4][0], board[5][0],  board[6][0], board[7][0], board[8][0])
                && areDistinct(board[0][1], board[1][1], board[2][1],  board[3][1], board[4][1], board[5][1],  board[6][1], board[7][1], board[8][1])
                && areDistinct(board[0][2], board[1][2], board[2][2],  board[3][2], board[4][2], board[5][2],  board[6][2], board[7][2], board[8][2])

                && areDistinct(board[0][3], board[1][3], board[2][3],  board[3][3], board[4][3], board[5][3],  board[6][3], board[7][3], board[8][3])
                && areDistinct(board[0][4], board[1][4], board[2][4],  board[3][4], board[4][4], board[5][4],  board[6][4], board[7][4], board[8][4])
                && areDistinct(board[0][5], board[1][5], board[2][5],  board[3][5], board[4][5], board[5][5],  board[6][5], board[7][5], board[8][5])

                && areDistinct(board[0][6], board[1][6], board[2][6],  board[3][6], board[4][6], board[5][6],  board[6][6], board[7][6], board[8][6])
                && areDistinct(board[0][7], board[1][7], board[2][7],  board[3][7], board[4][7], board[5][7],  board[6][7], board[7][7], board[8][7])
                && areDistinct(board[0][8], board[1][8], board[2][8],  board[3][8], board[4][8], board[5][8],  board[6][8], board[7][8], board[8][8])


                && areDistinct(board[0][0], board[0][1], board[0][2],  board[1][0], board[1][1], board[1][2],  board[2][0], board[2][1], board[2][2])
                && areDistinct(board[3][0], board[3][1], board[3][2],  board[4][0], board[4][1], board[4][2],  board[5][0], board[5][1], board[5][2])
                && areDistinct(board[6][0], board[6][1], board[6][2],  board[7][0], board[7][1], board[7][2],  board[8][0], board[8][1], board[8][2])

                && areDistinct(board[0][3], board[0][4], board[0][5],  board[1][3], board[1][4], board[1][5],  board[2][3], board[2][4], board[2][5])
                && areDistinct(board[3][3], board[3][4], board[3][5],  board[4][3], board[4][4], board[4][5],  board[5][3], board[5][4], board[5][5])
                && areDistinct(board[6][3], board[6][4], board[6][5],  board[7][3], board[7][4], board[7][5],  board[8][3], board[8][4], board[8][5])

                && areDistinct(board[0][6], board[0][7], board[0][8],  board[1][6], board[1][7], board[1][8],  board[2][6], board[2][7], board[2][8])
                && areDistinct(board[3][6], board[3][7], board[3][8],  board[4][6], board[4][7], board[4][8],  board[5][6], board[5][7], board[5][8])
                && areDistinct(board[6][6], board[6][7], board[6][8],  board[7][6], board[7][7], board[7][8],  board[8][6], board[8][7], board[8][8]);

    }



    private boolean areDistinct(char... x){
        int[] nums = new int[]{0,0,0, 0,0,0, 0,0,0};
        for(char c:x){
            if(c!='.'){
                nums[c-'0'-1]++;
            }
        }
        for(int num:nums){
            if(num>1){
                return false;
            }

        }
        return true;
    }
}