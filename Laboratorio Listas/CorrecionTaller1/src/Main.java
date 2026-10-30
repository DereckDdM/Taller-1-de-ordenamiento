//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
       int [] arrayLinear = {10, 20, 24, 23, 50, 11};
       MisAlgoritmos  misAlgoritmos = new MisAlgoritmos();
       int posicion = misAlgoritmos.linearSearch(arrayLinear,11);
       System.out.println(posicion);

       int [] arrayBinary = {10, 20, 30, 50, 70, 80, 90, 100};
        int posicionDos = misAlgoritmos.binarySearch(arrayBinary,10);
        System.out.println(posicionDos);

        int [] arrayBubble = {10, 20, 70, 80, 90, 65, 23, 24, 56, 1};
        int [] tercerArray = misAlgoritmos.bubbleSort(arrayBubble);
        System.out.println(Arrays.toString(tercerArray));

        int [] arraySelection = {10, 20, 70, 80, 90, 65, 23, 24, 56, 1};
        int [] cuartoArray = misAlgoritmos.selectionSort(arraySelection);
        System.out.println(Arrays.toString(cuartoArray));

        int [] arrayInsertion = {10, 20, 70, 80, 90, 65, 23, 24, 56, 1};;
        int [] quintoArray = misAlgoritmos.insertionSort(arrayInsertion);
        System.out.println(Arrays.toString(quintoArray));

        int [] arrayMerge = {10, 20, 70, 80, 90, 65, 23, 24, 56, 1};
        int [] sextoArray = misAlgoritmos.mergeSort(arrayMerge);
        System.out.println(Arrays.toString(sextoArray));


        int [] arrayQuick = {10, 20, 70, 80, 90, 65, 23, 24, 56, 1};
        int [] septimoArray = misAlgoritmos.mergeSort(arrayMerge);
        System.out.println(Arrays.toString(septimoArray));
    }
}