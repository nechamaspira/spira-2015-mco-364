package spira.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> queue;
	private ArrayList<Socket> al;

	public WriterThread(LinkedBlockingQueue<String> queue, ArrayList<Socket> al) {

		this.queue = queue;
		this.al = al;
	}

	// if one socket is closed, catches an exception, - it does not go to rest
	// of sockets, - if socket is not good,closed then need to remove from list
	// if ur in middle of writing out lines to all sockets and someone adds to
	// list then the for each loop will mess up.
	// = all problems = needd to synchronized access to list
	// vector is thread safe = it is sychronized. and arraylist is not
	// iterator is to be able to do iter.remove
	public void run() {
		while (true) {
			// try {
			String line;
			try {
				line = queue.take();
				writeToSockets(line);

				/*
				 * for (Socket socket : al) { OutputStream out; try { out =
				 * socket.getOutputStream(); PrintWriter writer = new
				 * PrintWriter(out); writer.println(line); writer.flush(); }
				 * catch (IOException e) { e.printStackTrace();
				 * 
				 * }
				 * 
				 * }
				 */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/*
			 * } catch (IOException e) { e.printStackTrace(); } catch
			 * (InterruptedException e) { e.printStackTrace(); }
			 */
		}
	}

	private void writeToSockets(String line) {
		synchronized (al) {
			Iterator<Socket> iter = al.iterator();
			while (iter.hasNext()) {
				Socket s = iter.next();
				try {
					OutputStream out = s.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(line);
					writer.flush();
				} catch (IOException e) {
					iter.remove();
					e.printStackTrace();
				}
			}

		}
	}
}
