/* *****************************************************************************
 * Project: TicTacToe.java
 * File: Model.java
 * Description: The Model class performs all back-end functionality for the game.
 * Author: William Koppelberger
 * Date: 1/13/15
 * *****************************************************************************/
public class Model {
	
	/* Variables used for the game */
	private int row = 3;
	private int col = 3;
	private char board[][] = new char[row][col];
	private char playerTurn = 'X';
	private int numMoves = 0;
	
	/* Getter methods for variable access */
	public int getRow() { return row; }
	public int getCol() { return col; }
	public char getPlayerTurn() { return playerTurn; }
	public char[][] getBoard() { return board; }
	
	/* Advances the game one turn */
	public void updatePlayerTurn(int xPos, int yPos, char player) {
		
		if(board[xPos][yPos] == ' ' && numMoves < 10) {
			
			board[xPos][yPos] = player;
		
			if(player == 'X'){
				board[xPos][yPos] = playerTurn;
				playerTurn = 'O';
			}
			else{
				board[xPos][yPos] = playerTurn;
				playerTurn = 'X';
			}
			
			numMoves++;
		}
	}
	
	/* Resets the game */
	public void reset() {
		
		playerTurn = 'X';
		
		for(int r = 0; r < row; r++)
			for(int c = 0; c < col; c++)
				board[r][c] = ' ';
		
		numMoves = 0;
	}
	
	/* Checks if a player has won */
	public char isWinner() {
		
		//check rows
		for(int r = 0; r < row; r++)
			if(board[r][0] == board[r][1] && board[r][0] == board[r][2] && board[r][0] != ' '){
				if(playerTurn == 'X') { playerTurn = 'O'; } else { playerTurn = 'X'; }
				numMoves = 10;
				return 'W';
			}
		
		//check rows
		for(int c = 0; c < col; c++)
			if(board[0][c] == board[1][c] && board[0][c] == board[2][c] && board[0][c] != ' '){
				if(playerTurn == 'X') { playerTurn = 'O'; } else { playerTurn = 'X'; }
				numMoves = 10;
				return 'W';
			}
		
		//check diagonal topLeft to botRight
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' '){
			if(playerTurn == 'X') { playerTurn = 'O'; } else { playerTurn = 'X'; }
			numMoves = 10;
			return 'W';
		}
		
		//check diagonal topRight to botLeft
		if(board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != ' '){
			if(playerTurn == 'X') { playerTurn = 'O'; } else { playerTurn = 'X'; }
			numMoves = 10;
			return 'W';
		}
		
		//check tie game
		if(numMoves >= 9){
			numMoves++;
			return 'T';
		}
		
		return 'N';
	}
}
