/*
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Controller {

	private Model gameModel;
	private View gameView;
	
	public Controller(Model gameModel, View gameView) {
		this.gameModel = gameModel;
		this.gameView = gameView;
		
		// Tell the View that when ever the buttons are clicked, call actionPerformed
		this.gameView.addButtonListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			int numRow = gameView.getNumRow();
			int numCol = gameView.getNumCol();
			
			for(int r = 0; r < numRow; r++)
				for(int c = 0; c < numCol; c++)
					if(e.getSource() == gameBoardButtons[r][c]){
						gameBoardButtons[r][c].
					}
						
			
		}
		
	}
}