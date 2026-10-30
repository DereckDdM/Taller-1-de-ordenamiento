import java.util.Scanner;

public class Punticos {

    void puntico() {
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el primer texto: ");
        String texto1 = teclado.nextLine();

        System.out.print("Introduce el segundo texto: ");
        String texto2 = teclado.nextLine();

        String resultado = texto1 + " " + texto2;

        System.out.println("El resultado es: " + resultado);

        teclado.close();
    }
    void puntico2(){
        System.out.print("Holaa ");
        System.out.print("Dereck!");
    }
    void puntico3(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su número: ");
        String valor = scanner.nextLine();
        int numero = Integer.valueOf(valor);


    }
}
