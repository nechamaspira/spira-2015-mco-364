package spira.paint;

import javax.swing.JButton;

public class ModeButton extends JButton {

	private BrushListener listener;
	private String item;
	
	public ModeButton(BrushListener listener,String item){
		this.listener = listener;
		this.item = item;
		this.setText(item);
	}
	
	public BrushListener getListener(){
		return listener;
	}
}
