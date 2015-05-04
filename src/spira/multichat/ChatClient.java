package spira.multichat;

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

import org.apache.commons.io.IOUtils;

public class ChatClient implements ReaderListener {

	private JTextArea area;
	private PrintWriter writer;
	private Socket socket;

	public ChatClient(JTextArea area) {
		this.area = area;

		try {
			socket = new Socket("localhost", 3749);

			OutputStream out = socket.getOutputStream();
			writer = new PrintWriter(out);

			ReaderThread t = new ReaderThread(socket, this);
			t.start();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void sendInfo(String line) {
		writer.println(line);
		writer.flush();

	}

	@Override
	public void onLineRead(String line) throws InterruptedException {
		area.append(line + "\n");
	}

	@Override
	public void onCloseSocket(Socket socket) {
		IOUtils.closeQuietly(socket);
	}
}
