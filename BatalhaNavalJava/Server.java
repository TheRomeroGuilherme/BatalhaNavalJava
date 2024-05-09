
// Fim Arquivo Server
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(12345)) { // Cria um servidor na porta 12345
            System.out.println("Servidor aguardando jogadores...");

            // Lógica para tratar a conexão do jogador 1
            Socket cliente1Socket = serverSocket.accept(); // Aguarda a conexão do primeiro cliente
            System.out.println("Jogador 1 conectado: " + cliente1Socket);
            // Cria um objeto para enviar mensagens para o Jogador 1
            PrintWriter outCliente1 = new PrintWriter(cliente1Socket.getOutputStream(), true);
            // Cria um objeto para receber mensagens do Jogador 1
            BufferedReader inCliente1 = new BufferedReader(new InputStreamReader(cliente1Socket.getInputStream()));

            // Lê o nome do jogador 1
            String nomeJogador1 = inCliente1.readLine();

            // Envia uma mensagem de boas-vindas ao Jogador 1 com o nome do jogador 1
            outCliente1.println("Bem-vindo, " + nomeJogador1 + "!");

            // Lógica para tratar a conexão do jogador 2
            Socket cliente2Socket = serverSocket.accept(); // Aguarda a conexão do segundo cliente
            System.out.println("Jogador 2 conectado: " + cliente2Socket);
            // Cria um objeto para enviar mensagens para o Jogador 2
            PrintWriter outCliente2 = new PrintWriter(cliente2Socket.getOutputStream(), true);
            // Cria um objeto para receber mensagens do Jogador 2
            BufferedReader inCliente2 = new BufferedReader(new InputStreamReader(cliente2Socket.getInputStream()));

            // Lê o nome do jogador 2
            String nomeJogador2 = inCliente2.readLine();

            // Envia uma mensagem de boas-vindas ao Jogador 2
            outCliente2.println("Bem-vindo, " + nomeJogador2 + "!");

            // Inicializa os mapas dos jogadores
            Mapa mapaJogador1 = new Mapa();
            Mapa mapaJogador2 = new Mapa();

            // Lógica para comunicação entre os jogadores
            String inputCliente1, inputCliente2;
            while (true) {
                // Solicita as coordenadas de ataque do jogador 1
                outCliente1.println("Seu turno, " + nomeJogador1 + "! Escolha a coluna de ataque (por exemplo, A):");
                String colunaCliente1 = inCliente1.readLine();
                outCliente1.println("Agora, escolha a linha de ataque (de 1 a 16):");
                String linhaCliente1 = inCliente1.readLine();
                inputCliente1 = colunaCliente1 + linhaCliente1;

                if (inputCliente1 != null && inputCliente1.matches("[A-P][1-9]|1[0-6]")) {
                    System.out.println(nomeJogador1 + " lançou um ataque na posição: " + inputCliente1);
                    // Analise as coordenadas do jogador 1 e verifique se ele acertou uma
                    // embarcação do jogador 2
                    if (mapaJogador2.verificarAtaque(colunaCliente1, linhaCliente1)) {
                        outCliente1.println("Você acertou um barco!");
                        outCliente2.println("Seu barco foi atingido!");
                    } else {
                        outCliente1.println("Você errou o ataque!");
                        outCliente2.println("O ataque do oponente foi um erro!");
                    }
                }

                // Solicita as coordenadas de ataque do jogador 2
                outCliente2.println("Seu turno, " + nomeJogador2 + "! Escolha a coluna de ataque (por exemplo, A):");
                String colunaCliente2 = inCliente2.readLine();
                outCliente2.println("Agora, escolha a linha de ataque (de 1 a 16):");
                String linhaCliente2 = inCliente2.readLine();
                inputCliente2 = colunaCliente2 + linhaCliente2;

                if (inputCliente2 != null && inputCliente2.matches("[A-P][1-9]|1[0-6]")) {
                    System.out.println(nomeJogador2 + " lançou um ataque na posição: " + inputCliente2);
                    // Analise as coordenadas do jogador 2 e verifique se ele acertou uma
                    // embarcação do jogador 1
                    if (mapaJogador1.verificarAtaque(colunaCliente2, linhaCliente2)) {
                        outCliente2.println("Você acertou um barco!");
                        outCliente1.println("Seu barco foi atingido!");
                    } else {
                        outCliente2.println("Você errou o ataque!");
                        outCliente1.println("O ataque do oponente foi um erro!");
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
// Fim Arquivo Server