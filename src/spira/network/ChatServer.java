package spira.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	
	public static void main(String[] args) {

		
		try {

			ServerSocket serverSocket = new ServerSocket(3745);// listen for the
																// other socket
			while (true) {

				Socket socket = serverSocket.accept(); 

				LoopThread t = new LoopThread(socket) ;
					
				t.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

}}
