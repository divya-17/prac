package MultiUserChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/*
Explaination video:

https://www.youtube.com/watch?v=cRfsUrU3RjE
 */

public class SimpleSocketProgram {


    public static void main(String[] args) throws IOException, InterruptedException {

        int portNumber = 8881;
        ServerSocket socket = new ServerSocket(portNumber);

        // Accept keep waiting for client and return client socket as soon as some client tries to connect
        System.out.println("Waiting for client connection -->");

        while (true) {
            Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from " + clientSocket);
            ClientHandle handle = new ClientHandle(clientSocket);
            handle.start();
        }
    }

}
