
// Arquivo Cliente 2
import java.io.*;
import java.net.*;

public class Cliente2 {
    public static void main(String[] args) {
        final String servidorHost = "localhost";
        final int servidorPorta = 12345;

        try (
                Socket socket = new Socket(servidorHost, servidorPorta);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("Servidor: " + serverResponse);
                if (serverResponse.equals("Bem-vindo, Cliente2!")) {
                    break;
                }
            }

            // Aqui você pode adicionar lógica para interagir com o servidor
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
            }

        } catch (UnknownHostException e) {
            System.err.println("Servidor não encontrado: " + servidorHost);
        } catch (IOException e) {
            System.err.println("Não foi possível obter E/S para a conexão com " + servidorHost);
        }
    }
}
// Fim Arquivo Cliente 2