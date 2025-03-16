package com.example;

import java.io.*;
import java.net.Socket;

/**
 * Kliento kodas prisijungiantis prie serverio
 */

public class EchoClient {
    public static void main(String[] args) throws IOException {

        //Tikrinama ar buvo perduoti argumentai
        if (args.length != 2) {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        //Prisijungiama prie serverio
        try (Socket socket = new Socket(hostName, portNumber);

             //Sukuriami srautai
             InputStream is = socket.getInputStream();
             FileOutputStream fos = new FileOutputStream("received_studentas.xml");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            //Skaitomi duomenys
            while ((bytesRead = is.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();
            System.out.println("File received and saved as received_studentas.xml");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}