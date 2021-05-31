
public class GameOfLife {

	int rows;
	int columns;
	boolean [][] curGen = null;
	boolean [][] newGen = null;
	public GameOfLife(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new IllegalArgumentException("rows or columns can't be negative!");
		}
		this.rows = rows;
		this.columns = columns;
		curGen = new boolean[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}

	public boolean isAlive(int row, int column) {
		boolean isAlive = false;
		if (row < 0 || row >= rows || column < 0 || column >= columns) {
			isAlive = false;
		}
		else {
			isAlive = curGen[row][column];
		}
		return isAlive;
	}

	public void setAlive(int row, int column, boolean life) {
		if (row >= 0 && row < rows && column >= 0 && column < columns) {
			curGen[row][column] = life;
		}
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
		if (isAlive(row+1, column)) {
			neighbors += 1;
		}
		if (isAlive(row-1, column)) {
			neighbors += 1;
		}
		return neighbors;
	}
	public void calculateNextGeneration() {
		newGen = new boolean[rows][columns];
		for (int row = 0; row < curGen.length; row ++) {
			for (int col = 0; col < curGen[row].length; col ++) {
				if (isAlive(row, col) == true) {
					if (getNeighbourCount(row, col) >= 4 || getNeighbourCount(row, col) <= 1) {
						newGen[row][col] = false;
						continue;
					}
					if (getNeighbourCount(row, col) == 2 || getNeighbourCount(row, col) == 3) {
						newGen[row][col] = true;
					}
				}
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
		for (int row = 0; row < curGen.length; row++) {
			for (int col = 0; col < curGen[row].length; col++) {
				if (isAlive(row, col) == true) {
					res += "*";
				}
				if (isAlive(row, col) == false) {
					res += " ";
				}
			}
			res += "\r\n";
		}
		return res;
	}
}