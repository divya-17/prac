package MultiUserChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class multipleUserServer extends Thread {

    private int portNumber;
    private List<multiUserClientHandle> clientHandleList = new ArrayList<>();


    public  multipleUserServer(int portNumber ){
        this.portNumber = portNumber;
    }

    @Override
    public void run() {

        int portNumber = 8881;
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accept keep waiting for client and return client socket as soon as some client tries to connect
        System.out.println("Waiting for client connection -->");

        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = socket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Accepted connection from " + clientSocket);
            multiUserClientHandle handle = null;
            try {
                handle = new multiUserClientHandle(clientSocket,this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientHandleList.add(handle);
            handle.start();
        }
    }

    public List<multiUserClientHandle> getAllConnectedClients (){
        return clientHandleList;
    }
}
