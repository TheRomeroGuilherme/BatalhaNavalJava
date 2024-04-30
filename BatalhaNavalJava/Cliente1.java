import java.io.*;
import java.net.*;

public class Cliente1 {
    // Declaração da variável mapa, que será usada para exibir o mapa
    private static Mapa mapa;

    public static void main(String[] args) {
        // Inicializa a variável mapa, que será usada para exibir o mapa
        mapa = new Mapa();
        // Exibe o mapa inicial
        mapa.displayMap();
        // Declaração e inicialização da variável pronto, que será usada para indicar se
        // o cliente está pronto
        int pronto = 0;
        // Verifica se o cliente está pronto (neste caso, sempre será falso)
        if (pronto == 1) {
            // Endereço do servidor (localhost para o servidor na mesma máquina)
            final String servidorHost = "localhost";
            // Porta do servidor
            final int servidorPorta = 12345;
            try (
                    // Cria uma conexão com o servidor
                    Socket socket = new Socket(servidorHost, servidorPorta);
                    // Cria um objeto para enviar mensagens ao servidor
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    // Cria um objeto para receber mensagens do servidor
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // Cria um objeto para ler entrada do usuário
                    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
                String serverResponse;
                // Loop para receber mensagens do servidor
                while ((serverResponse = in.readLine()) != null) {
                    // Exibe as mensagens recebidas do servidor
                    System.out.println("Servidor: " + serverResponse);
                    // Verifica se a mensagem de boas-vindas foi recebida
                    if (serverResponse.equals("Bem-vindo, Cliente1!")) {
                        // Aqui você pode adicionar lógica específica se necessário
                    }
                }

                // Aqui você pode adicionar lógica para interagir com o servidor
                String userInputLine;
                // Loop para ler entrada do usuário
                while ((userInputLine = userInput.readLine()) != null) {
                    // Envia a entrada do usuário para o servidor
                    out.println(userInputLine);
                }
            } catch (UnknownHostException e) {
                // Trata exceção se o servidor não for encontrado
                System.err.println("Servidor não encontrado: " + servidorHost);
            } catch (IOException e) {
                // Trata exceção de E/S
                System.err.println("Não foi possível obter E/S para a conexão com " + servidorHost);
            }
        }
    }
}
