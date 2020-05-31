/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
// this is main class where it controls/invokes all other classes
public class Game extends Canvas implements Runnable {
	// variables
	private volatile boolean running=false,pause=false,gameOver=false;
	private Window window;
	private  final  int WIDTH=900,HEIGHT=700;
	private Spawn spawn;
	private Handler handler;
	private Thread thread1;
	private BufferedImage spritesheet=null;
	private BufferedImage [] player;
	//constructor initializing variables
	public Game()
	{	player =new BufferedImage[5];
		thread1=new Thread(this);
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
		init();
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
		//spawn=new Spawn(running);
		//spawn.start();
		
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
	//creating bufferstragtegy so it displays graphics faster
	public void render() {
		
		
		BufferStrategy bs =this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g;
		g=bs.getDrawGraphics();
		long timer =System.currentTimeMillis();
		
		
		
		
			g.drawImage(player[0], 100, 100,50,60,this);
			
			
		
		
		g.dispose();
		bs.show();
		

}
public void init() {
	BufferedImageLoader bi= new BufferedImageLoader();
	spritesheet=bi.loadImage("/Idle__000.png");
	player[0]=spritesheet;
	spritesheet=bi.loadImage("/Idle__001.png");
	player[1]=spritesheet;
	spritesheet=bi.loadImage("/Idle__002.png");
	player[2]=spritesheet;
	spritesheet=bi.loadImage("/Idle__003.png");
	player[3]=spritesheet;
	spritesheet=bi.loadImage("/Idle__004.png");
	player[4]=spritesheet;
}
}
