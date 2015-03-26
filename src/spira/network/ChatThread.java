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

public class ChatThread extends Thread{
	private ServerSocket sersocket;
	private JTextArea area;
	private JTextField field;
	public ChatThread(ServerSocket socket,JTextArea area,JTextField field){
		this.sersocket=socket;
		this.area = area;
		this.field=field;
	}
	public void run() { 
		try {
			Socket socket = sersocket.accept(); 
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();


			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			PrintWriter writer = new PrintWriter(out);
			
			
			String inputLine;
			String outputLine;
		
			
				while((inputLine = reader.readLine()) != null){
					area.append(inputLine);
				}
				outputLine = field.getText();
				writer.println(outputLine);
				writer.flush();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
