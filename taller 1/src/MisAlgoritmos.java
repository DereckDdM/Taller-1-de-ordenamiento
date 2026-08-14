public class MisAlgoritmos implements Busquedas, Ordenamientos {

    @Override
    public int linearSearch(int[] arrayPorExplorar, int elementoABuscar) {
        int tamnoLista = arrayPorExplorar.length;
        for (int i = 0; i < tamnoLista-1; i++) {
            int elementoActual = arrayPorExplorar[i];
            if(elementoActual == elementoABuscar){
                return i;
            }

        }
        return -1;
    }

    @Override
    public int binarySearch(int[] arrayPorExplorar, int elementoABuscar) {
        return 0;
    }

    @Override
    public int[] bubbleSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] selectionSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] insertionSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] mergeSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] quickSort(int[] arrayDesordenado) {
        return new int[0];
    }
}
