package spira.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Canvas canvas;
	private JComboBox<String> box;
	private JComboBox<Integer> sizes;
	private JButton clear;

	public PaintFrame() {
		setSize(900, 900);
		setTitle("Paint :)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		sizes = new JComboBox<Integer>();
		for(int i =0;i<6;i++){
			sizes.addItem(i+1);
		}
		sizes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int size = (int) sizes.getSelectedItem();
				canvas.setSize(size);
			}
		});
		box = new JComboBox<String>();
		box.addItem("Pencil");
		box.addItem("Rectangle");
		box.addItem("Rounded Rectangle");
		box.addItem("Circle");
		box.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String type = (String) box.getSelectedItem();
				canvas.setOption(type);
			}
		});
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		addColors();
		//put eraser on button
		clear = new JButton("Clear");
		
		setAction(clear);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout());
		panel2.add(box);
		panel2.add(clear);
		panel2.add(sizes);
		panel2.add(panel);
		
		canvas = new Canvas(600, 600);
		//DrawListener listener = new DrawListener(canvas);
		BrushListener listener = new DrawListener(canvas);

		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);

		container.add(canvas, BorderLayout.CENTER);
		container.add(panel2, BorderLayout.NORTH);

	}

	private void addColors() {
		Color[] color = { Color.red, Color.orange, Color.yellow, Color.green,
				Color.blue, Color.CYAN, Color.pink, Color.gray,
				Color.DARK_GRAY, Color.black, Color.magenta ,Color.white};

		for (int i = 0; i < color.length; i++) {
			JButton button = new JButton();
			button.setBackground(color[i]);
			button.setPreferredSize(new Dimension(0,50));
			setAction(button);
			panel.add(button);
		}

	}

	private void setAction(JButton button) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				if(button == clear){
					canvas.clear();
				}
				else{
				Color color = button.getBackground();
				canvas.setPencilColor(color);
			}}
		});
	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

}
