public interface Connect4Grid {
	public static final int GRID_COLS = 7;
	public static final int GRID_ROWS = 6;
    public char[][] grid = new char[GRID_ROWS][GRID_COLS];
    public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();   
}
