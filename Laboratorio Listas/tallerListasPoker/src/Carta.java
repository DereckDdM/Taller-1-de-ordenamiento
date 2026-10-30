public class Carta implements Comparable<Carta> {

    private final String palo;
    private final int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public String getPalo() {

        return palo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int compareTo(Carta otra) {
        return Integer.compare(this.numero, otra.numero);
    }

    private String numeroFormateado() {
        switch (numero) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(numero);
        }
    }

    @Override
    public String toString() {
        return numeroFormateado() + "-" + palo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Carta)) return false;
        Carta otra = (Carta) obj;
        return palo == otra.palo && numero == otra.numero;
    }

    @Override
    public int hashCode() {
        return 31 * palo.hashCode() + numero;
    }

    static String obtenerEmojiPalo(char letra) {
        return switch (letra) {
            case 'C' -> "❤";
            case 'D' -> "♦️";
            case 'P' -> "♠️";
            case 'T' -> "🍀";
            default -> "";
        };
    }
}
