package spira.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.io.IOUtils;

public class Server implements ReaderListener {

	private LinkedBlockingQueue<String> queue;
	private ArrayList<Socket> al;

	public Server() {

		queue = new LinkedBlockingQueue<String>();
		al = new ArrayList<Socket>();

		try {

			ServerSocket serverSocket = new ServerSocket(3749);

			WriterThread thread = new WriterThread(queue, al);
			thread.start();

			while (true) {

				Socket socket = serverSocket.accept();
				al.add(socket);
				ReaderThread t = new ReaderThread(socket, this);
				t.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onLineRead(String line) throws InterruptedException {
		queue.add(line);
	}

	@Override
	public void onCloseSocket(Socket socket) {
		IOUtils.closeQuietly(socket);
	}

}
