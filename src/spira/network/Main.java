package spira.network;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		GUIServer gui;
		try {
			gui = new GUIServer();
			gui.setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GUIClient guiClient = new GUIClient();
		guiClient.setVisible(true);
	}

}
