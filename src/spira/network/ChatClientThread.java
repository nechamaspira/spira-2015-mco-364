package spira.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientThread extends Thread{
	private Socket socket;
	private JTextArea area;
	private JTextField field;
	public ChatClientThread(Socket socket,JTextArea area,JTextField field){
		this.socket=socket;
		this.area = area;
		this.field=field;
	}
	public void run() { 
		try {

			
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			PrintWriter writer = new PrintWriter(out);
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));// point of this
			
			String inputLine;
			String outputLine;
		//	String info = field.getText();

			while(true){
				outputLine = field.getText();
				writer.println(outputLine);
				writer.flush();
				
				if((inputLine = reader.readLine()) != null){
					area.append(inputLine);
				}
				
			}
			
			
			/*String info = field.getText();
			area.append(info);
			writer.flush();
			
			String inputLine;
		//	String outputLine;
			
			//GUIServer guiServer = new GUIServer();
			
			while ((inputLine = reader.readLine()) != null) {
				//System.out.println(line);
				area.append(inputLine);
				
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
