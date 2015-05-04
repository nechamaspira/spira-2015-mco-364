package spira.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> queue;
	private ArrayList<Socket> al;

	public WriterThread(LinkedBlockingQueue<String> queue, ArrayList<Socket> al) {

		this.queue = queue;
		this.al = al;

	}

	public void run() {
		while (true) {
			try {
				String line = queue.take();
				for (Socket socket : al) {
					OutputStream out = socket.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(line);
					writer.flush();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
