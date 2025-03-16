package com.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Serveris laukiantis kliento prisijungimo
 * Klientui prisijungus serveris nuskaito XML faila ir perduoda per tinklo srauta
 */

public class EchoServer {
    public static void main(String[] args) throws IOException {
        //Tikrina ar buvo gautas prievado numeris
        if (args.length < 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        System.out.print("Server started. Listening on Port 8005");
        int portNumber = Integer.parseInt(args[0]);

        //Sukuriamas ServerSocket objektas padedantis klausyti uzklausas
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            //Laukia kliento prisijungimo
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected on port " + portNumber + ", sending XML file...");

                InputStream inputStream = EchoServer.class.getClassLoader().getResourceAsStream("studentas.xml");

                //Tikrina ar failas buvo sekmingai ikeltas
                if (inputStream == null) {
                    System.out.println("File not found in resources.");
                    clientSocket.close();
                    continue;
                }

                //Sukuriami srautai, kur duomenys skaitomi ir siunciami klientui
                try (BufferedInputStream bis = new BufferedInputStream(inputStream);
                     OutputStream os = clientSocket.getOutputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    os.flush();
                    System.out.println("File sent successfully.");
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

    }
}