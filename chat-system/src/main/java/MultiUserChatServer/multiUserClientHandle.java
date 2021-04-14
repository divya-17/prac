package MultiUserChatServer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class multiUserClientHandle extends Thread {

    private Socket clientSocket;
    private String loggedInUser;
    private List<String> groups;

    private multipleUserServer server;

    private InputStream inputStream;
    private OutputStream outputStream;

    public multiUserClientHandle(Socket clientSocket,multipleUserServer server) throws IOException {

        this.clientSocket = clientSocket;
        this.server = server;
        inputStream = clientSocket.getInputStream();
        outputStream = clientSocket.getOutputStream();
        groups = new ArrayList<>();

    }
    @Override
    public void run() {
        try{
            handleClientSocket();
        }
        catch (Exception e){
            System.out.println("Exception occured while handling clients "+e);
            e.printStackTrace();
        }
    }

    private void handleClientSocket() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line =reader.readLine()) != null){

            String [] tokens = line.split(" ");
            if(tokens != null && tokens.length > 0) {

                String cmd = tokens[0];
                if (cmd.equalsIgnoreCase("quit") || cmd.equalsIgnoreCase("logoff")) {
                    handleLogOff();
                    break;
                }
                else if(cmd.equalsIgnoreCase("login")){
                    handleLogin(tokens,outputStream);
                }
                else if(cmd.equalsIgnoreCase("msg")){
                    handleMessage(tokens,outputStream);
                }
                else if(cmd.equalsIgnoreCase("join")){
                    joinGroup(tokens,outputStream);
                }
                else if(cmd.equalsIgnoreCase("leave")){
                    leaveGroup(tokens,outputStream);
                }
                else {

                    String msg = "unknown cmd "+cmd+"\n";
                    outputStream.write(msg.getBytes());
                }
            }
        }
        // Remove current client conn from list of active connections.
        server.getAllConnectedClients().remove(this);
        clientSocket.close();
    }

    private void leaveGroup(String[] tokens, OutputStream outputStream) throws IOException {

        if(tokens.length ==2 && tokens[1].startsWith("#")){

            String groupName = tokens[1].substring(1);
            leaveGroup(groupName);
            outputStream.write(("Left group #"+groupName).getBytes());

        }
    }

    private void joinGroup(String[] tokens, OutputStream outputStream) throws IOException {

        if(tokens.length == 2 && tokens[1].startsWith("#")){
            String group = tokens[1].substring(1);
            groups.add(group);

            outputStream.write(("You are now part of group : "+group+"\n").getBytes());
        }

    }



    private void handleMessage(String[] tokens,OutputStream outputStream) throws IOException {


        if(tokens.length > 3) {

            // Group messaging
            if (tokens[1].startsWith("#")) {
                String grpName  = tokens[1].substring(1);
                for (multiUserClientHandle conn : server.getAllConnectedClients()) {

                    // All connection with same grp name
                    if(conn.getGroups() != null && conn.getGroups().size() > 0) {
                        if (conn.getGroups().contains(grpName) && !conn.getLoggedInUser().equalsIgnoreCase(loggedInUser)) {
                            StringBuilder message = new StringBuilder();
                            for (int i = 2; i < tokens.length; i++) {

                                message.append(tokens[i]);
                                message.append(" ");
                            }
                            message.append("\n");
                            conn.sendMessage("#"+grpName+" : "+ this.getLoggedInUser() + " has sent: " + message.toString()+"\n");
                        }
                    }
                }
            }

            // Direct messaging
            else {
                String targetConn = tokens[1];
                StringBuilder message = new StringBuilder();
                for (int i = 2; i < tokens.length; i++) {

                    message.append(tokens[i]);
                    message.append(" ");
                }
                message.append("\n");

                for (multiUserClientHandle conn : server.getAllConnectedClients()) {
                    if (conn.getLoggedInUser().equalsIgnoreCase(targetConn)) {
                        conn.sendMessage(this.getLoggedInUser() + " has sent: " + message.toString());
                    }
                }
            }
        }
        else {
            outputStream.write("Incorrect cmd".getBytes());
        }
    }

    private void handleLogOff() throws IOException {

        List<multiUserClientHandle> currentlyActiveClients = server.getAllConnectedClients();

        for(multiUserClientHandle handle: currentlyActiveClients){
            if(loggedInUser!= null && !loggedInUser.equalsIgnoreCase(handle.getLoggedInUser())) {
                String msg = loggedInUser + " is offline \n";
                handle.sendMessage(msg);
            }
        }

    }

    private void handleLogin(String[] tokens, OutputStream outputStream) throws IOException {

        if(tokens.length == 3){

            String user = tokens[1];
            String password = tokens[2];

            if( (user.equalsIgnoreCase("guest") && password.equalsIgnoreCase("guest")) ||
                    (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) ||
                    (user.equalsIgnoreCase("root") && password.equalsIgnoreCase("root")) ||
                    (user.equalsIgnoreCase("system") && password.equalsIgnoreCase("system"))){

                outputStream.write("ok login \n".getBytes());
                loggedInUser = user;
                outputStream.write(("User logged in successfully "+user+"\n").getBytes());


                List<multiUserClientHandle> connectedClients = server.getAllConnectedClients();

                for(multiUserClientHandle handle: connectedClients){

                    /*
                        Tell all other users about this users
                     */


                    // User shouldn't send itself about it's status.
                    if(loggedInUser != null && loggedInUser != handle.loggedInUser) {
                        String msg = loggedInUser + " is online \n";
                        handle.sendMessage(msg);
                    }

                    /*
                        Tell this user about all other online users
                     */

                    if(handle.getLoggedInUser() != null && loggedInUser != handle.loggedInUser) {
                        String msg = handle.getLoggedInUser()+ " is online \n";
                        sendMessage(msg);
                    }
                }

            }
            else {
                outputStream.write("login failed \n".getBytes());
            }
        }
    }

    private void sendMessage(String msg) throws IOException {
        if(loggedInUser != null) {
            this.outputStream.write(msg.getBytes());
        }
    }

    private String getLoggedInUser(){
        return loggedInUser;
    }

    private List<String> getGroups(){
        return groups;
    }

    private void leaveGroup(String grpName){

        List<String> currActiveGrps = getGroups();
        while(currActiveGrps.remove(grpName)){};
    }
}
