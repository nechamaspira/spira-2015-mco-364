package spira.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer  {

	private JTextArea area;
	private ServerSocket serverSocket;
	private PrintWriter writer;

	public ChatServer(JTextArea area) throws IOException {
		this.area = area;

		serverSocket = new ServerSocket(8882);

		Thread t = new Thread() {
			public void run() {
				try {
					Socket socket = serverSocket.accept();

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
	}

	public void sendInfo(String line) {
		writer.println(line);
		writer.flush();
	}
}