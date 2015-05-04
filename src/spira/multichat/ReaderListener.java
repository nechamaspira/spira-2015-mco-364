package spira.multichat;

import java.net.Socket;

public interface ReaderListener {

	void onLineRead(String line) throws InterruptedException;

	void onCloseSocket(Socket socket);

}
