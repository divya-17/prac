package MultiUserChatServer;

public class App {

    public static void main(String[] args) {

        int portNumber = 8881;
        multipleUserServer server = new multipleUserServer(portNumber);
        server.start();
    }
}
