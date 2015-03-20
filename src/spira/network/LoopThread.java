package spira.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class LoopThread extends Thread{

	private Socket socket;
	public LoopThread(Socket socket){
		this.socket=socket;
	}
	public void run() { 
		try {

			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));// point of this
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
