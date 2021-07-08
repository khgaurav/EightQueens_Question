public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// Column will be a modulo of 8 since there are 8 columns and cell nos increase with columns

		return cellId % 8;
	}
	
	private int getRow(int cellId) {
		// Row no.s will be the divisors of 8 Since there are 8 rows and row no.s increases after 8 squares
		
		return cellId / 8;
	}

	public boolean isValidPosition(int cellId) {

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		int startRDiagonal, startLDiagonal;
		boolean greaterRow;
		
		//Checking if already present
		if(placedQueens[row][col]) {
			return false;
		}

		for(int i = 0; i < 8; i++) {
			// Checking for any previously placed queens in the row and column of the current queen 
			if (placedQueens[i][col] || placedQueens[row][i]) {
				return false;
			}
		}
		
		//Checking for any previously placed queens in the down right diagonal
		for(int i = row + 1, j = col + 1; i < 8 && j < 8; i++, j++) {
			if(placedQueens[i][j]) {
				return false;
			}
		}
		
		//Checking for any previously placed queens in the down left diagonal
		for(int i = row + 1, j = col - 1; i < 8 && j >= 0; i++, j--) {
			if(placedQueens[i][j]) {
				return false;
			}
		}
		
		//Checking for any previously placed queens in the up right diagonal
		for(int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
			if(placedQueens[i][j]) {
				return false;
			}
		}
		
		//Checking for any previously placed queens in the down right diagonal
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if(placedQueens[i][j]) {
				return false;
			}
		}
		
		// If return statement not yet executed then the queen placement is valid
		placedQueens[row][col] = true;
		numQueens++;
		return true;
	}
}














