
import java.io.*;
import java.net.*;

public class Client implements Runnable {

    private static boolean closed = false;
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader sIn = null;
    private static BufferedReader in = null;
    private static String fromServer;
    private static String fromUser;

    public static void main(String[] args) throws IOException {

        try {
            // TODO: Take object variables for PrintWriter, read from socket, write to the socket
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("No I/O: " + e.getMessage());
            System.exit(1);
        }

        // TODO if socket is ok, read, write connections are good then
            try {
                // TODO: Create a client
                while (!closed) {

                    // TODO: Keep listening to the port

                }
                out.close();
                in.close();
                sIn.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("No I/O: " + e.getMessage());
                System.exit(1);

            }

        }
    }

    /**
     * Server will run this method to start client thread after accepting client
     */
    @Override
    public void run() {
        String fromServer;
        try {
            // TODO: In an infinite loop read from server
            // TODO: Perform exit if server sends exit. closed = true if server sends exit message
            // TODO: Print the broadcasted message when server sends this client a broadcasted message
        } catch (IOException e) {
            System.out.println("");
        }
    }
}
