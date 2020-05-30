
import java.awt.Component;

import javax.swing.JFrame;
public class Window extends JFrame{
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
