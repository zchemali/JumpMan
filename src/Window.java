
/**
 * This is just the JFrame created and its invoked from @Game constructor
 *
 * @author zchem
 *@version 1.0
 *
 */

import javax.swing.JFrame;

public class Window extends JFrame {
	/**
	 * Constructor that sets the parameters for the JFrame Note: Maybe I can add the
	 * main screen here
	 * 
	 * @param width  of JFRAME
	 * @param height of JFrame
	 * @param game   adding the game to the frame
	 */
	public Window(int width, int height, Game game) {

		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Jump Man Game");
		setBounds(0, 0, width, height);
		setLocationRelativeTo(null);// when the Game runs its in the middle of the screen instead of the corner

		this.add(game);
		game.start();// starts the thread

	}
}
