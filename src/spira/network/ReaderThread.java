package spira.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


//how is this polymorphysm
public class ReaderThread extends Thread {

	private Socket socket;
	private ReaderListener listener;//all listeners are interfaces, cuz we know abt listeners are methods not data.
	//didnt make a setReaderListener cuz we dont want user to have to right set...
	public ReaderThread(Socket socket, ReaderListener listener){
		this.socket=socket;
		this.listener= listener;
	}
	//check out runnable!
	
	
	public void run(){//goal of thread is to read individual lines and then do somthing wiht it
		try {
			InputStream in = socket.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line;
			
			while((line = reader.readLine()) != null){
				//System.out.println(line);
				listener.onLineRead(line);//tell listener that read line.
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		listener.onCloseSocket(socket);//close socket
		
	}
}
