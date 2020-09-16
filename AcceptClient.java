
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class AcceptClient extends Thread {

    private Socket socket = null;
    private PrintWriter dout = null;
    private BufferedReader din = null;
    private BufferedWriter bw = null;
    private static int atUserName;
    private static int atPass;
    private static int atAuthentication;
    private static int atLoggedIn;
    private int state;
    private String userName = null;
    private String userPassword = null;
    int logInAttempts;
    String[][] allUsers;
    long timeEntered;
    String inputLine;
    String outputLine;

    /**
     * This is the constructor for this class.
     * Initialize some required variables and states with initial values
     * @param s - String argument Socket
     * @param userlist - String[][] for users
     * @param t - long Time
     * @throws IOException - I/O Exception
     */
    public AcceptClient(Socket s, String[][] userlist, long t) throws IOException {

        socket = s;
        allUsers = userlist;
        atUserName = 0;
        atPass = 1;
        atAuthentication = 2;
        atLoggedIn = 3;
        state = atUserName;
        logInAttempts = 1;
        timeEntered = t;
    }
    

    public void run() {
        // As soon as this process runs, we can say that client is connected this this socket
        System.out.println("Client connected to socket: " + socket.toString());

        try {

            // TODO: Read request from socket and write back the response to client.
            // TODO: You need the method handleRequest(String clientRequest) here to handle the reqeust and
            // return appropriate response to the socket
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // TODO: Close writing connection to the socket
                // TODO: Close read connection to the socket
                // TODO: Close the socket itself
            } catch (Exception e) {
                // Throw exception if we cannot close the socket connections in case
                System.out.println("Failed to close I/O");
            }
        }
    }

    public String handleRequest(String clientRequest) {
        String reply = null;
        String[] command_plus_param;
        try {
            if (clientRequest != null && clientRequest.equalsIgnoreCase("login")) {
                state = atPass;
            }
            if (clientRequest != null && clientRequest.equalsIgnoreCase("exit")) {
                Server.removeClient(this.userName);
                return "exit";
            }


            if (state == atUserName) {
                reply = "Please Enter your user name: ";
                state = atPass;
            } else if (state == atPass) {
                userName = clientRequest;
                reply = "Please Enter your password: ";
                state = atAuthentication;
            } else if (state == atAuthentication) {
                userPassword = clientRequest;
                int index = -1;


            } else if (state == atLoggedIn) {
                // TODO: Main operations will be done here
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "exit";
        }

        return reply;
    }

    public void message(String m) {
        dout.println(m);
    }

    public String getUserName() {
        return userName;
    }

    public long getTimeEntered() {
        return timeEntered;
    }
}