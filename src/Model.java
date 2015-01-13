
public class Model {
	private int row = 3;
	private int col = 3;
	private char board[][] = new char[row][col];
	private char playerTurn = 'X';
	
	public int getRow() {
		
		return row;
	}
	
	public int getCol() {
		
		return col;
	}
	
	public void updatePlayerTurn(int xPos, int yPos, char player) {
		
		if(board[xPos][yPos] == ' ') {
			
			board[xPos][yPos] = player;
		
			if(player == 'X')
				playerTurn = 'O';
			else
				playerTurn = 'X';
		}
	}
	
	public void reset() {
		
		playerTurn = 'X';
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				board[i][j] = ' ';
	}
	
	public char isWinner() {
		
		//check rows
		for(int i = 0; i < row; i++)
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
				return board[i][0];
		
		//check columns
		for(int i = 0; i < col; i++)
			if(board[0][i] == board[1][i] && board[0][1] == board[2][i])
				return board[0][i];
		
		//check diagonals
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2])
			return board[0][0];
		
		return 'T';
	}
}
