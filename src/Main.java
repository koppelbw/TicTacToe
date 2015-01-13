/* *****************************************************************************
 * Project: TicTacToe.java
 * File: Main.java
 * Description: Simple TicTacToe simulator implemented using Java Swing and MVC format.
 * Author: William Koppelberger
 * Date: 1/13/15
 * *****************************************************************************/
public class Main {

	public static void main(String[] args) {
		
		Model gameModel = new Model();
		View gameView = new View(3,3);
		Controller gameController = new Controller(gameModel, gameView);
		
		gameView.setVisible(true);
	}
}
