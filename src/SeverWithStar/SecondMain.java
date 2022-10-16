package SeverWithStar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 9210;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in))
        {
            String quest1 = in.readLine(); //спрашивает имя
            System.out.println(quest1); //спрашивает имя
            String name = scanner.nextLine(); //ввод имени
            out.println(name); //передача имени серверу

            String quest2 = in.readLine(); //спрашивает возраст
            System.out.println(quest2); //спрашивает возраст

            while (true){
                String isChild = scanner.nextLine();
                out.println(isChild);
                String quest3 = in.readLine();
                if (isChild.equals("да") || isChild.equals("Да") || isChild.equals("ДA") || isChild.equals("нет") || isChild.equals("Нет") || isChild.equals("НЕТ")){
                    System.out.println(quest3);
                    break;
                } else {
                    System.out.println(quest3);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
