package easy;

/**
 * Problem:
 * No: 463
 * Link: https://leetcode.com/problems/island-perimeter/
 * <p>
 * Analysis:
 * If a cell is land, check the cell around it, if the adjacent cell is water, the perimeter increase 1,
 * besides this, if a cell is next to the border of the grid, every edge of a cell which is part of the grid border increases the perimeter by 1.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int length = grid.length;
        int width = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                perimeter += getBorderCount(i, j, length, width);
                perimeter += getAdjacentWaterCellCount(i, j, grid);
            }
        }
        return perimeter;
    }

    private int getBorderCount(int x, int y, int length, int width) {
        int count = 0;
        if (x == 0) {
            count++;
        }
        if (x == (length - 1)) {
            count++;
        }
        if (y == 0) {
            count++;
        }
        if (y == (width - 1)) {
            count++;
        }
        return count;
    }

    private int getAdjacentWaterCellCount(int x, int y, int[][] grid) {
        int count = 0;
        int length = grid.length;
        int width = grid[0].length;
        if (x > 0 && grid[x - 1][y] == 0) {
            count++;
        }
        if (x < (length - 1) && grid[x + 1][y] == 0) {
            count++;
        }
        if (y > 0 && grid[x][y - 1] == 0) {
            count++;
        }
        if (y < (width - 1) && grid[x][y + 1] == 0) {
            count++;
        }
        return count;
    }
}
