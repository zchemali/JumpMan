package gameSetup;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/** 
 * This is just the JFrame created and its invoked from @Game constructor 
 *{@link #paint(Graphics)}
 * @author zchem
 *@version 1.0
 *
 */
public class Window extends JFrame {
	JButton start;
	JPanel panel;
	JLabel label;
	BufferedImage image;
	Canvas canvas;
	/**
	 * Constructor that sets the parameters for the JFrame Note: Maybe I can add the
	 * main screen here
	 * 
	 * @param width  of JFRAME
	 * @param height of JFrame
	 * @param game   adding the game to the frame
	 * @param backGround 
	 */
	public Window(int width, int height, Game game, BufferedImage backGround) {
		this.image=backGround;
		canvas=new Canvas();
		canvas.setVisible(true);
		start=new JButton("Press to Start");
		start.setFont(new Font ("",1,20));
		start.setPreferredSize(new Dimension(200,50));
		panel=new JPanel();
		label=new JLabel();
		//need layout to have both the button and background on the window screen
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c =new GridBagConstraints();
		//Constraints for the Background screen
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		panel.add(canvas);
		panel.repaint();//invokes the paint method
		//adds a button to mid screen
		c.fill=GridBagConstraints.NONE;
		c.gridx=4;
		c.gridy=4;
		panel.add(start);
		add(panel);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==start) {
					panel.setVisible(false);
					add(game);
					game.start();
				}
			}
		});

		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Ninja Boy");
		setBounds(0, 0, width, height);
		
		setLocationRelativeTo(null);// when the Game runs its in the middle of the screen instead of the corner
		// starts the thread

	}
	/**
	 * This method overrides the paint method to print the background of the Window
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image,0, 0, 1000, 1000, this);
	}
	
}
