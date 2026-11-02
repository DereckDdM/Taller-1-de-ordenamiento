/* =====================================================================
 *  EXAMEN PARCIAL 1 - ESTRUCTURAS DE DATOS
 *  Escenario A - "Sala de Urgencias"
 *
 *  Estructura elegida .....: Lista enlazada simple ordenada por insercion
 *  Laboratorio de origen ..: 01
 *
 *  Justificacion:
 *  Mantenemos la lista ordenada al insertar para que atender() sea O(1)
 *  sacando siempre la cabeza. El desempate de llegada (FIFO) se logra
 *  recorriendo con un menor o igual (<=) en la prioridad, dejando al
 *  paciente nuevo al final de su misma tanda de gravedad de forma facil.
 * ===================================================================== */

import java.util.Scanner;

class Urgencias {

    static final String SEP = ";";
    int contadorLlegadas = 0;
    MiLista sala = new MiLista();

    public void llega(String nombre, int prioridad) {
        String paciente = nombre + SEP + prioridad + SEP + contadorLlegadas;
        contadorLlegadas++;

        ListNode nuevo = new ListNode(paciente);

        if (sala.cabeza == null || prioridad < prioridadDe(sala.cabeza.info)) {
            nuevo.sig = sala.cabeza;
            sala.cabeza = nuevo;
            return;
        }

        ListNode ant = null;
        ListNode aux = sala.cabeza;

        while (aux != null && prioridadDe(aux.info) <= prioridad) {
            ant = aux;
            aux = aux.sig;
        }

        nuevo.sig = aux;
        if (ant != null) ant.sig = nuevo;
    }

    public String estado() {
        if (sala.estaVacia()) return "SALA_VACIA";

        StringBuilder sb = new StringBuilder("ESPERANDO: ");
        ListNode aux = sala.cabeza;

        while (aux != null) {
            String p = aux.info;
            sb.append(nombreDe(p)).append("(p").append(prioridadDe(p)).append(")");
            if (aux.sig != null) sb.append(", ");
            aux = aux.sig;
        }
        return sb.toString();
    }

    public String atender() {
        if (sala.estaVacia()) return "SIN_PACIENTES";

        String p = sala.cabeza.info;
        sala.cabeza = sala.cabeza.sig;

        return "ATENDIDO: " + nombreDe(p) + " (prioridad " + prioridadDe(p) + ")";
    }

    static String nombreDe(String paciente) {
        return paciente.split(SEP)[0];
    }

    static int prioridadDe(String paciente) {
        return Integer.parseInt(paciente.split(SEP)[1]);
    }

    static int ordenDe(String paciente) {
        return Integer.parseInt(paciente.split(SEP)[2]);
    }

    public static void main(String[] args) {
        Urgencias sistema = new Urgencias();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println();
            System.out.println("===== SALA DE URGENCIAS =====");
            System.out.println("1. Llega un paciente");
            System.out.println("2. Ver estado de la sala");
            System.out.println("3. Atender al siguiente paciente");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            String opcion = sc.hasNextLine() ? sc.nextLine().trim() : "0";

            switch (opcion) {
                case "1": {
                    System.out.print("Nombre: ");
                    String nombre = sc.hasNextLine() ? sc.nextLine().trim() : "";
                    System.out.print("Prioridad (1-5): ");
                    String raw = sc.hasNextLine() ? sc.nextLine().trim() : "";

                    int prioridad;
                    try {
                        prioridad = Integer.parseInt(raw);
                    } catch (NumberFormatException e) {
                        System.out.println("ENTRADA_INVALIDA");
                        break;
                    }
                    if (nombre.isEmpty() || nombre.contains(SEP) || prioridad < 1 || prioridad > 5) {
                        System.out.println("ENTRADA_INVALIDA");
                        break;
                    }
                    sistema.llega(nombre, prioridad);
                    break;
                }
                case "2":
                    System.out.println(sistema.estado());
                    break;
                case "3":
                    System.out.println(sistema.atender());
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("OPCION_INVALIDA");
            }
        }
        sc.close();
    }
}
