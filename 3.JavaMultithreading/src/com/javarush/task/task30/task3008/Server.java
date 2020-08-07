package com.javarush.task.task30.task3008;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            super();
            this.socket = socket;
        }
    }

    public static void main(String[] args) throws Exception{
        ConsoleHelper.writeMessage("Номер порта:");
        int portNum = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(portNum)) {
            ConsoleHelper.writeMessage("Сервер запущен на порту: " + portNum);
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
        catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

}
