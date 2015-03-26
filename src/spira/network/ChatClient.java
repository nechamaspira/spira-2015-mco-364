package spira.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient  {

	private JTextArea area;
	private PrintWriter writer;
	private Socket socket;

	public ChatClient(JTextArea area) {
		this.area = area;
		
		try {
			socket = new Socket("localhost", 8882);

			Thread t = new Thread() {
				public void run() {
					try {

						InputStream in = socket.getInputStream();
						OutputStream out = socket.getOutputStream();

						BufferedReader reader = new BufferedReader(
								new InputStreamReader(in));
						writer = new PrintWriter(out);

						String inputLine;
						
						while ((inputLine = reader.readLine()) != null) {

							area.append(inputLine);
							area.append("\n");

						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};

			t.start();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void sendInfo(String line) {
		writer.println(line);
		writer.flush();
	}
}
