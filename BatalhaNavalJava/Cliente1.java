
// Arquivo Cliente 1
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente1 {

    public static void main(String[] args) {
        Scanner scCliente1 = new Scanner(System.in);
        Mapa mapa = new Mapa();

        System.out.println("Bem-vindo Jogador!");
        System.out.println();
        System.out.println("Vamos preparar o mapa para começar a jogar");
        System.out.println();
        System.out.println("Coloque o seu nome para começar:");
        String nomeJogador = scCliente1.nextLine(); // Ler o nome do jogador
        System.out.println("Seu nome: " + nomeJogador);
        System.out.println();

        // Cria um jogador com o nome informado
        Jogador jogador = new Jogador(nomeJogador);
        System.out.println("Esse é o seu mapa antes de colocar os barcos:");
        mapa.displayMap();
        System.out.println("Essa é a sua esquadra:");
        montarEmbarcacoes();

        // Chama o método SequenciaBarcos() para definir a sequência de colocação dos
        // barcos
        jogador.getMapa().SequenciaBarcos();

        System.out.println();
        // Exibe o mapa atualizado após colocar os barcos
        System.out.println("Esse é o seu mapa após colocar os barcos:");
        jogador.getMapa().displayMap();

        // esconder mapa de jogador 1
        jogador.getMapa().EscondeMapa();

        //
        // lógica de atacar o mapa do jogador2
        //

        // Verifica se o cliente está pronto (neste caso, sempre será falso)
        int pronto = 0;
        System.out.println("Jogador está pronto?");
        System.out.println("Sim = 1");
        System.out.println("Não = 0");
        pronto = scCliente1.nextInt();
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

                //
                //
                //
                String serverResponse;

                // Loop para receber mensagens do servidor
                while ((serverResponse = in.readLine()) != null) {
                    // Exibe as mensagens recebidas do servidor
                    System.out.println("Servidor: " + serverResponse);
                    // Verifica se a mensagem de boas-vindas foi recebida
                    if (serverResponse.equals("Bem-vindo, " + nomeJogador + "!")) {
                        // Aqui você pode adicionar lógica específica se necessário
                    }
                }

                //
                // Aqui você pode adicionar lógica para interagir com o servidor
                //

                String userInputLine;
                // Loop para ler entrada do usuário
                while ((userInputLine = userInput.readLine()) != null) {
                    // Envia a entrada do usuário para o servidor
                    out.println(userInputLine);
                }

                //
                //
                //
            } catch (UnknownHostException e) {
                // Trata exceção se o servidor não for encontrado
                System.err.println("Servidor não encontrado: " + servidorHost);
            } catch (IOException e) {
                // Trata exceção de E/S
                System.err.println("Não foi possível obter E/S para a conexão com " + servidorHost);
            }
        }
        scCliente1.close();
    }

    private static void montarEmbarcacoes() {
        Embarcacao emb = new Embarcacao();
    }
}

// Fim Arquivo Cliente 1
