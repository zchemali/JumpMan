/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 * 
 *          this class will spawn obstacles and the platform and the platform
 *          possibly, it will have its own thread
 */

public class Spawn implements Runnable {

	// variables
	private boolean running;
	private Handler handler;
	private Thread thread;

	/**
	 * constructor, it gets the running status from the Game class
	 * 
	 * @see Game.java
	 * @param running it gets the running status from the Game class
	 */
	public Spawn(boolean running) {

		this.running = running;
		thread = new Thread(this);
		handler = new Handler();

	}

	/**
	 * Overrides the method in runnable interface which is invoked my thread.start
	 */
	@Override
	public void run() {
		long timer = System.currentTimeMillis();
		// i might make this another game loop with spawn/reder/update
		while (running) {
			// System.out.println(thread.getId());
			if ((System.currentTimeMillis() - timer) > 2000) {
				handler.addObject(new Obstacle(1000, 700, Tag.Obstacle1));

			}

		}

	}

	// start of thread
	public synchronized void start() {

		thread = new Thread(this);
		thread.start();
	}

//stop thread
	public synchronized void stop() {

		Thread thread = new Thread(this);
		thread.stop();
	}
}
