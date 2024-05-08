// Arquivo Embarcação
public class Embarcacao {
    public static String[] TipoBarco = { "  A  ", "  D  ", "  S  ", "  F  ", "  B  " };
    public static int[] TamanhoBarco = { 8, 5, 4, 3, 2 };
    public static int[] UnidadesBarcos = { 2, 3, 4, 5, 6 };

    public Embarcacao() {
        montarEmbarcacoes();
    }

    public static int getTamanho(String tipo) {
        for (int i = 0; i < TipoBarco.length; i++) {
            if (TipoBarco[i].trim().equals(tipo)) {
                return TamanhoBarco[i];
            }
        }
        return -1; // Se o tipo não for encontrado
    }

    public static int getUnidades(String tipo) {
        for (int i = 0; i < TipoBarco.length; i++) {
            if (TipoBarco[i].trim().equals(tipo)) {
                return UnidadesBarcos[i];
            }
        }
        return -1; // Se o tipo não for encontrado
    }

    private void montarEmbarcacoes() {
        for (int i = 0; i < TipoBarco.length; i++) {
            String tipo = TipoBarco[i];
            int tamanho = TamanhoBarco[i];
            int unidades = UnidadesBarcos[i];

            System.out.println("Barco tipo " + tipo.trim() + ", tamanho " + tamanho + ", unidades " + unidades);
        }
    }
}

/*
 * public static void displayBarcos() {
 * System.out.println("Barcos disponíveis:");
 * System.out.println("'", unidadesPortaAvioes, "' unidades de Porta-Aviões");
 * System.out.println("'", unidadesDestroyers, "' unidades de Destroyers");
 * System.out.println("'", unidadesSubmarinos, "' unidades de Submarinos");
 * System.out.println("'", unidadesFragatas, "' unidades de Fragatas");
 * System.out.println("'", unidadesBotes, "' unidades de Botes");
 * }
 * 
 * // Método para colocar um barco no mapa e atualizar a quantidade de unidades
 * // correspondente
 * 
 * displayBarcos();
 */

// Fim Arquivo Embarcação
