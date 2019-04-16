package engine;

import java.awt.Graphics;

public abstract class Game {
	public abstract void update(float tslf);
	public abstract void draw(Graphics graphics);	
	
	private Window gameWindow;
	
	public void run() {
		
		gameWindow = new Window("Eden", 1280, 860);
		
		long lastFrame = System.currentTimeMillis();
		while(true){
			long thisFrame = System.currentTimeMillis();
			float tslf = (float)(thisFrame - lastFrame) / 1000f;
			lastFrame = thisFrame;
			
			update(tslf);
			
			Graphics g = gameWindow.beginDrawing();
			draw(g);
			gameWindow.endDrawing(g);
		}
	}
}
