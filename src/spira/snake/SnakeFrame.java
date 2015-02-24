package spira.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {

	private World world;
	private WorldComponent comp;
	private Direction direc;

	public SnakeFrame() {
		setSize(645, 670);
		setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		world = new World();
		comp = new WorldComponent(world);

		comp.addKeyListener(this);
		comp.setFocusable(true);
		contentPane.add(comp);
		direc = Direction.NO_DIRECTION;

	}

	public Direction getDirection() {
		return direc;
	}

	public WorldComponent getWorldComponent() {
		return comp;
	}

	public static void main(String[] args) {
		final SnakeFrame snake = new SnakeFrame();
		snake.setVisible(true);
		GameLoopThread t = new GameLoopThread(snake);
		t.start();
		/*
		 * Thread t = new Thread() { public void run() { while (true) {
		 * snake.getWorldComponent
		 * ().getWorld().setDirection(snake.getDirection());
		 * snake.getWorldComponent().getWorld().move(); snake.repaint(); try {
		 * Thread.sleep(100); } catch (InterruptedException e) {
		 * e.printStackTrace(); } } } };
		 * 
		 * t.start();
		 */
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_8:
			if (direc != Direction.SOUTH) {
				direc = Direction.NORTH;
			}
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_2:
			if (direc != Direction.NORTH) {
				direc = Direction.SOUTH;
			}
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_6:
			if (direc != Direction.WEST) {
				direc = Direction.EAST;
			}
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_4:
			if (direc != Direction.EAST) {
				direc = Direction.WEST;
			}
			break;
		case KeyEvent.VK_ENTER:
			if (world.isGameOver()) {
				world.setGameOver(false);
				direc = Direction.NO_DIRECTION;
				world.createSnake();
			}
			if (world.isWonGame()) {
				world.setWonGame(false);
				direc = Direction.NO_DIRECTION;
				world.createSnake();
			}
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
