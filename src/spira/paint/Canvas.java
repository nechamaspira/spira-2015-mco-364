package spira.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private Color pencilColor;
	private BufferedImage image;
	private Point pointPressed;
	private Point pointDragged;
	private int width;
	private int height;
	private int size;
	private BrushListener listener;

	public BrushListener getListener() {
		return listener;
	}

	public Canvas(int width, int height) {
	

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);	
		size = 1;
		graphics.setStroke(new BasicStroke(size));

		pencilColor = Color.black;

		this.width = width;
		this.height = height;
	}

	public void clear() {
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setStroke(new BasicStroke(size));

		g.drawImage(image, 0, 0, null);
		g.setColor(pencilColor);
		if (listener != null && pointPressed != null) {
			listener.draw(g);
		}
	}

	public BufferedImage getImage() {
		return image;
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

	public Color getPencilColor() {
		return pencilColor;
	}

	public void setPencilColor(Color pencilColor) {
		this.pencilColor = pencilColor;
	}

	public void setSize(int size) {
		this.size = size;

	}

	public int getTheSize() {
		return this.size;

	}

	public void setBrushListener(BrushListener listener) {
		this.listener = listener;
	}
}
