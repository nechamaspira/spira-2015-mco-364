package spira.paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class DrawListener extends BrushListener {

	private Canvas canvas;
	private int lastX;
	private int lastY;
	private Point p1;
	private Point p2;
	private String option;
	
	
	//private int thicknes;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		Graphics2D graphics = (Graphics2D) canvas.getImage().getGraphics();
		graphics.setColor(canvas.getPencilColor());
		graphics.setStroke(new BasicStroke(canvas.getTheSize()));

		option = canvas.getOption();
		
		int x = Math.min(p1.x, p2.x);
		int y = Math.min(p1.y, p2.y);
		
		switch (option) {

		case "Rectangle":
			graphics.drawRect(x, y, Math.abs(p1.x - p2.x),
					Math.abs(p1.y - p2.y));
			break;
		case "Rounded Rectangle":
			graphics.drawRoundRect(x, y, Math.abs(p1.x - p2.x),
					Math.abs(p1.y - p2.y), 50, 25);
			break;
		case "Circle":
			graphics.drawOval(x, y, Math.abs(p1.x - p2.x),
					Math.abs(p1.y - p2.y));
			break;
		}

		canvas.setPointPressed(null);
		canvas.setPointDragged(null);
		p1 = null;
		p2 = null;
	}

	@Override
	public void mousePressed(MouseEvent event) {
		Graphics2D graphics = (Graphics2D) canvas.getImage().getGraphics();
		graphics.setColor(canvas.getPencilColor());
		graphics.setStroke(new BasicStroke(canvas.getTheSize()));

		p1 = event.getPoint();
		int x = event.getX();
		int y = event.getY();
		
		if (canvas.getOption().equalsIgnoreCase("Pencil")) {
			graphics.drawLine(x, y, x, y);
		}
		canvas.setPointPressed(p1);

		lastX = x;
		lastY = y;
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		Graphics2D graphics = (Graphics2D) canvas.getImage().getGraphics();
		graphics.setColor(canvas.getPencilColor());
		graphics.setStroke(new BasicStroke(canvas.getTheSize()));

		option = canvas.getOption();

		p2 = event.getPoint();
		int x = event.getX();
		int y = event.getY();

		if (canvas.getOption().equalsIgnoreCase("Pencil")) {
			graphics.drawLine(lastX, lastY, x, y);
			lastX = x;
			lastY = y;
		}else{
			canvas.setPointDragged(p2);
		}

		/*switch (option) {
		case "Rectangle":
		case "Rounded Rectangle":
		case "Circle":
			canvas.setPointDragged(p2);
			break;
		}*/

		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent event) {

	}

}
