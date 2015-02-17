package spira.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import spira.smile.SmileComponent;

public class Snake extends JFrame implements KeyListener {

	public Snake() {
		setSize(800, 600);
		setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new SnakeComponent());
		SnakeComponent comp = new SnakeComponent();
		
		comp.addKeyListener(this);
		comp.setFocusable(true);
		contentPane.add(comp);

	}

	public static void main(String[] args) {
		Snake snake = new Snake();
		snake.setVisible(true);
		Thread t = new Thread() {// making an anonymous class ,a class within a
			// class
			public void run() {
				while (true) {
					snake.repaint();
					try {
						Thread.sleep(50);// gonna stop thread and 100 milisecond
											// which is 1 second
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t.start();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// 4 or left arrow then turn left
		// 6 or right arrow then turn right
		System.out.println("key pressed");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
