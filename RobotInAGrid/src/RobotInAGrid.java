
public class RobotInAGrid {

	/*
	 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid
	 * with r rows and c columns. The robot can only move in two directions, right
	 * and down, but certain cells are "off limits" such that the robot cannot step
	 * on them. Design an algorithm to find a path for the robot from the top left
	 * to the bottom right.
	 */

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;

		// if the start cell has an obstacle, that means there are no path
		// then return 0
		if (obstacleGrid[0][0] == 1) {
			return 0;
		} else {
			obstacleGrid[0][0] = 1;
		}

		// marking values for the first row
		for (int i = 1; i < column; i++) {
			obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
		}

		// marking values for the first column
		for (int i = 1; i < row; i++) {
			obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
		}

		// marking values for the rest for grid
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}

		// returning value store at the last index
		return obstacleGrid[row - 1][column - 1];
	}

	public static void main(String[] args) {
		
		int[][] grid1 = {{0, 0, 0},
						 {0, 1, 0},
						 {0, 0, 0}};
		
		int[][] grid2 = {{0, 0, 1, 0},
						 {0, 1, 0, 0},
						 {0, 0, 0, 1},
						 {1, 0, 0, 0}};
		
		System.out.println("Grid 1:" + uniquePathsWithObstacles(grid1));
		System.out.println("Grid 2:" + uniquePathsWithObstacles(grid2));
		
		
	}
}
