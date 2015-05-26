package spira.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private ModeButton line;
	private ModeButton fillRectangle;
	private ModeButton rectangle;
	private ModeButton roundedRectangle;
	private ModeButton circle;
	private ModeButton fillCircle;
	private ModeButton pencil;

	private static final long serialVersionUID = 1L;
	private JPanel colorPanel;
	private Canvas canvas;
	private JComboBox<Integer> sizes;
	private JButton clear;

	public PaintFrame() {
		setSize(900, 900);
		setTitle("Paint :)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		sizes = new JComboBox<Integer>();
		for (int i = 0; i < 6; i++) {
			sizes.addItem(i + 1);
		}

		canvas = new Canvas(600, 600);
		rectangle = new ModeButton(new RectangleListener(canvas), "Rectangle");
		roundedRectangle = new ModeButton(new RoundedRectangleListener(canvas),
				"RoundedRectangle");
		circle = new ModeButton(new CircleListener(canvas), "Circle");
		line = new ModeButton(new LineListener(canvas), "Line");
		pencil = new ModeButton(new PencilListener(canvas), "Pencil");
		clear = new JButton();
		clear.setText("Clear");
		// clear.setIcon(new ImageIcon("clear.jpg"));
		fillRectangle = new ModeButton(new FillRectangleListener(canvas),
				"Fill Rectangle");
		fillCircle = new ModeButton(new FillCircleListener(canvas),
				"Fill Circle");

		rectangle.addActionListener(action);
		roundedRectangle.addActionListener(action);
		circle.addActionListener(action);
		line.addActionListener(action);
		pencil.addActionListener(action);
		fillRectangle.addActionListener(action);
		fillCircle.addActionListener(action);
		sizes.addActionListener(combo);
		clear.addActionListener(listener);

		colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(2, 0));
		addColors();

		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new GridLayout(2, 0));

		JPanel choices = new JPanel();
		choices.setLayout(new BoxLayout(choices,BoxLayout.X_AXIS));

		shapePanel.add(rectangle);
		shapePanel.add(roundedRectangle);
		shapePanel.add(circle);
		shapePanel.add(line);
		shapePanel.add(fillRectangle);
		shapePanel.add(fillCircle);

		choices.add(shapePanel);
		choices.add(pencil);
		choices.add(clear);
		choices.add(sizes);
		choices.add(colorPanel);

		container.add(canvas, BorderLayout.CENTER);
		container.add(choices, BorderLayout.NORTH);

	}

	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ModeButton button = (ModeButton) e.getSource();
			BrushListener listener = button.getListener();
			canvas.setBrushListener(listener);
			canvas.addMouseListener(listener);
			canvas.addMouseMotionListener(listener);
		}
	};
	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (button == clear) {
				canvas.clear();
			} else {
				Color color = button.getBackground();
				canvas.setPencilColor(color);
			}
		}
	};
	ActionListener combo = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int size = (int) sizes.getSelectedItem();
			canvas.setSize(size);
		}
	};

	private void addColors() {
		Color[] color = { Color.red, Color.orange, Color.yellow, Color.green,
				Color.blue, Color.CYAN, Color.pink, Color.gray,
				Color.DARK_GRAY, Color.black, Color.magenta, Color.white };

		for (int i = 0; i < color.length; i++) {
			JButton button = new JButton();
			button.setBackground(color[i]);
			button.setPreferredSize(new Dimension(40, 30));
			button.addActionListener(listener);
			colorPanel.add(button);
		}
	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

}
