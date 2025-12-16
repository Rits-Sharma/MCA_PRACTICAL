import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();
        List<List<String>> solutions = solveQueen(n);

        System.out.println("Total solutions: " + solutions.size());
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveQueen(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                 board[i][j] = '.';
        List<List<String>> ans = new ArrayList<>();
        queen(board, 0, ans);
        return ans;
    }

    public static void queen(char[][] board, int row, List<List<String>> ans) {
        if(row == board.length) {
            ans.add(makeString(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queen(board, row+1, ans);
                board[row][col] = '.';
            }
        }
    }

    public static List<String> makeString(char[][] board) {
        List<String> L = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            L.add(row);
        }
        return L;
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
}
