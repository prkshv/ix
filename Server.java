import java.net.*;
import java.io.*;

public class Server {
    private static Socket socket;

    public static void main(String[] args) {

        try {
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("System startlistening to the port 25000");
            while (true) {
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                String number2 = br.readLine();
                System.out.println("Message received from client is " + number);
                System.out.println("Message received from client is " + number2);

                String returnMessage;
                String returnMessage2 = null;
                String returnMessage3 = null;
                try {
                    int numberInIntFormat = Integer.parseInt(number);
                    int numberInIntFormat2 = Integer.parseInt(number2);
                    int returnValue = numberInIntFormat * 2;
                    int returnValue2 = numberInIntFormat2 * numberInIntFormat;
                    int returnValue3 = numberInIntFormat2 / numberInIntFormat;
                    returnMessage = String.valueOf(returnValue) + "\n";
                    returnMessage2 = String.valueOf(returnValue2) + "\n";
                    returnMessage3 = String.valueOf(returnValue3) + "\n";

                } catch (NumberFormatException e) {
                    returnMessage = "Please send a proper number\n";
                }

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                bw.write(returnMessage2);
                bw.write(returnMessage3);
                System.out.println("Message sent to the client is " + returnMessage);
                System.out.println("Message sent to the client is " + returnMessage2);
                System.out.println("Message sent to the client is " + returnMessage3);
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }

        }
    }
}
