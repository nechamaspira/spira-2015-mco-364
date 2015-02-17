package spira.snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SnakeComponent extends JComponent  {



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		g.drawRect(20 , 20, 750, 520);
	
	}
}
