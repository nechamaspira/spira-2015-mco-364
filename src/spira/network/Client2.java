package spira.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 3748);// socket blocks!

			// wanna write somthing to the socket
			OutputStream out = socket.getOutputStream();

			// wanna work with other things as apposed to byte which
			// outputstream does
			PrintWriter writer = new PrintWriter(out);

			writer.println("THIS IS SECOND ONE");
			
			writer.flush(); // flush pushes the data from the println to the
							// other side

		
		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}// socket cares abt ip address and port. localhost conncts u to ur own
			// socket-port
		

		finally {
			// IOUtils.closeQuietly(socket); //must include the jarfile of
			// apachi before use it
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
