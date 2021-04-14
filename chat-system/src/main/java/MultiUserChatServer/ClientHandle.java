package MultiUserChatServer;

import java.io.*;
import java.net.Socket;

public class ClientHandle extends Thread {

    Socket clientSocket;

    public ClientHandle(Socket clientSocket){

        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try{
            handleClientSocket();
        }
        catch (Exception e){

        }
    }

    private void handleClientSocket() throws IOException {

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line=reader.readLine())!= null){

            if(line.equalsIgnoreCase("quit")){
                break;
            }

            String msg = "You typed: "+line+"\n";
            outputStream.write(msg.getBytes());

        }

        clientSocket.close();


    }
}
