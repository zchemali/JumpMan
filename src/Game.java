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
// this is main class where it controls/invokes all other classes
public class Game extends Canvas implements Runnable {
	// variables
	private volatile boolean running=false,pause=false,gameOver=false;
	private Window window;
	
	public static  final  int WIDTH=800,HEIGHT=600;
	private Handler handler;
	private Thread thread1;
	private Actions actions; 
	private Camera cam;
	private int frames=0;
	private BufferedImage image,backGround,backGround2,backGround3;
	static Texture texture;
	//constructor initializing variables
	public Game()
	{	BufferedImageLoader loader =new BufferedImageLoader();
		
		thread1=new Thread(this);
		window =new Window(WIDTH,HEIGHT,this);
		backGround=loader.loadImage("/country-platform-back.png");
		backGround2=loader.loadImage("/country-platform-tiles-example.png");
		handler =new Handler();
		texture=new Texture();
		image=loader.loadImage("/Map.PNG");
		loadMap(image);
		handler.createEnemy();
		handler.addObject(new HealthPlayer(0, 0, Tag.Health, null));
		this.addKeyListener(new Actions(handler));
		//handler.addObject(new Player(70, 100, Tag.Player));
		
		cam=new Camera(0,0);
		//System.out.println(handler.chars.size());
		
	}
	
//main method where it calls the constuctor	
	public static void main(String[] args) {
		new Game();

	}
// overriding the method in Runnable interface. it is invoked when thread starts
	//Note: this contains the main game loop 
	@Override
	public void run() {
		
		int ticks=0;
		long before=System.currentTimeMillis();
		long timer=System.currentTimeMillis();
		long target=1000/60;
		
		while(running)
		{	
			try{
				update();
			}catch (Exception e)
			
		{System.err.println("GameLoop Line 74");}
		ticks++;
		try {
			render();}catch (Exception e)
		{System.err.println("Game Loop Line 78");}
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
		/*else
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		if((System.currentTimeMillis()-timer)>1000) {
			System.out.println(frames);
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
		for (int i=0;i<handler.gameObjects.size();i++)
		{
			if(handler.gameObjects.get(i).tag==Tag.Player)
				cam.update(handler.gameObjects.get(i));}
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
		g.setColor(new Color(130,182,255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//Shifting th x,y coordinates by tx=Width/2 and ty=height/2
		g2d.translate(cam.getX(), cam.getY());
		for (double xx=-200;xx<=6000;xx+=200) {
		g.drawImage(backGround,(int) xx, 200, 1000,1000, this);
		g2d.drawImage(backGround2,(int) xx, 300, 1000,700, this);}
		handler.render(g);
		
		g2d.translate(-cam.getX(),-cam.getY());
	/**	for (int i =0 ;i<5;i++)
	 * 
		{	g.drawImage(player[i], 100, 100,50,60,this);
		//System.out.println(i);
		}**/
			
		
		
		g.dispose();
		bs.show();
		

}
	public void loadMap (BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
		for (int xx=0; xx<h;xx++) {
			for(int yy=0;yy<w;yy++) {
				int pixel=image.getRGB(xx, yy);
				int red =(pixel >> 16) & 0xff;
				int green =(pixel >> 8) & 0xff;
				int blue =(pixel) & 0xff;
				//white blocks
				if (red==255 && green ==255 && blue==255)
				{
					//System.out.println(red + green+ blue);
					handler.addObject(new PlatForm (xx*32,yy*32,Tag.Block1,texture) );
				}
				//light grey vlocks
				else if (red==64 && green==64 &&blue ==64) {
					handler.addObject(new PlatForm (xx*32,yy*32,Tag.Block2,texture) );	
				}
				else if(red==0 && green==0 && blue==128) {
					handler.addObject(new Player (xx*32,yy*32-90,Tag.Player,texture));
				}
				else if (red ==0 && green==255 && blue==255) {
					handler.addObject(new MovingObsticale(xx*32, yy*32, Tag.Obstacle1,texture));
				}
				else if (red ==255 && green==0 && blue==0) {
					handler.addObject(new UpDown(xx*32, yy*32, Tag.Obstacle2,texture));
				}
				//else if (red ==0 && green==255 && blue==33) {
					//handler.addObject(new PlatForm(xx*32, yy*32, Tag.Tree,texture));
				//}
			}
			
		}
		
	}
	

}
