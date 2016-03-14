import algorithm.hard.NQueens_51;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        NQueens_51 o = new NQueens_51();
        List<List<String>> res = o.solveNQueens(4);
        for (List<String> list : res) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
