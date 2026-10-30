public class Main {

    public static void main(String[] args) {
        MisAlgoritmos misAlgoritmos = new MisAlgoritmos();
        int[] miArray = {70, 12, 19, 45, 11, 33, 26};

        // =========================================
        // BUSQUEDA LINEAL
        // =========================================

        System.out.println("===== BUSQUEDA LINEAL =====");
        int resultadoLineal =
                misAlgoritmos.linearSearch(miArray, 19);
        System.out.println("Resultado: " + resultadoLineal);

        // =========================================
        // BUBBLE SORT
        // =========================================

        System.out.println();
        System.out.println("===== BUBBLE SORT =====");
        int[] bubble = miArray.clone();
        int[] resultadoBubble =
                misAlgoritmos.bubbleSort(bubble);
        for (int numero : resultadoBubble) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // =========================================
        // SELECTION SORT
        // =========================================

        System.out.println();
        System.out.println("===== SELECTION SORT =====");
        int[] selection = miArray.clone();
        int[] resultadoSelection =
                misAlgoritmos.selectionSort(selection);
        for (int numero : resultadoSelection) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // =========================================
        // INSERTION SORT
        // =========================================

        System.out.println();
        System.out.println("===== INSERTION SORT =====");
        int[] insertion = miArray.clone();
        int[] resultadoInsertion =
                misAlgoritmos.insertionSort(insertion);
        for (int numero : resultadoInsertion) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // =========================================
        // MERGE SORT
        // =========================================

        System.out.println();
        System.out.println("===== MERGE SORT =====");
        int[] merge = miArray.clone();
        int[] resultadoMerge =
                misAlgoritmos.mergeSort(merge);
        for (int numero : resultadoMerge) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // =========================================
        // QUICK SORT
        // =========================================

        System.out.println();
        System.out.println("===== QUICK SORT =====");
        int[] quick = miArray.clone();
        int[] resultadoQuick =
                misAlgoritmos.quickSort(quick);
        for (int numero : resultadoQuick) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // =========================================
        // BUSQUEDA BINARIA
        // =========================================

        System.out.println();
        System.out.println("===== BUSQUEDA BINARIA =====");
        // Para busqueda binaria el arreglo debe estar ordenado
        int[] arregloOrdenado = {
                11, 12, 19, 26, 33, 45, 70
        };
        int resultadoBinario =
                misAlgoritmos.binarySearch(arregloOrdenado, 19);
        System.out.println("Resultado: " + resultadoBinario);
    }
}