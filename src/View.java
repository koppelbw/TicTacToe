import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame{

	private JPanel gamePanel;
	private GridLayout gameLayout;
	private JButton[][] gameBoardButtons;
	private int numRow;
	private int numCol;
	
	View(int row, int col) {
		
		numRow = row;
		numCol = col;
		gamePanel = new JPanel();
		gameLayout = new GridLayout(row,col);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		setLayout(gameLayout);
		
		//ButtonListener listener = new ButtonListener();
		
		//Create and insert buttons to Panel
		for(int r = 0; r < numRow; r++)
			for(int c = 0; c < numCol; c++){
				gameBoardButtons[r][c] = new JButton(" ");
				//gameBoardButtons[r][c].addActionListener(listener);
				gamePanel.add(gameBoardButtons[r][c]);
			}
		
		this.add(gamePanel);
	}
	
	public void addButtonListener(ActionListener listener) {
		
		//Add ButtonListener to all buttons
		for(int r = 0; r < numRow; r++)
			for(int c = 0; c < numCol; c++)
				gameBoardButtons[r][c].addActionListener(listener);
				
	}
	
	void displayGUIBoard() {
		
	}
	
	public int getNumRow() {
		return numRow;
	}
	
	public int getNumCol() {
		return numCol;
	}
	
	public JButton[][] getGameBoardButtons() {
		return gameBoardButtons;
	}

}

/*	private class ButtonListener implements ActionListener{

@Override
public void actionPerformed(ActionEvent e) {

	for(int r = 0; r < numRow; r++)
		for(int c = 0; c < numCol; c++)
			if(e.getSource() == gameBoardButtons[r][c]){
				gameBoardButtons[r][c]
			}
				
	
}

}*/
