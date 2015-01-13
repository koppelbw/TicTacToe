import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/* *****************************************************************************
 * Project: TicTacToe.java
 * File: View.java
 * Description: The View class performs as the GUI
 * Author: William Koppelberger
 * Date: 1/13/15
 * *****************************************************************************/
public class View extends JFrame{

	/* Instantiate GUI related variables */
	private JPanel gamePanel;
	private GridLayout gameLayout;
	private JButton[][] gameBoardButtons;
	private int numRow;
	private int numCol;
	private char[][] gameBoard;
	private JButton resetButton, bufferButton;
	
	/* Constructor: 2 parameters; Sets up GUI board, Frame, Panel, etc. */
	View(int row, int col) {
		
		numRow = row;
		numCol = col;
		gameBoardButtons = new JButton[numRow][numCol];
		gamePanel = new JPanel();
		gameLayout = new GridLayout(row+1,col+1);
		resetButton = new JButton("Reset");
		bufferButton = new JButton(" ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,350);
		this.setTitle("TicTacToe");
		gamePanel.setLayout(gameLayout);
		

		//Create and insert buttons to Panel
		for(int r = 0; r < numRow; r++)
			for(int c = 0; c < numCol; c++){
				gameBoardButtons[r][c] = new JButton(" ");
				gameBoardButtons[r][c].setFocusPainted(false);
				gamePanel.add(gameBoardButtons[r][c]);
			}
		
		gamePanel.add(bufferButton);
		gamePanel.add(resetButton);
		
		this.add(gamePanel);
	}
	
	/* Adds ButtonListeners to all buttons. This method corresponds with the Controller method */
	public void addButtonListener(ActionListener listener) {
		
		//Add ButtonListener to all game buttons
		for(int r = 0; r < numRow; r++)
			for(int c = 0; c < numCol; c++)
				gameBoardButtons[r][c].addActionListener(listener);
		
		//Add ButtonListener to Reset button
		resetButton.addActionListener(listener);
				
	}
	
	/* Updates what the user sees */
	void displayGUIBoard() {
		
		for(int r = 0; r < numRow; r++)
			for(int c = 0; c < numCol; c++){
				gameBoardButtons[r][c].setText("" + gameBoard[r][c]);
			}
	}
	
	/* Getter and Setter methods */
	public int getNumRow() { return numRow; }
	public int getNumCol() { return numCol; }
	public JButton[][] getGameBoardButtons() { return gameBoardButtons; }
	public JButton getResetButton() { return resetButton; }
	public void setGameBoard(char[][] gameBoard) { this.gameBoard = gameBoard; }
}