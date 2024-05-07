
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
            System.out.printf("  %s  ", rowLabel);
            rowLabel++;
        }
        System.out.println();

        // Exibe as letras das linhas e os elementos do tabuleiro
        for (int i = 0; i < TAM; i++) {
            System.out.printf(" %-3d ", i + 1);
            for (int j = 0; j < TAM; j++) {
                System.out.print(Tabuleiro[i][j]); // Inverte a ordem das coordenadas
            }
            System.out.println();

        }
    }

    private boolean ColocarBarco(String barcos, int tamanho) {
        System.out.println("Colocando " + barcos + "...");
        Scanner scanner = new Scanner(System.in);

        boolean colocado = false;
        while (!colocado) {
            System.out.print("Onde será a primeira posição do " + barcos + " (Linhas de 1 até 16): ");
            int linha = scanner.nextInt();

            System.out.print("Onde será a primeira posição do " + barcos + " (Colunas de A até P): ");
            char coluna = scanner.next().toUpperCase().charAt(0);

            if (!TemBarco(linha - 1, coluna - 'A')) {
                System.out.println("Já existe um barco nessa posição!");
                continue;
            }

            System.out.print("O " + barcos + " ficará na vertical ou horizontal?\n1 = Vertical\n2 = Horizontal\n... ");
            int orientacao = scanner.nextInt();

            if (orientacao == 1) {
                if (BarcoVertical(linha, coluna, tamanho)) {
                    colocado = true;
                }
            } else if (orientacao == 2) {
                if (BarcoHorizontal(linha, coluna, tamanho)) {
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
        return Tabuleiro[linha][coluna].equals("  ~  ");
    }

    public void SequenciaBarcos() {

        // Colocar duas unidades de Porta-Aviões
        for (int i = 0; i < 2; i++) {
            if (!ColocarBarco("Porta-Aviões", 8)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar três unidades de Destroyers
        for (int i = 0; i < 3; i++) {
            if (!ColocarBarco("Destroyer", 5)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar quatro unidades de Submarinos
        for (int i = 0; i < 4; i++) {
            if (!ColocarBarco("Submarino", 4)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar cinco unidades de Fragatas
        for (int i = 0; i < 5; i++) {
            if (!ColocarBarco("Fragata", 3)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }

        // Colocar seis unidades de Botes
        for (int i = 0; i < 6; i++) {
            if (!ColocarBarco("Bote", 2)) {
                i--; // Tentar novamente se o barco não for colocado com sucesso
            }
        }
    }

    private boolean BarcoVertical(int linha, char coluna, int tamanho) {
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
            Tabuleiro[i][indiceColuna] = "  " + tamanho + "  ";
        }

        System.out.println("Barco colocado com sucesso na posição " + linha + " " + coluna + " na Vertical!");
        displayMap();
        return true;
    }

    private boolean BarcoHorizontal(int linha, char coluna, int tamanho) {

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
            Tabuleiro[linha - 1][j] = "  " + tamanho + "  ";
        }
        System.out.println("Barco colocado com sucesso na posição " + linha + " " + coluna + " na Horizontal!");
        displayMap();
        return true;

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