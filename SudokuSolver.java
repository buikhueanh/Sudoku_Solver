import java.util.ArrayList;
import java.util.List;


public class SudokuSolver {
    private int[][] grid;

    public SudokuSolver() {
        Helper h = new Helper();
        String input = h.getInput();
        this.grid = h.getGrid(input);
    }

    // Check if the inserted element is safe
    private boolean isSafe(int row, int col, int insertedNum) {
        // Check row
        for (int i = 0; i < Helper.N; i++) {
            if (grid[row][i] == insertedNum) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < Helper.N; i++) {
            if (grid[i][col] == insertedNum) {
                return false;
            }
        }

        // Check in the subgrid
        int subRow = row - row % 3;
        int subCol = col - col % 3;
        for (int r = subRow; r < subRow + 3; r++) {
            for (int c = subCol; c < subCol + 3; c++) {
                if (grid[r][c] == insertedNum) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean getSudokuSolution() {
        for (int i = 0; i < Helper.N; i++) {
            for (int j = 0; j < Helper.N; j++) {
                int curr = grid[i][j];
                if (curr == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(i, j, num)) {
                            grid[i][j] = num;
                            if (getSudokuSolution()) {
                                return true;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void print() {
        for (int[] row : grid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void solve() {
        System.out.println();
        System.out.println("This is your solution:");
        getSudokuSolution();
        print();
    }

}