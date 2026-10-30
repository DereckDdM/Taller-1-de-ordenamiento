import com.sun.net.httpserver.SimpleFileServer;

public class MisAlgoritmos implements Busquedas, Ordenamientos{
    @Override
    public int linearSearch(int[] arrayLinear, int elementoABuscar) {
        int tamanoLista = arrayLinear.length;
        for (int i = 0; i < tamanoLista; i++) {
            int elementoActual =    arrayLinear[i];
            if (elementoActual == elementoABuscar){
                return i;
            }

        }
        return -1;
    }

    @Override
    public int binarySearch(int[] arrayBinary, int elementoDos) {
        int izquierdo = 0;
        int derecho = arrayBinary.length - 1;

        while(izquierdo <= derecho) {
            int medio = (izquierdo + derecho) / 2;
            int valor = arrayBinary[medio];

            if (elementoDos > valor) {
                izquierdo = medio + 1;
            }
            else if (elementoDos < valor){
                derecho = medio - 1;
            }
            else{
                return medio;
            }

        }
            return -1;
    }

    @Override
    public int[] bubbleSort(int[] arrayBubble) {
        int size = arrayBubble.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(arrayBubble[j] > arrayBubble[j+1]){
                    int temp = arrayBubble[j];
                    arrayBubble[j] = arrayBubble[j + 1];
                    arrayBubble[j + 1] = temp;
                }
            }
        }
        return arrayBubble;
    }



    @Override
    public int[] selectionSort(int[] arraySelection) {
    int size = arraySelection.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++){
                if(arraySelection[min] > arraySelection[j]){
                    min = j;
                }
            }
        int temp = arraySelection[i];
        arraySelection[i] = arraySelection[min];
        arraySelection[min] = temp;
        }
        return arraySelection;

    }

    @Override
    public int[] insertionSort(int[] arrayInsertion) {
        int size = arrayInsertion.length;
        for (int i = 1; i < size; i++) {
            int temp = arrayInsertion[i];
            int j = i - 1;
            while(j >= 0 && arrayInsertion[j] > temp) {
                arrayInsertion[j + 1] = arrayInsertion[j];
                j = j - 1;
            }

            arrayInsertion[j+1] = temp;
        }
        return arrayInsertion;
    }

    @Override
    public int[] mergeSort(int[] arrayDesordenado) {
    int size = arrayDesordenado.length;
    if (size <= 1) return arrayDesordenado;

    int medio = size / 2;
    int [] arrayIzquierdo = new int[medio];
    int [] arrayDerecho = new int[size - medio];

    int i = 0;
    int j = 0;

        for (; i < size; i++) {
            if(i < medio){
                arrayIzquierdo[i] = arrayDesordenado[i];
            }
            else{
                arrayDerecho[i - medio] = arrayDesordenado[i];
                j++;
            }
        }
        mergeSort(arrayIzquierdo);
        mergeSort(arrayDerecho);
        merge(arrayIzquierdo, arrayDerecho, arrayDesordenado);
        return arrayDesordenado;
    }
    private static void merge(int[] arrayIzquierdo, int[] arrayDerecho, int[] arrayDesordenado ){

        int sizeIzquierdo = arrayIzquierdo.length;
        int sizeDerecho = arrayDerecho.length;
        int i = 0, l = 0, r = 0;
        while(l < sizeIzquierdo &&  r < sizeDerecho){
            if(arrayIzquierdo[l] < arrayDerecho[r]){
                arrayDesordenado[i] = arrayIzquierdo[l];
                i++;
                l++;
            }
            else{
                arrayDesordenado[i] = arrayDerecho[r];
                i++;
                r++;
            }
        }
        while(l < sizeIzquierdo){
            arrayDesordenado[i] = arrayIzquierdo[l];
            i++;
            l++;
        }
        while(r < sizeDerecho){
            arrayDesordenado[i] = arrayDerecho[r];
            i++;
            r++;
        }
    }

    @Override
    public int[] quickSort(int[] arrayDesordenado) {
        if (arrayDesordenado == null || arrayDesordenado.length <= 1) {
            return arrayDesordenado;
        }
        quick(arrayDesordenado, 0, arrayDesordenado.length - 1);
        return arrayDesordenado;

    }
    private void quick(int[] array, int bajo, int alto) {
        if (bajo < alto) {
            int indicePivote = particion(array, bajo, alto);
            quick(array, bajo, indicePivote - 1);
            quick(array, indicePivote + 1, alto);
        }
    }
    private int particion(int[] array, int bajo, int alto) {
        int pivote = array[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {
            if (array[j] <= pivote) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;

        return i + 1;
    }
    }
