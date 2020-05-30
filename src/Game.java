/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 */

import java.awt.Canvas;
// this is main class where it controls/invokes all other classes
public class Game extends Canvas implements Runnable {
	// variables
	private volatile boolean running=false,pause=false,gameOver=false;
	private Window window;
	private  final  int WIDTH=900,HEIGHT=700;
	private Spawn spawn;
	private Handler handler;
	private Thread thread1;
	//constructor initializing variables
	public Game()
	{	thread1=new Thread(this);
		window =new Window(WIDTH,HEIGHT,this);
		
		handler =new Handler();
		spawn =new Spawn (running);
		
		
	}
	
//main method where it calls the constuctor	
	public static void main(String[] args) {
		new Game();

	}
// overriding the method in Runnable interface. it is invoked when thread starts
	//Note: this contains the main game loop 
	@Override
	public void run() {
		long before=System.currentTimeMillis();
		long timer=System.currentTimeMillis();
		long target=1000/60;
		int frames=0;
		while(running)
		{
			update();
			render();
			frames++;
		long diff=System.currentTimeMillis()-before;
		long sleep=target-diff;
		if(sleep>0)
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if((System.currentTimeMillis()-timer)>1000) {
			System.out.println(frames);
			frames=0;
			timer+=1000;
		}
		
		before=System.currentTimeMillis();
	}}
// start threads
	public synchronized void start() {
		
		Thread player =new Thread(this);
		thread1.start();
		running=true;
		spawn=new Spawn(running);
		spawn.start();
		
	}
	//stop threads
	public synchronized void stop() {
		thread1.stop();
		running=false;
		
	}
	//this method will be used to update the x,y coordinates of player/obstacles 
	public void update() {
		
	}
	// this will update the graphics
	public void render() {
		
	}

}
