
public class GameOfLife {

	int rows;
	int columns;
	boolean [][] twoDArray;
	
	public GameOfLife(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		twoDArray = new boolean[rows][columns];
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
	}
	
}
