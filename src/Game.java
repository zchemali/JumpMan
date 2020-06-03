/**
 * 
 * @author zchem
 * @since
 * @version 1.0
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
// this is main class where it controls/invokes all other classes
public class Game extends Canvas implements Runnable {
	// variables
	private volatile boolean running=false,pause=false,gameOver=false;
	private Window window;
	
	public static  final  int WIDTH=800,HEIGHT=600;
	private Handler handler;
	private Thread thread1;
	private BufferedImage spritesheet=null;
	private BufferedImage [] player;
	private Actions actions; 
	private Camera cam;
	//constructor initializing variables
	public Game()
	{	player =new BufferedImage[5];
		thread1=new Thread(this);
		window =new Window(WIDTH,HEIGHT,this);
		handler =new Handler();
		handler.createLevel();
		this.requestFocusInWindow();
		this.addKeyListener(new Actions(handler));
		handler.addObject(new Player(70, 100, Tag.Player));
		cam=new Camera(0,0);
		System.out.println(handler.chars.size());
		
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
		int ticks=0;
		long before=System.currentTimeMillis();
		long timer=System.currentTimeMillis();
		long target=1000/60;
		int frames=0;
		while(running)
		{	
			update();
		ticks++;
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
		else
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if((System.currentTimeMillis()-timer)>1000) {
			//System.out.println(frames);
			frames=0;
			timer+=1000;
		}
		
		before=System.currentTimeMillis();
	}}
// start threads
	public synchronized void start() {
		
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
		handler.update();
		for (int i=0;i<handler.chars.size();i++)
		{
			if(handler.chars.get(i).tag==Tag.Player)
				cam.update(handler.chars.get(i));}
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
		Graphics2D g2d =(Graphics2D) g;
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g2d.translate(cam.getX(), cam.getY());
		handler.render(g);
		g2d.translate(-cam.getX(),-cam.getY());
	/**	for (int i =0 ;i<5;i++)
		{	g.drawImage(player[i], 100, 100,50,60,this);
		//System.out.println(i);
		}**/
			
		
		
		g.dispose();
		bs.show();
		

}
public void init() {
	
	BufferedImageLoader bi= new BufferedImageLoader();
	spritesheet=bi.loadImage("/Jump__000.png");
	player[0]=spritesheet;
	spritesheet=bi.loadImage("/Jump__001.png");
	player[1]=spritesheet;
	spritesheet=bi.loadImage("/Jump__002.png");
	player[2]=spritesheet;
	spritesheet=bi.loadImage("/Jump__003.png");
	player[3]=spritesheet;
	spritesheet=bi.loadImage("/Jump__004.png");
	player[4]=spritesheet;
}
}
