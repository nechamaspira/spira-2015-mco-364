package spira.network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements KeyListener {

	private JTextField input;
	private JTextArea words;
	
	public GUI() {
		this.setSize(300, 200);
		this.setTitle("Hangman");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.addKeyListener(this);
		this.setFocusable(true);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		input = new JTextField();
		words = new JTextArea();
		input.addKeyListener(this);
		container.add(input, BorderLayout.SOUTH);
		container.add(words, BorderLayout.CENTER);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			String type = input.getText();
			words.append(type + "\n");
			input.setText("");
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

	public static void main(String args[]){
		GUI gui = new GUI();
		gui.setVisible(true);
	}
}
