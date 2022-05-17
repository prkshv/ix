import java.net.*;
import java.io.*;

public class Client {
    private static Socket socket;

    public static void main(String args[]) {

        try {
            String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String number = "6";
            String number2 = "10";
            String sendMessage = number + "\n";
            String sendMessage2 = number2 + "\n";
            bw.write(sendMessage);
            bw.write(sendMessage2);
            bw.flush();
            System.out.println("Message sent to the server : " + sendMessage);
            System.out.println("Message sent to the server : " + sendMessage2);

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            String message2 = br.readLine();
            String message3 = br.readLine();
            System.out.println("Message received from the server : " + message);
            System.out.println("Message received from the server: " + message2);
            System.out.println("Message received from the server: " + message3);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {

            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}