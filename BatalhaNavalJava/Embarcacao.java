// Arquivo Embarcação
public class Embarcacao {
    private static final int NUM_PORTA_AVIOES = 2;
    private static final int NUM_DESTROYERS = 3;
    private static final int NUM_SUBMARINOS = 4;
    private static final int NUM_FRAGATAS = 5;
    private static final int NUM_BOTES = 6;

    private static int unidadesPortaAvioes = NUM_PORTA_AVIOES;
    private static int unidadesDestroyers = NUM_DESTROYERS;
    private static int unidadesSubmarinos = NUM_SUBMARINOS;
    private static int unidadesFragatas = NUM_FRAGATAS;
    private static int unidadesBotes = NUM_BOTES;

    public static String[] PortaAvioes = {
            "  A  " + "  A  " + "  A  " + "  A  " + "  A  " + "  A  " + "  A  " + "  A  "
    };
    public static String[] Destroyers = {
            "  D  " + "  D  " + "  D  " + "  D  " + "  D  "
    };
    public static String[] Submarinos = {
            "  S  " + "  S  " + "  S  " + "  S  "
    };
    public static String[] Fragatas = {
            "  F  " + "  F  " + "  F  "
    };
    public static String[] Botes = {
            "  B  " + "  B  "
    };

    public Embarcacao() {
        PortaAvioes = new String[NUM_PORTA_AVIOES];
        Destroyers = new String[NUM_DESTROYERS];
        Submarinos = new String[NUM_SUBMARINOS];
        Fragatas = new String[NUM_FRAGATAS];
        Botes = new String[NUM_BOTES];
    }

    // Métodos de acesso para obter as posições das embarcações
    public String[] getPortaAvioes() {
        return PortaAvioes; // Retorna as posições do porta-aviões
    }

    public String[] getDestroyers() {
        return Destroyers;// Retorna as posições dos destroyers
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

    public static void displayBarcos() {
        System.out.println("Barcos disponíveis:");
        System.out.println("'" + unidadesPortaAvioes + "' unidades de Porta-Aviões");
        System.out.println("'" + unidadesDestroyers + "' unidades de Destroyers");
        System.out.println("'" + unidadesSubmarinos + "' unidades de Submarinos");
        System.out.println("'" + unidadesFragatas + "' unidades de Fragatas");
        System.out.println("'" + unidadesBotes + "' unidades de Botes");
    }

    // Método para colocar um barco no mapa e atualizar a quantidade de unidades
    // correspondente
    public static void colocarBarco(String tipoBarco) {
        switch (tipoBarco) {
            case "PortaAvioes":
                unidadesPortaAvioes--;
                break;
            case "Destroyers":
                unidadesDestroyers--;
                break;
            case "Submarinos":
                unidadesSubmarinos--;
                break;
            case "Fragatas":
                unidadesFragatas--;
                break;
            case "Botes":
                unidadesBotes--;
                break;
            default:
                break;
        }
        displayBarcos();
    }
}

// Fim Arquivo Embarcação
