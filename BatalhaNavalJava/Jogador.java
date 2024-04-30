public class Jogador {
    // Declaração dos atributos privados da classe Jogador
    private int pontuacao; // Armazena a pontuação do jogador
    private String esquadra; // Armazena a esquadra (ou equipe) à qual o jogador pertence

    // Construtor da classe Jogador
    public Jogador(int pontuacao, String esquadra) {
        // Inicializa os atributos pontuacao e esquadra com os valores fornecidos como
        // parâmetros
        this.pontuacao = pontuacao;
        this.esquadra = esquadra;
    }

    // Método de acesso para obter a pontuação do jogador
    public int getPontuacao() {
        return pontuacao; // Retorna a pontuação atual do jogador
    }

    // Método de acesso para obter a esquadra do jogador
    public String getEsquadra() {
        return esquadra; // Retorna a esquadra à qual o jogador pertence
    }

    // Método modificador para definir a pontuação do jogador
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao; // Atualiza a pontuação do jogador com o valor fornecido como parâmetro
    }

    // Método modificador para definir a esquadra do jogador
    public void setEsquadra(String esquadra) {
        this.esquadra = esquadra; // Atualiza a esquadra do jogador com o valor fornecido como parâmetro
    }

    // cada jogador tem as seguintes quantidades para a sua esquadra
    // 2 unidades de Porta-Aviões
    // 3 unidades de Destroyers
    // 4 unidades de Submarino
    // 5 unidades de Fragata
    // 6 unidades de Botes

    /*
     * faça uma função para o jogador escolher a posição do barco se é na vertical
     * ou horizontal, use (1 = Vertical , 2 = horizontal).
     * a ordem será primeiro os (2 unidades de Porta-Aviões)
     * o jogador irá escolher de 0 a 16 onde iniciará o barco
     */
}
