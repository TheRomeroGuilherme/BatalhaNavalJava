
//Fim Arquivo Server
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(12345)) { // Cria um servidor na porta 12345
            System.out.println("Servidor aguardando Jogadores darem pronto...");

            // Aceita a conexão do Cliente1
            Socket cliente1Socket = serverSocket.accept(); // Aguarda a conexão do primeiro cliente
            System.out.println("Jogador1 conectado: " + cliente1Socket);
            // Cria um objeto para enviar mensagens para o Cliente1
            PrintWriter outCliente1 = new PrintWriter(cliente1Socket.getOutputStream(), true);
            // Cria um objeto para receber mensagens/ do Cliente1
            BufferedReader inCliente1 = new BufferedReader(new InputStreamReader(cliente1Socket.getInputStream()));
            // Envia uma mensagem de boas-vindas ao Cliente1
            outCliente1.println("Bem-vindo, ");

            // Aceita a conexão do Cliente2
            Socket cliente2Socket = serverSocket.accept(); // Aguarda a conexão do segundo cliente
            System.out.println("Cliente2 conectado: " + cliente2Socket);
            // Cria um objeto para enviar mensagens para o Cliente2
            PrintWriter outCliente2 = new PrintWriter(cliente2Socket.getOutputStream(), true);
            // Cria um objeto para receber mensagens do Cliente2
            BufferedReader inCliente2 = new BufferedReader(new InputStreamReader(cliente2Socket.getInputStream()));

            // Envia uma mensagem de boas-vindas ao Cliente2
            outCliente2.println("Bem-vindo, Cliente2!");

            // Lógica para comunicação entre os clientes
            String inputCliente1, inputCliente2;
            while (true) {
                // tem que fazer a mediação entre os clientes ou seja aqui tem que ocorrer a
                // logíca de cada jogada

                // Recebe mensagem do Cliente1 e envia para o Cliente2
                inputCliente1 = inCliente1.readLine();
                if (inputCliente1 != null) {
                    System.out.println("Cliente1 diz: " + inputCliente1);
                    outCliente2.println("Cliente1 diz: " + inputCliente1);
                }

                // Recebe mensagem do Cliente2 e envia para o Cliente1
                inputCliente2 = inCliente2.readLine();
                if (inputCliente2 != null) {
                    System.out.println("Cliente2 diz: " + inputCliente2);
                    outCliente1.println("Cliente2 diz: " + inputCliente2);
                }

            }

        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

}
// Fim Arquivo Server