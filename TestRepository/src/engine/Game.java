package engine;

import java.awt.Graphics;

public abstract class Game {
	public abstract void update();
	public abstract void draw(Graphics graphics);	
	
	private Window gameWindow;
	
	public void run() {
		
		gameWindow = new Window("Eden", 1280, 860);
		
		while(true) {
			update();
			
			Graphics g = gameWindow.beginDrawing();
			draw(g);
			gameWindow.endDrawing(g);
		}
	}
}
