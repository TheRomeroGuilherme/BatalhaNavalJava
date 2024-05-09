
// Arquivo Jogador
public class Jogador {
    private String nomeJogador;
    private int pontosJogador;
    private Mapa mapa;
    private int tirosBarcos;

    public Jogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        this.pontosJogador = 0;
        this.mapa = new Mapa();
        this.tirosBarcos = 74; // Define o total de tiros para 74
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

    public int getTirosBarcos() {
        return tirosBarcos;
    }

    public void setTirosBarcos(int tirosBarcos) {
        this.tirosBarcos = tirosBarcos;
    }
}
// Fim Arquivo Jogador