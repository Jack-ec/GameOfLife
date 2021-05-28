
public class GameOfLife {

	int rows;
	int columns;
	boolean [][] twoDArray;
	
	public GameOfLife(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		twoDArray = new boolean[rows][columns];
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
			isAlive = twoDArray[row][column];
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
	public boolean calculateNextGeneration(int row, int column, boolean life) {
			if (getNeighbourCount(row, column) < 2) {
				life = false;
				setAlive(row, column, life);
			}
			if (getNeighbourCount(row, column) >= 2 && getNeighbourCount(row, column) <= 3) {
				setAlive(row, column, life);
			}
			if (getNeighbourCount(row, column) > 3) {
				life = false;
				setAlive(row, column, life);
			}
			if (getNeighbourCount(row, column) == 3) {
				setAlive(row, column, life);
			}
			return life;
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
