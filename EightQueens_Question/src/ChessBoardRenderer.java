public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {
		// Even numbered squares in odd rows and odd numbered squares in even rows should be black 
		if((square % 2 != 0 && (square / 8) % 2 == 0) || (square % 2 == 0 && (square / 8) % 2 != 0)) {
			return true;
		}
		return false;
	}
}
