import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
// import java.util.Timer;
// import java.util.TimerTask;

public class LiveServer {
    
    private static int PORT = 8080;
    

    public static void main(String[] args) throws Exception {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Created...\nListening on port " + PORT);

            while (true) {
                try (Socket client = serverSocket.accept()) {

                    System.out.println(client.toString());
                    InputStreamReader isr = new InputStreamReader(client.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder req = new StringBuilder();
                    String line = "hello";
                    // line = br.readLine();
                    while (!line.isBlank()) {
                        req.append(line + "\r\n");
                        line = br.readLine();
                    }

                    FileInputStream file = new FileInputStream(args[0]);
                    System.out.println("Request: " + req.toString());

                    OutputStream clientOutput = client.getOutputStream();
                    clientOutput.write(("HTTP/1.1 200 OK\r\n").getBytes());
                    // clientOutput.write(("http-equiv: Refresh\r\n" + "content: 60\r\n").getBytes());
                    // clientOutput.write(("Connection: keep-alive\r\n" + "Keep-Alive: timeout=5\r\n").getBytes());
                    clientOutput.write(("Refresh: 60; URL=/\r\n").getBytes());
                    clientOutput.write(("Connection: close\r\n").getBytes());

                    clientOutput.write(("\r\n").getBytes());
                    clientOutput.write(file.readAllBytes());
                    clientOutput.flush();
                    // Thread.sleep(1000);

                    file.close();
                    client.close();

                    // main(args);
                }
            }
        }

    }
}