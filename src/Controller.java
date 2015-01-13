import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/* *****************************************************************************
 * Project: TicTacToe.java
 * File: Controller.java
 * Description: Controller class that bridges the gap between the Model and View.
 * Author: William Koppelberger
 * Date: 1/13/15
 * *****************************************************************************/
public class Controller {

	/* Instantiate the Model and View objects */
	private Model gameModel;
	private View gameView;
	
	/* Constructor: 2 parameters */
	public Controller(Model gameModel, View gameView) {
		
		//Set Look&Feel to Nimbus style
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		//initialize Model and View
		this.gameModel = gameModel;
		gameModel.reset();
		
		this.gameView = gameView;
		
		// Tell the View that when ever the buttons are clicked, call actionPerformed
		this.gameView.addButtonListener(new ButtonListener());
	}
	
	/* Corresponding method to the View method. This method handles game interactions. */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			int numRow = gameView.getNumRow();
			int numCol = gameView.getNumCol();
			JButton[][] gameBoardButtons = gameView.getGameBoardButtons();
			char gameBoard[][] = gameModel.getBoard();
			JButton resetButton = gameView.getResetButton();
			
			// Update Model and View
			for(int r = 0; r < numRow; r++)
				for(int c = 0; c < numCol; c++)
					if(e.getSource() == gameBoardButtons[r][c]){
						
						// Check with model if valid spot and update if can
						gameModel.updatePlayerTurn(r, c, gameModel.getPlayerTurn());

						// Update View
						gameView.setGameBoard(gameBoard);
						gameView.displayGUIBoard();
						
						// Check with model if isWinner
						if(gameModel.isWinner() == 'W')
							JOptionPane.showMessageDialog(null, "Player " + gameModel.getPlayerTurn() + " is the winner!!", "Winner!", JOptionPane.PLAIN_MESSAGE);
						if(gameModel.isWinner() == 'T')
							JOptionPane.showMessageDialog(null, "Cat's Game!!",  "Tie Game!", JOptionPane.PLAIN_MESSAGE);
						
					}
					else if(e.getSource() == resetButton) {
						gameModel.reset();
						gameView.displayGUIBoard();
					}
		}
	}
}