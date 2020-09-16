
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Continuously Running Server
public class Server extends Thread {

    private static int port;
    String[] connecterUsers;
    static ArrayList<AcceptClient> threads = new ArrayList<AcceptClient>();
    static ArrayList<AcceptClient> clientArrayList = new ArrayList<AcceptClient>();
    static long time;
    int sorry = 0;
    
    
    public static void main(String[] args) throws Exception {
        int count = 0;
        ServerSocket serverSocket = null;
        boolean condition = true;
        String[][] allUsers = new String[0][0];
        Scanner input;
        port = Integer.parseInt(args[0]);
        
        try {
            // Read the users from the file
            File inFile = new File("userlist.txt");
            input = new Scanner(inFile);
            String wholeLine;
            int numberOfLines = 0;
            
            //count number of users to initialize array
            while (input.hasNext()) {
                numberOfLines++;
                input.nextLine();
            }
            //allUsers is a 2D array.  Col1=username, col2=password
            allUsers = new String[numberOfLines][2];
            
            input = new Scanner(inFile);
            int row = 0;
            String[] arr;  //arr[0] is username, arr[1] is pass
            while (input.hasNext()) {
                wholeLine = input.nextLine();
                arr = wholeLine.split("\\s+");
                allUsers[row][0] = arr[0];
                allUsers[row][1] = arr[1];
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error connecting via port " + port);
            System.exit(-1);
        }
        
        // Continuously listen for clients
        // Run a infinite loop, and whenever you get AcceptClient object with serverSocket.accept() then
        // start that client
        while (condition) {
            // TODO: Create a new AcceptClient object to get the client
            // TODO: Add client in the thread list variable we declared at the top
            // TODO: Add another entry in allEverEntered list
            // TODO: Start client
        }
        System.out.println(count);
        serverSocket.close();
    }

    
    public static ArrayList<AcceptClient> getConnectedClients(){
        return threads;
    }
    
    //2 min = 2000 ms
    public static ArrayList<String> getLast2Minuts() {
        ArrayList<String> last2 = new ArrayList<String>();
        // Get the clients connected in last 2 minutes
        return last2;
    }
    
    public static void removeClient(String name){
        // TODO: Remove the client from thread list
    }
    
    public static void messageAll(String m) {
        // TODO
    }
}
