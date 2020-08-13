package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            super();
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name = null;
            boolean noconnection = true;
            while (noconnection) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receivemess = connection.receive();
                if (receivemess.getType() == MessageType.USER_NAME) {
                    name = receivemess.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        noconnection = false;
                    }
                }
            }
            return name;
        }

        public static void main(String[] args) throws Exception {
            ConsoleHelper.writeMessage("Номер порта:");
            int portNum = ConsoleHelper.readInt();
            try (ServerSocket serverSocket = new ServerSocket(portNum)) {
                ConsoleHelper.writeMessage("Сервер запущен на порту: " + portNum);
                while (true) {
                    Socket socket = serverSocket.accept();
                    new Handler(socket).start();
                }
            } catch (Exception e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException
        {
            for (String clientName : connectionMap.keySet()) {
                if (!clientName.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
            }
            }
        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException{
        while (!Thread.currentThread().isInterrupted()){
            Message message = connection.receive();
            if(message != null && message.getType() == MessageType.TEXT){
                String textmessage  = userName + ": " + message.getData();
                sendBroadcastMessage(new Message(MessageType.TEXT, textmessage));
            }
            else {
                ConsoleHelper.writeMessage("Ошибка.");
            }
        }
        }
        }
    public static void sendBroadcastMessage(Message message) {
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: " + clientName);
            }
        }
    }
}