package spira.paint;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener, MouseMotionListener{

	protected Point pointPressed;
	protected Point pointDragged;
	
	Canvas canvas;
	
	private BrushListener(Canvas canvas){
		this.canvas = canvas;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	
		pointDragged= e.getPoint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pointPressed = e.getPoint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		draw(canvas.getImage().getGraphics());
		
	}

	abstract public void draw(Graphics g);
	
	
	
}
