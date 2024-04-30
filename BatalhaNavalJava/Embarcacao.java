public class Embarcacao {
    // Declaração dos atributos protegidos da classe Embarcacao
    /*
     * Cada atributo representa um tipo de embarcação e é um array de strings que
     * representa as posições da embarcação no tabuleiro
     */

    protected String[] PortaAvioes = { "  A  ", "  A  ", "  A  ", "  A  ", "  A  ", "  A  ", "  A  ", "  A  " };
    protected String[] Destroyers = { "  D  ", "  D  ", "  D  ", "  D  ", "  D  " };
    protected String[] Submarinos = { "  S  ", "  S  ", "  S  ", "  S  " };
    protected String[] Fragatas = { "  F  ", "  F  ", "  F  " };
    protected String[] Botes = { "  B  ", "  B  " };

    // Métodos de acesso para obter as posições das embarcações
    public String[] getPortaAvioes() {
        return PortaAvioes; // Retorna as posições do porta-aviões
    }

    public String[] getDestroyers() {
        return Destroyers; // Retorna as posições dos destroyers
    }

    public String[] getSubmarinos() {
        return Submarinos; // Retorna as posições dos submarinos
    }

    public String[] getFragatas() {
        return Fragatas; // Retorna as posições das fragatas
    }

    public String[] getBotes() {
        return Botes; // Retorna as posições dos botes
    }
}
