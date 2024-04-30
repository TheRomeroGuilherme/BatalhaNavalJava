public class Mapa {
    // Declaração do tamanho do tabuleiro e do tabuleiro em si
    private final int TAM = 16; // Tamanho do tabuleiro
    private String[][] Tabuleiro = new String[TAM][TAM]; // Declaração do tabuleiro como uma matriz de strings

    // Construtor da classe Mapa
    public Mapa() {
        initializeMap(); // Inicializa o tabuleiro ao criar um novo objeto Mapa
    }

    // Método privado para inicializar o tabuleiro com água (~)
    private void initializeMap() {
        for (int i = 0; i < Tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro[0].length; j++) {
                Tabuleiro[i][j] = "  ~  "; // Define cada célula do tabuleiro como "~", representando água
            }
        }
    }

    // Método público para exibir o tabuleiro
    public void displayMap() {
        for (int i = 0; i < Tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro[0].length; j++) {
                System.out.print(Tabuleiro[i][j]); // Exibe cada célula do tabuleiro
            }
            System.out.println(); // Quebra de linha após cada linha do tabuleiro
        }
    }
}
