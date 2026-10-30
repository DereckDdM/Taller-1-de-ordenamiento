public class MisAlgoritmos implements Ordenamientos,Busquedas {

    @Override
    public int linearSearch(int[] arrayPorExplorar, int elementoABuscar) {

        for (int i = 0; i < arrayPorExplorar.length; i++) {

            if (arrayPorExplorar[i] == elementoABuscar) {
                return i;
            }
        }

        return -1;
    }


    @Override
    public int binarySearch(int[] arrayPorExplorar, int elementoABuscar) {

        int izquierda = 0;
        int derecha = arrayPorExplorar.length - 1;

        while (izquierda <= derecha) {

            int medio = (izquierda + derecha) / 2;

            if (arrayPorExplorar[medio] == elementoABuscar) {
                return medio;
            }

            if (arrayPorExplorar[medio] < elementoABuscar) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }


    @Override
    public int[] bubbleSort(int[] arrayDesordenado) {

        for (int i = 0; i < arrayDesordenado.length - 1; i++) {

            for (int j = 0; j < arrayDesordenado.length - 1 - i; j++) {

                if (arrayDesordenado[j] > arrayDesordenado[j + 1]) {

                    int temporal = arrayDesordenado[j];

                    arrayDesordenado[j] = arrayDesordenado[j + 1];

                    arrayDesordenado[j + 1] = temporal;
                }
            }
        }

        return arrayDesordenado;
    }


    @Override
    public int[] selectionSort(int[] arrayDesordenado) {

        for (int i = 0; i < arrayDesordenado.length - 1; i++) {

            int posicionMenor = i;

            for (int j = i + 1; j < arrayDesordenado.length; j++) {

                if (arrayDesordenado[j] < arrayDesordenado[posicionMenor]) {
                    posicionMenor = j;
                }
            }

            int temporal = arrayDesordenado[i];

            arrayDesordenado[i] = arrayDesordenado[posicionMenor];

            arrayDesordenado[posicionMenor] = temporal;
        }

        return arrayDesordenado;
    }


    @Override
    public int[] insertionSort(int[] arrayDesordenado) {

        for (int i = 1; i < arrayDesordenado.length; i++) {

            int actual = arrayDesordenado[i];

            int j = i - 1;

            while (j >= 0 && arrayDesordenado[j] > actual) {

                arrayDesordenado[j + 1] = arrayDesordenado[j];

                j--;
            }

            arrayDesordenado[j + 1] = actual;
        }

        return arrayDesordenado;
    }


    @Override
    public int[] mergeSort(int[] arrayDesordenado) {

        if (arrayDesordenado.length <= 1) {
            return arrayDesordenado;
        }

        int medio = arrayDesordenado.length / 2;

        int[] izquierda = new int[medio];

        int[] derecha = new int[arrayDesordenado.length - medio];

        for (int i = 0; i < medio; i++) {
            izquierda[i] = arrayDesordenado[i];
        }

        for (int i = medio; i < arrayDesordenado.length; i++) {
            derecha[i - medio] = arrayDesordenado[i];
        }

        izquierda = mergeSort(izquierda);

        derecha = mergeSort(derecha);

        int[] resultado = new int[arrayDesordenado.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izquierda.length && j < derecha.length) {

            if (izquierda[i] <= derecha[j]) {
                resultado[k] = izquierda[i];
                i++;
            } else {
                resultado[k] = derecha[j];
                j++;
            }

            k++;
        }

        while (i < izquierda.length) {
            resultado[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < derecha.length) {
            resultado[k] = derecha[j];
            j++;
            k++;
        }

        return resultado;
    }


    @Override
    public int[] quickSort(int[] arrayDesordenado) {

        if (arrayDesordenado.length <= 1) {
            return arrayDesordenado;
        }

        int pivote = arrayDesordenado[arrayDesordenado.length - 1];

        int[] menores = new int[arrayDesordenado.length];
        int[] mayores = new int[arrayDesordenado.length];

        int cantidadMenores = 0;
        int cantidadMayores = 0;

        for (int i = 0; i < arrayDesordenado.length - 1; i++) {

            if (arrayDesordenado[i] < pivote) {

                menores[cantidadMenores] = arrayDesordenado[i];
                cantidadMenores++;

            } else {

                mayores[cantidadMayores] = arrayDesordenado[i];
                cantidadMayores++;
            }
        }

        int[] menoresExactos = new int[cantidadMenores];
        int[] mayoresExactos = new int[cantidadMayores];

        for (int i = 0; i < cantidadMenores; i++) {
            menoresExactos[i] = menores[i];
        }

        for (int i = 0; i < cantidadMayores; i++) {
            mayoresExactos[i] = mayores[i];
        }

        menoresExactos = quickSort(menoresExactos);
        mayoresExactos = quickSort(mayoresExactos);

        int[] resultado = new int[arrayDesordenado.length];

        int posicion = 0;

        for (int i = 0; i < menoresExactos.length; i++) {
            resultado[posicion] = menoresExactos[i];
            posicion++;
        }

        resultado[posicion] = pivote;
        posicion++;

        for (int i = 0; i < mayoresExactos.length; i++) {
            resultado[posicion] = mayoresExactos[i];
            posicion++;
        }

        return resultado;
    }
}