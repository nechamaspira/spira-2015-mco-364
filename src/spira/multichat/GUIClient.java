package spira.multichat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIClient extends JFrame implements KeyListener {

	private JTextField input;
	private JTextArea words;
	private ChatClient client;
	private JScrollPane scroll;

	public GUIClient() {
		this.setSize(300, 200);
		this.setTitle("Client");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setFocusable(true);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		input = new JTextField();
		words = new JTextArea();

		scroll = new JScrollPane(words, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		words.setLineWrap(true);
		words.setWrapStyleWord(true);

		input.addKeyListener(this);

		container.add(input, BorderLayout.SOUTH);
		container.add(scroll, BorderLayout.CENTER);

		client = new ChatClient(words);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String type = input.getText();
			client.sendInfo(type);
			input.setText("");

			JScrollBar bar = scroll.getVerticalScrollBar();
			bar.setValue(bar.getMaximum());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
