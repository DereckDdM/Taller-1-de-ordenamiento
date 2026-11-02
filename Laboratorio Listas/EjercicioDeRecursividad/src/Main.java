public class Main {

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int suma(int n) {
        if (n == 0) return 0;
        return n + suma(n - 1);
    }

    public static int potencia(int b, int e) {
        if (e == 0) return 1;
        return b * potencia(b, e - 1);
    }

    public static int contarDigitos(int n) {
        if (n < 10) return 1;
        return 1 + contarDigitos(n / 10);
    }

    public static String invertir(String txt) {
        if (txt.isEmpty()) return "";
        return invertir(txt.substring(1)) + txt.charAt(0);
    }

    public static void main(String[] args) {
        int num = 6;
        int nSuma = 10;
        int b = 3;
        int e = 4;
        int valor = 9472;
        String txt = "mundo";

        System.out.println("Factorial: " + factorial(num));
        System.out.println("Suma: " + suma(nSuma));
        System.out.println("Potencia: " + potencia(b, e));
        System.out.println("Cantidad de dígitos: " + contarDigitos(valor));
        System.out.println("Cadena invertida: " + invertir(txt));
    }
}
