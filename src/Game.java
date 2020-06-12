
/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 */
import Game_ch.*;
import Image_editors.BufferedImageLoader;
import Image_editors.Texture;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This is main class where it controls/invokes all other classes . This class
 * contains the game loop which invokes methods in @handler class to update()
 * and render()
 * 
 * @author zchem
 *
 */
public class Game extends Canvas implements Runnable {
	// variables
	private volatile boolean running = false, pause = false, gameOver = false;
	private Window window;
	public static final int WIDTH = 800, HEIGHT = 600;
	private Handler handler;
	private Thread thread1;
	private Actions actions;
	private Camera cam;
	private int frames = 0;
	private BufferedImage image, backGround, backGround2, backGround3;
	static Texture texture;

	/**
	 * Constructor for the Class
	 */
	public Game() {
		BufferedImageLoader loader = new BufferedImageLoader();
		thread1 = new Thread(this);
		window = new Window(WIDTH, HEIGHT, this);// calling window class
		backGround = loader.loadImage("/country-platform-back.png");// loading background image1
		backGround2 = loader.loadImage("/country-platform-tiles-example.png");// loading background image2
		handler = new Handler();// creating an instance of handler class
		texture = new Texture();// creating instance of Texture class w
		image = loader.loadImage("/Map.PNG");// loading map image
		loadMap(image);/** invoking a method in this class to create the map @see loadMap() */
		handler.createEnemy();///////// Temp.
		this.addKeyListener(new Actions(handler));// Creating actions
		cam = new Camera(0, 0);// creating instance of camera class
	}

//main method where it calls the Constuctor	
	public static void main(String[] args) {
		new Game();

	}

	/**
	 * Overriding the method in Runnable interface. it is invoked when thread starts
	 * Note: this contains the main game loop
	 */
	@Override
	public void run() {
		// Variables needed to calculate the target FPS and sleeping time for thread
		long before = System.currentTimeMillis();
		long timer = System.currentTimeMillis();
		long target = 1000 / 60;
		// Main loop
		while (running) {
			try {
				update();
			} catch (Exception e)

			{
				System.err.println("GameLoop Line 74");
			}
			try {
				render();
			} catch (Exception e) {
				System.err.println("Game Loop Line 78");
			}
			frames++;
			long diff = System.currentTimeMillis() - before;
			long sleep = target - diff;
			if (sleep > 0)
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					System.out.println("Line 95");
				}
			/*
			 * Temp else try { Thread.sleep(1); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			// prints FPS and resets Frames
			if ((System.currentTimeMillis() - timer) > 1000) {
				System.out.println(frames);
				frames = 0;
				timer += 1000;
			}

			before = System.currentTimeMillis();
		}
	}

	/**
	 * Method to start the thread
	 */
	public synchronized void start() {

		thread1.start();
		running = true;
	}

	/**
	 * Method to Stop the Thread
	 */
	public synchronized void stop() {
		thread1.stop();
		running = false;

	}

	/**
	 * This method will be used to update the x,y coordinates of player/obstacles
	 * Also will update the x,y coordinates of Camera class so the window translates
	 * with the player
	 */
	public void update() {
		handler.update();
		for (int i = 0; i < handler.gameObjects.size(); i++) {
			if (handler.gameObjects.get(i).tag == Tag.Player)
				cam.update(handler.gameObjects.get(i));
		}
	}

	/**
	 * This method will update the graphics Creating Bufferstragtegy so it displays
	 * graphics faster
	 */
	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g;
		g = bs.getDrawGraphics();
		// setting color for the window
		g.setColor(new Color(130, 182, 255));
		g.fillRect(0, 0, WIDTH * 4, HEIGHT);
		// casting to 2d so we can use translate method to move camera
		Graphics2D g2d = (Graphics2D) g;
		// Shifting the x,y coordinates by tx=Width/2 and ty=height/2
		g2d.translate(cam.getX(), cam.getY());
		// for loop to repeat the background image NOTE: it is drawn before invoking
		// render() method
		for (double xx = -200; xx <= 6000; xx += 200) {
			g.drawImage(backGround, (int) xx, 200, 1000, 1000, this);
			g2d.drawImage(backGround2, (int) xx, 300, 1000, 700, this);
		}
		// updating grahics of GameObjects
		handler.render(g);
		g2d.translate(-cam.getX(), -cam.getY());
		g.dispose();
		bs.show();

	}

	/**
	 * This method gets the map and reads every pixel and converts the pixels to RGB
	 * color Then Game Objects are created based on color of the pixel
	 * 
	 * @param image passed from Constructor {@link #Game()}
	 */
	public void loadMap(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		for (int xx = 0; xx < h; xx++) {
			for (int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				// white blocks
				if (red == 255 && green == 255 && blue == 255) {
					// System.out.println(red + green+ blue);
					handler.addObject(new PlatForm(xx * 32, yy * 32, Tag.Block1, texture));
				}
				// light grey vlocks
				else if (red == 64 && green == 64 && blue == 64) {
					handler.addObject(new PlatForm(xx * 32, yy * 32, Tag.Block2, texture));
				} else if (red == 0 && green == 0 && blue == 128) {
					handler.addObject(new Player(xx * 32, yy * 32 - 90, Tag.Player, texture));
				} else if (red == 0 && green == 255 && blue == 255) {
					handler.addObject(new MovingObsticale(xx * 32, yy * 32, Tag.Obstacle1, texture));
				} else if (red == 255 && green == 0 && blue == 0) {
					handler.addObject(new UpDown(xx * 32, yy * 32, Tag.Obstacle2, texture));
				}
				// Temp.
				// else if (red ==0 && green==255 && blue==33) {
				// handler.addObject(new PlatForm(xx*32, yy*32, Tag.Tree,texture));
				// }
			}

		}

	}

}
