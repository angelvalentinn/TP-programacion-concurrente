package Datos;
import java.util.concurrent.RecursiveAction;

//https://gist.github.com/EliaRohana/25b924048d990c5358313d18daf8f491
//Extiende de RecursiveAction para permitir ejecucion paralela con pileta de hilos
public class Quicksort_concurrente extends RecursiveAction{
	
  private int[] data;
  private int left;
  private int right;

  public Quicksort_concurrente(int[] data) {
    this.data = data;
    left = 0;
    right = data.length - 1;
  }

  public Quicksort_concurrente(int[] data, int left, int right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  
  //Metodo que ejecuta ForkJoinPool
  @Override
  protected void compute() {
	  
    if(left < right){ //Condicion de corte de recursividad
    	
      //Elige el pivote y acomoda los mas chicos a su izquierda y mas grandes a su derecha
      int pivot = partition(data, left, right); 
      
      //Metodo que ejecuta ambas tareas en concurrente y en mejor de los casos paralelo
      invokeAll(new Quicksort_concurrente(data,left, pivot), //Se repite el algoritmo con sub array izq
                new Quicksort_concurrente(data, pivot + 1, right)); //Se repite el algoritmo con sub array izq
    
    }
    
  }

  private int partition(int[] array, int low, int high) {
	  
    int pivot = array[low]; //Se elige el primer elemento como pivote
    int i = low - 1; // Índice que comienza antes del array
    int j  = high + 1; // Índice que comienza después del array
    
    while (true){ 
    	
      //Avanza i hasta encontrar elemento >= pivote
      do {
        i++;
      } while (array[i] < pivot);
      
      //Retrocede j hasta encontrar elemento <= pivote
      do {
        j--;
      } while (array[j] > pivot);
      
      //Si se cruzaron los índices, retorna posición final
      if (i >= j)
        return j;  //j es el nuevo punto de división

      swap(array, i, j); //Intercambia los elementos mal ubicados
    }
    
  }
  
  //Metodo que realiza el cambio de elementos entre posiciones
  private void swap(int[] array, int i, int j) {
	  
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    
  }
}