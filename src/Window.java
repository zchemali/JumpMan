/**
 * 
 * @author zchem
 *@version 1.0
 *this is just the JFrame created and its invoked from Game constructor
 *@see Game.java constructor
 */

import javax.swing.JFrame;
public class Window extends JFrame{
	/**
	 * 
	 * @param width of JFRAME
	 * @param height of JFrame
	 * @param game adding the game to the frame 
	 */
	public Window (int width,int height,Game game ) {
		
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Jump Man Game");
		this.add(game);
		game.start();
		
	}
}
