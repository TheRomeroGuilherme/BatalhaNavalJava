
// Arquivo Mapa
import java.util.Scanner;

public class Mapa {
    private static final int TAM = 16;
    private String[][] Tabuleiro = new String[TAM][TAM];

    public Mapa() {
        inicializeMapa();
    }

    public void inicializeMapa() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                Tabuleiro[i][j] = "  ~  ";
            }
        }
    }

    public void displayMap() {
        // Exibe os números das colunas
        char rowLabel = 'A';
        System.out.print("     ");
        for (int i = 1; i <= TAM; i++) {
            System.out.printf("  %c  ", rowLabel);
            rowLabel++;
        }
        System.out.println();

        // Exibe as letras das linhas e os elementos do tabuleiro
        for (int i = 0; i < TAM; i++) {
            System.out.printf(" %-3d ", i + 1);
            for (int j = 0; j < TAM; j++) {
                // Modifica o código aqui para exibir o tipo de barco em vez de apenas números
                if (!Tabuleiro[i][j].equals("  ~  ")) {
                    // Obtém o tipo de barco a partir da posição atual do Tabuleiro
                    String tipoBarco = Tabuleiro[i][j].trim();
                    // Exibe o tipo de barco
                    System.out.printf("  %s  ", tipoBarco);
                } else {
                    // Se não houver barco na posição, exibe "~"
                    System.out.print(Tabuleiro[i][j]);
                }
            }
            System.out.println();
        }
    }

    private boolean ColocarBarco(String tipoBarco, int tamanho) {
        System.out.println("Colocando " + tipoBarco + "...");
        Scanner scanner = new Scanner(System.in);

        boolean colocado = false;
        while (!colocado) {
            System.out.print("Onde será a primeira posição do " + tipoBarco + " (Linhas de 1 até 16): ");
            int linha = scanner.nextInt();

            System.out.print("Onde será a primeira posição do " + tipoBarco + " (Colunas de A até P): ");
            char coluna = scanner.next().toUpperCase().charAt(0);

            // Chama o método TemBarco para verificar se já há um barco ou borda de barco na
            // posição especificada
            if (!TemBarco(linha - 1, coluna - 'A')) {
                System.out.println("Já existe um barco ou borda de barco nessa posição!");
                continue;
            }

            System.out
                    .print("O " + tipoBarco + " ficará na vertical ou horizontal?\n1 = Vertical\n2 = Horizontal\n... ");
            int orientacao = scanner.nextInt();

            if (orientacao == 1) {
                if (BarcoVertical(linha, coluna, tipoBarco)) {
                    colocado = true;
                }
            } else if (orientacao == 2) {
                if (BarcoHorizontal(linha, coluna, tipoBarco)) {
                    colocado = true;
                }
            } else {
                System.out.println("Opção inválida!");
            }
        }

        // Após o barco ser colocado, salva o mapa
        SalvarMapa();

        return colocado;
    }

    public boolean TemBarco(int linha, int coluna) {
        if (linha < 0 || linha >= TAM || coluna < 0 || coluna >= TAM) {
            return false;
        }

        // Verifica se há barco na célula atual
        if (!Tabuleiro[linha][coluna].equals("  ~  ")) {
            return false; // Se houver um barco na célula atual, não é possível colocar outro
        }

        // Verifica as células vizinhas (acima, abaixo, esquerda, direita)
        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                // Ignora a própria célula atual
                if (i == linha && j == coluna) {
                    continue;
                }
                // Verifica se a célula está dentro dos limites do mapa
                if (i >= 0 && i < TAM && j >= 0 && j < TAM) {
                    // Verifica se há um barco na célula vizinha
                    if (!Tabuleiro[i][j].equals("  ~  ")) {
                        return false; // Se houver um barco em qualquer célula vizinha, não é possível colocar outro
                    }
                }
            }
        }

        return true; // Se não houver barcos em nenhuma célula vizinha, é possível colocar um barco
    }

    public void SequenciaBarcos() {
        // Colocar duas unidades de Porta-Aviões
        for (int i = 0; i < 2; i++) {
            if (!ColocarBarco("  A  ", 8)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar três unidades de Destroyers
        for (int i = 0; i < 3; i++) {
            if (!ColocarBarco("  D  ", 5)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar quatro unidades de Submarinos
        for (int i = 0; i < 4; i++) {
            if (!ColocarBarco("  S  ", 4)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar cinco unidades de Fragatas
        for (int i = 0; i < 5; i++) {
            if (!ColocarBarco("  F  ", 3)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar seis unidades de Botes
        for (int i = 0; i < 6; i++) {
            if (!ColocarBarco("  B  ", 2)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }
    }

    private boolean BarcoVertical(int linha, char coluna, String tipoBarco) {
        int tamanho = tamanhoDoBarco(tipoBarco); // Obtém o tamanho do barco com base no tipo
        if (linha + tamanho > TAM) {
            System.out.println("O barco não cabe nessa posição!");
            return false;
        }

        int indiceColuna = coluna - 'A';
        for (int i = linha - 1; i < linha + tamanho - 1; i++) {
            if (!Tabuleiro[i][indiceColuna].equals("  ~  ")) {
                System.out.println(
                        "Não pode colocar o barco, tente colocar 1 casa de distância ou em outro lugar do mapa!");
                return false;
            }
        }

        for (int i = linha - 1; i < linha + tamanho - 1; i++) {
            Tabuleiro[i][indiceColuna] = "  " + tipoBarco + "  "; // Usa o tipo de barco em vez do tamanho
        }

        System.out.println("Barco colocado com sucesso na posição " + linha + " " + coluna + " na Vertical!");
        displayMap();
        return true;
    }

    private boolean BarcoHorizontal(int linha, char coluna, String tipoBarco) {
        int tamanho = tamanhoDoBarco(tipoBarco); // Obtém o tamanho do barco com base no tipo

        int indiceColuna = coluna - 'A';
        if (indiceColuna + tamanho > TAM) {
            System.out.println("O barco não cabe nessa posição!");
            return false;
        }

        for (int j = indiceColuna; j < indiceColuna + tamanho; j++) {
            if (!Tabuleiro[linha - 1][j].equals("  ~  ")) {
                System.out.println(
                        "Não pode colocar o barco, tente colocar 1 casa de distância ou em outro lugar do mapa!");
                return false;
            }
        }

        for (int j = indiceColuna; j < indiceColuna + tamanho; j++) {
            Tabuleiro[linha - 1][j] = "  " + tipoBarco + "  "; // Usa o tipo de barco em vez do tamanho
        }
        System.out.println("Barco colocado com sucesso na posição " + linha + " " + coluna + " na Horizontal!");
        displayMap();
        return true;

    }

    private int tamanhoDoBarco(String tipoBarco) {
        if (tipoBarco.equals("  A  ")) {
            return 8;
        } else if (tipoBarco.equals("  D  ")) {
            return 5;
        } else if (tipoBarco.equals("  S  ")) {
            return 4;
        } else if (tipoBarco.equals("  F  ")) {
            return 3;
        } else if (tipoBarco.equals("  B  ")) {
            return 2;
        } else {
            return 0; // Se o tipo de barco não for reconhecido, retorna 0
        }
    }

    private void SalvarMapa() {
        String[][] mapa = new String[TAM][TAM];
        // Copia as posições do mapa principal para o mapa específico da embarcação
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                mapa[i][j] = Tabuleiro[i][j];
            }
        }
        // Exibe o mapa da embarcação
        System.out.println("Mapa salvo com sucesso!");
    }

    public void EscondeMapa() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (!Tabuleiro[i][j].equals("  ~  ")) {
                    Tabuleiro[i][j] = "  ~  "; // Substitui a posição do navio por "~"
                }
            }
        }
        System.out.println("Mapa escondido com sucesso!");
    }

}
// Fim Arquivo Mapa