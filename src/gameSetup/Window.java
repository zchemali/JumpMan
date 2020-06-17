package gameSetup;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This is just the JFrame created and its invoked from @Game constructor
 *
 * @author zchem
 *@version 1.0
 *
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	JButton start;
	JPanel panel;
	JLabel label;

	/**
	 * Constructor that sets the parameters for the JFrame Note: Maybe I can add the
	 * main screen here
	 * 
	 * @param width  of JFRAME
	 * @param height of JFrame
	 * @param game   adding the game to the frame
	 */
	public Window(int width, int height, Game game) {
		//temp MainScreen elemts
		start=new JButton("Start");
		panel=new JPanel();
		label=new JLabel();
		label.setText("Press Start");
		panel.setLayout(new GridLayout(0,2));
		panel.add(label);
		panel.add(start);
		panel.setBackground(Color.GREEN);
		this.setLayout(new BorderLayout());
		add(panel,BorderLayout.NORTH);
		add(game,BorderLayout.CENTER);
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==start) {
					panel.setVisible(false);
					
					game.start();
				}
			}
		});

		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Jump Man Game");
		setBounds(0, 0, width, height);
		setLocationRelativeTo(null);// when the Game runs its in the middle of the screen instead of the corner
		// starts the thread

	}
	
}
