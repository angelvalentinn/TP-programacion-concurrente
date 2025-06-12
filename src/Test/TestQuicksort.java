package Test;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import Datos.*;

public class TestQuicksort {

	public static void main(String[] args) {
		
	    //Creacion de array aleatorio
	    int[] arr1 = CrearArray.generarArrayAleatorio(5000000, 1, 50000);
           int[] arr2 = Arrays.copyOf(arr1, arr1.length);
	    double arranco, fin;
		
	    //System.out.println(Arrays.arrayToString(arr)); //Array aleaotorio desordenado
		
	    //--------------------------------------------------------------------------------------------
            //-------------------------------- QUICK SORT, SOLUCIÓN CONCURRENTE ---------------------------
	    //--------------------------------------------------------------------------------------------
		
	    //Creo un objeto para usar el metodo de ordenacion 
	    Quicksort_concurrente quickSort = new Quicksort_concurrente(arr1);
	    
	    //Creo la pileta de hilos encargada de administrar los hilos para ejecutar las tareas concurrentes
	    ForkJoinPool pool = new ForkJoinPool();
	    
	    //Mido el tiempo de ejecucion del algoritmo en ms
	    arranco = System.currentTimeMillis();
	    
	    pool.invoke(quickSort);
	    
	    fin = System.currentTimeMillis() - arranco;
	    
	    //Muestro el tiempo que tardo
	    System.out.println("\nSolucion concurrente ---> " + fin + " milisegundos");

	    
	    //System.out.println(Arrays.arrayToString(arr1)); //Array ordenado concurrentemente
		
	    //--------------------------------------------------------------------------------------------
	    //-------------------------------- QUICK SORT, SOLUCIÓN SECUENCIAL ---------------------------
	    //--------------------------------------------------------------------------------------------
	    
	    //Mando a ordenar el array pero en secuencial y mido el tiempo que tardós
	    arranco = System.currentTimeMillis();
		
	    Quicksort_secuencial.quickSort(arr2, 0, arr2.length - 1);
		
	    fin = System.currentTimeMillis() - arranco;
	
	    System.out.println("\nSolucion secuencial ---> " + fin + " milisegundos");
		
	    //System.out.println(Arrays.arrayToString(arr2)); //Array ordenado secuencialmente
		
		
	}

}
