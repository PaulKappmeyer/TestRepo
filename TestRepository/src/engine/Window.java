package engine;

import java.awt.image.BufferStrategy;
import java.awt.Insets;
import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	public int insetX;
	public int insetY;
	private BufferStrategy strat;
	
	public Window(String title, int width, int height) {
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(false);
		this.setVisible(true);
		this.setResizable(false);
		
		createBufferStrategy(2);
		strat = getBufferStrategy();
		
		Insets i = getInsets();
		insetX = i.left;
		insetY = i.top;
		
		this.setSize(width + insetX + i.right, height + insetY + i.bottom);
		this.setLocationRelativeTo(null);
	}
	
	public Graphics beginDrawing() {
		return strat.getDrawGraphics();
	}
	
	public void endDrawing(Graphics g){
		g.dispose();
		strat.show();
	}
}
