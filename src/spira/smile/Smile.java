package spira.smile;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Smile extends JFrame {

	public Smile() {
		setSize(400,400);
		setTitle("SMILE :)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(new SmileComponent());
	}

	public static void main(String[] args) {
		Smile smile = new Smile();
		smile.setVisible(true);

		Thread t = new Thread() {// making an anonymous class ,a class within a
									// class
			public void run() {
				while (true) {
					smile.repaint();
					try {
						Thread.sleep(40);// gonna stop thread and 100 milisecond
											// which is 1 second
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t.start();
	}
}
