package spira.paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener,
		MouseMotionListener {

	protected Point pointPressed;
	protected Point pointDragged;
	protected Point lastPoint;
	protected Graphics2D graphics;

	protected Canvas canvas;
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public BrushListener(Canvas canvas) {
		this.canvas = canvas;
		graphics = (Graphics2D) this.canvas.getImage().getGraphics();
	}

	public Point getPointPressed() {
		return pointPressed;
	}

	public void setPointPressed(Point pointPressed) {
		this.pointPressed = pointPressed;
	}

	public Point getPointDragged() {
		return pointDragged;
	}

	public void setPointDragged(Point pointDragged) {
		this.pointDragged = pointDragged;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		pointDragged = e.getPoint();

		graphics.setColor(canvas.getPencilColor());
		graphics.setStroke(new BasicStroke(canvas.getTheSize()));

		canvas.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {

		graphics.setColor(canvas.getPencilColor());
		graphics.setStroke(new BasicStroke(canvas.getTheSize()));

		pointPressed = e.getPoint();

		canvas.setPointPressed(pointPressed);
		lastPoint = pointPressed;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		graphics.setColor(canvas.getPencilColor());
		graphics.setStroke(new BasicStroke(canvas.getTheSize()));

		canvas.getListener().draw(graphics);

		pointPressed = null;
		pointDragged = null;
		canvas.setPointPressed(null);
		canvas.setPointDragged(null);
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

	abstract public void draw(Graphics g);

}
