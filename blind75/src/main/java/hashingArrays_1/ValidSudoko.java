package hashingArrays_1;

import java.util.HashSet;

public class ValidSudoko {

    public static void main(String[] args) {

            char[][] board = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

            boolean result = isValidSudoku(board);

            System.out.println("Is Valid Sudoku: " + result);
        }


    public static boolean isValidSudoku(char[][] board) {

            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    // Skip empty cell
                    if (c == '.') {
                        continue;
                    }
                    if (!set.add("row" + i + c)) {
                        return false;
                    }
                    if (!set.add("col" + j + c)) {
                        return false;
                    }
                    int box = (i / 3) * 3 + (j / 3);
                    if (!set.add("box" + box + c)) {
                        return false;
                    }
                }
            }
        return true;
    }

}
