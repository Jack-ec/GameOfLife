
public class GameOfLife {

	int rows;
	int columns;
	boolean [][] curGen;
 	public GameOfLife(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		curGen = new boolean[rows][columns];
		if (rows < 1 || columns < 1) {
			throw new IllegalArgumentException("rows or columns can't be negative!");
		}
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	
	public boolean isAlive(int row, int column) {
		boolean isAlive = false;
		if (row < 0 || row > rows || column < 0 || column > columns) {
			isAlive = false;
		}
		else {
			isAlive = curGen[row][column];
		}
		return isAlive;
	}
	
	public boolean setAlive(int row, int column, boolean life) {
		twoDArray[row][column] = life;
		return life;
	}
	public int getNeighbourCount(int row, int column) {
		int neighbors = 0;
		if (isAlive(row+1, column+1)) {
			neighbors += 1;
		}
		if (isAlive(row+1, column-1)) {
			neighbors += 1;
		}
		if (isAlive(row-1, column+1)) {
			neighbors += 1;
		}
		if (isAlive(row-1, column-1)) {
			neighbors += 1;
		}
		if (isAlive(row, column+1)) {
			neighbors += 1;
		}
		if (isAlive(row, column-1)) {
			neighbors += 1;
		}
		if (isAlive(row, column+1)) {
			neighbors += 1;
		}
		if (isAlive(row, column-1)) {
			neighbors += 1;
		}
		return neighbors;
	}
	public void calculateNextGeneration() {
		boolean [][] newGen;
		for (int row = 1; row < curGen.length; row ++) {
			for (int col = 1; twoDArray[row].length; col ++) {
				if (isAlive(row, col) == true) {
					if (getNeighbourCount(row, col) < 2) {
						newGen[row][col] = false;
					}
					continue;
				if (getNeighbourCount(row, col) >= 4 && getNeighbourCount(row, col) <= 1) {
					newGen[row][col] = false;
				}
				continue;
				
				}
				if (getNeighbourCount(row, col) == 3 || getNeighbourCount(row, col) == 2) {
					newGen[row][col] = true;
				}
				continue;
				if (isAlive(row, col) == false) {
					if (getNeighbourCount(row, col) == 3)
						newGen[row][col] = true;
				}
			}
		}
		curGen = newGen;
	}


	 public String toString() {
	        String res = "";
	        for (int r = 0; r < twoDArray.length; r++) {
	            for (int c = 0; c < twoDArray[r].length; c++) 
	                res = res + twoDArray[r][c];

	        }
	        return res;
	 }
}
