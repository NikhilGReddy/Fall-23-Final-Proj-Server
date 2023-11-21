package ServerSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.google.gson.Gson;
public class Server extends Observable {

    public static Map<String,String> userNamePassMap;

    public static void main(String[] args) {
        System.out.println("This is server is built on openjdk-21.0.1");
        new Server().runServer();

    }

    private void runServer() {
        userNamePassMap = new HashMap<>();
        userNamePassMap.put("Nikhil", "password");
        try {
            setUpNetworking();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private void setUpNetworking() throws Exception {
        @SuppressWarnings("resource")
        ServerSocket serverSock = new ServerSocket(4242);
        while (true) {
            Socket clientSocket = serverSock.accept();
            System.out.println("Connecting to... " + clientSocket);

            ClientHandler handler = new ClientHandler(this, clientSocket);
            this.addObserver(handler);

            Thread t = new Thread(handler);
            t.start();
        }
    }

    protected void processRequest(String input, Socket client) throws IOException {
        PrintWriter toClient = new PrintWriter(client.getOutputStream());
        String output = "Error";
        Gson gson = new Gson();
        Message message = gson.fromJson(input, Message.class);
        Message out = new Message("whoops");
        try {

            String temp = "";
            switch (message.type) {
                case "login":
                    System.out.println("Login attempt read correctly: " + message.name + message.password);
                    Message message1 = new Message("loggedIn", message.name, message.password);
                    toClient.write(gson.toJson(message1));
                    break;
                case "lower":
                    temp = message.input.toLowerCase();
                    break;
                case "strip":
                    temp = message.input.replace(" ", "");
                    break;
            }
            output = "";
            for (int i = 0; i < message.number; i++) {
                output += temp;
                output += " ";
            }
            this.setChanged();
            this.notifyObservers(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
