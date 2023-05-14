package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private final Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String request = in.readLine();
            while (!request.equalsIgnoreCase("stop")) {
                String response = "Server received the request \"" + request + "\"";
                out.println(response);
                request = in.readLine();
            }
            out.println("Server stopped");
            socket.close();
        } catch (IOException e) {
            System.err.println("Error handling client request: " + e);
        }
    }
}
