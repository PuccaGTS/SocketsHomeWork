package MainTaskServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{
        System.out.println("Сервер начал свою работу");
        System.out.println("-------------------------------------------");
        int port = 9205;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader((clientSocket.getInputStream()))))
                {
                    System.out.println("Новое подключение установлено \nПорт подключения: "  + clientSocket.getPort());
                    System.out.println("-------------------------------------------");

                    final String name = in.readLine();
                    out.println(String.format("Привет %s, твой порт - %d", name, clientSocket.getPort()));
                }
            }
        }
    }
}
