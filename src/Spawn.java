
public class Spawn implements Runnable {
	
	
	
	private boolean running;
	private Handler handler;
	private Thread thread;
	public Spawn(boolean running) {
	
		this.running=running;
		thread=new Thread(this);
		handler=new Handler();
			
		
	}
	@Override
	public void run() {
		long timer=System.currentTimeMillis();
		//game loop with spawn/reder/update
		while (running) {
			//System.out.println(thread.getId());
		if((System.currentTimeMillis()-timer)>2000) {
			handler.addObject(new Obsticales(1000,700,Tag.Obstical));
		
		}
			
		}
		
		
	}
	
public synchronized void start(){
	
 thread =new Thread(this);
			thread.start();
}
public synchronized void stop(){
	
	Thread thread =new Thread(this);
			thread.stop();
}}
