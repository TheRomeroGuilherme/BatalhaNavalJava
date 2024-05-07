
// Arquivo Jogador
public class Jogador {
    private String nomeJogador;
    private int pontosJogador;
    private Mapa mapa;

    public Jogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        this.pontosJogador = 0;
        this.mapa = new Mapa();
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getPontosJogador() {
        return pontosJogador;
    }

    public void setPontosJogador(int pontosJogador) {
        this.pontosJogador = pontosJogador;
    }

    public Mapa getMapa() {
        return mapa;
    }
}
// Fim Arquivo Jogador