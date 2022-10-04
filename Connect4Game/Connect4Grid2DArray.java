import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Connect4Grid2DArray implements Connect4Grid {
	public int lastCol = -1, lastTop = -1;
	public char emptyGridChar = 'o';
	
	public Connect4Grid2DArray() {
		for (int i = 0; i < GRID_ROWS; i++) {
			Arrays.fill(grid[i] = new char[GRID_COLS], emptyGridChar);
		}
	}

	public void emptyGrid() {
		for (int i = 0; i < GRID_ROWS; i++) {
			Arrays.fill(grid[i] = new char[GRID_COLS], emptyGridChar);
		}
	}

	public String toString() {
		return IntStream.range(0, GRID_COLS).mapToObj(Integer::toString).collect(Collectors.joining()) + "\n"
				+ Arrays.stream(grid).map(String::new).collect(Collectors.joining("\n"));
	}

	public boolean isValidColumn(int column) {
		if (column > GRID_COLS-1 || column < 0) {
			return false;
		} else
			return true;
	}

	public boolean isColumnFull(int column) {
		if (grid[0][column] == 'R' || grid[0][column] == 'Y') {
			return true;
		}
		return false;
	}

	public void dropPiece(ConnectPlayer player, int column) {
		for (int h = GRID_ROWS - 1; h >= 0; h--) {
			if (grid[h][column] == emptyGridChar) {
				grid[lastTop = h][lastCol = column] = player.getSymbol();
				return;
			}
		}
	}

	public String horizontal() {
		return new String(grid[lastTop]);
	}

	public String vertical() {
		StringBuilder sb = new StringBuilder(GRID_ROWS);
		for (int h = 0; h < GRID_ROWS; h++) {
			sb.append(grid[h][lastCol]);
		}
		return sb.toString();
	}

	public String diagonal() {
		StringBuilder sb = new StringBuilder(GRID_ROWS);

		for (int h = 0; h < GRID_ROWS; h++) {
			int w = lastCol + lastTop - h;

			if (0 <= w && w < GRID_COLS) {
				sb.append(grid[h][w]);
			}
		}

		return sb.toString();
	}

	public String reverseDiagonal() {
		StringBuilder sb = new StringBuilder(GRID_ROWS);

		for (int h = 0; h < GRID_ROWS; h++) {
			int w = lastCol - lastTop + h;

			if (0 <= w && w < GRID_COLS) {
				sb.append(grid[h][w]);
			}
		}
		return sb.toString();
	}

	public static boolean contains(String str, String substring) {
		return str.indexOf(substring) >= 0;
	}

	public boolean didLastPieceConnect4() {
		if (lastCol == -1) {
			System.err.println("No move has been made yet");
			return false;
		}
		char sym = grid[lastTop][lastCol];
		String streak = String.format("%c%c%c%c", sym, sym, sym, sym);
		return contains(horizontal(), streak) || contains(vertical(), streak) || contains(diagonal(), streak)
				|| contains(reverseDiagonal(), streak);
	}

	public boolean isGridFull() {
		boolean bgridFull =true;
		for (int row = 0; row < GRID_ROWS && bgridFull; row++) {
			for (int column = 0; column < GRID_COLS && bgridFull; column ++) {
				if (grid[row][column] == emptyGridChar) {
					bgridFull = false;
				}
			}
		}		
		return bgridFull;
	}

	public int getTotalColumns() {
		return GRID_COLS;
	}
}
