package spira.multichat;

public class Main {

	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
		Server server = new Server();
			}};
			t.start();
			for (int i = 0; i < 3; i++) {
				Thread thread = new Thread() {
					public void run() {

						GUIClient client1 = new GUIClient();
						client1.setVisible(true);
					}
				};
				
				thread.start();
			}
		
	}

}
