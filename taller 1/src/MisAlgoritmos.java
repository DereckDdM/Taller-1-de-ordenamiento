public class MisAlgoritmos implements Busquedas, Ordenamientos {

    @Override
    public int linearSearch(int[] arrayPorExplorar, int elementoABuscar) {
        int tamnoLista = arrayPorExplorar.length;
        for (int i = 0; i < tamnoLista; i++) {
            int elementoActual = arrayPorExplorar[i];

            if(elementoActual == elementoABuscar){
                return i;
            }

        }
        return -1;
    }

    @Override
    public int binarySearch(int[] segundoArray, int elementoABuscar) {
        int izquierdo = 0;
        int derecho = segundoArray.length;
        int medio = (izquierdo + derecho) / 2;
        while (izquierdo <= derecho) {
            if (segundoArray[medio] > elementoABuscar) {
                izquierdo = medio + 1;
            } else if (segundoArray[medio] < elementoABuscar) {
                derecho = medio - 1;
            } else {
                return medio;
            }
            medio = (izquierdo + derecho) / 2;
        }

        return -1;

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
