public class Main {
  public static void main (String[] args){
    int [] miArray = {70,12,19,45,11,33};
    MisAlgoritmos misAlgoritmos = new MisAlgoritmos();
    int posicion = misAlgoritmos.linearSearch(miArray,  33);
    System.out.println(posicion);


  }
        }