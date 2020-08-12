package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();;

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

    public static void sendBroadcastMessage(Message message){
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: " + clientName);
            }
        }
    }

}
