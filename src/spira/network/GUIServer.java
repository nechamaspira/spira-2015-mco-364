package spira.network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIServer extends JFrame implements KeyListener {

	private JTextField input;
	private JTextArea words;
	private ChatServer server;
	private JScrollPane scroll;

	public GUIServer() throws IOException {
		this.setSize(300, 200);
		this.setTitle("Server");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setFocusable(true);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		input = new JTextField();
		words = new JTextArea();

		scroll = new JScrollPane(words, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		words.setLineWrap(true);
		words.setWrapStyleWord(true);
		
		input.addKeyListener(this);

		container.add(input, BorderLayout.SOUTH);
		container.add(scroll, BorderLayout.CENTER);

		server = new ChatServer(words);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String type = input.getText();
			words.append("Me: " + type + "\n");
			server.sendInfo("Nechama: " + type );
			input.setText("");

			JScrollBar bar = scroll.getVerticalScrollBar();
			bar.setValue(bar.getMaximum());
		}
		
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